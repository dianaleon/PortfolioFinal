package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.portfolio.R;
import com.portfolio.components.menu;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.ITextPage;
import com.portfolio.model.interfaces.component.INetworkObject;
import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class NetworkActivity extends Activity {
	
	private Button buttonMenu;
	Button buttonItem1;
    Button buttonItem2;
    Button buttonItem3;
    Button buttonItem4;
    Button buttonItem5;
    Button buttonItem6;
    Button buttonItem7;
    ViewFlipper flipper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_network);
		Bundle bundle = this.getIntent().getExtras();
		int position = bundle.getInt("position");
		
		//levanto la pagina de esa posicion
        //la interfaz que se llama redes sociales,....
        INetworkPage textPage = (INetworkPage) PortfolioModel.getInstance(this).getPageInfo(position);
        
        //cargar el layout
        List<IPageObject> objetos = textPage.getObjects();
        String title = null;
        String subtitle = null;
        String content = null;
        String urlFinal = null;
        
        for (int index = 0; index < objetos.size(); index++) {
            IPageObject object = objetos.get(index);
            switch (object.getType()) {
            	
            	case IPageObject.type_network:
            		INetworkObject text = (INetworkObject) object;
            		title = text.getTitle();//???
            		subtitle = text.getSubtitle();
            		content = text.getContent();
            
           }
        }
		//caragar layout
        //url de la red social + nombre red social
        Button fbButton = (Button) findViewById(R.id.facebook);
        fbButton.setText(content);
        
        Button twitterButton = (Button) findViewById(R.id.twitter);
        twitterButton.setText(content);
        
        Button linkedInButton = (Button) findViewById(R.id.linkedin);
        linkedInButton.setText(content);
        
        Button googleButton = (Button) findViewById(R.id.google);
        twitterButton.setText(content);
        
        Button pinterestButton = (Button) findViewById(R.id.pinterest);
        twitterButton.setText(content);
        
        Button instagramButton = (Button) findViewById(R.id.instagram);
        twitterButton.setText(content);
		
		
		
		
		
		//MENU
		final menu menuLayout = (menu) findViewById(R.id.layout_menu);
        menuLayout.init();
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        buttonMenu = (Button) findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	flipper.setInAnimation(inFromRightAnimation());
                	flipper.setOutAnimation(outToLeftAnimation());
                	flipper.showNext();     
                }
            });
      //BuFETE
        buttonItem1 = (Button) findViewById(R.id.itemMenu1);
        buttonItem1.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), PhotoTittleTextActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
        //Socios
        buttonItem2 = (Button) findViewById(R.id.itemMenu2);
        buttonItem2.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), PhotoTextListTwoRowsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
        //Especialistas en: despliega el submenu
        buttonItem3 = (Button) findViewById(R.id.itemMenu2);
        buttonItem3.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), PhotoTextListTwoRowsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
        //Servicios? seguramente despliega otro submenu tambien, consultar!
        buttonItem4 = (Button) findViewById(R.id.itemMenu2);
        buttonItem4.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), PhotoTextListTwoRowsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
        //Testimonios
        buttonItem5 = (Button) findViewById(R.id.itemMenu2);
        buttonItem5.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), PhotoTextListActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
        //Redes sociales
        buttonItem6 = (Button) findViewById(R.id.itemMenu2);
        buttonItem6.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), NetworkActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
      //Contacto
        buttonItem7 = (Button) findViewById(R.id.itemMenu2);
        buttonItem7.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), ContactActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
            });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private Animation inFromRightAnimation() {
        
    	Animation inFromRight = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	inFromRight.setDuration(500);
    	inFromRight.setInterpolator(new AccelerateInterpolator());
    	
    	return inFromRight;
    	
    }
    private Animation outToLeftAnimation() {
    	
    	Animation outtoLeft = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	outtoLeft.setDuration(500);
    	outtoLeft.setInterpolator(new AccelerateInterpolator());
    	
    	return outtoLeft;
    }
    private Animation inFromLeftAnimation() {
    
    	Animation inFromLeft = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	inFromLeft.setDuration(500);
    	inFromLeft.setInterpolator(new AccelerateInterpolator());
    	
    	return inFromLeft;
    }
    	
    private Animation outToRightAnimation() {
    	
    	Animation outtoRight = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	
    	outtoRight.setDuration(500);
    	outtoRight.setInterpolator(new AccelerateInterpolator());
    	
    	return outtoRight;
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
