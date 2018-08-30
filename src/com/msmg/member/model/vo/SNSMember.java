package com.msmg.member.model.vo;
  
public class SNSMember {
	private int mNo;
	private String mId;
	private String mPwd;
	private String mName;
	private String mStatus;
	private String mToken;
	private String mType;

	public SNSMember(){}
	public SNSMember(int mNo, String mId, String mPwd, String mName, String mStatus, String mToken, String mType) {
		super();
		this.mNo = mNo;
		this.mId = mId;
		this.mPwd = mPwd;
		this.mName = mName;
		this.mStatus = mStatus;
		this.mToken = mToken;
		this.mType = mType;
	}

	public int getmNo() {
		return mNo;
	}

	public String getmId() {
		return mId;
	}

	public String getmPwd() {
		return mPwd;
	}

	public String getmName() {
		return mName;
	}

	public String getmStatus() {
		return mStatus;
	}

	public String getmToken() {
		return mToken;
	}

	public String getmType() {
		return mType;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	public void setmToken(String mToken) {
		this.mToken = mToken;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	@Override
	public String toString() {
		return "SNSMember [mNo=" + mNo + ", mId=" + mId + ", mPwd=" + mPwd + ", mName=" + mName + ", mStatus=" + mStatus
				+ ", mToken=" + mToken + ", mType=" + mType + "]";
	}
	
	
	
	
}
