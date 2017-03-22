package com.xipin.est.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * <p>
 * Description: 预报清单实体类
 * </p>
 * 
 * @Timestamp 2016年5月11日
 * @version 1.0
 *          <p>
 *          Company:XiPinTech
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2015
 *          </p>
 */
public class DetailList implements Model {

	private static final long serialVersionUID = -9150728671962707880L;

	private String postoffice;
	private String accountNo;
	private String transportLine;
	private String ppiNo;
	private String postofficeAddr;
	private String serviceType;
	private String airwayBillNo;
	private String dispatchType;
	private String truckingNo;
	private Long truckingNoId;
	private String payMode;
	private BigDecimal estimateBagNum;
	private BigDecimal estimateTotalWeight;
	private BigDecimal actualBagNum;
	private BigDecimal actualTotalWeight;
	private Timestamp dispatchDate;
	private Timestamp estimateArrivceDate;
	private Timestamp actualArrivceDate;
	private String dispatchNo;
	private String customerName;
	private String customerNo;
	private Integer status;
	private String countryCode;
	private String addWho;
	private Timestamp addDate;
	private String updateWho;
	private Timestamp updateDate;
	private String createPerson;

	private Long jgOrgId;
	private Long bmOrgId;

	private Long cJgOrgId;

	private Long cBmOrgId;
	private String postofficeEnName;
	private Timestamp submitDate;

	@Override
	public Long getId() {
		return -1l;
	}

	/**
	 * {@linkplain #postoffice}
	 */
	public String getPostoffice() {
		return postoffice;
	}

	/**
	 * {@linkplain #postoffice}
	 */
	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	/**
	 * {@linkplain #accountNo}
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * {@linkplain #accountNo}
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * {@linkplain #transportLine}
	 */
	public String getTransportLine() {
		return transportLine;
	}

	/**
	 * {@linkplain #transportLine}
	 */
	public void setTransportLine(String transportLine) {
		this.transportLine = transportLine;
	}

	/**
	 * {@linkplain #ppiNo}
	 */
	public String getPpiNo() {
		return ppiNo;
	}

	/**
	 * {@linkplain #ppiNo}
	 */
	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	/**
	 * {@linkplain #postofficeAddr}
	 */
	public String getPostofficeAddr() {
		return postofficeAddr;
	}

	/**
	 * {@linkplain #postofficeAddr}
	 */
	public void setPostofficeAddr(String postofficeAddr) {
		this.postofficeAddr = postofficeAddr;
	}

	/**
	 * {@linkplain #serviceType}
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * {@linkplain #serviceType}
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * {@linkplain #airwayBillNo}
	 */
	public String getAirwayBillNo() {
		return airwayBillNo;
	}

	/**
	 * {@linkplain #airwayBillNo}
	 */
	public void setAirwayBillNo(String airwayBillNo) {
		this.airwayBillNo = airwayBillNo;
	}

	/**
	 * {@linkplain #dispatchType}
	 */
	public String getDispatchType() {
		return dispatchType;
	}

	/**
	 * {@linkplain #dispatchType}
	 */
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	/**
	 * {@linkplain #truckingNo}
	 */
	public String getTruckingNo() {
		return truckingNo;
	}

	/**
	 * {@linkplain #truckingNo}
	 */
	public void setTruckingNo(String truckingNo) {
		this.truckingNo = truckingNo;
	}

	/**
	 * {@linkplain #payMode}
	 */
	public String getPayMode() {
		return payMode;
	}

	/**
	 * {@linkplain #payMode}
	 */
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	/**
	 * {@linkplain #estimateBagNum}
	 */
	public BigDecimal getEstimateBagNum() {
		return estimateBagNum;
	}

	/**
	 * {@linkplain #estimateBagNum}
	 */
	public void setEstimateBagNum(BigDecimal estimateBagNum) {
		this.estimateBagNum = estimateBagNum;
	}

	/**
	 * {@linkplain #estimateTotalWeight}
	 */
	public BigDecimal getEstimateTotalWeight() {
		return estimateTotalWeight;
	}

	/**
	 * {@linkplain #estimateTotalWeight}
	 */
	public void setEstimateTotalWeight(BigDecimal estimateTotalWeight) {
		this.estimateTotalWeight = estimateTotalWeight;
	}

	/**
	 * {@linkplain #actualBagNum}
	 */
	public BigDecimal getActualBagNum() {
		return actualBagNum;
	}

