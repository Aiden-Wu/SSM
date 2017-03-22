package com.xipin.est.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * <p>
 * Description: 邮包实体类
 * </p>
 * 
 * @Timestamp 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 *          <p>
 *          Company:XiPinTech
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2015
 *          </p>
 */
public class Package implements Model {

	private static final long serialVersionUID = 254900422159358014L;
	/**
	 * 邮袋编号
	 */
	private String packageNo;
	/**
	 * 邮寄类型
	 */
	private String dispatchType;
	/**
	 * 预报总包裹数
	 */
	private BigDecimal estimatePackageNum;
	/**
	 * 实际总包裹数
	 */
	private BigDecimal actualPackageNum;
	/**
	 * 邮袋预报总重量
	 */
	private BigDecimal estimatePackageWeight;
	/**
	 * 邮袋实际总重量
	 */
	private BigDecimal actualPackageWeight;
	/**
	 * 录入重量时间
	 */
	private Timestamp inputDate;
	/**
	 * 误差值
	 */
	private BigDecimal errorValue;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 批次号
	 */
	private String dispatchNo;
	/**
	 * 目的国代码
	 */
	private String countryCode;
	/**
	 * 添加人
	 */
	private String addWho;
	/**
	 * 添加时间
	 */
	private Timestamp addDate;
	/**
	 * 修改人
	 */
	private String updateWho;
	/**
	 * 修改时间
	 */
	private Timestamp updateDate;
	/**
	 * 服务类型
	 */
	private String serviceType;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 客户编号
	 */
	private String customerNo;

	private String cn35;
	
	private String cn38;

	private String postoffice;
	
	private String postofficeEnName;
	
	private String sealNo;

	@Override
	public Long getId() {
		return -1l;
	}

	/**
	 * {@linkplain #packageNo}
	 */
	public String getPackageNo() {
		return packageNo;
	}

	/**
	 * {@linkplain #packageNo}
	 */
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
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
	 * {@linkplain #estimatePackageNum}
	 */
	public BigDecimal getEstimatePackageNum() {
		return estimatePackageNum;
	}

	/**
	 * {@linkplain #estimatePackageNum}
	 */
	public void setEstimatePackageNum(BigDecimal estimatePackageNum) {
		this.estimatePackageNum = estimatePackageNum;
	}

	/**
	 * {@linkplain #actualPackageNum}
	 */
	public BigDecimal getActualPackageNum() {
		return actualPackageNum;
	}

	/**
	 * {@linkplain #actualPackageNum}
	 */
	public void setActualPackageNum(BigDecimal actualPackageNum) {
		this.actualPackageNum = actualPackageNum;
	}

	/**
	 * {@linkplain #estimatePackageWeight}
	 */
	public BigDecimal getEstimatePackageWeight() {
		return estimatePackageWeight;
	}

	/**
	 * {@linkplain #estimatePackageWeight}
	 */
	public void setEstimatePackageWeight(BigDecimal estimatePackageWeight) {
		this.estimatePackageWeight = estimatePackageWeight;
	}

	/**
	 * {@linkplain #actualPackageWeight}
	 */
	public BigDecimal getActualPackageWeight() {
		return actualPackageWeight;
	}

	/**
	 * {@linkplain #actualPackageWeight}
	 */
	public void setActualPackageWeight(BigDecimal actualPackageWeight) {
		this.actualPackageWeight = actualPackageWeight;
	}

	/**
	 * {@linkplain #inputDate}
	 */
	public Timestamp getInputDate() {
		return inputDate;
	}

	/**
	 * {@linkplain #inputDate}
	 */
	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * {@linkplain #errorValue}
	 */
	public BigDecimal getErrorValue() {
		return errorValue;
	}

	/**
	 * {@linkplain #errorValue}
	 */
	public void setErrorValue(BigDecimal errorValue) {
		this.errorValue = errorValue;
	}

	/**
	 * {@linkplain #remark}
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * {@linkplain #remark}
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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

	public String getCn35() {
		return cn35;
	}

	public void setCn35(String cn35) {
		this.cn35 = cn35;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
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
		return "Package [packageNo=" + packageNo + ", dispatchType="
				+ dispatchType + ", estimatePackageNum=" + estimatePackageNum
				+ ", actualPackageNum=" + actualPackageNum
				+ ", estimatePackageWeight=" + estimatePackageWeight
				+ ", actualPackageWeight=" + actualPackageWeight
				+ ", inputDate=" + inputDate + ", errorValue=" + errorValue
				+ ", remark=" + remark + ", dispatchNo=" + dispatchNo
				+ ", countryCode=" + countryCode + ", addWho=" + addWho
				+ ", addDate=" + addDate + ", updateWho=" + updateWho
				+ ", updateDate=" + updateDate + ", serviceType=" + serviceType
				+ ", customerName=" + customerName + ", customerNo="
				+ customerNo + ", cn35=" + cn35 + ", cn38=" + cn38
				+ ", postoffice=" + postoffice + ", postofficeEnName="
				+ postofficeEnName + "]";
	}


}
