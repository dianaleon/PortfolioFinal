package com.portfolio.model.entities;

import java.util.Collection;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IClient;
import com.portfolio.model.interfaces.IMenu;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITheme;

public class Portfolio {

	private HashMap<Integer, IPage> pages;
	private IClient client;
	private ITheme theme;
	private IMenu menu;
	
	public Portfolio(final JSONObject JSONPortfolio) {
        try {
        	client = new Client(JSONPortfolio.getJSONObject("client"));
        	theme = new Theme(JSONPortfolio.getJSONObject("theme"));
        	JSONObject jsonMenu = JSONPortfolio.getJSONObject("menu");
        	menu = new Menu(jsonMenu);
        	this.pages = new HashMap<Integer, IPage>();
            JSONArray pages = jsonMenu.getJSONArray("pages");
            for (int index = 0; index < pages.length(); index++) {
            	JSONObject page = pages.getJSONObject(index);
            	String layout = page.getString("layout");
            	Type type = new Type(page.getJSONObject("type"));
            	IPage pageObject = null;
            	if (layout.equalsIgnoreCase("photo_text_gridlist")) {
            		pageObject = new PhotoTxtGridListPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("curriculum")) {
            		pageObject = new CurriculumPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("text_subtopic")) {
            		pageObject = new TxtSubtopicPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("image")) {
            		pageObject = new ImagePage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("photo_grid")) {
            		pageObject = new PhotoGridPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("photo_gallery")) {
            		pageObject = new PhotoGalleryPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("video")) {
            		pageObject = new VideoPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("redesSociales")) {
            		pageObject = new NetworkPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("photo_text")) {
            		pageObject = new PhotoTextPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("text_photo_text")) {
            		pageObject = new TxtPhotoTxtPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("contacto")) {
            		pageObject = new ContactPage(type, page, layout);
            	}
            	if (layout.equalsIgnoreCase("catalogo")) {
            		pageObject = new CatalogoPage(type, page, layout);
            	}

            	if (pageObject != null) {
//	            	String namePage = page.getString("name");
//	            	((Page) pageObject).setName(namePage);
	        		this.pages.put(pageObject.getPosition(), pageObject);
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public IClient getClient() {
		return client;
	}

	public ITheme getTheme() {
		return theme;
	}

	public IMenu getMenu() {
		return menu;
	}

	public int getNumberPages() {
		return pages.size();
	}

	public IPage getPage(int numberPage) {
		return pages.get(numberPage);
	}

	public Collection<IPage> getPages() {
		return pages.values();
	}

//	public void setPages(List<IPage> pages) {
//		this.pages = pages;
//	}
}
