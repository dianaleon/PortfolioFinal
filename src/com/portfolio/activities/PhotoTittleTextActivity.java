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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.portfolio.R;
import com.portfolio.components.menu;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.IPhotoTextPage;
import com.portfolio.model.interfaces.ITextPage;
import com.portfolio.model.interfaces.ITheme;
import com.portfolio.model.interfaces.component.IImageObject;
import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class PhotoTittleTextActivity extends Activity {
        
        private Button buttonMenu;
        ViewFlipper flipper;
        Button buttonItem1;
        Button buttonItem2;
        Button buttonItem3;
        Button buttonItem4;
        Button buttonItem5;
        Button buttonItem6;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_ttl_txt_img);
                Bundle bundle = this.getIntent().getExtras();
                int position = bundle.getInt("position");
		        
                //levanto la pagina de esa posicion
                //la interfaz que se llama text, que tiene imagen, titulo y texto
                IPhotoTextPage textPage = (IPhotoTextPage) PortfolioModel.getInstance(this).getPageInfo(position);
               
                //caragr info
                ITheme iTheme = PortfolioModel.getInstance(this).getTheme();
                String url = iTheme.getUrlImages();
                ImageView imgView = (ImageView) findViewById(R.id.imageView1);
                //levantar info para el layout
                // imagen +  titulo + texto
                List<IPageObject> objetos = textPage.getObjects();
                String title = null;
                String subtitle = null;
                String content = null;
                String urlFinal = null;
                for (int index = 0; index < objetos.size(); index++) {
                	IPageObject object = objetos.get(index);
                	switch (object.getType()) {
                        
                        case IPageObject.type_text:
                            ITextObject text = (ITextObject) object;
                            title = text.getTitle();
                            subtitle = text.getSubtitle();
                            content = text.getContent();
                            urlFinal = url + text.getContent_img();
                        
                        case IPageObject.type_image:
                        	IImageObject img = (IImageObject) object;
                            title = img.getTitle();
                            subtitle = img.getSubtitle();
                            content = img.getDescription();
                            urlFinal = url + img.getContent_img();
                        
                    
                   }
                }
                
                //cargar el layout
                TextView tittleView = (TextView) findViewById(R.id.tittle);
                tittleView.setText(title);
                
                TextView textView = (TextView) findViewById(R.id.text_item);
                textView.setText(content);
                
               
                
                
                
                
                
                //MENU
                flipper = (ViewFlipper) findViewById(R.id.flipper);
		
		        final menu menuLayout = (menu) findViewById(R.id.layout_menu);
		        menuLayout.init();	
                
                buttonMenu.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    flipper.setInAnimation(inFromRightAnimation());
                    flipper.setOutAnimation(outToLeftAnimation());
                    flipper.showNext(); 
	                }
	            });
                buttonItem1 = (Button) findViewById(R.id.itemMenu1);
                buttonItem1.setOnClickListener(new OnClickListener() {
                @Override
                    public void onClick(View v) {
                                startActivity(new Intent(getApplicationContext(), PhotoTittleTextActivity.class));
                                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                            }
                    });
                buttonItem2 = (Button) findViewById(R.id.itemMenu2);
                buttonItem2.setOnClickListener(new OnClickListener() {
                @Override
                    public void onClick(View v) {
                                startActivity(new Intent(getApplicationContext(), PhotoTextListTwoRowsActivity.class));
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