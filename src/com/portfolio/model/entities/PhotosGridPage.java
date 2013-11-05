package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.ImageObject;
import com.portfolio.model.entities.component.TextObject;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.IPhotosGridPage;
import com.portfolio.model.interfaces.component.IPageObject;

public class PhotosGridPage extends Page implements IPhotosGridPage {

	private List<IPageObject> objects;

	public PhotosGridPage(Type type, JSONObject jsonObject) {
		this.type = type;
		this.type.setTypeValue(IPage.type_photos_grid);
		this.objects= new ArrayList<IPageObject>();
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				if (((String)object.get("code")).equalsIgnoreCase("image")) {
					this.objects.add(new ImageObject(object));
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<IPageObject> getObjects() {
		return this.objects;
	}

}
