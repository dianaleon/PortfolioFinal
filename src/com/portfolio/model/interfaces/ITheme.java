package com.portfolio.model.interfaces;

import com.portfolio.model.entities.component.BackgroundObject;

public interface ITheme {

	public String getCode();
	
	public String getUrlImages();
	
	public BackgroundObject getBackground();
	
	public BackgroundObject getTitleBarBackground();

	public BackgroundObject getMenuBackground();

	public BackgroundObject getMenuItemBackground();

}
