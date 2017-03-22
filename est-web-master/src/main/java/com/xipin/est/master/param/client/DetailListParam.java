package com.xipin.est.master.param.client;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.po.client.DetailDataListPo;
import com.xipin.est.ucontroller.date.DateFomatEnum;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

public class DetailListParam extends PageParam<DetailDataListPo> implements BeanParam<DetailListBean>{
	
	//预报日期开始时间
	private Date beginAddTime;
	
	//预报日期结束时间
	private Date endAddTime;
	
	//开始提交时间
	private Date beginSubmitTime;
	
	//结束提交时间
	private Date endSubmitTime;
	
	//批次号
	private String dispatchNo;
	
	//邮局
	private String postoffice;
	
	//目的国
	private String countryCode;
	
	//服务类型
	private String serviceType;
	
	//邮寄类型
	private String dispatchType;
	
	public Date getBeginAddTime() {
		return beginAddTime;
	}


	public void setBeginAddTime(String beginAddTime) {
		this.beginAddTime = DateFomatEnum.DATETIME.toDate(beginAddTime, " 00:00:00","开始日期格式错误");
	}


	public Date getEndAddTime() {
		return endAddTime;
	}


	public void setEndAddTime(String endAddTime) {
		this.endAddTime = DateFomatEnum.DATETIME.toDate(endAddTime, " 23:59:59","结束日期格式错误");
	}

	public Date getBeginSubmitTime() {
		return beginSubmitTime;
	}


	public void setBeginSubmitTime(String beginSubmitTime) {
		this.beginSubmitTime = DateFomatEnum.DATETIME.toDate(beginSubmitTime, " 00:00:00","开始提交日期格式错误");
	}

	public Date getEndSubmitTime() {
		return endSubmitTime;
	}


	public void setEndSubmitTime(String endSubmitTime) {
		this.endSubmitTime = DateFomatEnum.DATETIME.toDate(endSubmitTime, " 23:59:59","结束提交日期格式错误");
	}


	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		dispatchNo = StringUtils.dealBlank(dispatchNo);
		this.dispatchNo = dispatchNo;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}
	
	@Override
	public DetailListBean initBean() {
		DetailListBean detailListBean = new DetailListBean();
		//		detailListBean.set
		BeanUtils.copyProperties(this, detailListBean);
		return detailListBean;
	}

	

}
