package com.dongnemon.domain;

import java.util.Arrays;
import java.util.Date;

public class MoimVO {

	private Integer id;
	private Integer user_id;
	private Integer store_id;
	private String title;
	private String content;
	private double latitude;
	private double longitude;
	private String town;
	private String address;
	private Date meet_at;
	private int price_orig;
	private int price_discount;
	private int cnt_attendee;
	private int max_attendee;
	private int min_attendee;
	private int cnt_comment;
	private String img_1;
	private String img_2;
	private String img_3;
	private String img_4;
	private String img_5;
	private String img_6;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	private int item_id;

	private String[] files;

	private String nickname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getMeet_at() {
		return meet_at;
	}

	public void setMeet_at(Date meet_at) {
		this.meet_at = meet_at;
	}

	public int getPrice_orig() {
		return price_orig;
	}

	public void setPrice_orig(int price_orig) {
		this.price_orig = price_orig;
	}

	public int getPrice_discount() {
		return price_discount;
	}

	public void setPrice_discount(int price_discount) {
		this.price_discount = price_discount;
	}

	public int getCnt_attendee() {
		return cnt_attendee;
	}

	public void setCnt_attendee(int cnt_attendee) {
		this.cnt_attendee = cnt_attendee;
	}

	public int getMax_attendee() {
		return max_attendee;
	}

	public void setMax_attendee(int max_attendee) {
		this.max_attendee = max_attendee;
	}

	public int getMin_attendee() {
		return min_attendee;
	}

	public void setMin_attendee(int min_attendee) {
		this.min_attendee = min_attendee;
	}

	public int getCnt_comment() {
		return cnt_comment;
	}

	public void setCnt_comment(int cnt_comment) {
		this.cnt_comment = cnt_comment;
	}

	public String getImg_1() {
		return img_1;
	}

	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}

	public String getImg_2() {
		return img_2;
	}

	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}

	public String getImg_3() {
		return img_3;
	}

	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}

	public String getImg_4() {
		return img_4;
	}

	public void setImg_4(String img_4) {
		this.img_4 = img_4;
	}

	public String getImg_5() {
		return img_5;
	}

	public void setImg_5(String img_5) {
		this.img_5 = img_5;
	}

	public String getImg_6() {
		return img_6;
	}

	public void setImg_6(String img_6) {
		this.img_6 = img_6;
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

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "MoimVO [id=" + id + ", user_id=" + user_id + ", store_id=" + store_id + ", title=" + title
				+ ", content=" + content + ", latitude=" + latitude + ", longitude=" + longitude + ", town=" + town
				+ ", address=" + address + ", meet_at=" + meet_at + ", price_orig=" + price_orig + ", price_discount="
				+ price_discount + ", cnt_attendee=" + cnt_attendee + ", max_attendee=" + max_attendee
				+ ", min_attendee=" + min_attendee + ", cnt_comment=" + cnt_comment + ", img_1=" + img_1 + ", img_2="
				+ img_2 + ", img_3=" + img_3 + ", img_4=" + img_4 + ", img_5=" + img_5 + ", img_6=" + img_6
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at
				+ ", item_id=" + item_id + ", files=" + Arrays.toString(files) + ", nickname=" + nickname + "]";
	}

}
