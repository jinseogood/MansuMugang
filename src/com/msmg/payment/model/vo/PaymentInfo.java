package com.msmg.payment.model.vo;

public class PaymentInfo implements java.io.Serializable{
	
	private int buy_info_no;
	private String sort;
	private String buy_sort;
	private String diet_no;
	
	
	public PaymentInfo(){}
	

	public PaymentInfo(int buy_info_no, String sort, String buy_sort, String diet_no) {
		super();
		this.buy_info_no = buy_info_no;
		this.sort = sort;
		this.buy_sort = buy_sort;
		this.diet_no = diet_no;
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



	
	
}
