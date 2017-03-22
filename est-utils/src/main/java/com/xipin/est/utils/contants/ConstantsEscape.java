package com.xipin.est.utils.contants;

/**
 * 
 * <p>Description: 静态变量转义类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class ConstantsEscape {

	/**
	 * 
	 * 方法用途: 服务类型转义<br>
	 * 实现步骤: <br>
	 * @param serviceType
	 * @return
	 */
	public static String serviceTypeEscap(Integer serviceType) {
		String str = "";
		switch (serviceType) {
		case Constants.SERVICE_TYPE_DIRECT_MAIL: {
			str = "DE";
		}
			break;
		case Constants.SERVICE_TYPE_TRANSFER: {
			str = "TS";
		}
			break;
		}
		return str;
	}

	public static String logTypeEscap(Integer type) {
		String str = "";
		switch (type) {
		case Constants.LOG_TYPE_LOGIN: {
			str = "登录";
		}
			break;
		case Constants.LOG_TYPE_OPERATOR: {
			str = "操作";
		}
			break;
		}
		return str;
	}

}
