package com.portfolio.model.entities.component;

import org.json.JSONObject;

import com.portfolio.model.interfaces.component.INetworkObject;
import com.portfolio.model.interfaces.component.IPageObject;

public class NetworkObject extends PageObject implements INetworkObject {
	
	private String subtype;
	
	public NetworkObject(JSONObject jsonObject) {
		super(jsonObject);
		this.type = IPageObject.type_network;
	}
	
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	@Override
	public String getSubtype() {
		return this.subtype;
	}
}