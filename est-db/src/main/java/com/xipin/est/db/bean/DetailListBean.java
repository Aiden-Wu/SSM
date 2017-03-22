package com.xipin.est.db.bean;

import java.util.Date;
import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class DetailListBean extends Bean {

	// 预报日期开始时间
	private Date beginAddTime;

	// 预报日期结束时间
	private Date endAddTime;
	
	//开始提交时间
	private Date beginSubmitTime;
	
	//结束提交时间
	private Date endSubmitTime;

	// 批次号
	private String dispatchNo;

	// 邮局
	private String postoffice;

	// 目的国
	private String countryCode;

	// 服务类型
	private String serviceType;

	// 邮寄类型
	private String dispatchType;

	// 状态
	private Integer status;

	/**
	 * 分页开始
	 */
	private Integer beginIndex;

	/**
	 * 分页大小
	 */
	private Integer pageSize;

	private Long jgOrgId;

	private Long bmOrgId;

	private Long userId;

	private List<Long> postOfficeList;

	private List<Long> cbmList;

	public Date getBeginAddTime() {
		return beginAddTime;
	}

	public void setBeginAddTime(Date beginAddTime) {
		this.beginAddTime = beginAddTime;
	}

	public Date getEndAddTime() {
		return endAddTime;
	}

	public void setEndAddTime(Date endAddTime) {
		this.endAddTime = endAddTime;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Long getJgOrgId() {
		return jgOrgId;
	}

	public void setJgOrgId(Long jgOrgId) {
		this.jgOrgId = jgOrgId;
	}

	public Long getBmOrgId() {
		return bmOrgId;
	}

	public void setBmOrgId(Long bmOrgId) {
		this.bmOrgId = bmOrgId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getPostOfficeList() {
		return postOfficeList;
	}

	public void setPostOfficeList(List<Long> postOfficeList) {
		this.postOfficeList = postOfficeList;
	}

	public List<Long> getCbmList() {
		return cbmList;
	}

	public void setCbmList(List<Long> cbmList) {
		this.cbmList = cbmList;
	}

	public Date getBeginSubmitTime() {
		return beginSubmitTime;
	}

	public void setBeginSubmitTime(Date beginSubmitTime) {
		this.beginSubmitTime = beginSubmitTime;
	}

	public Date getEndSubmitTime() {
		return endSubmitTime;
	}

	public void setEndSubmitTime(Date endSubmitTime) {
		this.endSubmitTime = endSubmitTime;
	}
	
	

}
