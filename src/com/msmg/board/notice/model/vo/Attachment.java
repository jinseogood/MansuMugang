package com.msmg.board.notice.model.vo;

import java.sql.Date;

public class Attachment {
	private int fid;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int board_no;
	private String board_sort;

	public Attachment(){}

	public Attachment(int fid, String originName, String changeName, String filePath, Date uploadDate, int board_no,
			String board_sort) {
		super();
		this.fid = fid;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.board_no = board_no;
		this.board_sort = board_sort;
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

	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", originName=" + originName + ", changeName=" + changeName + ", filePath="
				+ filePath + ", uploadDate=" + uploadDate + ", board_no=" + board_no + ", board_sort=" + board_sort
				+ "]";
	}

	
	
}
