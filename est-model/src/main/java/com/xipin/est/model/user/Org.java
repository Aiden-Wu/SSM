package com.xipin.est.model.user;

import java.sql.Timestamp;

import com.xipin.est.model.Model;

public class Org implements Model {

	/**
     * 
     */
	private Long id;

	/**
	 * 父机构ID
	 */
	private Long parentId;

	/**
	 * 机构名
	 */
	private String name;

	/**
	 * 英文名称
	 */
	private String ename;

	/**
	 * 机构代码
	 */
	private String no;

	/**
	 * 机构类型,[邮局：0， 客户：1]
	 */
	private Byte type;

	/**
	 * 级别，0-组织架构，1-客户/邮局，2-机构，3-部门
	 */
	private Byte level;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 添加人
	 */
	private Long creater;

	/**
	 * 添加人用户名
	 */
	private String createrName;

	/**
	 * 是否转运线
	 */
	private Integer isTransport;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 联系电话
	 */
	private String phoneNum;

	/**
     * 
     */
	private Timestamp createDate;

	/**
     * 
     */
	private Timestamp updateDate;

	private static final long serialVersionUID = 1L;

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsTransport() {
		return isTransport;
	}

	public void setIsTransport(Integer isTransport) {
		this.isTransport = isTransport;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
