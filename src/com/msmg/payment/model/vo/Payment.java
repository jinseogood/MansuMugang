package com.msmg.payment.model.vo;

import java.sql.Date;

public class Payment implements java.io.Serializable {

	private int buy_no;
	private String u_code;
	private String menu_code;
	private Date buy_date;
	private String diet_no;
	private String status;
	
	public Payment(){}

	public int getBuy_no() {
		return buy_no;
	}

	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public String getDiet_no() {
		return diet_no;
	}

	public void setDiet_no(String diet_no) {
		this.diet_no = diet_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [buy_no=" + buy_no + ", u_code=" + u_code + ", menu_code=" + menu_code + ", buy_date="
				+ buy_date + ", diet_no=" + diet_no + ", status=" + status + "]";
	}

	public Payment(int buy_no, String u_code, String menu_code, Date buy_date, String diet_no, String status) {
		super();
		this.buy_no = buy_no;
		this.u_code = u_code;
		this.menu_code = menu_code;
		this.buy_date = buy_date;
		this.diet_no = diet_no;
		this.status = status;
	}

	
}
