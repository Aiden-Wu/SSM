package com.xipin.est.db.bean;

import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class DetailListSubmitBean extends Bean{
	
	private List<String> list;
	
	private List<String> poenList;

	public List<String> getList() {
		return list;
	}

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
