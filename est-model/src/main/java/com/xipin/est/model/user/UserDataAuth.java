package com.xipin.est.model.user;

import java.util.Date;

import com.xipin.est.model.Model;

/**
 * 请写出类的用途 
 * @author lvjl
 * @date  2016-05-17 14:30:57
 * @version 1.0.0
 * @copyright (C) 2015 XiPinTech Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the XiPinTech technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
public class UserDataAuth implements Model {
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

    private static final long serialVersionUID = 1L;

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