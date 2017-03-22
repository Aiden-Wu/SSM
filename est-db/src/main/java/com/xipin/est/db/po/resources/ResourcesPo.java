package com.xipin.est.db.po.resources;

import com.xipin.est.model.Resources;

public class ResourcesPo extends Resources{
	
	/**
	 * 用户是否拥有权限
	 */
	private int permission;
	

	public int getPermission() {
		return permission;
	}



	public void setPermission(int permission) {
		this.permission = permission;
	}



	private static final long serialVersionUID = 5972466567316522797L;

}
