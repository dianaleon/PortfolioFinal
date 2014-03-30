package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.component.IPageObject;

public abstract class Page implements IPage {

	protected Type type;
	protected String iconURL;
	protected int pos;
	protected String title;
	protected String content;
	protected String layout;
	
	protected List<IPageObject> objects;

	public Page(JSONObject jsonObject) {
		try {
			this.objects= new ArrayList<IPageObject>();
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
	
	@Override
	public List<IPageObject> getObjects() {
		return objects;
	}
	
	@Override
	public String getLayout() {
		return layout;
	}
}
