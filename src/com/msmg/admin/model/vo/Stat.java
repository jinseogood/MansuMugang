package com.msmg.admin.model.vo;

public class Stat implements java.io.Serializable{
	private String menu_name;
	private int sale_count;
	
	public Stat(){}
	public Stat(String menu_name, int sale_count) {
		super();
		this.menu_name = menu_name;
		this.sale_count = sale_count;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	@Override
	public String toString() {
		return "Stat [menu_name=" + menu_name + ", sale_count=" + sale_count + "]";
	}
	

}
