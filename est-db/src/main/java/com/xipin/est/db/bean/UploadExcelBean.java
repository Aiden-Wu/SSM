package com.xipin.est.db.bean;

import java.sql.Timestamp;

import com.xipin.est.utils.bean.Bean;

public class UploadExcelBean extends Bean {

	private String postoffice;
	private String customerNo;
	private String ppiNo;
	private String transportLine;
	private String postofficeAddr;

	private String serviceType;
	private String airwayBillNo;
	private String dispatchType;
	private String truckingNo;
	private Long truckingNoId;
	private String payMode;

	private String estimateBagNum;
	private String estimateTotalWeight;
	private Timestamp dispatchDate;
	private Timestamp estimateArrivceDate;
	private String dispatchNo;
	private Long postId;
	private String addWho;
	private String createPerson;
	private String uuid;
	private String transportLineId;
	private Long userId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTransportLineId() {
		return transportLineId;
	}

	public void setTransportLineId(String transportLineId) {
		this.transportLineId = transportLineId;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getPpiNo() {
		return ppiNo;
	}

	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	public String getTransportLine() {
		return transportLine;
	}

	public void setTransportLine(String transportLine) {
		this.transportLine = transportLine;
	}

	public String getPostofficeAddr() {
		return postofficeAddr;
	}

	public void setPostofficeAddr(String postofficeAddr) {
		this.postofficeAddr = postofficeAddr;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getAirwayBillNo() {
		return airwayBillNo;
	}

	public void setAirwayBillNo(String airwayBillNo) {
		this.airwayBillNo = airwayBillNo;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getTruckingNo() {
		return truckingNo;
	}

	public void setTruckingNo(String truckingNo) {
		this.truckingNo = truckingNo;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getEstimateBagNum() {
		return estimateBagNum;
	}

	public void setEstimateBagNum(String estimateBagNum) {
		this.estimateBagNum = estimateBagNum;
	}

	public String getEstimateTotalWeight() {
		return estimateTotalWeight;
	}

	public void setEstimateTotalWeight(String estimateTotalWeight) {
		this.estimateTotalWeight = estimateTotalWeight;
	}

	public Timestamp getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Timestamp dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Timestamp getEstimateArrivceDate() {
		return estimateArrivceDate;
	}

	public void setEstimateArrivceDate(Timestamp estimateArrivceDate) {
		this.estimateArrivceDate = estimateArrivceDate;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getAddWho() {
		return addWho;
	}

	public void setAddWho(String addWho) {
		this.addWho = addWho;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Long getTruckingNoId() {
		return truckingNoId;
	}

	public void setTruckingNoId(Long truckingNoId) {
		this.truckingNoId = truckingNoId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
