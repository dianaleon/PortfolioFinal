package com.portfolio.model.entities.component;

import com.portfolio.model.interfaces.component.IPageObject;

public class PageObject implements IPageObject {

	protected int type;
	
	@Override
	public int getType() {
		return type;
	}
}
