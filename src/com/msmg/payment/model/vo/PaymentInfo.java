package com.msmg.payment.model.vo;

public class PaymentInfo implements java.io.Serializable{

	private int buy_info_no;
	private String sort;
	private int buy_no;
	private int amount;
	private String buy_sort;
	
	
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
	public int getBuy_no() {
		return buy_no;
	}
	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
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
	@Override
	public String toString() {
		return "PaymentInfo [buy_info_no=" + buy_info_no + ", sort=" + sort + ", buy_no=" + buy_no + ", amount="
				+ amount + ", buy_sort=" + buy_sort + "]";
	}
	public PaymentInfo(int buy_info_no, String sort, int buy_no, int amount, String buy_sort) {
		super();
		this.buy_info_no = buy_info_no;
		this.sort = sort;
		this.buy_no = buy_no;
		this.amount = amount;
		this.buy_sort = buy_sort;
	}
	
	
	
}
