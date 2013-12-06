package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IMenu;


public class Menu implements IMenu {

	private String title;
	private String subtitle;
	private String icon;
	private String gradient_orientation;
	private String text_color;
	private String background;
	
	public Menu(JSONObject jsonObject) {
		try {
			this.title = jsonObject.getString("code");
			this.subtitle= jsonObject.getString("url-images");
			this.icon = jsonObject.getString("background");
			this.gradient_orientation = jsonObject.getString("titlebar_background");
			this.text_color = jsonObject.getString("menu-background");
			this.background = jsonObject.getString("menu_item_background");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getSubtitle() {
		return this.subtitle;
	}

	@Override
	public String getIcon() {
		return this.icon;
	}

	@Override
	public String getGradient_orientation() {
		return this.gradient_orientation;
	}

	@Override
	public String getText_color() {
		return this.text_color;
	}

	@Override
	public String getBackground() {
		return this.background;
	}
}