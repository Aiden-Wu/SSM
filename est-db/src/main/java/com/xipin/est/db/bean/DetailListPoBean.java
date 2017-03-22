package com.xipin.est.db.bean;

import com.xipin.est.db.po.DetailListPo;
import com.xipin.est.utils.bean.Bean;

public class DetailListPoBean extends Bean {

	private String dispatchNo;
	private DetailListPo detailListPo;
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
	 * {@linkplain #detailListPo}
	 */
	public DetailListPo getDetailListPo() {
		return detailListPo;
	}
	/**
	 * {@linkplain #detailListPo}
	 */
	public void setDetailListPo(DetailListPo detailListPo) {
		this.detailListPo = detailListPo;
	}
	
}