	/**
	 * {@linkplain #actualBagNum}
	 */
	public void setActualBagNum(BigDecimal actualBagNum) {
		this.actualBagNum = actualBagNum;
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public BigDecimal getActualTotalWeight() {
		return actualTotalWeight;
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public void setActualTotalWeight(BigDecimal actualTotalWeight) {
		this.actualTotalWeight = actualTotalWeight;
	}

	/**
	 * {@linkplain #dispatchDate}
	 */
	public Timestamp getDispatchDate() {
		return dispatchDate;
	}

	/**
	 * {@linkplain #dispatchDate}
	 */
	public void setDispatchDate(Timestamp dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	/**
	 * {@linkplain #estimateArrivceDate}
	 */
	public Timestamp getEstimateArrivceDate() {
		return estimateArrivceDate;
	}

	/**
	 * {@linkplain #estimateArrivceDate}
	 */
	public void setEstimateArrivceDate(Timestamp estimateArrivceDate) {
		this.estimateArrivceDate = estimateArrivceDate;
	}

	/**
	 * {@linkplain #actualArrivceDate}
	 */
	public Timestamp getActualArrivceDate() {
		return actualArrivceDate;
	}

	/**
	 * {@linkplain #actualArrivceDate}
	 */
	public void setActualArrivceDate(Timestamp actualArrivceDate) {
		this.actualArrivceDate = actualArrivceDate;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #customerName}
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * {@linkplain #customerName}
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * {@linkplain #customerNo}
	 */
	public String getCustomerNo() {
		return customerNo;
	}

	/**
	 * {@linkplain #customerNo}
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * {@linkplain #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * {@linkplain #status}
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * {@linkplain #countryCode}
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * {@linkplain #countryCode}
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * {@linkplain #addWho}
	 */
	public String getAddWho() {
		return addWho;
	}

	/**
	 * {@linkplain #addWho}
	 */
	public void setAddWho(String addWho) {
		this.addWho = addWho;
	}

	/**
	 * {@linkplain #addDate}
	 */
	public Timestamp getAddDate() {
		return addDate;
	}

	/**
	 * {@linkplain #addDate}
	 */
	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	/**
	 * {@linkplain #updateWho}
	 */
	public String getUpdateWho() {
		return updateWho;
	}

	/**
	 * {@linkplain #updateWho}
	 */
	public void setUpdateWho(String updateWho) {
		this.updateWho = updateWho;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
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

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Long getCJgOrgId() {
		return cJgOrgId;
	}

	public void setCJgOrgId(Long cJgOrgId) {
		this.cJgOrgId = cJgOrgId;
	}

	public Long getCBmOrgId() {
		return cBmOrgId;
	}

	public void setCBmOrgId(Long cBmOrgId) {
		this.cBmOrgId = cBmOrgId;
	}

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	public Long getTruckingNoId() {
		return truckingNoId;
	}

	public void setTruckingNoId(Long truckingNoId) {
		this.truckingNoId = truckingNoId;
	}
	
	

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	@Override
	public String toString() {
		return "DetailList [postoffice=" + postoffice + ", accountNo="
				+ accountNo + ", transportLine=" + transportLine + ", ppiNo="
				+ ppiNo + ", postofficeAddr=" + postofficeAddr
				+ ", serviceType=" + serviceType + ", airwayBillNo="
				+ airwayBillNo + ", dispatchType=" + dispatchType
				+ ", truckingNo=" + truckingNo + ", truckingNoId="
				+ truckingNoId + ", payMode=" + payMode + ", estimateBagNum="
				+ estimateBagNum + ", estimateTotalWeight="
				+ estimateTotalWeight + ", actualBagNum=" + actualBagNum
				+ ", actualTotalWeight=" + actualTotalWeight
				+ ", dispatchDate=" + dispatchDate + ", estimateArrivceDate="
				+ estimateArrivceDate + ", actualArrivceDate="
				+ actualArrivceDate + ", dispatchNo=" + dispatchNo
				+ ", customerName=" + customerName + ", customerNo="
				+ customerNo + ", status=" + status + ", countryCode="
				+ countryCode + ", addWho=" + addWho + ", addDate=" + addDate
				+ ", updateWho=" + updateWho + ", updateDate=" + updateDate
				+ ", createPerson=" + createPerson + ", jgOrgId=" + jgOrgId
				+ ", bmOrgId=" + bmOrgId + ", cJgOrgId=" + cJgOrgId
				+ ", cBmOrgId=" + cBmOrgId + ", postofficeEnName="
				+ postofficeEnName + ", submitDate=" + submitDate + "]";
	}

}
