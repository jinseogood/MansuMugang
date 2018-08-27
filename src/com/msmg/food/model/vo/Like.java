package com.msmg.food.model.vo;

public class Like {
	private int u_code;
	private int m_code;
	
	public Like(){}

	public Like(int u_code, int m_code) {
		super();
		this.u_code = u_code;
		this.m_code = m_code;
	}

	public int getU_code() {
		return u_code;
	}

	public void setU_code(int u_code) {
		this.u_code = u_code;
	}

	public int getM_code() {
		return m_code;
	}

	public void setM_code(int m_code) {
		this.m_code = m_code;
	}

	@Override
	public String toString() {
		return "Like [u_code=" + u_code + ", m_code=" + m_code + "]";
	}
	
}
