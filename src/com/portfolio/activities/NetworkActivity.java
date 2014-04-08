package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
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
import com.portfolio.model.interfaces.IContactPage;
import com.portfolio.model.interfaces.IMenu;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITextPage;
import com.portfolio.model.interfaces.ITheme;
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
    String addressfb = null;
    String addresstwitter = null;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_network);
		Bundle bundle = this.getIntent().getExtras();
		int position = bundle.getInt("position");
		
		//levanto la pagina de esa posicion
        //la interfaz que se llama redes sociales,....
        INetworkPage textPage = (INetworkPage) PortfolioModel.getInstance(this).getPageInfo(position);
       
        //caragr info
        ITheme iTheme = PortfolioModel.getInstance(this).getTheme();
        String url = iTheme.getUrlImages();
        
        //cargar el layout
        List<IPageObject> objetos = textPage.getObjects();
        
        
        
        //Cargar el titulo en la pagina
        PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
        IMenu menu = portfolioModel.getPorfolioMenu();
        menu.getBackground();
        
        
        
        //Identifico los botones de las redes sociales
        Button twButton = (Button) findViewById(R.id.twitter);
        Button fbButton = (Button) findViewById(R.id.facebook);
        Button liButton = (Button) findViewById(R.id.linkedin);
        Button gpButton = (Button) findViewById(R.id.google);
        Button ptButton = (Button) findViewById(R.id.pinterest);
        Button inButton = (Button) findViewById(R.id.instagram);
       
        
        for (int index = 0; index < objetos.size(); index++) {
            
        	IPageObject object = objetos.get(index);
            String title = object.getTitle();
            //String  imageBgUrl = object.getIconUrl();
            String  content = object.getContent();
            
            switch (object.getType()) {
            	
            	case IPageObject.type_network:
            		INetworkObject social = (INetworkObject) object;
            		String  type = social.getSubtype();
            		if (type != null){
            			if(type.equalsIgnoreCase(INetworkPage.facebook)) {
            				addressfb = content;
	        				fbButton.setText(title);
	        				fbButton.setTextColor(Color.TRANSPARENT);
	        			
	        			}
            			if(type.equalsIgnoreCase(INetworkPage.twitter)) {
            				addresstwitter = content;
            				twButton.setText(content);
            				twButton.setTextColor(Color.TRANSPARENT);	
	        			}
            		}
        
           }
        }
        
        //set listeners for buttons
        fbButton.setOnClickListener(new OnClickListener() {
	       	public void onClick(View v) {
	       		 Uri uri = Uri.parse(addressfb);
	       		 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	       		 startActivity(intent);
	            }
        });
        
        twButton.setOnClickListener(new OnClickListener() {
	       	public void onClick(View v) {
	       		 Uri uri = Uri.parse(addresstwitter);
	       		 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	       		 startActivity(intent);
	            }
        });
        
        /*Button twitterButton = (Button) findViewById(R.id.twitter);
        twitterButton.setText(content);
        
        Button linkedInButton = (Button) findViewById(R.id.linkedin);
        linkedInButton.setText(content);
        
        Button googleButton = (Button) findViewById(R.id.google);
        twitterButton.setText(content);
        
        Button pinterestButton = (Button) findViewById(R.id.pinterest);
        twitterButton.setText(content);
        
        Button instagramButton = (Button) findViewById(R.id.instagram);
        twitterButton.setText(content);*/
		
		
		
        //FUENTES
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/CopperplateGothicStd 31BC.otf");
        TextView customTittle = (TextView)findViewById(R.id.tittle_app);
        customTittle.setTypeface(font1);
        customTittle.setTextSize(22);
         //customTittle.setText(TITULO);
        
        
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/CopperplateGothicStd 31BC.otf");
        TextView customSubtittle = (TextView)findViewById(R.id.sub_tittle_app);
        customSubtittle.setTypeface(font1);
        customSubtittle.setTextSize(14);
        customSubtittle.setTextScaleX(1);
        //customTittle.setText(SUBTITULO);
		
        customTittle.setText(menu.getTitle());
        customSubtittle.setText(menu.getSubtitle());
        
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
    	inFromRight.setDuration(100);
    	inFromRight.setInterpolator(new AccelerateInterpolator());
    	
    	return inFromRight;
    	
    }
    private Animation outToLeftAnimation() {
    	
    	Animation outtoLeft = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	outtoLeft.setDuration(100);
    	outtoLeft.setInterpolator(new AccelerateInterpolator());
    	
    	return outtoLeft;
    }
    private Animation inFromLeftAnimation() {
    
    	Animation inFromLeft = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	inFromLeft.setDuration(100);
    	inFromLeft.setInterpolator(new AccelerateInterpolator());
    	
    	return inFromLeft;
    }
    	
    private Animation outToRightAnimation() {
    	
    	Animation outtoRight = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f);
    	
    	outtoRight.setDuration(100);
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
