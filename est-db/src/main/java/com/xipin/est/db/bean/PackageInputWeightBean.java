package com.xipin.est.db.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.xipin.est.utils.bean.Bean;

public class PackageInputWeightBean extends Bean {
	
	/**
	 * 实际总邮袋数
	 */
	private BigDecimal actualPackageNum;
	
	/**
	 * 实际总重量
	 */
	private BigDecimal actualPackageWeight;
	
	/**
	 * 批次号
	 */
	private String dispatchNo;
	
	/**
	 * 误差值
	 */
	private BigDecimal errorValue;
	
	/**
	 * 是否录入完毕
	 */
	private Integer isFinish = 1;
	
	/**
	 * 邮袋编号
	 */
	private String packageNo;
	
	/**
	 * 邮局英文名称
	 */
	private String postofficeEnName;
	
	/**
	 * 录入重量状态
	 */
	private Integer status;
	
	/**
	 * 录入重量时间
	 */
	private Date statusTime;
	
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * {@linkplain #actualPackageNum}
	 */
	public BigDecimal getActualPackageNum() {
		return actualPackageNum;
	}

	/**
	 * {@linkplain #actualPackageWeight}
	 */
	public BigDecimal getActualPackageWeight() {
		return actualPackageWeight;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #errorValue}
	 */
	public BigDecimal getErrorValue() {
		return errorValue;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public Integer getIsFinish() {
		return isFinish;
	}

	/**
	 * {@linkplain #packageNo}
	 */
	public String getPackageNo() {
		return packageNo;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	/**
	 * {@linkplain #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * {@linkplain #statusTime}
	 */
	public Date getStatusTime() {
		return statusTime;
	}

	/**
	 * {@linkplain #actualPackageNum}
	 */
	public void setActualPackageNum(BigDecimal actualPackageNum) {
		this.actualPackageNum = actualPackageNum;
	}

	/**
	 * {@linkplain #actualPackageWeight}
	 */
	public void setActualPackageWeight(BigDecimal actualPackageWeight) {
		this.actualPackageWeight = actualPackageWeight;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #errorValue}
	 */
	public void setErrorValue(BigDecimal errorValue) {
		this.errorValue = errorValue;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}

	/**
	 * {@linkplain #packageNo}
	 */
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	/**
	 * {@linkplain #status}
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * {@linkplain #statusTime}
	 */
	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
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
	
}
