package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Shader.TileMode;

import com.portfolio.activities.CustomThemeWindow;
import com.portfolio.model.interfaces.IPage;

public abstract class Page implements IPage {

	protected Type type;
	protected String name;
	protected String iconURL;
	protected int pos;
	protected String title;
	protected String content;
	
	public Page(JSONObject jsonObject) {
		try {
			this.pos = Integer.valueOf(jsonObject.getString("pos"));
			this.title = jsonObject.getString("title");
			this.content = jsonObject.getString("content");
			this.iconURL = jsonObject.getString("url_icon");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getPosition() {
		return pos;
	}

	@Override
	public String getIconUrl() {
		return iconURL;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getContent() {
		return content;
	}
}
