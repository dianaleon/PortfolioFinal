package com.portfolio.model.entities.component;

import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IContactObject;
import com.portfolio.model.interfaces.component.IPageObject;

public class ContactObject extends PageObject implements IContactObject {
	
	private String subtype;
	
	public ContactObject(JSONObject jsonObject) {
		super(jsonObject);
		this.type = IPageObject.type_contact;
	}
	
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	@Override
	public String getSubtype() {
		return this.subtype;
	}
}