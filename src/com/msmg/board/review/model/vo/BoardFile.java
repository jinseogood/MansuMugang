package com.msmg.board.review.model.vo;

import java.sql.Date;

public class BoardFile implements java.io.Serializable{
	private int file_no;
	private String origin_name; 
	private String edit_name;
	private String file_src;
	private Date file_date;
	private String board_sort;
	private int Board_id;
	private String file_type;
	private int u_code;
	private int file_level;
	
	public BoardFile() {}

	public BoardFile(int file_no, String origin_name, String edit_name, String file_src, Date file_date,
			String board_sort, int board_id, String file_type, int u_code, int file_level) {
		super();
		this.file_no = file_no;
		this.origin_name = origin_name;
		this.edit_name = edit_name;
		this.file_src = file_src;
		this.file_date = file_date;
		this.board_sort = board_sort;
		this.Board_id = board_id;
		this.file_type = file_type;
		this.u_code = u_code;
		this.file_level = file_level;
		
	}

	public int getFile_no() {
		return file_no;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public String getEdit_name() {
		return edit_name;
	}

	public String getFile_src() {
		return file_src;
	}

	public Date getFile_date() {
		return file_date;
	}

	public String getBoard_sort() {
		return board_sort;
	}
	
	public int getFile_level() {
		return file_level;
	}

	public int getBoard_id() {
		return Board_id;
	}

	public String getFile_type() {
		return file_type;
	}

	public int getU_code() {
		return u_code;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public void setEdit_name(String edit_name) {
		this.edit_name = edit_name;
	}

	public void setFile_src(String file_src) {
		this.file_src = file_src;
	}

	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}

	public void setBoard_sort(String board_sort) {
		this.board_sort = board_sort;
	}

	public void setBoard_id(int board_id) {
		Board_id = board_id;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public void setU_code(int u_code) {
		this.u_code = u_code;
	}
	
	public void setFile_level(int file_level) {
		this.file_level = file_level;
	}

	@Override
	public String toString() {
		return "BoardFile [file_no=" + file_no + ", origin_name=" + origin_name + ", edit_name=" + edit_name
				+ ", file_src=" + file_src + ", file_date=" + file_date + ", board_sort=" + board_sort + ", Board_id="
				+ Board_id + ", file_type=" + file_type + ", u_code=" + u_code + ", file_level=" + file_level + "]";
	}
	
}
