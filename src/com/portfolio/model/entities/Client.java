package com.portfolio.model.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IClient;


public class Client implements IClient {

	private String name;
	private String surname;
	private String update = "0";
	private String resources;
	
	public Client(JSONObject jsonObject) {
		try {
			this.name = jsonObject.getString("name");
			this.surname = jsonObject.getString("surname");
			this.update = jsonObject.getString("update");
			this.resources = jsonObject.getString("resources");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getSurname() {
		return this.surname;
	}

	@Override
	public long getUpdate() {
		return Integer.valueOf(this.update);
	}

	@Override
	public String getResources() {
		return this.resources;
	}

}
