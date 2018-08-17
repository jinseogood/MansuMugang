package com.msmg.member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable{
	private int u_code;
	private String u_id;
	private String u_pwd;
	private String u_name;
	private String drop_yn;
	private String token;
	
	public Member(){}

	public Member(int u_code, String u_id, String u_pwd, String u_name, String drop_yn, String token) {
		super();
		this.u_code = u_code;
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.drop_yn = drop_yn;
		this.token = token;
	}

	public int getU_code() {
		return u_code;
	}

	public void setU_code(int u_code) {
		this.u_code = u_code;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getDrop_yn() {
		return drop_yn;
	}

	public void setDrop_yn(String drop_yn) {
		this.drop_yn = drop_yn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Member [u_code=" + u_code + ", u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_name=" + u_name + ", drop_yn="
				+ drop_yn + ", token=" + token + ", getU_code()=" + getU_code() + ", getU_id()=" + getU_id()
				+ ", getU_pwd()=" + getU_pwd() + ", getU_name()=" + getU_name() + ", getDrop_yn()=" + getDrop_yn()
				+ ", getToken()=" + getToken() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	};
	
	

	
	
	
}