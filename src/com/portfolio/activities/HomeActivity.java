package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.portfolio.R;
import com.portfolio.components.menu;
import com.portfolio.listener.IPortfolioListener;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.IImagePage;
import com.portfolio.model.interfaces.IMenu;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITextPage;
import com.portfolio.model.interfaces.ITheme;
import com.portfolio.model.interfaces.component.IImageObject;
import com.portfolio.model.interfaces.component.INetworkObject;
import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class HomeActivity extends Activity {

        private Button buttonMenu;
      
        ImageView imgView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                
                super.onCreate(savedInstanceState);
                
                //la vista de la home. Layout:image (json)
                setContentView(R.layout.activity_image);
                Bundle bundle = this.getIntent().getExtras();
        		int position = bundle.getInt("position");
        		//levanto la pagina de esa posicion
                //la interfaz que se llama redes sociales,....
                IImagePage homePage = (IImagePage) PortfolioModel.getInstance(this).getPageInfo(position);
        	       
        		
                
                //cargar info
                ITheme iTheme = PortfolioModel.getInstance(this).getTheme();
                String url = iTheme.getUrlImages();
                ImageView imgView = (ImageView) findViewById(R.id.imageView1);
                List<IPageObject> objetos = homePage.getObjects();
                
                
                //Setear el titulo en la pagina
                PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
                IMenu menu = portfolioModel.getPorfolioMenu();
                     
                menu.getBackground();
                //Find views
                TextView textViewTittle = (TextView) findViewById(R.id.tittle_app);
                TextView textViewSubTittle = (TextView) findViewById(R.id.sub_tittle_app);
                //Set title and subtitle from json
                textViewTittle.setText(menu.getTitle());
                textViewSubTittle.setText(menu.getSubtitle());
                
                //Image to set as the home page
                ImageView imageView = (ImageView) findViewById(R.id.layout_content);
                //Fill Content
                for (int index = 0; index < objetos.size(); index++) {
                	IPageObject object = objetos.get(index);
                    String title = object.getTitle();
                    //String  imageBgUrl = object.getIconUrl();
                    String  content = object.getContent();
                    
                    switch (object.getType()) {
                    	
                    	case IPageObject.type_image:
                    		IImageObject img = (IImageObject) object;
                    		//imageView.setImageURI(img.getContent_img());???
                        	break;
                    		
                
                   }
                }
                
                
                
                
                
                
                
                //FUENTES
                Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/CopperplateGothicStd 31BC.otf");
                TextView customTittle = (TextView)findViewById(R.id.tittle_app);
                customTittle.setTypeface(font1);
                customTittle.setTextSize(22);
                //customTittle.setText(TITULO);
                Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/CopperplateGothicStd 31BC.otf");
                TextView customSubtittle = (TextView)findViewById(R.id.sub_tittle_app);
                customTittle.setTextSize(20);
                customSubtittle.setTypeface(font1);
                customSubtittle.setTextSize(14);
                customSubtittle.setTextScaleX(1);
                //customTittle.setText(SUBTITULO);
                
                
 
               
                
		        
        

        }
        //movement of the menu 
        
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