package com.portfolio.model.entities.component;

import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.IVideoObject;

public class VideoObject extends PageObject implements IVideoObject {
	
	public VideoObject(JSONObject jsonObject) {
		super(jsonObject);
		this.type = IPageObject.type_video;
	}
}
