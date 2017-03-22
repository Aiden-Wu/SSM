package com.xipin.est.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * <p>Description: 包裹实体类</p>
 * @Timestamp 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class Items implements Model {

	private static final long serialVersionUID = 2054547028402066650L;

	private Timestamp dispatchDate;
	private String postoffice;
	private String transportLine;
	private String customerNo;
	private String dispatchNo;
	private String dispatchType;
	private String lockedBagNo;
	private String ppiNo;
	private String airwayBillNo;
	private String truckingNo;
	private Timestamp eta;
	private String referenceId;
	private String bagNo;
	private String shipperName;
	private String shipperAddress1;
	private String shipperAddress2;
	private String shipperCity;
	private String shipperState;
	private String shipperPostalCode;
	private String shipperCountryCode;
	private String receiverAddress1;
	private String receiverAddress2;
	private String receiverCity;
	private String receiverState;
	private String receiverPostcode;
	private String receiverCountryCode;
	private String receiverName;
	private String receiverPhone;
	private String receiverEmail;
	private String itemDescription;
	private BigDecimal qty;
	private BigDecimal weight;
	private BigDecimal length;
	private BigDecimal height;
	private BigDecimal width;
	private BigDecimal itemValue;
	private String referenceIdentificationB;
	private String terms;
	private String cn35;
	private String cn38;
	private String countryCode;
	private String addWho;
	private Timestamp addDate;
	private String updateWho;
	private Timestamp updateDate;
	private String postofficeEnName;
	private String sealNo;

	@Override
	public Long getId() {
		return -1l;
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
	 * {@linkplain #lockedBagNo}
	 */
	public String getLockedBagNo() {
		return lockedBagNo;
	}

	/**
	 * {@linkplain #lockedBagNo}
	 */
	public void setLockedBagNo(String lockedBagNo) {
		this.lockedBagNo = lockedBagNo;
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
	 * {@linkplain #eta}
	 */
	public Timestamp getEta() {
		return eta;
	}

	/**
	 * {@linkplain #eta}
	 */
	public void setEta(Timestamp eta) {
		this.eta = eta;
	}

	/**
	 * {@linkplain #referenceId}
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * {@linkplain #referenceId}
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * {@linkplain #bagNo}
	 */
	public String getBagNo() {
		return bagNo;
	}

	/**
	 * {@linkplain #bagNo}
	 */
	public void setBagNo(String bagNo) {
		this.bagNo = bagNo;
	}

	/**
	 * {@linkplain #shipperName}
	 */
	public String getShipperName() {
		return shipperName;
	}

	/**
	 * {@linkplain #shipperName}
	 */
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	/**
	 * {@linkplain #shipperAddress1}
	 */
	public String getShipperAddress1() {
		return shipperAddress1;
	}

	/**
	 * {@linkplain #shipperAddress1}
	 */
	public void setShipperAddress1(String shipperAddress1) {
		this.shipperAddress1 = shipperAddress1;
	}

	/**
	 * {@linkplain #shipperAddress2}
	 */
	public String getShipperAddress2() {
		return shipperAddress2;
	}

	/**
	 * {@linkplain #shipperAddress2}
	 */
	public void setShipperAddress2(String shipperAddress2) {
		this.shipperAddress2 = shipperAddress2;
	}

	/**
	 * {@linkplain #shipperCity}
	 */
	public String getShipperCity() {
		return shipperCity;
	}

	/**
	 * {@linkplain #shipperCity}
	 */
	public void setShipperCity(String shipperCity) {
		this.shipperCity = shipperCity;
	}

	/**
	 * {@linkplain #shipperState}
	 */
	public String getShipperState() {
		return shipperState;
	}

	/**
	 * {@linkplain #shipperState}
	 */
	public void setShipperState(String shipperState) {
		this.shipperState = shipperState;
	}

	/**
	 * {@linkplain #shipperPostalCode}
	 */
	public String getShipperPostalCode() {
		return shipperPostalCode;
	}

	/**
	 * {@linkplain #shipperPostalCode}
	 */
	public void setShipperPostalCode(String shipperPostalCode) {
		this.shipperPostalCode = shipperPostalCode;
	}

	/**
	 * {@linkplain #shipperCountryCode}
	 */
	public String getShipperCountryCode() {
		return shipperCountryCode;
	}

	/**
	 * {@linkplain #shipperCountryCode}
	 */
	public void setShipperCountryCode(String shipperCountryCode) {
		this.shipperCountryCode = shipperCountryCode;
	}

	/**
	 * {@linkplain #receiverAddress1}
	 */
	public String getReceiverAddress1() {
		return receiverAddress1;
	}

	/**
	 * {@linkplain #receiverAddress1}
	 */
	public void setReceiverAddress1(String receiverAddress1) {
		this.receiverAddress1 = receiverAddress1;
	}

	/**
	 * {@linkplain #receiverAddress2}
	 */
	public String getReceiverAddress2() {
		return receiverAddress2;
	}

	/**
	 * {@linkplain #receiverAddress2}
	 */
	public void setReceiverAddress2(String receiverAddress2) {
		this.receiverAddress2 = receiverAddress2;
	}

	/**
	 * {@linkplain #receiverCity}
	 */
	public String getReceiverCity() {
		return receiverCity;
	}

	/**
	 * {@linkplain #receiverCity}
	 */
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	/**
	 * {@linkplain #receiverState}
	 */
	public String getReceiverState() {
		return receiverState;
	}

	/**
	 * {@linkplain #receiverState}
	 */
	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	/**
	 * {@linkplain #receiverPostcode}
	 */
	public String getReceiverPostcode() {
		return receiverPostcode;
	}

	/**
	 * {@linkplain #receiverPostcode}
	 */
	public void setReceiverPostcode(String receiverPostcode) {
		this.receiverPostcode = receiverPostcode;
	}

	/**
	 * {@linkplain #receiverCountryCode}
	 */
	public String getReceiverCountryCode() {
		return receiverCountryCode;
	}

	/**
	 * {@linkplain #receiverCountryCode}
	 */
	public void setReceiverCountryCode(String receiverCountryCode) {
		this.receiverCountryCode = receiverCountryCode;
	}

	/**
	 * {@linkplain #receiverName}
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * {@linkplain #receiverName}
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * {@linkplain #receiverPhone}
	 */
	public String getReceiverPhone() {
		return receiverPhone;
	}

	/**
	 * {@linkplain #receiverPhone}
	 */
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	/**
	 * {@linkplain #receiverEmail}
	 */
	public String getReceiverEmail() {
		return receiverEmail;
	}

	/**
	 * {@linkplain #receiverEmail}
	 */
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	/**
	 * {@linkplain #itemDescription}
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * {@linkplain #itemDescription}
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * {@linkplain #qty}
	 */
	public BigDecimal getQty() {
		return qty;
	}

	/**
	 * {@linkplain #qty}
	 */
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	/**
	 * {@linkplain #weight}
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * {@linkplain #weight}
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * {@linkplain #length}
	 */
	public BigDecimal getLength() {
		return length;
	}

	/**
	 * {@linkplain #length}
	 */
	public void setLength(BigDecimal length) {
		this.length = length;
	}

	/**
	 * {@linkplain #height}
	 */
	public BigDecimal getHeight() {
		return height;
	}

	/**
	 * {@linkplain #height}
	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	/**
	 * {@linkplain #width}
	 */
	public BigDecimal getWidth() {
		return width;
	}

	/**
	 * {@linkplain #width}
	 */
	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	/**
	 * {@linkplain #itemValue}
	 */
	public BigDecimal getItemValue() {
		return itemValue;
	}

	/**
	 * {@linkplain #itemValue}
	 */
	public void setItemValue(BigDecimal itemValue) {
		this.itemValue = itemValue;
	}

	/**
	 * {@linkplain #referenceIdentificationB}
	 */
	public String getReferenceIdentificationB() {
		return referenceIdentificationB;
	}

	/**
	 * {@linkplain #referenceIdentificationB}
	 */
	public void setReferenceIdentificationB(String referenceIdentificationB) {
		this.referenceIdentificationB = referenceIdentificationB;
	}

	/**
	 * {@linkplain #terms}
	 */
	public String getTerms() {
		return terms;
	}

	/**
	 * {@linkplain #terms}
	 */
	public void setTerms(String terms) {
		this.terms = terms;
	}

	/**
	 * {@linkplain #cn35}
	 */
	public String getCn35() {
		return cn35;
	}

	/**
	 * {@linkplain #cn35}
	 */
	public void setCn35(String cn35) {
		this.cn35 = cn35;
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

	/**
	 * {@linkplain #updateDate}
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * {@linkplain #updateDate}
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}
	
	

	public String getCn38() {
		return cn38;
	}

	public void setCn38(String cn38) {
		this.cn38 = cn38;
	}
	

	public String getSealNo() {
		return sealNo;
	}

	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}

	@Override
	public String toString() {
		return "Items [dispatchDate=" + dispatchDate + ", postoffice="
				+ postoffice + ", transportLine=" + transportLine
				+ ", customerNo=" + customerNo + ", dispatchNo=" + dispatchNo
				+ ", dispatchType=" + dispatchType + ", lockedBagNo="
				+ lockedBagNo + ", ppiNo=" + ppiNo + ", airwayBillNo="
				+ airwayBillNo + ", truckingNo=" + truckingNo + ", eta=" + eta
				+ ", referenceId=" + referenceId + ", bagNo=" + bagNo
				+ ", shipperName=" + shipperName + ", shipperAddress1="
				+ shipperAddress1 + ", shipperAddress2=" + shipperAddress2
				+ ", shipperCity=" + shipperCity + ", shipperState="
				+ shipperState + ", shipperPostalCode=" + shipperPostalCode
				+ ", shipperCountryCode=" + shipperCountryCode
				+ ", receiverAddress1=" + receiverAddress1
				+ ", receiverAddress2=" + receiverAddress2 + ", receiverCity="
				+ receiverCity + ", receiverState=" + receiverState
				+ ", receiverPostcode=" + receiverPostcode
				+ ", receiverCountryCode=" + receiverCountryCode
				+ ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", receiverEmail=" + receiverEmail
				+ ", itemDescription=" + itemDescription + ", qty=" + qty
				+ ", weight=" + weight + ", length=" + length + ", height="
				+ height + ", width=" + width + ", itemValue=" + itemValue
				+ ", referenceIdentificationB=" + referenceIdentificationB
				+ ", terms=" + terms + ", cn35=" + cn35 + ", cn38=" + cn38
				+ ", countryCode=" + countryCode + ", addWho=" + addWho
				+ ", addDate=" + addDate + ", updateWho=" + updateWho
				+ ", updateDate=" + updateDate + ", postofficeEnName="
				+ postofficeEnName + "]";
	}
	

}
