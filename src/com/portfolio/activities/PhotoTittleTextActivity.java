package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
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
import com.portfolio.listener.IMediaListener;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.IPhotoTextPage;
import com.portfolio.model.interfaces.IPhotosGridPage;
import com.portfolio.model.interfaces.ITextPage;
import com.portfolio.model.interfaces.ITheme;
import com.portfolio.model.interfaces.component.IImageObject;
import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class PhotoTittleTextActivity extends Activity {
        
        private Button buttonMenu;
        ViewFlipper flipper;
        String title = null;//title
        String content = null;//texto
        ImageView imgView = null;//content_img
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                
                super.onCreate(savedInstanceState);
                //la vista de la home. Layout:photo_grid (json pos 4)
                setContentView(R.layout.activity_ttl_txt_img);
                Bundle bundle = this.getIntent().getExtras();
                int position = bundle.getInt("position");
		        
                //levanto la pagina de esa posicion
                //la interfaz que se llama text, que tiene imagen, titulo y texto
                IPhotosGridPage ttlPage = (IPhotosGridPage) PortfolioModel.getInstance(this).getPageInfo(position);
               
                //caragr info
                ITheme iTheme = PortfolioModel.getInstance(this).getTheme();
                String url = iTheme.getUrlImages();
                final ImageView imageView = (ImageView)findViewById(R.id.imageView1);
                //levantar info para el layout
                // imagen +  titulo + texto
                List<IPageObject> objetos = ttlPage.getObjects();
                
                for (int index = 0; index < objetos.size(); index++) {
                	IPageObject object = objetos.get(index);
                	switch (object.getType()) {
                 
                        case IPageObject.type_image:
                        	final IImageObject img = (IImageObject) object;
                        	title = img.getTitle();
                            content = img.getDescription();
                    		PortfolioModel.getInstance(this).getMedia(new IMediaListener() {
								
								@Override
								public void onImageReady(Bitmap bitmap) {
									imageView.setImageBitmap(bitmap);
								}
								
							}, img.getContent_img());
                        	break;
                            
                           
                        
                    
                   }
                }
                
                //cargar el layout con el contenido del json
                TextView tittleView = (TextView) findViewById(R.id.tittle);
                tittleView.setText(title);
                
                TextView textView = (TextView) findViewById(R.id.text_page_item);
                textView.setText(content);
         
                
                
                
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