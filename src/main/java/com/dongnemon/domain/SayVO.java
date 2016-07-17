package com.dongnemon.domain;

import java.util.Arrays;
import java.util.Date;

public class SayVO {

	private Integer id;
	private Integer user_id;
	private String body;
	private double latitude;
	private double longitude;
	private String img_src;
	private int cnt_like;
	private int cnt_comment;
	private Integer item_id;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;

	private String[] files;

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public int getCnt_like() {
		return cnt_like;
	}

	public void setCnt_like(int cnt_like) {
		this.cnt_like = cnt_like;
	}

	public int getCnt_comment() {
		return cnt_comment;
	}

	public void setCnt_comment(int cnt_comment) {
		this.cnt_comment = cnt_comment;
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
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

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "SayVO [id=" + id + ", user_id=" + user_id + ", body=" + body + ", latitude=" + latitude + ", longitude="
				+ longitude + ", img_src=" + img_src + ", cnt_like=" + cnt_like + ", cnt_comment=" + cnt_comment
				+ ", item_id=" + item_id + ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at="
				+ deleted_at + ", files=" + Arrays.toString(files) + "]";
	}

}
