package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IClient;
import com.portfolio.model.interfaces.IMenu;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITheme;

public class Portfolio {

	private List<IPage> pages;
	private IClient client;
	private ITheme theme;
	private IMenu menu;
	
	public Portfolio(final JSONObject JSONPortfolio) {
        try {
        	client = new Client(JSONPortfolio.getJSONObject("client"));
        	theme = new Theme(JSONPortfolio.getJSONObject("theme"));
        	JSONObject jsonMenu = JSONPortfolio.getJSONObject("menu");
        	menu = new Menu(jsonMenu);
        	this.pages = new ArrayList<IPage>();
            JSONArray pages = jsonMenu.getJSONArray("page");
            for (int index = 0; index < pages.length(); index++) {
            	JSONObject page = pages.getJSONObject(index);
            	Type type = new Type(page.getJSONObject("type"));
            	IPage pageObject = null;
            	if (type.getType().equalsIgnoreCase("text")) {
            		pageObject = new TextPage(type, page);
            	}
            	if (type.getType().equalsIgnoreCase("photos-gallery")) {
            		pageObject = new PhotoGaleryPage(type, page);
            	}
            	if (type.getType().equalsIgnoreCase("contact")) {
            		pageObject = new ContactPage(type, page);
            	}
            	if (type.getType().equalsIgnoreCase("network")) {
            		pageObject = new NetworkPage(type, page);
            	}
            	//NUEVAS PAGINAS
            	if (type.getType().equalsIgnoreCase("photo_txt_gridlist")) {
            		pageObject = new PhotoTxtGridListPage(type, page);
            	}

            	String namePage = page.getString("name");
            	((Page) pageObject).setName(namePage);
        		this.pages.add(pageObject);
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
		return pages.get(numberPage - 1);
	}

	public List<IPage> getPages() {
		return pages;
	}

	public void setPages(List<IPage> pages) {
		this.pages = pages;
	}
}
