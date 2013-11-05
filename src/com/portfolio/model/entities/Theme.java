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
	
	public Theme(JSONObject jsonObject) {
		try {
			this.code = jsonObject.getString("code");
			this.urlImages= jsonObject.getString("url-images");
			this.background = jsonObject.getString("background");
			this.titleBarBackground = jsonObject.getString("titlebar-background");
			this.menuBackground = jsonObject.getString("menu-background");
			this.menuItemBackground = jsonObject.getString("menu-item-background");
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

}
