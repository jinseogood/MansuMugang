package com.msmg.food.model.vo;

public class Buy implements java.io.Serializable{
	private String ucode;
	private String mcode;
	
	public Buy(){}

	public Buy(String ucode, String mcode) {
		super();
		this.ucode = ucode;
		this.mcode = mcode;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	@Override
	public String toString() {
		return "Buy [ucode=" + ucode + ", mcode=" + mcode + "]";
	}
	
}
