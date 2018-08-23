package com.msmg.board.qna.model.vo;

import java.sql.Date;

public class Attachment {
	private int fid;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int board_no;
	private String board_sort;
	private int u_code;

	public Attachment(){}

	public Attachment(int fid, String originName, String changeName, String filePath, Date uploadDate, int board_no,
			String board_sort, int u_code) {
		super();
		this.fid = fid;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.board_no = board_no;
		this.board_sort = board_sort;
		this.u_code = u_code;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
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

	public int getU_code() {
		return u_code;
	}

	public void setU_code(int u_code) {
		this.u_code = u_code;
	}

	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", originName=" + originName + ", changeName=" + changeName + ", filePath="
				+ filePath + ", uploadDate=" + uploadDate + ", board_no=" + board_no + ", board_sort=" + board_sort
				+ ", u_code=" + u_code + "]";
	}

	
	
	
}
