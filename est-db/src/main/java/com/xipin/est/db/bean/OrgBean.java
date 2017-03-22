package com.xipin.est.db.bean;

import java.sql.Timestamp;
import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class OrgBean extends Bean {

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

	/**
	 * 分页开始
	 */
	private Integer beginIndex;

	/**
	 * 分页大小
	 */
	private Integer pageSize;

	private List<Long> ids;

	private Long userId;

	private Long orgId;

	/**
	 * 用户类型
	 */
	private Byte userType;

	private String ename;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getIsTransport() {
		return isTransport;
	}

	public void setIsTransport(Integer isTransport) {
		this.isTransport = isTransport;
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

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
