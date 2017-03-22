package com.xipin.est.db.po.client;

import java.util.Date;

import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ConstantsEscape;
import com.xipin.est.utils.convert.CommConvertUtils;

public class DetailDataListPo {

	private String addDate;
	private String dispatchDate;
	private String estimateArrivceDate;
	private String actualArrivceDate;
	private String airwayBillNo;
	private String dispatchNo;
	private String bmOrgId;
	private String postoffice;
	private String postofficeAddr;
	private String accountNo;
	private String truckingNo;
	private Integer serviceType;
	private String serviceTypeName;
	private String dispatchType;
	private String estimateBagNum;
	private String estimateTotalWeight;
	private String statusTime;
	private String status;
	private String ppiNo;
	private String payMode;
	private String statusContent;
	private String actualBagNum;
	private String actualTotalWeight;
	private String postofficeEnName;
	private String submitDate;
	private Integer isBroken;
	

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = CommConvertUtils.converToStr(addDate,
				Constants.DATETIME_FORMAT);
	}
	
	

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = CommConvertUtils.converToStr(submitDate,
				Constants.DATETIME_FORMAT);
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = CommConvertUtils.converToStr(dispatchDate,
				Constants.DATETIME_FORMAT);
	}

	public String getEstimateArrivceDate() {
		return estimateArrivceDate;
	}

	public void setEstimateArrivceDate(Date estimateArrivceDate) {
		this.estimateArrivceDate = CommConvertUtils.converToStr(
				estimateArrivceDate, Constants.DATETIME_FORMAT);
	}

	public String getActualArrivceDate() {
		return actualArrivceDate;
	}

	public void setActualArrivceDate(Date actualArrivceDate) {
		this.actualArrivceDate = CommConvertUtils.converToStr(
				actualArrivceDate, Constants.DATETIME_FORMAT);
	}

	public String getAirwayBillNo() {
		return airwayBillNo;
	}

	public void setAirwayBillNo(String airwayBillNo) {
		this.airwayBillNo = airwayBillNo;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getTruckingNo() {
		return truckingNo;
	}

	public void setTruckingNo(String truckingNo) {
		this.truckingNo = truckingNo;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
		this.serviceTypeName = ConstantsEscape.serviceTypeEscap(serviceType);
	}

	/**
	 * {@linkplain #serviceTypeName}
	 */
	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
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

	public String getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = CommConvertUtils.converToStr(statusTime,
				Constants.DATETIME_FORMAT);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getPostofficeAddr() {
		return postofficeAddr;
	}

	public void setPostofficeAddr(String postofficeAddr) {
		this.postofficeAddr = postofficeAddr;
	}

	public String getPpiNo() {
		return ppiNo;
	}

	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getStatusContent() {
		return statusContent;
	}

	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}

	public String getActualBagNum() {
		return actualBagNum;
	}

	public void setActualBagNum(String actualBagNum) {
		this.actualBagNum = actualBagNum;
	}

	public String getActualTotalWeight() {
		return actualTotalWeight;
	}

	public void setActualTotalWeight(String actualTotalWeight) {
		this.actualTotalWeight = actualTotalWeight;
	}

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	/**
	 * {@linkplain #bmOrgId}
	 */
	public String getBmOrgId() {
		return bmOrgId;
	}

	/**
	 * {@linkplain #bmOrgId}
	 */
	public void setBmOrgId(String bmOrgId) {
		this.bmOrgId = bmOrgId;
	}

	/**
	 * {@linkplain #isBroken}
	 */
	public Integer getIsBroken() {
		return isBroken;
	}

	/**
	 * {@linkplain #isBroken}
	 */
	public void setIsBroken(Integer isBroken) {
		this.isBroken = isBroken;
	}
	
	

}