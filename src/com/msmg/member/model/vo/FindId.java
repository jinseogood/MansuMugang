package com.msmg.member.model.vo;
   
public class FindId implements java.io.Serializable{
	private String userName;
	private String joinQ;
	private String joinA;
	private String userId;
	
	public FindId(){}

	public FindId(String userName, String joinQ, String joinA, String userId) {
		super();
		this.userName = userName;
		this.joinQ = joinQ;
		this.joinA = joinA;
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getJoinQ() {
		return joinQ;
	}

	public String getJoinA() {
		return joinA;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setJoinQ(String joinQ) {
		this.joinQ = joinQ;
	}

	public void setJoinA(String joinA) {
		this.joinA = joinA;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FindId [userName=" + userName + ", joinQ=" + joinQ + ", joinA=" + joinA + ", userId=" + userId + "]";
	}

	
	
}
