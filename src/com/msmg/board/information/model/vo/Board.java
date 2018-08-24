package com.msmg.board.information.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int boardId;
	private int boardNo;
	private String boardSort;
	private String title;
	private String content;
	private Date boardDate;
	private String uCode;
	private int buyInfoNo;
	private int bCount;
	private int refBno;
	private String writeYn;
	
	public Board() {}

	public Board(int boardId, int boardNo, String boardSort, String uName, String title, String content, Date boardDate, String uCode,
			int buyInfoNo, int bCount, int refBno, String writeYn) {
		super();
		this.boardId = boardId;
		this.boardNo = boardNo;
		this.boardSort = boardSort;
		this.title = title;
		this.content = content;
		this.boardDate = boardDate;
		this.uCode = uCode;
		this.buyInfoNo = buyInfoNo;
		this.bCount = bCount;
		this.refBno = refBno;
		this.writeYn = writeYn;
	}

	public int getBoardId() {
		return boardId;
	}
	
	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardSort() {
		return boardSort;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public String getuCode() {
		return uCode;
	}

	public int getBuyInfoNo() {
		return buyInfoNo;
	}

	public int getbCount() {
		return bCount;
	}

	public int getRefBno() {
		return refBno;
	}
	
	public String getWriteYn() {
		return writeYn;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setBoardSort(String boardSort) {
		this.boardSort = boardSort;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public void setBuyInfoNo(int buyInfoNo) {
		this.buyInfoNo = buyInfoNo;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}
	
	public void setWriteYn(String writeYn) {
		this.writeYn = writeYn;
	}

	@Override
	public String toString() {
		return "board [boardId =" + boardId + ", boardNo=" + boardNo + ", boardSort=" + boardSort + ", title=" + title + ", content=" + content
				+ ", boardDate=" + boardDate + ", uCode=" + uCode + ", buyInfoNo=" + buyInfoNo + ", bCount=" + bCount
				+ ", refBno=" + refBno + ", writeYn="+ writeYn + "]";
	}

}
