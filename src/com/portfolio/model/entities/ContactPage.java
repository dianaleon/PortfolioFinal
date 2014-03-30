package com.portfolio.model.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.ContactObject;
import com.portfolio.model.interfaces.IContactPage;
import com.portfolio.model.interfaces.IPage;

public class ContactPage extends Page implements IContactPage {

	public ContactPage(Type type, JSONObject jsonObject, String layout) {
		super(jsonObject);
		this.layout = layout;
		this.type = type;
		this.type.setTypeValue(IPage.type_contact);
		
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				String tipo = ((String)object.get("tipo"));
				ContactObject contactObject = new ContactObject(object);
				if (tipo.equalsIgnoreCase(IContactPage.email)) {
					contactObject.setSubtype(IContactPage.email);
				}
				if (tipo.equalsIgnoreCase(IContactPage.address)) {
					contactObject.setSubtype(IContactPage.address);
				}
				if (tipo.equalsIgnoreCase(IContactPage.movil)) {
					contactObject.setSubtype(IContactPage.movil);
				}
				if (tipo.equalsIgnoreCase(IContactPage.telefono)) {
					contactObject.setSubtype(IContactPage.telefono);
				}
				this.objects.add(contactObject);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
