package com.dongnemon.domain;

public class AccountVO {

	private String uid;
	private String upw;
	private String uname;
	private int upoint;
	private int user_id;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUpoint() {
		return upoint;
	}

	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "AccountVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + ", user_id="
				+ user_id + "]";
	}

}
