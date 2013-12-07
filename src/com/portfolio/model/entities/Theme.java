package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.ITheme;


public class Theme implements ITheme {

	private String code;
	private String urlImages;
	private String background;
	private String titleBarBackground;
	private String menuBackground;
	private String menuItemBackground;
	private String homeBackground;
	private String colors;
	
	public Theme(JSONObject jsonObject) {
		try {
			this.code = jsonObject.getString("code");
			this.urlImages= jsonObject.getString("url_images");
			this.background = jsonObject.getString("background");
			this.titleBarBackground = jsonObject.getString("titlebar_background");
			this.menuBackground = jsonObject.getString("menu_background");
			this.menuItemBackground = jsonObject.getString("menu_item_background");
			this.homeBackground = jsonObject.getString("home_background");
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
	public String getBackground() {
		return this.background;
	}

	@Override
	public String getTitleBarBackground() {
		return this.titleBarBackground;
	}

	@Override
	public String getMenuBackground() {
		return this.menuBackground;
	}

	@Override
	public String getMenuItemBackground() {
		return this.menuItemBackground;
	}

	public String getHomeBackground() {
		return homeBackground;
	}

	public String getColors() {
		return colors;
	}

}
