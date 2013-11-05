package com.portfolio.model.interfaces.component;

public interface IPageObject {

	public static final int type_text = 1;
	public static final int type_image = 2;
	public static final int type_contact_cv = 3;
	public static final int type_section_cv = 4;
	

	public int getType();

}
