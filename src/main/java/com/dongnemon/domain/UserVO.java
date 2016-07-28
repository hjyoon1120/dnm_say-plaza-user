package com.dongnemon.domain;

import java.util.Arrays;
import java.util.Date;

public class UserVO {

	private Integer id;
	private String pw, email, nickname, img_src, sex, job, text, address, locale, country, town1, town2, town3, town4,
			town5, auth, sess, client_id, device_id, img1;

	private int cnt_heart, cnt_coin, cnt_follower, cnt_following, cnt_today, cnt_total, is_active, is_banned;

	private double town_latitude, town_longitude, latitude, longitude;
	private Date dob, created_at, updated_at, sessionlimit;
	private boolean unlimited;

	private String[] files;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTown1() {
		return town1;
	}

	public void setTown1(String town1) {
		this.town1 = town1;
	}

	public String getTown2() {
		return town2;
	}

	public void setTown2(String town2) {
		this.town2 = town2;
	}

	public String getTown3() {
		return town3;
	}

	public void setTown3(String town3) {
		this.town3 = town3;
	}

	public String getTown4() {
		return town4;
	}

	public void setTown4(String town4) {
		this.town4 = town4;
	}

	public String getTown5() {
		return town5;
	}

	public void setTown5(String town5) {
		this.town5 = town5;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getSess() {
		return sess;
	}

	public void setSess(String sess) {
		this.sess = sess;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public int getCnt_heart() {
		return cnt_heart;
	}

	public void setCnt_heart(int cnt_heart) {
		this.cnt_heart = cnt_heart;
	}

	public int getCnt_coin() {
		return cnt_coin;
	}

	public void setCnt_coin(int cnt_coin) {
		this.cnt_coin = cnt_coin;
	}

	public int getCnt_follower() {
		return cnt_follower;
	}

	public void setCnt_follower(int cnt_follower) {
		this.cnt_follower = cnt_follower;
	}

	public int getCnt_following() {
		return cnt_following;
	}

	public void setCnt_following(int cnt_following) {
		this.cnt_following = cnt_following;
	}

	public int getCnt_today() {
		return cnt_today;
	}

	public void setCnt_today(int cnt_today) {
		this.cnt_today = cnt_today;
	}

	public int getCnt_total() {
		return cnt_total;
	}

	public void setCnt_total(int cnt_total) {
		this.cnt_total = cnt_total;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}

	public int getIs_banned() {
		return is_banned;
	}

	public void setIs_banned(int is_banned) {
		this.is_banned = is_banned;
	}

	public boolean isUnlimited() {
		return unlimited;
	}

	public void setUnlimited(boolean unlimited) {
		this.unlimited = unlimited;
	}

	public double getTown_latitude() {
		return town_latitude;
	}

	public void setTown_latitude(double town_latitude) {
		this.town_latitude = town_latitude;
	}

	public double getTown_longitude() {
		return town_longitude;
	}

	public void setTown_longitude(double town_longitude) {
		this.town_longitude = town_longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getSessionlimit() {
		return sessionlimit;
	}

	public void setSessionlimit(Date sessionlimit) {
		this.sessionlimit = sessionlimit;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", email=" + email + ", nickname=" + nickname + ", img_src="
				+ img_src + ", sex=" + sex + ", job=" + job + ", text=" + text + ", address=" + address + ", locale="
				+ locale + ", country=" + country + ", town1=" + town1 + ", town2=" + town2 + ", town3=" + town3
				+ ", town4=" + town4 + ", town5=" + town5 + ", auth=" + auth + ", sess=" + sess + ", client_id="
				+ client_id + ", device_id=" + device_id + ", img1=" + img1 + ", cnt_heart=" + cnt_heart + ", cnt_coin="
				+ cnt_coin + ", cnt_follower=" + cnt_follower + ", cnt_following=" + cnt_following + ", cnt_today="
				+ cnt_today + ", cnt_total=" + cnt_total + ", is_active=" + is_active + ", is_banned=" + is_banned
				+ ", town_latitude=" + town_latitude + ", town_longitude=" + town_longitude + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", dob=" + dob + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", sessionlimit=" + sessionlimit + ", unlimited=" + unlimited + ", files="
				+ Arrays.toString(files) + "]";
	}

}
