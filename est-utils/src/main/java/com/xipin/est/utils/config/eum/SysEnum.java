package com.xipin.est.utils.config.eum;

import com.xipin.est.utils.comm.ConfigEnum;

public enum SysEnum implements ConfigEnum{
	
	;
	
	private String val;
	
	private SysEnum(String val) {
		this.val = val;
	}
	
	@Override
	public String getVal() {
		return val;
	}

}
