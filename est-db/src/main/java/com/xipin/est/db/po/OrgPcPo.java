package com.xipin.est.db.po;

import java.util.List;

import com.xipin.est.model.user.Org;

public class OrgPcPo extends Org {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 客户-邮局关联信息
	 */
	private List<PostClientPo> pcList;

	public List<PostClientPo> getPcList() {
		return pcList;
	}

	public void setPcList(List<PostClientPo> pcList) {
		this.pcList = pcList;
	}
}
