package com.xipin.est.db.bean;

import java.util.List;

import com.xipin.est.utils.bean.Bean;

public class FinishDetailListsBean extends Bean {
	
	/**
	 * 结单参数列表
	 */
	private List<UpdateDetailListBean> finishDetailLists;
	
	/**
	 * {@linkplain #finishDetailLists}
	 */
	public List<UpdateDetailListBean> getFinishDetailLists() {
		return finishDetailLists;
	}

	/**
	 * {@linkplain #finishDetailLists}
	 */
	public void setFinishDetailLists(List<UpdateDetailListBean> finishDetailLists) {
		this.finishDetailLists = finishDetailLists;
	}

}
