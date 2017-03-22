package com.xipin.est.db.bean;

import java.util.Date;

import com.xipin.est.utils.bean.Bean;

public class DataAuthBean extends Bean {
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
     * 类别，1-客户，2-客户机构，3-机构部门，4-邮局，5-邮局-1，6-邮局-2
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
