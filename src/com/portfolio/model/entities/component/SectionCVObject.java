package com.portfolio.model.entities.component;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.adapter.ContactItem;
import com.portfolio.model.interfaces.component.IContactCVObject;
import com.portfolio.model.interfaces.component.ISectionCVObject;
import com.portfolio.model.interfaces.component.ISectionItemObject;

public class SectionCVObject extends PageObject implements ISectionCVObject {

	private String title;
	private List<ISectionItemObject> objects;
	
	public SectionCVObject(JSONObject jsonObject) {
		try {
			this.title = jsonObject.getString("title");
			objects = new ArrayList<ISectionItemObject>();
			JSONArray values = jsonObject.getJSONArray("info");
			for (int index = 0; index < values.length(); index++) {
				JSONObject value = values.getJSONObject(index);
				objects.add(new SectionItemObject(value));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public ISectionItemObject getSectionItemItem(int position) {
		return this.objects.get(position);
	}
}
