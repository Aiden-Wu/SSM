package com.xipin.est.utils.config;

import java.util.Properties;

import com.xipin.est.utils.comm.ConfigEnum;
import com.xipin.est.utils.comm.PropertiesContext;

public class SysConfig {
	
	private static PropertiesContext instance = new PropertiesContext();
	
	public void setSysConfig(Properties sysconfig) {
		instance.setProperties(sysconfig);
	}

	public final static String getConfig(ConfigEnum key){
		Properties sysconfig = instance.getProperties();
		if(sysconfig != null){
			String msg = sysconfig.getProperty(key.getVal());
			return msg == null ? key.getVal() : msg;
		}
		return key.getVal();
	}
}
