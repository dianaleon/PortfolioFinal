package com.portfolio.model.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.NetworkObject;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;

public class NetworkPage extends Page implements INetworkPage {

	public NetworkPage(Type type, JSONObject jsonObject, String layout) {
		super(jsonObject);
		this.layout = layout;
		this.type = type;
		this.type.setTypeValue(IPage.type_network);
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				String tipo = ((String)object.get("tipo"));
				NetworkObject networkObject = new NetworkObject(object);
				if (tipo.equalsIgnoreCase(INetworkPage.facebook)) {
					networkObject.setSubtype(INetworkPage.facebook);
				}
				if (tipo.equalsIgnoreCase(INetworkPage.twitter)) {
					networkObject.setSubtype(INetworkPage.twitter);
				}
				if (tipo.equalsIgnoreCase(INetworkPage.gplus)) {
					networkObject.setSubtype(INetworkPage.gplus);
				}
				if (tipo.equalsIgnoreCase(INetworkPage.instagram)) {
					networkObject.setSubtype(INetworkPage.instagram);
				}
				if (tipo.equalsIgnoreCase(INetworkPage.pinterest)) {
					networkObject.setSubtype(INetworkPage.pinterest);
				}
				if (tipo.equalsIgnoreCase(INetworkPage.linkedin)) {
					networkObject.setSubtype(INetworkPage.linkedin);
				}
				this.objects.add(networkObject);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
