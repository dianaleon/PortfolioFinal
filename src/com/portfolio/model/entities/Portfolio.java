package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IPage;

public class Portfolio {

	private List<IPage> pages;
	
	public Portfolio(final JSONObject JSONPortfolio) {
        try {
        	this.pages = new ArrayList<IPage>();
            JSONArray pages = JSONPortfolio.getJSONArray("page");
            for (int index = 0; index < pages.length(); index++) {
            	JSONObject page = pages.getJSONObject(index);
            	JSONObject type = page.getJSONObject("type");
            	IPage pageObject = null;
            	if (type.getString("code").equalsIgnoreCase("text")) {
            		pageObject = new TextPage(page);
            	}
            	if (type.getString("code").equalsIgnoreCase("photos-gallery")) {
            		pageObject = new PhotoGaleryPage(page);
            	}
            	if (type.getString("code").equalsIgnoreCase("contact")) {
            		pageObject = new ContactPage(page);
            	}
            	if (type.getString("code").equalsIgnoreCase("network")) {
            		pageObject = new NetworkPage(page);
            	}
            	String namePage = page.getString("name");
            	((Page) pageObject).setName(namePage);
        		this.pages.add(pageObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
