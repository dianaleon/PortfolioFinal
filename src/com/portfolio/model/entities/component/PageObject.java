package com.portfolio.model.entities.component;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IPageObject;

public class PageObject implements IPageObject {

	protected int type;
	
	private String content;
	private String content_img;
	private int pos;
	private String description;
	private String background;
	private String textColor;
	private String title;
	private String subtitle;
	
	public PageObject(JSONObject jsonObject) {
		try {
			if (jsonObject.has("content")) {
				this.content= jsonObject.getString("content");
			}
			if (jsonObject.has("content_img")) {
				this.content_img= jsonObject.getString("content_img");
			}
			if (jsonObject.has("pos")) {
				this.pos= Integer.valueOf(jsonObject.getString("pos"));
			}
			if (jsonObject.has("description")) {
				this.description= jsonObject.getString("description");
			}
			if (jsonObject.has("background")) {
				this.background= jsonObject.getString("background");
			}
			if (jsonObject.has("textColor")) {
				this.textColor= jsonObject.getString("textColor");
			}
			if (jsonObject.has("title")) {
				this.title= jsonObject.getString("title");
			}
			if (jsonObject.has("subtitle")) {
				this.subtitle= jsonObject.getString("subtitle");
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public String getContent() {
		return content;
	}
	
	@Override
	public String getContent_img() {
		return content_img;
	}

	@Override
	public int getPos() {
		return pos;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getBackground() {
		return background;
	}

	@Override
	public String getTextColor() {
		return textColor;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getSubtitle() {
		return subtitle;
	}
}
