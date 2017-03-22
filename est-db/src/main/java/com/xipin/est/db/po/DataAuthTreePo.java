package com.xipin.est.db.po;

import java.io.Serializable;

public class DataAuthTreePo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 机构id
	 */
	private Long orgId;
	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 
	 */
	private Long parentId;
	/**
	 * 数据权限id
	 */
	private Long dataAuthId;
	/**
	 * 是否有权限，1-有，0-没有
	 */
	private Integer isPermisson;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getDataAuthId() {
		return dataAuthId;
	}
	public void setDataAuthId(Long dataAuthId) {
		this.dataAuthId = dataAuthId;
	}
	public Integer getIsPermisson() {
		return isPermisson;
	}
	public void setIsPermisson(Integer isPermisson) {
		this.isPermisson = isPermisson;
	}

}
