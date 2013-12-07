package com.portfolio.model.entities.component;

import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IImageObject;
import com.portfolio.model.interfaces.component.IPageObject;

public class ImageObject extends PageObject implements IImageObject {
	
	public ImageObject(JSONObject jsonObject) {
		super(jsonObject);
		this.type = IPageObject.type_image;		
	}
}
