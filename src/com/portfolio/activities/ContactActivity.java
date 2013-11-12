package com.portfolio.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.portfolio.R;
import com.portfolio.components.menu;

public class ContactActivity extends Activity {

	private Button buttonMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		//getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
		///TextView txt = (TextView) findViewById(R.id.custom_font);
		///Typeface font = Typeface.createFromAsset(getAssets(), "hindifont.ttf");
		///txt.setTypeface(font);
		setContentView(R.layout.activity_contact);
		
		final menu menuLayout = (menu) findViewById(R.id.layout_menu);
        menuLayout.init();
        
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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
