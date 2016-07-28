package com.dongnemon.dto;

public class LoginDTO {

	private String id;
	private String pw;
	private boolean useCookie;
/*	private int user_id;
	private String nickname;*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

/*	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}*/

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pw=" + pw + ", useCookie=" + useCookie + "]";
	}

}
