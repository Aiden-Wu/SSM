package com.xipin.est.db.bean;

import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class InputCNBean extends Bean {
	
	/**
	 * 录入CN
	 */
	private List<PackageBean> CNList;
	
	/**
	 * 批次号
	 */
	private String dispatchNo;
	
	private String postofficeEnName;

	/**
	 * {@linkplain #cNList}
	 */
	public List<PackageBean> getCNList() {
		return CNList;
	}

	/**
	 * {@linkplain #cNList}
	 */
	public void setCNList(List<PackageBean> cNList) {
		CNList = cNList;
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
}
