package com.portfolio.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.portfolio.MainActivity;
import com.portfolio.R;
import com.portfolio.components.menu;

public class PhotoTextListActivity extends Activity {
	private Button buttonMenu;
	private Button buttonItem1;
	private Button buttonItem2;
	private Button buttonItem3;
	private Button buttonItem4;
	private Button buttonItem5;
	private Button buttonItem6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		
		setContentView(R.layout.activity_photo_text_gridlist);
		final menu menuLayout = (menu) findViewById(R.id.layout_menu);

		
		buttonMenu = (Button) findViewById(R.id.buttonMenu);
		buttonMenu.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	if (menuLayout.getVisibility() == View.VISIBLE) {
	        		menuLayout.setVisibility(View.INVISIBLE);
	        	} else {
	        		menuLayout.setVisibility(View.VISIBLE);	        		
	        	}
	        }
	    });
		buttonItem1 = (Button) findViewById(R.id.itemMenu1);
		buttonItem1.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(PhotoTextListActivity.this, TextActivity.class);
	        	startActivity(intent);
	        }
	    });
		buttonItem2 = (Button) findViewById(R.id.itemMenu2);
		buttonItem2.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(PhotoTextListActivity.this, TextActivity.class);
	        	startActivity(intent);
	        }
	    });
		buttonItem3 = (Button) findViewById(R.id.itemMenu3);
		buttonItem3.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(PhotoTextListActivity.this, TextActivity.class);
	        	startActivity(intent);
	        }
	    });
		buttonItem4 = (Button) findViewById(R.id.itemMenu4);
		buttonItem4.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(PhotoTextListActivity.this, TextActivity.class);
	        	startActivity(intent);
	        }
	    });
		buttonItem5 = (Button) findViewById(R.id.itemMenu5);
		buttonItem5.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(PhotoTextListActivity.this, TextActivity.class);
	        	startActivity(intent);
	        }
	    });
		buttonItem6 = (Button) findViewById(R.id.itemMenu6);
		buttonItem6.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(PhotoTextListActivity.this, TextActivity.class);
	        	startActivity(intent);
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
