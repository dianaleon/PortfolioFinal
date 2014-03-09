package com.portfolio.model.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.entities.component.ImageObject;
import com.portfolio.model.entities.component.TextObject;
import com.portfolio.model.entities.component.VideoObject;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.IVideoPage;


public class VideoPage extends Page implements IVideoPage {
	
	public VideoPage(Type type, JSONObject jsonObject) {
		super(jsonObject);
		this.type = type;
		this.type.setTypeValue(IPage.type_video);
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
				if (((String)object.get("tipo")).equalsIgnoreCase("video")) {
					this.objects.add(new VideoObject(object));
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
