package com.portfolio.model.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.ImageObject;
import com.portfolio.model.entities.component.TextObject;
import com.portfolio.model.interfaces.ICatalogoPage;
import com.portfolio.model.interfaces.IPage;


public class CatalogoPage extends Page implements ICatalogoPage {
	
	public CatalogoPage(Type type, JSONObject jsonObject) {
		super(jsonObject);
		this.type = type;
		this.type.setTypeValue(IPage.type_catalogo);
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				if (((String)object.get("tipo")).equalsIgnoreCase("text")) {
					this.objects.add(new TextObject(object));
				}
				if (((String)object.get("tipo")).equalsIgnoreCase("image")) {
					this.objects.add(new ImageObject(object));
				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
