package com.portfolio.components;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.portfolio.activities.TextActivity;

public class Menu extends LinearLayout {
	
	//private TextView textPageItem;
	//private TextView galleryPageItem;
	//private TextView contactPageItem;
	//private TextView socialPageItem;
	private Button buttonMenu;
	private LinearLayout menu;
	private TextActivity ta;
	
	public Menu(Context context) {
		super(context);
		ta = (TextActivity) context;
	}
	private void initialize() {	
		
		buttonMenu = (Button) findViewById(R.id.buttonMenu);
		buttonMenu.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           menu = (LinearLayout) findViewById(R.id.menu);
	           menu.setVisibility(View.VISIBLE);
	        }
	    });
		
		
	}
	
	
	

}
	
	

