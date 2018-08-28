package com.msmg.member.model.vo;

public class UserAllergy implements java.io.Serializable{
	private String user_al_no;
	private String al_code;
	private String u_code;
	
	public UserAllergy(){}

	public UserAllergy(String user_al_no, String al_code, String u_code) {
		super();
		this.user_al_no = user_al_no;
		this.al_code = al_code;
		this.u_code = u_code;
	}


	public String getUser_al_no() {
		return user_al_no;
	}

	public String getAl_code() {
		return al_code;
	}

	public String getU_code() {
		return u_code;
	}

	public void setUser_al_no(String user_al_no) {
		this.user_al_no = user_al_no;
	}

	public void setAl_code(String al_code) {
		this.al_code = al_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	
	
	@Override
	public String toString() {
		return "{user_al_no=" + user_al_no + "|al_code=" + al_code + "|u_code=" + u_code + "}";
	}

}
