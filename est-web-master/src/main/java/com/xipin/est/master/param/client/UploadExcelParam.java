package com.xipin.est.master.param.client;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.UploadExcelBean;
import com.xipin.est.utils.convert.CommConvertUtils;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class UploadExcelParam extends Param implements
		BeanParam<UploadExcelBean> {

	@NotEmpty(message=ParamConstants.POSTOFFICE_CANNOT_EMPTY)
	private String postoffice;
	@NotEmpty(message=ParamConstants.CUSTOMERNO_CANNOT_EMPTY)
	private String customerNo;
	@NotEmpty(message=ParamConstants.PPINO_CANNOT_EMPTY)
	private String ppiNo;
	@NotEmpty(message=ParamConstants.TRANSPORTLINE_CANNOT_EMPTY)
	private String transportLine;
	private String postofficeAddr;

	@NotEmpty(message=ParamConstants.SERVICETYPE_CANNOT_EMPTY)
	private String serviceType;
	private String airwayBillNo;
	@NotEmpty(message=ParamConstants.DISPATCHTYPE_CANNOT_EMPTY)
	private String dispatchType;
	private String truckingNo;
	private Long truckingNoId;

	private String payMode;

	private String estimateBagNum;
	private String estimateTotalWeight;
	private Timestamp dispatchDate;
	private Timestamp estimateArrivceDate;
	private String dispatchNo;

	@NotNull(message=ParamConstants.POSTID_CANNOT_NULL)
	private Long postId;

	private String uuid;

	private String transportLineId;

	@Override
	public UploadExcelBean initBean() {
		UploadExcelBean uploadExcelBean = new UploadExcelBean();
		BeanUtils.copyProperties(this, uploadExcelBean);
		return uploadExcelBean;
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

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = CommConvertUtils.convertToTimestamp(dispatchDate,
				"dd-MM-yyyy");
	}

	public Timestamp getEstimateArrivceDate() {
		return estimateArrivceDate;
	}

	public void setEstimateArrivceDate(String estimateArrivceDate) {
		this.estimateArrivceDate = CommConvertUtils.convertToTimestamp(
				estimateArrivceDate, "dd-MM-yyyy");
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

	public Long getTruckingNoId() {
		return truckingNoId;
	}

	public void setTruckingNoId(Long truckingNoId) {
		this.truckingNoId = truckingNoId;
	}

	@Override
	public String toString() {
		return "UploadExcelParam [postoffice=" + postoffice + ", accountNo="
				+ customerNo + ", ppiNo=" + ppiNo + ", transportLine="
				+ transportLine + ", postofficeAddr=" + postofficeAddr
				+ ", serviceType=" + serviceType + ", airwayBillNo="
				+ airwayBillNo + ", dispatchType=" + dispatchType
				+ ", truckingNo=" + truckingNo + ", payMode=" + payMode
				+ ", estimateBagNum=" + estimateBagNum
				+ ", estimateTotalWeight=" + estimateTotalWeight
				+ ", dispatchDate=" + dispatchDate + ", estimateArrivceDate="
				+ estimateArrivceDate + ", dispatchNo=" + dispatchNo + "]";
	}

}
