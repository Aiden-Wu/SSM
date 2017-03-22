package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

public class PackageUpdateBean extends Bean{
	
	//批次号
	private String dispatchNo;
	//邮袋编号
	private String packageNo;
	//cn35
	private String cn35;
	//cn38
	private String cn38;
	//国家代码
	private String countryCode;
	//包裹类型
	private String dispatchType;
	//跟踪编号
	private String referenceId;
	
	private String postofficeEnName;
	
	public String getDispatchNo() {
		return dispatchNo;
	}
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}
	public String getPackageNo() {
		return packageNo;
	}
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	public String getCn35() {
		return cn35;
	}
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDispatchType() {
		return dispatchType;
	}
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getPostofficeEnName() {
		return postofficeEnName;
	}
	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}
	

}
