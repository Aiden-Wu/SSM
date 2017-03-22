package com.xipin.est.utils.msg;

import com.xipin.est.utils.comm.StringUtils;

public class MsgConfig {

	public static String getMessage(String val, String lanuage){
		String msg = StringUtils.EMPTY;
		val = StringUtils.isEmpty(val) ? StringUtils.EMPTY : val;
		if("en_US".equals(lanuage)){
			msg = MsgConfigEnUS.getMessage(val);
		} else {
			msg = MsgConfigZhCN.getMessage(val);
		}
		return msg;
	}
		
}
