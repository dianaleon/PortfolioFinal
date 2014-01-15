package com.portfolio;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.ImageView;

import com.portfolio.activities.ContactActivity;
import com.portfolio.activities.NetworkActivity;
import com.portfolio.activities.PhotoTextListActivity;
import com.portfolio.activities.PhotoTextListTwoRowsActivity;
import com.portfolio.activities.TextActivity;
import com.portfolio.activities.VideoActivity;
import com.portfolio.listener.IPortfolioListener;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.entities.Portfolio;
import com.portfolio.model.interfaces.IMenu;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.IPhotoGaleryPage;
import com.portfolio.model.interfaces.ITextPage;

public class MainActivity extends Activity implements IPortfolioListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                 //requestWindowFeature(Window.FEATURE_NO_TITLE);     
                 setContentView(R.layout.activity_contact);
                
                PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
                portfolioModel.getPortfolio(this);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }

        @Override
        public void onPortfolioReady() {
                
        	PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
            IMenu menu = portfolioModel.getPorfolioMenu();
            menu.getTitle();
            menu.getBackground();
                
            //Obtener la cantidad de paginas.
            int pagesCount = portfolioModel.getNumberPages();
            //Obtener los tipos de paginas
            List<String> names = portfolioModel.getPagesTitles();
            
            //Levantar la primer pagina.
            IPage pageNum1 = portfolioModel.getPageInfo(5);
            switch (pageNum1.getType().getTypeValue()) {
                    
            		//la home
            		case IPage.type_image:
            			Intent intent5 = new Intent(MainActivity.this, TextActivity.class);
            			intent5.putExtra("position", 5);
            			startActivity(intent5);
            			break;
            		
            		
            		
            		case IPage.type_video:
	                	Intent intent1 = new Intent(MainActivity.this, VideoActivity.class);
	                    intent1.putExtra("position", 1);
	                    startActivity(intent1);
	                    break;
	                //listas
	                case IPage.type_photo_galery:
                    	Intent intent2 = new Intent(MainActivity.this, PhotoTextListTwoRowsActivity.class);
                        intent2.putExtra("position", 0);
                        startActivity(intent2);
                        break;
                    //redes sociales
	                case IPage.type_network:
                    	Intent intent3 = new Intent(MainActivity.this, NetworkActivity.class);
                        intent3.putExtra("position", 3);
                        startActivity(intent3);
                        break;
            		//imagen texto 
	                case IPage.type_text:
                            Intent intent4 = new Intent(MainActivity.this, TextActivity.class);
                            intent4.putExtra("position", 4);
                            startActivity(intent4);
                            break;
                    
                    //contacto  
                    case IPage.type_contact:
                    	Intent intent6 = new Intent(MainActivity.this, ContactActivity.class);
                        intent6.putExtra("position", 7);
                        startActivity(intent6);
                        break;
                                          
                    default:
                            break;
                    }
//            finish();                
    }

        @Override
        public void onImageReady(Bitmap bitmap) {
                ImageView imageView = (ImageView) getWindow().findViewById(R.id.image);
                imageView.setImageBitmap(bitmap);
        }

        @Override
        public void errorGetPortfolio() {

                Intent intent = new Intent(MainActivity.this, TextActivity.class);
                intent.putExtra("text", "");
                startActivity(intent);
        }

}