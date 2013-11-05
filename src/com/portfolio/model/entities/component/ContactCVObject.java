package com.portfolio.model.entities.component;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.adapter.ContactItem;
import com.portfolio.model.interfaces.component.IContactCVObject;
import com.portfolio.model.interfaces.component.IPageObject;

public class ContactCVObject extends PageObject implements IContactCVObject {

	private List<ContactItem> objects;
	
	public ContactCVObject(JSONObject jsonObject) {
		try {
			this.type = IPageObject.type_contact_cv;
			objects = new ArrayList<ContactItem>();
			JSONArray values = jsonObject.getJSONArray("value");
			for (int index = 0; index < values.length(); index++) {
				JSONObject value = values.getJSONObject(index);
				ContactItem contactItem = new ContactItem();
				contactItem.setText(value.getString("title"));
				contactItem.setValue(value.getString("value"));
				objects.add(contactItem);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ContactItem getContactItem(int position) {
		return this.objects.get(position);
	}
}
