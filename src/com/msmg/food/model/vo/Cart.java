package com.msmg.food.model.vo;

import java.sql.Date;

public class Cart implements java.io.Serializable{

	private String diet_no;
	private String user_menu_name;
	private Date buy_date;
	private String ucode;
	private int price;
	
	public Cart(){}

	public Cart(String diet_no, String user_menu_name, Date buy_date, String ucode, int price) {
		super();
		this.diet_no = diet_no;
		this.user_menu_name = user_menu_name;
		this.buy_date = buy_date;
		this.ucode = ucode;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDiet_no() {
		return diet_no;
	}

	public void setDiet_no(String diet_no) {
		this.diet_no = diet_no;
	}

	public String getUser_menu_name() {
		return user_menu_name;
	}

	public void setUser_menu_name(String user_menu_name) {
		this.user_menu_name = user_menu_name;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	
	
}
