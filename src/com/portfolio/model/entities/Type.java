package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.BackgroundObject;
import com.portfolio.model.interfaces.IType;


public class Type implements IType {

	private int typeValue;
	private String type;
	private BackgroundObject background = null;
	
	public Type(JSONObject jsonObject) {
		try {
			this.type = jsonObject.getString("code");
			if (jsonObject.has("background")) {
				this.background = new BackgroundObject(jsonObject.getString("background"));				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public BackgroundObject getBackground() {
		return this.background;
	}

	public int getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(int value) {
		this.typeValue = value;
	}
}
