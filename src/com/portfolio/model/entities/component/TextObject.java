package com.portfolio.model.entities.component;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.ITextObject;

public class TextObject extends PageObject implements ITextObject {

	private String title = null;
	private String subtitle = null;
	private String value = null;
	private String bgColor = null;
	private String textColor = null;
	
	public TextObject(JSONObject jsonObject) {
		this.type = IPageObject.type_text;
		try {
			if (jsonObject.has("title")) {
				this.title= jsonObject.getString("title");
			}
			if (jsonObject.has("subtitle")) {
				this.subtitle= jsonObject.getString("subtitle");
			}
			if (jsonObject.has("value")) {
				this.value= jsonObject.getString("value");
			}
			if (jsonObject.has("bgcolor")) {
				this.bgColor= jsonObject.getString("bgcolor");
			}
			if (jsonObject.has("textcolor")) {
				this.textColor = jsonObject.getString("textcolor");
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
	public String getValue() {
		return this.value;
	}

	@Override
	public String getBgColor() {
		return this.bgColor;
	}

	@Override
	public String getTextColor() {
		return this.textColor;
	}
}
