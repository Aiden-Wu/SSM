package com.xipin.est.db.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.xipin.est.utils.bean.Bean;

public class DetailListInputWeightBean extends Bean {
	
	/**
	 * 实际总邮袋数
	 */
	private BigDecimal actualBagNum;
	
	/**
	 * 实际总重量
	 */
	private BigDecimal actualTotalWeight;
	
	/**
	 * 批次号
	 */
	private String dispatchNo;
	
	/**
	 * 是否录入完毕
	 */
	private Integer isFinish;
	
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
	 * 是否不完整
	 */
	private int isBroken = 0;

	/**
	 * {@linkplain #actualBagNum}
	 */
	public BigDecimal getActualBagNum() {
		return actualBagNum;
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public BigDecimal getActualTotalWeight() {
		return actualTotalWeight;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public Integer getIsFinish() {
		return isFinish;
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
	 * {@linkplain #actualBagNum}
	 */
	public void setActualBagNum(BigDecimal actualBagNum) {
		this.actualBagNum = actualBagNum;
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public void setActualTotalWeight(BigDecimal actualTotalWeight) {
		this.actualTotalWeight = actualTotalWeight;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
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
	 * {@linkplain #isBroken}
	 */
	public int getIsBroken() {
		return isBroken;
	}

	/**
	 * {@linkplain #isBroken}
	 */
	public void setIsBroken(int isBroken) {
		this.isBroken = isBroken;
	}
	
}
