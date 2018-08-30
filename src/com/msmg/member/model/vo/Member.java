package com.msmg.member.model.vo;
  
import java.sql.Date;

public class Member implements java.io.Serializable{
	private int u_code;
	private String u_id;
	private String u_pwd;
	private String u_name; 
	private String drop_yn; 
	private String token;
	private String u_type;
	private String u_tel;
	private String u_addr;
	private String u_question;
	private String u_answer;
	
	public Member(){}

	public Member(int u_code, String u_id, String u_pwd, String u_name, String drop_yn, String token, String u_type,
			String u_tel, String u_addr, String u_question, String u_answer) {
		super();
		this.u_code = u_code;
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.drop_yn = drop_yn;
		this.token = token;
		this.u_type = u_type;
		this.u_tel = u_tel;
		this.u_addr = u_addr;
		this.u_question = u_question;
		this.u_answer = u_answer;
	}

	public int getU_code() {
		return u_code;
	}

	public String getU_id() {
		return u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public String getDrop_yn() {
		return drop_yn;
	}

	public String getToken() {
		return token;
	}

	public String getU_type() {
		return u_type;
	}

	public String getU_tel() {
		return u_tel;
	}

	public String getU_addr() {
		return u_addr;
	}

	public String getU_question() {
		return u_question;
	}

	public String getU_answer() {
		return u_answer;
	}

	public void setU_code(int u_code) {
		this.u_code = u_code;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public void setDrop_yn(String drop_yn) {
		this.drop_yn = drop_yn;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setU_type(String u_type) {
		this.u_type = u_type;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}

	public void setU_question(String u_question) {
		this.u_question = u_question;
	}

	public void setU_answer(String u_answer) {
		this.u_answer = u_answer;
	}

	@Override
	public String toString() {
		return "Member [u_code=" + u_code + ", u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_name=" + u_name + ", drop_yn="
				+ drop_yn + ", token=" + token + ", u_type=" + u_type + ", u_tel=" + u_tel + ", u_addr=" + u_addr
				+ ", u_question=" + u_question + ", u_answer=" + u_answer + "]";
	}

	
	
}