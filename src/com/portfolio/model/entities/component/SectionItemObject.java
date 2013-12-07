package com.portfolio.model.entities.component;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.component.ISectionItemObject;

public class SectionItemObject extends PageObject implements ISectionItemObject {

	private String title = null;
	private String subtitle = null;
	private String description = null;
	private String subscript = null;
	
	public SectionItemObject(JSONObject jsonObject) {
		super(jsonObject);
		try {
			if (jsonObject.has("title")) {
				this.title= jsonObject.getString("title");
			}
			if (jsonObject.has("subtitle")) {
				this.subtitle= jsonObject.getString("subtitle");
			}
			if (jsonObject.has("description")) {
				this.description= jsonObject.getString("description");
			}
			if (jsonObject.has("subscript")) {
				this.subscript= jsonObject.getString("subscript");
			}
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
	public String getSubTitle() {
		return this.subtitle;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getSubscript() {
		return this.subscript;
	}
}
