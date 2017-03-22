package com.xipin.est.service.vo;

import java.util.ArrayList;
import java.util.List;

public class Auth {
	
	/**
	 * 权限id
	 */
	private Long id;
	
	/**
	 * 机构id
	 */
	private Long orgId;
	/**
	 * 机构父id
	 */
	private Long orgParentId;
	/**
	 * 机构名称
	 */
	private String name;
	
	/**
	 * 是否有权
	 */
	private Integer isPermisson;
	/**
	 * 子权限列表
	 */
	private List<Auth> child = new ArrayList<Auth>();
	
	
	public Integer getIsPermisson() {
		return isPermisson;
	}
	public void setIsPermisson(Integer isPermisson) {
		this.isPermisson = isPermisson;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgParentId() {
		return orgParentId;
	}
	public void setOrgParentId(Long orgParentId) {
		this.orgParentId = orgParentId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Auth> getChild() {
		return child;
	}
	public void setChild(List<Auth> child) {
		this.child = child;
	}
	
}
