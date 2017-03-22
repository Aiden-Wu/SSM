package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

public class UserAuthCheckBean extends Bean {
	
	private Long userId;
	private Long dataAuthId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getDataAuthId() {
		return dataAuthId;
	}
	public void setDataAuthId(Long dataAuthId) {
		this.dataAuthId = dataAuthId;
	}
	

}
