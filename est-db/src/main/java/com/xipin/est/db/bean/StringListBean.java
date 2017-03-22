package com.xipin.est.db.bean;

import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class StringListBean extends Bean {
	
	private List<String> list;
	
	private List<String> poenList;

	/**
	 * {@linkplain #list}
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * {@linkplain #list}
	 */
	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String> getPoenList() {
		return poenList;
	}

	public void setPoenList(List<String> poenList) {
		this.poenList = poenList;
	}
	
	
	
}
