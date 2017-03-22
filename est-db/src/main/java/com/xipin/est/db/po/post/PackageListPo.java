package com.xipin.est.db.po.post;

import java.math.BigDecimal;

/**
 * 
 * <p>Description: 邮袋列表展现类</p>
 * @date 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class PackageListPo {

	/**
	 * 邮袋编号
	 */
	private String packageNo;
	/**
	 * CN35
	 */
	private String cn35;
	/**
	 * CN38
	 */
	private String cn38;
	/**
	 * 包裹类型
	 */
	private String dispatchType;
	/**
	 * 预报总包裹数
	 */
	private BigDecimal estimatePackageNum;
	/**
	 * 实际包裹数
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
	 * 误差值
	 */
	private BigDecimal errorValue;
	/**
	 * 数量误差值
	 */
	private BigDecimal numErrorValue;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 跟踪号
	 */
	private String referenceId;
	/**
	 * 国家编号
	 */
	private String countryCode;
	/**
	 * 邮局英文名称
	 */
	private String postofficeEnName;
	
	private String receiverCountryCode;

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
	 * {@linkplain #cn38}
	 */
	public String getCn38() {
		return cn38;
	}

	/**
	 * {@linkplain #cn38}
	 */
	public void setCn38(String cn38) {
		this.cn38 = cn38;
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
	 * {@linkplain #numErrorValue}
	 */
	public BigDecimal getNumErrorValue() {
		return numErrorValue;
	}

	/**
	 * {@linkplain #numErrorValue}
	 */
	public void setNumErrorValue(BigDecimal numErrorValue) {
		this.numErrorValue = numErrorValue;
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

	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	public String getReceiverCountryCode() {
		return receiverCountryCode;
	}

	public void setReceiverCountryCode(String receiverCountryCode) {
		this.receiverCountryCode = receiverCountryCode;
		this.countryCode = receiverCountryCode;
	}
	
	

}
