package com.portfolio.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.portfolio.R;
import com.portfolio.components.menu;

public class TextActivity extends Activity {

	private Button buttonMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_text);
        Bundle bundle = this.getIntent().getExtras();

//        String text = bundle.getString("text");
        //TextView textView = (TextView) findViewById(R.id.text);
        //textView.setText(text);
        
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
