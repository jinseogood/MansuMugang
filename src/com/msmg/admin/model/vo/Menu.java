package com.msmg.admin.model.vo;

public class Menu implements java.io.Serializable{
	private String menuCode;
	private String menuName;
	private String mainMat;
	private String subMat;
	private int price;
	
	public Menu(){}
	public Menu(String menuCode, String menuName, String mainMat, String subMat, int price) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.mainMat = mainMat;
		this.subMat = subMat;
		this.price = price;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMainMat() {
		return mainMat;
	}

	public String getSubMat() {
		return subMat;
	}

	public int getPrice() {
		return price;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMainMat(String mainMat) {
		this.mainMat = mainMat;
	}

	public void setSubMat(String subMat) {
		this.subMat = subMat;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [menuCode=" + menuCode + ", menuName=" + menuName + ", mainMat=" + mainMat + ", subMat=" + subMat
				+ ", price=" + price + "]";
	}
	
}
