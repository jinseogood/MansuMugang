package com.msmg.mypage.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int board_no;
	private String board_sort;
	private String title;
	private String content;
	private Date board_date;
	private String u_code;
	private int buy_info_num;
	private int b_count;
	private int ref_bno;
	private int board_id;
	private String write_yn;
	private String admin_yn;

	public Board(){}

	public Board(int board_no, String board_sort, String title, String content, Date board_date, String u_code,
			int buy_info_num, int b_count, int ref_bno, int board_id, String write_yn, String admin_yn) {
		super();
		this.board_no = board_no;
		this.board_sort = board_sort;
		this.title = title;
		this.content = content;
		this.board_date = board_date;
		this.u_code = u_code;
		this.buy_info_num = buy_info_num;
		this.b_count = b_count;
		this.ref_bno = ref_bno;
		this.board_id = board_id;
		this.write_yn = write_yn;
		this.admin_yn = admin_yn;
	}

	public int getBoard_no() {
		return board_no;
	}

	public String getBoard_sort() {
		return board_sort;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public String getU_code() {
		return u_code;
	}

	public int getBuy_info_num() {
		return buy_info_num;
	}

	public int getB_count() {
		return b_count;
	}

	public int getRef_bno() {
		return ref_bno;
	}

	public int getBoard_id() {
		return board_id;
	}

	public String getWrite_yn() {
		return write_yn;
	}

	public String getAdmin_yn() {
		return admin_yn;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public void setBoard_sort(String board_sort) {
		this.board_sort = board_sort;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public void setBuy_info_num(int buy_info_num) {
		this.buy_info_num = buy_info_num;
	}

	public void setB_count(int b_count) {
		this.b_count = b_count;
	}

	public void setRef_bno(int ref_bno) {
		this.ref_bno = ref_bno;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public void setWrite_yn(String write_yn) {
		this.write_yn = write_yn;
	}

	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_sort=" + board_sort + ", title=" + title + ", content="
				+ content + ", board_date=" + board_date + ", u_code=" + u_code + ", buy_info_num=" + buy_info_num
				+ ", b_count=" + b_count + ", ref_bno=" + ref_bno + ", board_id=" + board_id + ", write_yn=" + write_yn
				+ ", admin_yn=" + admin_yn + "]";
	}
	
	
}
