package com.msmg.payment.model.vo;

public class Destination implements java.io.Serializable {
	
	private int destination_no;
	private String destination_sort;
	private String destionation;
	private String u_code;
	
	public Destination(){}

	public Destination(int destination_no, String destination_sort, String destionation, String u_code) {
		super();
		this.destination_no = destination_no;
		this.destination_sort = destination_sort;
		this.destionation = destionation;
		this.u_code = u_code;
	}

	@Override
	public String toString() {
		return "Delivery [destination_no=" + destination_no + ", destination_sort=" + destination_sort
				+ ", destionation=" + destionation + ", u_code=" + u_code + "]";
	}

	public int getDestination_no() {
		return destination_no;
	}

	public void setDestination_no(int destination_no) {
		this.destination_no = destination_no;
	}

	public String getDestination_sort() {
		return destination_sort;
	}

	public void setDestination_sort(String destination_sort) {
		this.destination_sort = destination_sort;
	}

	public String getDestionation() {
		return destionation;
	}

	public void setDestionation(String destionation) {
		this.destionation = destionation;
	}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	
	

}
