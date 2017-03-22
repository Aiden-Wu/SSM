package com.xipin.est.db.bean;

import java.math.BigDecimal;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 更新包裹参数</p>
 * @date 2016年5月10日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class PackageBean extends Bean {

	/**
	 * 批次号
	 */
	private String dispatchNo;
	/**
	 * 邮袋编号
	 */
	private String packageNo;
	/**
	 * 实际总包裹数
	 */
	private BigDecimal actualPackageNum;
	/**
	 * 邮袋实际总重量
	 */
	private BigDecimal actualPackageWeight;
	/**
	 * 误差值
	 */
	private BigDecimal errorValue;

	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 邮局英文名称
	 */
	private String postofficeEnName;
	
	/**
	 * CN38
	 */
	private String cn38;
	
	/**
	 * CN35
	 */
	private String cn35;
	
	/**
	 * 是否录入完毕
	 */
	private Integer isFinish;
	
	/**
	 * 国家代码
	 */
	private String countryCode;

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
	 * {@linkplain #isFinish}
	 */
	public Integer getIsFinish() {
		return isFinish;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
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

}
