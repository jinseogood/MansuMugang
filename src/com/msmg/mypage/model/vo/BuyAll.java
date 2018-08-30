package com.msmg.mypage.model.vo;

import java.sql.Date;

public class BuyAll implements java.io.Serializable{
	private int buy_no;  
	private String u_code;
	private String menu_code;
	private Date buy_date;
	private String status;
	private String diet_no;
	private int price;
	private String user_menu_name;
	private int buy_info_no;
	private String sort;
	private String buy_sort;
	private String buy_status;
	
	public BuyAll(){}

	public BuyAll(int buy_no, String u_code, String menu_code, Date buy_date, String status, String diet_no, int price,
			String user_menu_name, int buy_info_no, String sort, String buy_sort, String buy_status) {
		super();
		this.buy_no = buy_no;
		this.u_code = u_code;
		this.menu_code = menu_code;
		this.buy_date = buy_date;
		this.status = status;
		this.diet_no = diet_no;
		this.price = price;
		this.user_menu_name = user_menu_name;
		this.buy_info_no = buy_info_no;
		this.sort = sort;
		this.buy_sort = buy_sort;
		this.buy_status = buy_status;
	}

	public int getBuy_no() {
		return buy_no;
	}

	public String getU_code() {
		return u_code;
	}

	public String getMenu_code() {
		return menu_code;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public String getStatus() {
		return status;
	}

	public String getDiet_no() {
		return diet_no;
	}

	public int getPrice() {
		return price;
	}

	public String getUser_menu_name() {
		return user_menu_name;
	}

	public int getBuy_info_no() {
		return buy_info_no;
	}

	public String getSort() {
		return sort;
	}

	public String getBuy_sort() {
		return buy_sort;
	}

	public String getBuy_status() {
		return buy_status;
	}

	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public void setStatus(String string) {
		this.status = string;
	}

	public void setDiet_no(String diet_no) {
		this.diet_no = diet_no;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setUser_menu_name(String user_menu_name) {
		this.user_menu_name = user_menu_name;
	}

	public void setBuy_info_no(int buy_info_no) {
		this.buy_info_no = buy_info_no;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setBuy_sort(String buy_sort) {
		this.buy_sort = buy_sort;
	}

	public void setBuy_status(String buy_status) {
		this.buy_status = buy_status;
	}

	@Override
	public String toString() {
		return "BuyAll [buy_no=" + buy_no + ", u_code=" + u_code + ", menu_code=" + menu_code + ", buy_date=" + buy_date
				+ ", status=" + status + ", diet_no=" + diet_no + ", price=" + price + ", user_menu_name="
				+ user_menu_name + ", buy_info_no=" + buy_info_no + ", sort=" + sort + ", buy_sort=" + buy_sort
				+ ", buy_status=" + buy_status + "]";
	}

	
}
