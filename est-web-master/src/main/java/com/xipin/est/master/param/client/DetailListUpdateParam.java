package com.xipin.est.master.param.client;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class DetailListUpdateParam extends Param implements BeanParam<DetailListUpdateBean> {
	
	@NotNull(message=ParamConstants.DISPATCHNO_CANNOT_NULL)
	private String dispatchNo;
	private String airwayBillNo;
	private String truckingNoId;
	private String truckingNo;
	private String postofficeEnName;

	@Override
	public DetailListUpdateBean initBean() {
		DetailListUpdateBean bean = new DetailListUpdateBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
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
	 * {@linkplain #truckingNoId}
	 */
	public String getTruckingNoId() {
		return truckingNoId;
	}

	/**
	 * {@linkplain #truckingNoId}
	 */
	public void setTruckingNoId(String truckingNoId) {
		this.truckingNoId = truckingNoId;
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

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}
	
	

}
