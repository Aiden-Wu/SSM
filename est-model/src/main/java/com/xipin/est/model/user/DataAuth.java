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
public class DataAuth implements Model {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long orgId;

    /**
     * 
     */
    private String orgName;

    /**
     * 类别，1-客户，2-客户机构，3-客户机构部门，4-邮局，5-邮局机构，6-邮局机构部门
     */
    private Byte type;

    /**
     * 
     */
    private String code;

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

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedate() {
		return createDate;
	}

	public void setCreatedate(Date createDate) {
		this.createDate = createDate;
	}
    
}