package com.xipin.est.utils.msg;

import java.util.Properties;

import com.xipin.est.utils.comm.ConfigEnum;
import com.xipin.est.utils.comm.PropertiesContext;
import com.xipin.est.utils.comm.StringUtils;

public class MsgConfigZhCN {

	private static PropertiesContext instance = new PropertiesContext();
	
	public void setMessageZh(Properties messageZh) {
		instance.setProperties(messageZh);
	}

	public final static String getMessage(ConfigEnum key){
		Properties message = instance.getProperties();
		if(message != null){
			String msg = message.getProperty(key.getVal());
			return msg == null ? key.getVal() : msg;
		}
		return key.getVal();
	}
		
	public final static String getMessage(String key){
		Properties message = instance.getProperties();
		if(message != null){
			String msg = message.getProperty(key);
			if(msg == null){
				if(!StringUtils.isEmpty(key) && key.contains(":")){
					return message.getProperty(key.split(":")[1]);
				}
			}
			return msg;
		}
		return key;
	}
}
