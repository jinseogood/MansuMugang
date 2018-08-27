package com.msmg.food.model.vo;

public class MenuList implements java.io.Serializable{
	private String img_name;
	private String menu_info;
	private String menu_name;
	private String menu_code;
	
	public MenuList(){}

	public MenuList(String img_name, String menu_info, String menu_name,String menu_code) {
		super();
		this.img_name = img_name;
		this.menu_info = menu_info;
		this.menu_name = menu_name;
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getMenu_info() {
		return menu_info;
	}

	public void setMenu_info(String menu_info) {
		this.menu_info = menu_info;
	}

	@Override
	public String toString() {
		return "MenuList [img_name=" + img_name + ", menu_info=" + menu_info + ", menu_name=" + menu_name
				+ ", menu_code=" + menu_code + "]";
	}

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	
}
