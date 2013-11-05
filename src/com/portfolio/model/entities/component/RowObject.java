package com.portfolio.model.entities.component;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.component.IPageObject;
import com.portfolio.model.interfaces.component.IRowObject;

public class RowObject extends PageObject implements IRowObject {

	private List<IPageObject> objects;
	
	public RowObject(JSONObject jsonObject) {
		try {
			objects = new ArrayList<IPageObject>();
			JSONArray values = jsonObject.getJSONArray("value");
			for (int index = 0; index < values.length(); index++) {
				JSONObject value = values.getJSONObject(index);
				if (((String) value.get("code")).equalsIgnoreCase("image")) {
					this.objects.add(new ImageObject(value));
				}
				if (((String) value.get("code")).equalsIgnoreCase("text")) {
					this.objects.add(new TextObject(value));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public IPageObject getPageObject(int position) {
		return this.objects.get(position);
	}
}
