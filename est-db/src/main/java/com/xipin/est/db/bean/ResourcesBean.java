package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

public class ResourcesBean extends Bean {

	/**
     * 
     */
	private Long id;

	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 资源英文名称
	 */
	private String ename;

	/**
	 * 资源类型（按钮，目录）
	 */
	private String type;

	/**
	 * 父资源ID
	 */
	private Long pid;

	/**
	 * 父资源ids
	 */
	private String pids;

	/**
	 * 资源URL
	 */
	private String url;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 图标
	 */
	private String icon;

	/**
     * 
     */
	private Long createId;

	/**
     * 
     */
	private String createName;

	/**
	 * 分页开始
	 */
	private Integer beginIndex;

	/**
	 * 分页大小
	 */
	private Integer pageSize;

	public Integer getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

}
