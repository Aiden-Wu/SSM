package com.xipin.est.db.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.xipin.est.utils.bean.Bean;

public class TrunkingLineBean extends Bean{
	
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private String no;
	
	private String start;
	
	private String end;
	
	private String isTransport;
	
	private String trunkStatus;
	
	private Date createDate;
	
	private Date updateDate;
	
	private String createName;
	
	private BigDecimal creater;
	
	private String departmentName;
	
	private String departmentID;
	
	/**
	 * 分页开始
	 */
	private Integer beginIndex;
	
	/**
	 * 分页大小
	 */
	private Integer pageSize;

	
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	

	public String getIsTransport() {
		return isTransport;
	}

	public void setIsTransport(String isTransport) {
		this.isTransport = isTransport;
	}

	public String getTrunkStatus() {
		return trunkStatus;
	}

	public void setTrunkStatus(String trunkStatus) {
		this.trunkStatus = trunkStatus;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public BigDecimal getCreater() {
		return creater;
	}

	public void setCreater(BigDecimal creater) {
		this.creater = creater;
	}
	

}
