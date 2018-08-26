package com.msmg.mainIndex.model.vo;

public class MenuIndex {
	private int menu_code;
	private String menu_name;
	private String menu_main;
	private String menu_sub;
	private int price;
	private int sale_count;
	private String menu_img_oname;
	private String menu_img_src;
	private String menu_info;
	private String menu_img_ename;
	
	public MenuIndex(){}

	public MenuIndex(int menu_code, String menu_name, String menu_main, String menu_sub, int price, int sale_count,
			String menu_img_oname, String menu_img_src, String menu_info, String menu_img_ename) {
		super();
		this.menu_code = menu_code;
		this.menu_name = menu_name;
		this.menu_main = menu_main;
		this.menu_sub = menu_sub;
		this.price = price;
		this.sale_count = sale_count;
		this.menu_img_oname = menu_img_oname;
		this.menu_img_src = menu_img_src;
		this.menu_info = menu_info;
		this.menu_img_ename = menu_img_ename;
	}

	public int getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_main() {
		return menu_main;
	}

	public void setMenu_main(String menu_main) {
		this.menu_main = menu_main;
	}

	public String getMenu_sub() {
		return menu_sub;
	}

	public void setMenu_sub(String menu_sub) {
		this.menu_sub = menu_sub;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	public String getMenu_img_oname() {
		return menu_img_oname;
	}

	public void setMenu_img_oname(String menu_img_oname) {
		this.menu_img_oname = menu_img_oname;
	}

	public String getMenu_img_src() {
		return menu_img_src;
	}

	public void setMenu_img_src(String menu_img_src) {
		this.menu_img_src = menu_img_src;
	}

	public String getMenu_info() {
		return menu_info;
	}

	public void setMenu_info(String menu_info) {
		this.menu_info = menu_info;
	}

	public String getMenu_img_ename() {
		return menu_img_ename;
	}

	public void setMenu_img_ename(String menu_img_ename) {
		this.menu_img_ename = menu_img_ename;
	}

	@Override
	public String toString() {
		return "MenuIndex [menu_code=" + menu_code + ", menu_name=" + menu_name + ", menu_main=" + menu_main
				+ ", menu_sub=" + menu_sub + ", price=" + price + ", sale_count=" + sale_count + ", menu_img_oname="
				+ menu_img_oname + ", menu_img_src=" + menu_img_src + ", menu_info=" + menu_info + ", menu_img_ename="
				+ menu_img_ename + "]";
	}
	
	
}
