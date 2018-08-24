package com.msmg.food.model.vo;

public class SelectFood implements java.io.Serializable{
	
	private int go;
	private int dang;
	private int head;
	private int ggi;
	private int day;
	private int side;
	private int user;
	
	public SelectFood(){}

	public SelectFood(int go, int dang, int head, int day, int ggi, int side) {
		super();
		this.go = go;
		this.dang = dang;
		this.head = head;
		this.day = day;
		this.ggi = ggi;
		this.side = side;
	}

	public int getGo() {
		return go;
	}

	public void setGo(int go) {
		this.go = go;
	}

	public int getDang() {
		return dang;
	}

	public void setDang(int dang) {
		this.dang = dang;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public int getGgi() {
		return ggi;
	}

	public void setGgi(int ggi) {
		this.ggi = ggi;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "SelectFood [go=" + go + ", dang=" + dang + ", head=" + head + ", ggi=" + ggi + ", day=" + day
				+ ", side=" + side + ", user=" + user + "]";
	}




	
	
}
