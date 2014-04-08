package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ImageView;
import com.portfolio.R;
import com.portfolio.components.menu;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.ICatalogoPage;
import com.portfolio.model.interfaces.IMenu;
import com.portfolio.model.interfaces.ITheme;
import com.portfolio.model.interfaces.component.IImageObject;
import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class CatalogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//la vista de la pagina que es una lista de imagenes y textos. Layout:catalgo (json)
        setContentView(R.layout.activity_catalogo);
		Bundle bundle = this.getIntent().getExtras();
		int position = bundle.getInt("position");

		// levanto la pagina de esa posicion
		// la interfaz que se llama contact, que tiene una lista de url + nombre
		// + etc
		ICatalogoPage catalogoPage = (ICatalogoPage) PortfolioModel
				.getInstance(this).getPageInfo(position);

		// caragr info
		ITheme iTheme = PortfolioModel.getInstance(this).getTheme();
		String url = iTheme.getUrlImages();

		
		
		PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
		IMenu menu = portfolioModel.getPorfolioMenu();
		menu.getBackground();
		TextView textViewTittle = (TextView) findViewById(R.id.tittle_app);
		TextView textViewSubTittle = (TextView) findViewById(R.id.sub_tittle_app);
		textViewTittle.setText(menu.getTitle());
		textViewSubTittle.setText(menu.getSubtitle());

		// cargar el layout
		List<IPageObject> objetos = catalogoPage.getObjects();
		TableLayout table = new TableLayout(this);
		
		for (int index = 0; index < objetos.size(); index++) {
			IPageObject object = objetos.get(index);
			String title = object.getTitle();
			String subtitle = object.getSubtitle();
			String content = object.getContent();
			TableRow tableRow = (TableRow)findViewById(R.id.tableRowList);
			ImageView imageItem = (ImageView) tableRow.findViewById(R.id.imageView1);
			TextView titlePageItem = (TextView) findViewById(R.id.tittle_item_list);
			TextView textPageItem = (TextView) findViewById(R.id.text_page_item);
			switch (object.getType()) {

			case IPageObject.type_text:
				ITextObject text = (ITextObject) object;
				//imageItem.setImageDrawable(text.getContent_img()); ???
				titlePageItem.setText(text.getTitle());
				textPageItem.setText(text.getContent());
				
				break;

			case IPageObject.type_image:
				IImageObject img = (IImageObject) object;
				//imageItem.setImageDrawable(text.getContent_img()); ???
				titlePageItem.setText(img.getTitle());
				textPageItem.setText(img.getContent());
				break;
			}
			table.addView(tableRow);
			
		}
		//FUENTES
		// Cargar el titulo y el subtitulo
		Typeface font1 = Typeface.createFromAsset(getAssets(),
						"fonts/CopperplateGothicStd 31AB.otf");
		TextView customTittle = (TextView) findViewById(R.id.tittle_app);
		customTittle.setTypeface(font1);
		// customTittle.setText(TITULO);
		Typeface font2 = Typeface.createFromAsset(getAssets(),
						"fonts/CopperplateGothicStd 32AB.otf");
		TextView customSubtittle = (TextView) findViewById(R.id.sub_tittle_app);
		customSubtittle.setTypeface(font1);
		// customTittle.setText(SUBTITULO);

		// MENU
		final menu menuLayout = (menu) findViewById(R.id.layout_menu);
		menuLayout.init();

	}
}
