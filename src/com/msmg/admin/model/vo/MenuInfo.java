package com.msmg.admin.model.vo;

public class MenuInfo implements java.io.Serializable{
	private int menuCode;
	private String originName;
	private String editName;
	private String filePath;
	private String info;
	
	public MenuInfo(){}

	public MenuInfo(int menuCode, String originName, String editName, String filePath, String info) {
		super();
		this.menuCode = menuCode;
		this.originName = originName;
		this.editName = editName;
		this.filePath = filePath;
		this.info = info;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public String getOriginName() {
		return originName;
	}

	public String getEditName() {
		return editName;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getInfo() {
		return info;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public void setEditName(String editName) {
		this.editName = editName;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "MenuInfo [menuCode=" + menuCode + ", originName=" + originName + ", editName=" + editName
				+ ", filePath=" + filePath + ", info=" + info + "]";
	}
	
	
	
}
