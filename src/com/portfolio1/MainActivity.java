package com.portfolio1;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.portfolio.activities.HomeActivity;
import com.portfolio.activities.TextActivity;
import com.portfolio.listener.IPortfolioListener;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.ITheme;
import com.portfolio.util.MenuBuilder1;
import com.portfolio.util.UIUtils;
import com.portfolio.utils.Config;
import com.portfolio1.*;





public class MainActivity extends Activity implements IPortfolioListener {

	public String tittleApp = null;
	public String subtittleApp = null;
    public ITheme theme;
    public PortfolioModel portfolioModel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Config.URL = "http://appsworld.alzatis.com/apps/json/25&color=yellow";
		//Config.URL = "https://dl.dropboxusercontent.com/u/49247770/PortfolioApps/AppAbogados/AppData2.json";
		//Config.URL = "https://dl.dropboxusercontent.com/u/49247770/PortfolioApps/AppAbogados/AppData.json";
	    portfolioModel = PortfolioModel.getInstance(this);
		portfolioModel.getPortfolio(this);
		//theme = portfolioModel.getTheme();

		UIUtils.setMenuBuilder(new MenuBuilder1());
		setContentView(R.layout.splash_app1);
		//UIUtils.setHeader(this);
	    ImageView splash_image = (ImageView)findViewById(R.id.imageView1);
	    splash_image.setImageResource(R.drawable.splash_image);
	    

	    LinearLayout layoutHeader = (LinearLayout) findViewById(R.id.layout_header);
		UIUtils.setGradient(layoutHeader,
				"#D0B36A","#775728",
				String.valueOf("135"));

		Typeface font1 = Typeface.createFromAsset(this.getAssets(),
				"fonts/CopperplateGothicStd 31BC.otf");

		TextView customTittle = (TextView) findViewById(R.id.tittle_app);
		customTittle.setTypeface(font1);
		customTittle.setTextSize(25);
		customTittle.setText("NUÑEZ SUAREZ");

		TextView customSubtittle = (TextView) findViewById(R.id.sub_tittle_app);
		customSubtittle.setTypeface(font1);
		customSubtittle.setTextSize(20);
		customSubtittle.setTextScaleX(1);
		customSubtittle.setText("A  B  O  G  A  D  O  S");

		LinearLayout layoutFooter = (LinearLayout) findViewById(R.id.layout_footer);
			;		UIUtils.setGradient(layoutFooter,
					"#D0B36A","#775728",
					String.valueOf("135"));
	}
	
	@Override
	public void onPortfolioReady() {
		//PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
//		IMenu menu = portfolioModel.getPorfolioMenu();
//		menu.getTitle();
//		tittleApp = menu.getTitle();
//		subtittleApp = menu.getSubtitle();
//		menu.getBackground();
	
	
		
	
		
		
		UIUtils.setHeader(this);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent intent = new Intent(MainActivity.this, HomeActivity.class);
		startActivity(intent);
		finish();
	}

//	@Override
//	public void onPortfolioReady() {
//
//		PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
//		IMenu menu = portfolioModel.getPorfolioMenu();
//		menu.getTitle();
//		tittleApp = menu.getTitle();
//		subtittleApp = menu.getSubtitle();
//		menu.getBackground();
//
//		Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//		startActivity(intent);
//		finish();
//	}

	@Override
	public void errorGetPortfolio() {
//		Intent intent = new Intent(MainActivity.this, TextActivity.class);
//		intent.putExtra("text", "");
//		startActivity(intent);
		msgErrorConnection();
	}
	
	private void msgErrorConnection(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				this);
 
			// set title
			alertDialogBuilder.setTitle("No se pudo conectar");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("¿Desea reintentar la conexión?")
				.setCancelable(false)
				.setPositiveButton("Reintentar",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						
						
						PortfolioModel portfolioModel = PortfolioModel.getInstance(MainActivity.this);
						portfolioModel.getPortfolio(MainActivity.this);
						
					}
				  })
				.setNegativeButton("Salir",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						MainActivity.this.finish();
						//dialog.cancel();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
	}
}