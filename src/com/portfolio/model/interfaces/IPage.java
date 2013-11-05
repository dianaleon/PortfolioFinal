package com.portfolio.model.interfaces;

import com.portfolio.model.entities.Type;

public interface IPage {

	public static final int type_text = 1;
	public static final int type_photo_galery = 2;
	public static final int type_contact = 3;
	public static final int type_network = 4;
	
	//NUEVAS PAGINAS
	public static final int type_photo_txt_grid_list = 5;
	public static final int type_photo_text = 6;
	public static final int type_txt_photo_txt = 7;
	public static final int type_horizontal_txt_photo_list = 8;
	public static final int type_curriculum = 9;
	public static final int type_photos_grid = 10;
	

	public Type getType();
	
	public String getName();
	
	public int getPosition();
	
	public String getIconUrl();

}
