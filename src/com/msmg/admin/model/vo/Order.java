package com.msmg.admin.model.vo;

import java.sql.Date;

public class Order implements java.io.Serializable{
	private int buy_no;
	private String u_name;
	private int menu_code;
	private Date buy_date;
	private String status;
	private String diet_no;
	private int price;
	private int amount;
	
	public Order(){}

	public Order(int buy_no, String u_name, int menu_code, Date buy_date, String status, String diet_no, int price, int amount) {
		super();
		this.buy_no = buy_no;
		this.u_name = u_name;
		this.menu_code = menu_code;
		this.buy_date = buy_date;
		this.status = status;
		this.diet_no = diet_no;
		this.price = price;
		this.amount = amount;
	}

	public int getBuy_no() {
		return buy_no;
	}

	public String getU_name() {
		return u_name;
	}

	public int getMenu_code() {
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
	
	public int getAmount() {
		return amount;
	}

	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDiet_no(String diet_no) {
		this.diet_no = diet_no;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [buy_no=" + buy_no + ", u_name=" + u_name + ", menu_code=" + menu_code + ", buy_date=" + buy_date
				+ ", status=" + status + ", diet_no=" + diet_no + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
}
