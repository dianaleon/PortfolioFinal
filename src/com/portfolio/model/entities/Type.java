package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IType;


public class Type implements IType {

	private int typeValue;
	private String type;
	private String background = null;
	
	public Type(JSONObject jsonObject) {
		try {
			this.type = jsonObject.getString("code");
			if (jsonObject.has("background")) {
				this.background = jsonObject.getString("background");				
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
	public String getBackground() {
		return this.background;
	}

	public int getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(int value) {
		this.typeValue = value;
	}
}
