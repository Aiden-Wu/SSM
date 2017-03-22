package com.xipin.est.master.param.client;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class PackageUpdateParam extends Param implements BeanParam<PackageUpdateBean>{

	//批次号
//	@NotEmpty
	private String dispatchNo;
	//邮袋编号
	@NotEmpty(message=ParamConstants.PACKAGENO_CANNOT_EMPTY)
	private String packageNo;
	//cn35
	@NotEmpty(message=ParamConstants.CN35_CANNOT_EMPTY)
	@Length(max=35, min=1,message=ParamConstants.CN35_LENGTH_LIMIT)
	private String cn35;
	//国家代码
	private String countryCode;
	//包裹类型
	private String dispatchType;
	//跟踪编号
	private String referenceId;
	
	private String postofficeEnName;
	
	@Override
	public PackageUpdateBean initBean() {
		PackageUpdateBean packageUpdateBean = new PackageUpdateBean();
		BeanUtils.copyProperties(this, packageUpdateBean);
		return packageUpdateBean;
	}
	

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
