package com.msmg.admin.model.vo;

public class Menu implements java.io.Serializable{
	private int menuCode;
	private String menuName;
	private String mainMat;
	private String subMat;
	private int price;
	private String menuInfo;
	
	public Menu(){}
	public Menu(int menuCode, String menuName, String mainMat, String subMat, int price, String menuInfo) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.mainMat = mainMat;
		this.subMat = subMat;
		this.price = price;
		this.menuInfo = menuInfo;
	}

	public int getMenuCode() {
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
	
	public String getMenuInfo(){
		return menuInfo;
	}

	public void setMenuCode(int menuCode) {
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
	
	public void setMenuInfo(String menuInfo){
		this.menuInfo = menuInfo;
	}

	@Override
	public String toString() {
		return "Menu [menuCode=" + menuCode + ", menuName=" + menuName + ", mainMat=" + mainMat + ", subMat=" + subMat
				+ ", price=" + price + ", menuInfo=" + menuInfo + "]";
	}
	
}
