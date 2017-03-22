package com.xipin.est.db.po;

import java.util.List;

import com.xipin.est.model.DetailList;

public class DetailListPo extends DetailList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3584264536450437155L;

	private List<PackagePo> packagePoList = null;

	public List<PackagePo> getPackagePoList() {
		return packagePoList;
	}

	public void setPackagePoList(List<PackagePo> packagePoList) {
		this.packagePoList = packagePoList;
	}

}
