package com.xipin.est.db.bean;

import java.util.Date;

import com.xipin.est.utils.bean.Bean;

public class UserDataAuthBean extends Bean {
	/**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private Long dataAuthId;

    /**
     * 
     */
    private Long creater;

    /**
     * 
     */
    private Date createDate;

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

	public Long getDataAuthId() {
		return dataAuthId;
	}

	public void setDataAuthId(Long dataAuthId) {
		this.dataAuthId = dataAuthId;
	}

	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
