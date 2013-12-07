package com.portfolio.model.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
            	Type type = new Type(page.getJSONObject("type"));
            	IPage pageObject = null;
            	if (type.getType().equalsIgnoreCase("text")) {
            		pageObject = new TextPage(type, page);
            	}
            	if (type.getType().equalsIgnoreCase("galeriaMultimedia")) {
            		pageObject = new PhotoGaleryPage(type, page);
            	}
            	if (type.getType().equalsIgnoreCase("contacto")) {
            		pageObject = new ContactPage(type, page);
            	}
            	if (type.getType().equalsIgnoreCase("redesSociales")) {
            		pageObject = new NetworkPage(type, page);
            	}
            	//NUEVAS PAGINAS
            	if (type.getType().equalsIgnoreCase("photo_txt_gridlist")) {
            		pageObject = new PhotoTxtGridListPage(type, page);
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
