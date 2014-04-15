package com.portfolio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.portfolio.activities.HomeActivity;
import com.portfolio.activities.NetworkActivity;
import com.portfolio.activities.TextActivity;
import com.portfolio.listener.IPortfolioListener;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.IMenu;

public class MainActivity extends Activity implements IPortfolioListener{
		
		public String tittleApp =null;
		public String subtittleApp =null;
        
		@Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                 //requestWindowFeature(Window.FEATURE_NO_TITLE);     
                 //setContentView(R.layout.activity_contact);
                
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
            tittleApp = menu.getTitle();
            subtittleApp = menu.getSubtitle();
            menu.getBackground();
            
            
            /*    
            //Obtener la cantidad de paginas.
            int pagesCount = portfolioModel.getNumberPages();
            //Obtener los tipos de paginas
            List<String> names = portfolioModel.getPagesTitles();
            
            //TextView textView = (TextView) findViewById(R.id.tittle_app);
            //Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/CopperGothicStd29AB.otf");
            //textView.setTypeface(tf);
            
            
            
            //Levantar la primer pagina.
            IPage pageNum1 = portfolioModel.getPageInfo(5);*/
            /*hago estatica la home para asi pruebo el resto de las paginas
            Intent intent0 = new Intent(MainActivity.this, HomeActivity.class);
            intent0.putExtra("position", 3);
            startActivity(intent0);*/
            Intent intent3 = new Intent(MainActivity.this, NetworkActivity.class);
      	 	intent3.putExtra("position", 7);
      	 	startActivity(intent3);
            /*
            switch (pageNum1.getType().getTypeValue()) {
            		//contacto  
            		case IPage.type_contact:
		            	Intent intent6 = new Intent(MainActivity.this, ContactActivity.class);
		                intent6.putExtra("position", 7);
		                startActivity(intent6);
		                break;
		            //redes sociales
	                case IPage.type_network:
                    	Intent intent3 = new Intent(MainActivity.this, NetworkActivity.class);
                        intent3.putExtra("position", 4);
                        startActivity(intent3);
                        break;
                    
                    //la home
            		case IPage.type_image:
            			Intent intent5 = new Intent(MainActivity.this, TextActivity.class);
            			intent5.putExtra("position", 5);
            			startActivity(intent5);
            			break;
            			
            		//listas de imagenes con textos
	                case IPage.type_text:
                            Intent intent4 = new Intent(MainActivity.this, PhotoTextListActivity.class);
                            intent4.putExtra("position", 1);
                            startActivity(intent4);
                            break;
            	
                            
                            
                    /*       
            		case IPage.type_video:
	                	Intent intent1 = new Intent(MainActivity.this, VideoActivity.class);
	                    intent1.putExtra("position", 1);
	                    startActivity(intent1);
	                    break;
	                //listas
	                case IPage.type_photo_galery:
                    	Intent intent2 = new Intent(MainActivity.this, PhotoTextListActivity.class);
                        intent2.putExtra("position", 0);
                        startActivity(intent2);
                        break;
                    */
                    
                    
                   
                    /*                      
                    default:
                            break;
                    } */
           finish();                
    }


        @Override
        public void errorGetPortfolio() {

                Intent intent = new Intent(MainActivity.this, TextActivity.class);
                intent.putExtra("text", "");
                startActivity(intent);
        }

}