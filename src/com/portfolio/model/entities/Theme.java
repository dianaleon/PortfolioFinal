package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.BackgroundObject;
import com.portfolio.model.interfaces.ITheme;


public class Theme implements ITheme {

	private String code;
	private String urlImages;
	private BackgroundObject background;
	private BackgroundObject titleBarBackground;
	private BackgroundObject menuBackground;
	private BackgroundObject menuItemBackground;
	private BackgroundObject homeBackground;
	private String colors;
	
	public Theme(JSONObject jsonObject) {
		try {
			this.code = jsonObject.getString("code");
			this.urlImages= jsonObject.getString("url_images");
			this.background = new BackgroundObject(jsonObject.getString("background"));
			this.titleBarBackground = new BackgroundObject(jsonObject.getString("titlebar_background"));
			this.menuBackground = new BackgroundObject(jsonObject.getString("menu_background"));
			this.menuItemBackground = new BackgroundObject(jsonObject.getString("menu_item_background"));
			this.homeBackground = new BackgroundObject(jsonObject.getString("home_background"));
			this.colors = jsonObject.getString("colors");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getUrlImages() {
		return this.urlImages;
	}

	@Override
	public BackgroundObject getBackground() {
		return this.background;
	}

	@Override
	public BackgroundObject getTitleBarBackground() {
		return this.titleBarBackground;
	}

	@Override
	public BackgroundObject getMenuBackground() {
		return this.menuBackground;
	}

	@Override
	public BackgroundObject getMenuItemBackground() {
		return this.menuItemBackground;
	}

	public BackgroundObject getHomeBackground() {
		return homeBackground;
	}

	public String getColors() {
		return colors;
	}

}
