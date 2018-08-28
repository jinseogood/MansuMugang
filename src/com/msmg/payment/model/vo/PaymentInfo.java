package com.msmg.payment.model.vo;

public class PaymentInfo implements java.io.Serializable{
	
	private int buy_info_no;
	private String sort;
	private int amount;
	private String buy_sort;
	private String diet_no;
	private String menu_code;
	
	
	public PaymentInfo(){}
	

	public PaymentInfo(int buy_info_no, String sort, int amount, String buy_sort, String diet_no, String menu_code) {
		super();
		this.buy_info_no = buy_info_no;
		this.sort = sort;
		this.amount = amount;
		this.buy_sort = buy_sort;
		this.diet_no = diet_no;
		this.menu_code = menu_code;
	}




	public int getBuy_info_no() {
		return buy_info_no;
	}




	public void setBuy_info_no(int buy_info_no) {
		this.buy_info_no = buy_info_no;
	}




	public String getSort() {
		return sort;
	}




	public void setSort(String sort) {
		this.sort = sort;
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	public String getBuy_sort() {
		return buy_sort;
	}




	public void setBuy_sort(String buy_sort) {
		this.buy_sort = buy_sort;
	}




	public String getDiet_no() {
		return diet_no;
	}




	public void setDiet_no(String diet_no) {
		this.diet_no = diet_no;
	}




	public String getMenu_code() {
		return menu_code;
	}




	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}





	

	
	
}
