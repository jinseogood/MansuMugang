package com.msmg.payment.model.vo;

public class Phone {
	
	private String u_code;
	private String tel;
	
	public Phone(){}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Phone(String u_code, String tel) {
		super();
		this.u_code = u_code;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Phone [u_code=" + u_code + ", tel=" + tel + "]";
	}
	
	

}
