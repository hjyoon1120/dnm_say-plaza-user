package com.dongnemon.domain;

import java.util.Arrays;
import java.util.Date;

public class PlazaVO {

	private Integer id;
	private String title;
	private String plaza_title;
	private String body;
	private String img_src;
	private Date created_at;
	private Date updated_at;
	private int cnt_like;
	private int cnt_comment;

	private String[] files;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlaza_title() {
		return plaza_title;
	}

	public void setPlaza_title(String plaza_title) {
		this.plaza_title = plaza_title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
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

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
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

	@Override
	public String toString() {
		return "PlazaVO [id=" + id + ", title=" + title + ", plaza_title=" + plaza_title + ", body=" + body
				+ ", img_src=" + img_src + ", created_at=" + created_at + ", updated_at=" + updated_at + ", cnt_like="
				+ cnt_like + ", cnt_comment=" + cnt_comment + ", files=" + Arrays.toString(files) + "]";
	}

	

}
