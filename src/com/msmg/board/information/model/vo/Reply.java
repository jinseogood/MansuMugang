package com.msmg.board.information.model.vo;

import java.sql.Date;

public class Reply implements java.io.Serializable{
	private String board_sort;
	private String u_code;  
	private String re_content;
	private Date re_date;
	private int board_id;
	
	public Reply() {}
	
	public Reply(String board_sort, String u_code, String re_content, Date re_date, int board_id) {
		super();
		this.board_sort = board_sort;
		this.u_code = u_code;
		this.re_content = re_content;
		this.re_date = re_date;
		this.board_id = board_id;
	}

	public String getBoard_sort() {
		return board_sort;
	}

	public String getU_code() {
		return u_code;
	}

	public String getRe_content() {
		return re_content;
	}

	public Date getRe_date() {
		return re_date;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_sort(String board_sort) {
		this.board_sort = board_sort;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	@Override
	public String toString() {
		return "Reply [board_sort=" + board_sort + ", u_code=" + u_code + ", re_content=" + re_content + ", re_date="
				+ re_date + ", board_id=" + board_id + "]";
	}
	
	
}
