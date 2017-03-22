package com.xipin.est.db.po;

import java.util.List;

import com.xipin.est.model.Package;

public class PackagePo extends Package {

	private static final long serialVersionUID = 2450256652542540459L;
	
	private List<ItemsPo> itemsPoList = null;

	public List<ItemsPo> getItemsPoList() {
		return itemsPoList;
	}

	public void setItemsPoList(List<ItemsPo> itemsPoList) {
		this.itemsPoList = itemsPoList;
	}

}
