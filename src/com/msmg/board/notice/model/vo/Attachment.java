package com.msmg.board.notice.model.vo;

import java.sql.Date;

public class Attachment {
	private int fid;
	private int bno;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;

	public Attachment(){}

	public Attachment(int fid, int bno, String originName, String changeName, String filePath, Date uploadDate) {
		super();
		this.fid = fid;
		this.bno = bno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", bno=" + bno + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + "]";
	}
	
	
}
