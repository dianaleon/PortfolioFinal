package com.portfolio.model.entities;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.adapter.NetworkItem;
import com.portfolio.model.entities.component.NetworkObject;
import com.portfolio.model.interfaces.IContactPage;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;

public class NetworkPage extends Page implements INetworkPage {

//	private List<NetworkItem> items;

	public NetworkPage(Type type, JSONObject jsonObject) {
		super(jsonObject);
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
				this.objects.add(networkObject);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
//		this.items = new ArrayList<NetworkItem>();
//		try {
//			JSONArray data = jsonObject.getJSONArray("data");
//			for (int index = 0; index < data.length(); index++) {
//				JSONObject object = data.getJSONObject(index);
//				NetworkItem networkItem = new NetworkItem();
//				networkItem.setNetwork(object.getString("code"));
//				networkItem.setUrl(object.getString("value"));
//				if (object.has("icon")) {
//					networkItem.setIcon(object.getString("icon"));
//				}
//				this.items.add(networkItem);
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

//	@Override
//	public List<NetworkItem> getItems() {
//		return items;
//	}

}
