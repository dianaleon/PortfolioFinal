package com.portfolio.activities;

import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

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

		// Setear el titulo en la pagina
		PortfolioModel portfolioModel = PortfolioModel.getInstance(this);
		IMenu menu = portfolioModel.getPorfolioMenu();
		menu.getTitle();
		menu.getBackground();
		TextView textViewTittle = (TextView) findViewById(R.id.tittle_app);
		TextView textViewSubTittle = (TextView) findViewById(R.id.sub_tittle_app);
		textViewTittle.setText(menu.getTitle());
		textViewSubTittle.setText(menu.getSubtitle());

		// cargar el layout
		List<IPageObject> objetos = catalogoPage.getObjects();

		for (int index = 0; index < objetos.size(); index++) {
			IPageObject object = objetos.get(index);
			String title = object.getTitle();
			String subtitle = object.getSubtitle();
			String content = object.getContent();

			switch (object.getType()) {

			case IPageObject.type_text:
				ITextObject text = (ITextObject) object;
				// textViewTittlePage.setText(text.getTitle());
				// textViewTextPage.setText(text.getDescription());
				break;

			case IPageObject.type_image:
				IImageObject img = (IImageObject) object;
				// titulo
				// textViewTittlePage.setText(img.getTitle());
				// texto
				// textViewTextPage.setText(img.getDescription());
				break;
			}
		}

		// MENU
		final menu menuLayout = (menu) findViewById(R.id.layout_menu);
		menuLayout.init();

	}
}