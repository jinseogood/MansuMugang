package com.msmg.board.qna.model.vo;

import java.sql.Date;

public class Qna {
	private int board_id;
	private int board_no;
	private String board_sort;
	private String title;
	private String content;
	private Date board_date;
	private String u_name;
	private int buy_info_no;
	private int b_count;
	private int ref_bno;
	private String write_yn;
	private int ref_ucode;

	public Qna(){}

	public Qna(int board_id, int board_no, String board_sort, String title, String content, Date board_date, String u_name,
			int buy_info_no, int b_count, int ref_bno, String write_yn, int ref_ucode) {
		super();
		this.board_id = board_id;
		this.board_no = board_no;
		this.board_sort = board_sort;
		this.title = title;
		this.content = content;
		this.board_date = board_date;
		this.u_name = u_name;
		this.buy_info_no = buy_info_no;
		this.b_count = b_count;
		this.ref_bno = ref_bno;
		this.write_yn = write_yn;
		this.ref_ucode = ref_ucode;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_sort() {
		return board_sort;
	}

	public void setBoard_sort(String board_sort) {
		this.board_sort = board_sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public int getBuy_info_no() {
		return buy_info_no;
	}

	public void setBuy_info_no(int buy_info_no) {
		this.buy_info_no = buy_info_no;
	}

	public int getB_count() {
		return b_count;
	}

	public void setB_count(int b_count) {
		this.b_count = b_count;
	}

	public int getRef_bno() {
		return ref_bno;
	}

	public void setRef_bno(int ref_bno) {
		this.ref_bno = ref_bno;
	}

	public String getWrite_yn() {
		return write_yn;
	}

	public void setWrite_yn(String write_yn) {
		this.write_yn = write_yn;
	}

	public int getRef_ucode() {
		return ref_ucode;
	}

	public void setRef_ucode(int ref_ucode) {
		this.ref_ucode = ref_ucode;
	}

	@Override
	public String toString() {
		return "Qna [board_id=" + board_id + ", board_no=" + board_no + ", board_sort=" + board_sort + ", title="
				+ title + ", content=" + content + ", board_date=" + board_date + ", u_name=" + u_name
				+ ", buy_info_no=" + buy_info_no + ", b_count=" + b_count + ", ref_bno=" + ref_bno + ", write_yn="
				+ write_yn + ", ref_ucode=" + ref_ucode + "]";
	}

	

	
	
}
