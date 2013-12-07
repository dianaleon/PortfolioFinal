package com.portfolio.model.entities.component;

import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class TextObject extends PageObject implements ITextObject {
	
	public TextObject(JSONObject jsonObject) {
		super(jsonObject);
		this.type = IPageObject.type_text;
	}
}
