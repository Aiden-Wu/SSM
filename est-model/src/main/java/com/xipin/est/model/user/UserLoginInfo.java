package com.xipin.est.model.user;

import java.sql.Timestamp;

import com.xipin.est.model.Model;

public class UserLoginInfo implements Model {

	private static final long serialVersionUID = 690917409270389389L;
	
	private Long id;
	private Long userId;
	private String username;
	private String ip;
	private Short typ;
	private Timestamp createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Short getTyp() {
		return typ;
	}

	public void setTyp(Short typ) {
		this.typ = typ;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
