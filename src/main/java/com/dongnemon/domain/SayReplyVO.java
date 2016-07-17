package com.dongnemon.domain;

import java.util.Date;

public class SayReplyVO {

	private Integer id;
	private Integer say_id;
	private String body;
	private Integer user_id;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSay_id() {
		return say_id;
	}

	public void setSay_id(Integer say_id) {
		this.say_id = say_id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	@Override
	public String toString() {
		return "SayReplyVO [id=" + id + ", say_id=" + say_id + ", body=" + body + ", user_id=" + user_id
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}

}
