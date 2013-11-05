package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.RowObject;
import com.portfolio.model.interfaces.IHorizontalTxtPhotoListPage;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.component.IRowObject;

public class HorizontalTxtPhotoListPage extends Page implements
		IHorizontalTxtPhotoListPage {

	private List<IRowObject> objects;

	public HorizontalTxtPhotoListPage(Type type, JSONObject jsonObject) {
		this.type = type;
		this.type.setTypeValue(IPage.type_horizontal_txt_photo_list);
		this.objects = new ArrayList<IRowObject>();
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				this.objects.add(new RowObject(object));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<IRowObject> getRowObjects() {
		return this.objects;
	}

}
