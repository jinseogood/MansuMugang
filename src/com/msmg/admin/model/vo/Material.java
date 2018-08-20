package com.msmg.admin.model.vo;

public class Material implements java.io.Serializable{
	private String m_code;
	private String m_name;
	private String a_code;
	private String d_go;
	private String d_dang;
	private String d_head;
	
	public Material(){}
	public Material(String m_code, String m_name, String a_code, String d_go, String d_dang, String d_head) {
		super();
		this.m_code = m_code;
		this.m_name = m_name;
		this.a_code = a_code;
		this.d_go = d_go;
		this.d_dang = d_dang;
		this.d_head = d_head;
	}

	public String getM_code() {
		return m_code;
	}

	public String getM_name() {
		return m_name;
	}

	public String getA_code() {
		return a_code;
	}

	public String getD_go() {
		return d_go;
	}

	public String getD_dang() {
		return d_dang;
	}

	public String getD_head() {
		return d_head;
	}

	public void setM_code(String m_code) {
		this.m_code = m_code;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setA_code(String a_code) {
		this.a_code = a_code;
	}

	public void setD_go(String d_go) {
		this.d_go = d_go;
	}

	public void setD_dang(String d_dang) {
		this.d_dang = d_dang;
	}

	public void setD_head(String d_head) {
		this.d_head = d_head;
	}

	@Override
	public String toString() {
		return "Material [m_code=" + m_code + ", m_name=" + m_name + ", a_code=" + a_code + ", d_go=" + d_go
				+ ", d_dang=" + d_dang + ", d_head=" + d_head + "]";
	}
	

}
