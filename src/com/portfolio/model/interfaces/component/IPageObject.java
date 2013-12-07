package com.portfolio.model.interfaces.component;

public interface IPageObject {

	public static final int type_text = 1;
	public static final int type_image = 2;
	public static final int type_contact_cv = 3;
	public static final int type_section_cv = 4;
	public static final int type_network = 5;
	public static final int type_contact = 6;
	

	public int getType();
	public String getContent();
	public String getContent_img();
	public int getPos();
	public String getDescription();
	public String getBackground();
	public String getTextColor();
	public String getTitle();
	public String getSubtitle();
}
