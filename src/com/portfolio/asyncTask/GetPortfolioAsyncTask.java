package com.portfolio.asyncTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;

import com.portfolio.connection.ConnectionPool;
import com.portfolio.connection.MyAsyncTask;
import com.portfolio.handler.AsyncTaskHandler;
import com.portfolio.model.entities.Portfolio;
import com.portfolio.utils.FileHelper;

public class GetPortfolioAsyncTask extends MyAsyncTask {

	private static String TAG = GetPortfolioAsyncTask.class.getSimpleName();

	private Handler handler;
	private JSONObject param;
	private Portfolio response;

	public GetPortfolioAsyncTask(Context ctx, Handler handler) {
		super(ctx);
		this.handler = handler;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// Showing the progress dialog before starting process
		progress = new ProgressDialog(_context);
		progress.setMessage("Cargando");
		progress.setCancelable(false);
		progress.show();
	}
	
	@Override
	protected Integer doInBackground(Integer... arg0) {
		try {
			Looper.prepare();
			if (!isNetworkConnected()) {
				String previousUpdate = getJSONUpdate();
				if (previousUpdate.length() > 0) {
					String path = getJSONPath();
					String jsonOld = readFileJSON(path);
					if (jsonOld != null) {
						response = new Portfolio(new JSONObject(jsonOld));
					} else {
						return AsyncTaskHandler.ERRORREQUEST;
					}
				} else {
					return AsyncTaskHandler.ERRORREQUEST;
				}
			} else {
				ConnectionPool pool = ConnectionPool.getInstanced(_context);
				JSONObject result = pool.request("", param);
				String update = result.getString("update");
				String previousUpdate = getJSONUpdate();
				long newUpdate = Long.parseLong(update);
				long preUpdate = Long.parseLong(previousUpdate);
				if (newUpdate > preUpdate) {
					response = new Portfolio(result);
					String path = writeFileJSON(update, result.toString());
					updateJSONUpdate(update, path);
				} else {
					String path = getJSONPath();
					String jsonOld = readFileJSON(path);
					response = new Portfolio(new JSONObject(jsonOld));
				}
			}

		} catch (Exception e) {
			return AsyncTaskHandler.ERRORREQUEST;
		}
		return AsyncTaskHandler.ACEPTREQUEST;
	}

	private boolean isNetworkConnected() {
		ConnectivityManager cm = (ConnectivityManager) _context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			// There are no active networks.
			return false;
		} else
			return true;
	}

	private String readFileJSON(String path) {
		File file = new File(path);

		// Read text from file
		StringBuilder text = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {
				text.append(line);
				text.append('\n');
			}
			br.close();
			return text.toString();
		} catch (Exception e) {
			System.out.println("Asd");
			// You'll need to add proper error handling here
		}
		return null;
	}

	private String writeFileJSON(String fileName, String jsonContent) {
		String filepath = "";
		File file = FileHelper.createNewJSONFile(_context, fileName + ".txt");
		try {
			if (file != null) {
				if (!file.exists()) {
					file.createNewFile();
				}
				// this will be used to write the downloaded data into the file
				// we
				// created
				FileOutputStream fileOutput = new FileOutputStream(file);

				fileOutput.write(jsonContent.getBytes());
				fileOutput.flush();
				fileOutput.close();
				filepath = file.getPath();
			} else {
				return null;
			}
			// catch some possible errors...
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			filepath = null;
			e.printStackTrace();
			return null;
		}
		Log.i("filepath:", " " + filepath);

		return filepath;

	}

	private void updateJSONUpdate(String update, String path) {
		SharedPreferences pref = PreferenceManager
				.getDefaultSharedPreferences(_context);
		Editor editor = pref.edit();
		editor.putString("update", update);
		editor.putString("path", path);
		editor.commit();
	}

	private String getJSONUpdate() {
		SharedPreferences pref = PreferenceManager
				.getDefaultSharedPreferences(_context);
		return pref.getString("update", "0");
	}

	private String getJSONPath() {
		SharedPreferences pref = PreferenceManager
				.getDefaultSharedPreferences(_context);
		return pref.getString("path", "");
	}

	@Override
	protected void onPostExecute(Integer result) {
		android.os.Message msg = new android.os.Message();
		msg.what = result;
		if (result == AsyncTaskHandler.ACEPTREQUEST) {
			msg.obj = response;
		}
		progress.dismiss();
		handler.sendMessage(msg);
	}
}
