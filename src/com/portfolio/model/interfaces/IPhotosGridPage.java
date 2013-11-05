package com.portfolio.model.interfaces;

import java.util.List;

import com.portfolio.model.interfaces.component.IPageObject;

public interface IPhotosGridPage extends IPage {

	public List<IPageObject> getObjects();

}
