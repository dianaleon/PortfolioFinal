package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
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
        
        
        Button twButton = (Button) findViewById(R.id.twitter);
        Button fbButton = (Button) findViewById(R.id.facebook);
        Button liButton = (Button) findViewById(R.id.linkedin);
        Button gpButton = (Button) findViewById(R.id.google);
        Button ptButton = (Button) findViewById(R.id.pinterest);
        Button inButton = (Button) findViewById(R.id.instagram);
       
        //por ahora son estaticos cargados
        //google plus
        StateListDrawable slDrawGplus = new StateListDrawable(); 
        slDrawGplus.addState(new int[] {android.R.attr.state_focused}, 
                getResources().getDrawable(R.drawable.gplus_hover));
        slDrawGplus.addState(new int[] {}, 
                getResources().getDrawable(R.drawable.gplus)); 
        
        //pinterest
        StateListDrawable slDrawPinterest = new StateListDrawable(); 
        slDrawPinterest.addState(new int[] {android.R.attr.state_focused}, 
                getResources().getDrawable(R.drawable.pinterest_hover));
        slDrawPinterest.addState(new int[] {}, 
                getResources().getDrawable(R.drawable.pinterest)); 
      //Instagram
        StateListDrawable slDrawInstagram = new StateListDrawable(); 
        slDrawInstagram.addState(new int[] {android.R.attr.state_focused}, 
                getResources().getDrawable(R.drawable.instagram_hover));
        slDrawInstagram.addState(new int[] {}, 
                getResources().getDrawable(R.drawable.instagram));
      //Instagram
        StateListDrawable slDrawLinkedIn= new StateListDrawable(); 
        slDrawLinkedIn.addState(new int[] {android.R.attr.state_focused}, 
                getResources().getDrawable(R.drawable.linkedin_hover));
        slDrawLinkedIn.addState(new int[] {}, 
                getResources().getDrawable(R.drawable.lin));
        
        liButton.setBackgroundResource(R.drawable.lin);
        gpButton.setBackgroundResource(R.drawable.gplus);
        inButton.setBackgroundResource(R.drawable.instagram);
        ptButton.setBackgroundResource(R.drawable.pinterest);
        
        
        
        
        
        
        
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
	        				
	        				//aca irian las imagenes que traemos de hover y normal, por ahora son estaticas
	        				StateListDrawable slDrawFacebook = new StateListDrawable(); 
	        		        slDrawFacebook.addState(new int[] {android.R.attr.state_focused}, 
	        		                getResources().getDrawable(R.drawable.fb_hover));
	        		        slDrawFacebook.addState(new int[] {}, 
	        		                getResources().getDrawable(R.drawable.fb)); 
	        		        fbButton.setBackgroundResource(R.drawable.fb);
	        				
	        			}
            			if(type.equalsIgnoreCase(INetworkPage.twitter)) {
            				addresstwitter = content;
            				twButton.setText(content);
            				//aca irian las imagenes que traemos de hover y normal, por ahora son estaticas
	        				StateListDrawable slDrawTwitter= new StateListDrawable(); 
	        				slDrawTwitter.addState(new int[] {android.R.attr.state_focused}, 
	        		                getResources().getDrawable(R.drawable.twitter));
	        				slDrawTwitter.addState(new int[] {}, 
	        		                getResources().getDrawable(R.drawable.twitter_hover)); 
	        				twButton.setBackgroundResource(R.drawable.twitter);
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
        /*
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
        
	
*/
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
