package com.portfolio.model.entities;

import com.portfolio.activities.CustomThemeWindow;
import com.portfolio.model.interfaces.IPage;

public abstract class Page extends CustomThemeWindow implements IPage {

	protected Type type;
	protected String name;
	protected String iconURL;
	protected int pos;
	
	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getPosition() {
		return pos;
	}

	@Override
	public String getIconUrl() {
		return iconURL;
	}
}
