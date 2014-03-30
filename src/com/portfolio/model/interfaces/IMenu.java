package com.portfolio.model.interfaces;

import com.portfolio.model.entities.component.BackgroundObject;

public interface IMenu {

	public String getTitle();

	public String getSubtitle();

	public String getIcon();
	
	public String getGradient_orientation();

	public String getText_color();

	public BackgroundObject getBackground();
	
}
