package com.portfolio.model.entities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.ContactCVObject;
import com.portfolio.model.entities.component.ImageObject;
import com.portfolio.model.entities.component.SectionCVObject;
import com.portfolio.model.interfaces.ICurriculumPage;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.component.IPageObject;

public class CurriculumPage extends Page implements ICurriculumPage {

	public CurriculumPage(Type type, JSONObject jsonObject, String layout) {
		super(jsonObject);
		this.layout = layout;
		this.type = type;
		this.type.setTypeValue(IPage.type_curriculum);
		this.objects= new ArrayList<IPageObject>();
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				if (((String)object.get("tipo")).equalsIgnoreCase("image")) {
					this.objects.add(new ImageObject(object));
				}
				if (((String)object.get("tipo")).equalsIgnoreCase("contact")) {
					this.objects.add(new ContactCVObject(object));
				}
				if (((String)object.get("tipo")).equalsIgnoreCase("section")) {
					this.objects.add(new SectionCVObject(object));
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
