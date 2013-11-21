package com.portfolio.components;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.portfolio.R;
import com.portfolio.activities.ContactActivity;
import com.portfolio.activities.NetworkActivity;
import com.portfolio.activities.PhotoTextListActivity;
import com.portfolio.activities.PhotoTextListTwoRowsActivity;
import com.portfolio.activities.PhotoTittleTextActivity;
import com.portfolio.activities.TextActivity;

public class menu extends LinearLayout {
        
        //private TextView textPageItem;
        //private TextView galleryPageItem;
        //private TextView contactPageItem;
        //private TextView socialPageItem;
        private Button buttonItem1;
        private Button buttonItem2;
        private Button buttonItem3;
        private Button buttonItem4;
        private Button buttonItem5;
        private Button buttonItem6;
        private LinearLayout menu;
        private TextActivity ta;
        
        public menu(Context context) {
                super(context);
                init();
        }

        public menu(Context context, AttributeSet attrs) {
                super(context, attrs);
        }
        
        public void init() {
            
            buttonItem2 = (Button) findViewById(R.id.itemMenu2);
            buttonItem2.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                getContext().startActivity(new Intent(getContext(), PhotoTextListTwoRowsActivity.class));
                        }
                });
            buttonItem3 = (Button) findViewById(R.id.itemMenu3);
            buttonItem3.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                getContext().startActivity(new Intent(getContext(), NetworkActivity.class));
                        }
                });
            buttonItem4 = (Button) findViewById(R.id.itemMenu4);
            buttonItem4.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                getContext().startActivity(new Intent(getContext(), PhotoTextListActivity.class));
                        }
                });
            buttonItem5 = (Button) findViewById(R.id.itemMenu4);
            buttonItem5.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                getContext().startActivity(new Intent(getContext(), NetworkActivity.class));
                        }
                });
            buttonItem6 = (Button) findViewById(R.id.itemMenu4);
            buttonItem6.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                getContext().startActivity(new Intent(getContext(), ContactActivity.class));
                        }
                });
    }
}