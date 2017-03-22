package com.xipin.est.db.po.manager;

import java.math.BigDecimal;
import java.sql.Date;

import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.convert.CommConvertUtils;

public class TrunkingLinePo {
	
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private String no;
	
	private String start;
	
	private String end;
	
	private String isTransport;
	
	private String trunkStatus;
	
	private String createName;
	
	private String creater;
	
	private String createDate;
	
	private String updateDate;
	
	private String departmentName;
	
	private BigDecimal departmentID;

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

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = CommConvertUtils.converToStr(createDate, Constants.DATETIME_FORMAT);
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = CommConvertUtils.converToStr(updateDate, Constants.DATETIME_FORMAT);
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public BigDecimal getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(BigDecimal departmentID) {
		this.departmentID = departmentID;
	}
	
	
	

}
