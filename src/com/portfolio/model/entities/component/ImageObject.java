package com.portfolio.model.entities.component;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IImageObject;

public class ImageObject extends PageObject implements IImageObject {

	private String value;
	
	public ImageObject(JSONObject jsonObject) {
		try {
			this.value= jsonObject.getString("value");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
