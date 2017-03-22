package com.xipin.est.db.bean;

import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class InputWeightBean extends Bean {

	/**
	 * 清单
	 */
	private DetailListInputWeightBean detailListInputWeightBean;
	
	/**
	 * 邮包列表
	 */
	private List<PackageInputWeightBean> packageList;
	
	/**
	 * {@linkplain #detailListInputWeightBean}
	 */
	public DetailListInputWeightBean getDetailListInputWeightBean() {
		return detailListInputWeightBean;
	}

	/**
	 * {@linkplain #packageList}
	 */
	public List<PackageInputWeightBean> getPackageList() {
		return packageList;
	}

	/**
	 * {@linkplain #detailListInputWeightBean}
	 */
	public void setDetailListInputWeightBean(DetailListInputWeightBean detailListInputWeightBean) {
		this.detailListInputWeightBean = detailListInputWeightBean;
	}

	/**
	 * {@linkplain #packageList}
	 */
	public void setPackageList(List<PackageInputWeightBean> packageList) {
		this.packageList = packageList;
	}

}
