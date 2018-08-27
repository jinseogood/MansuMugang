package com.msmg.mypage.model.vo;

import java.sql.Date;

public class BuyAll implements java.io.Serializable{
	private int buy_no;  
	private String u_code;
	private String menu_code;
	private Date buy_date;
	private String status;
	private int buy_info_no;
	private String sort;
	private int amount;
	private String buy_sort;
	
	public BuyAll(){}

	public BuyAll(int buy_no, String u_code, String menu_code, Date buy_date, String status, int buy_info_no,
			String sort, int amount, String buy_sort) {
		super();
		this.buy_no = buy_no;
		this.u_code = u_code;
		this.menu_code = menu_code;
		this.buy_date = buy_date;
		this.status = status;
		this.buy_info_no = buy_info_no;
		this.sort = sort;
		this.amount = amount;
		this.buy_sort = buy_sort;
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

	public int getBuy_info_no() {
		return buy_info_no;
	}

	public String getSort() {
		return sort;
	}

	public int getAmount() {
		return amount;
	}

	public String getBuy_sort() {
		return buy_sort;
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

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBuy_info_no(int buy_info_no) {
		this.buy_info_no = buy_info_no;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setBuy_sort(String buy_sort) {
		this.buy_sort = buy_sort;
	}

	@Override
	public String toString() {
		return "BuyAll [buy_no=" + buy_no + ", u_code=" + u_code + ", menu_code=" + menu_code + ", buy_date=" + buy_date
				+ ", status=" + status + ", buy_info_no=" + buy_info_no + ", sort=" + sort + ", amount=" + amount
				+ ", buy_sort=" + buy_sort + "]";
	}
	
	
	
}
