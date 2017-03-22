package com.xipin.est.utils.contants;

/**
 * 
 * <p>Description: 对象类型</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class ObjectType {

	/**
	 * 清单
	 */
	public static final int DETAIIL_LIST = 1;
	/**
	 * 邮包
	 */
	public static final int PACKAGE = 3;
	/**
	 * 包裹
	 */
	public static final int ITEMS = 5;
	/**
	 * 国家二字代码
	 */
	public static final int COUNTRY = 7;
	/**
	 * 数据权限
	 */
	public static final int DATA_AUTH = 9;
	/**
	 * 航线
	 */
	public static final int TRUNKING_LINE = 11;
	/**
	 * 机构
	 */
	public static final int ORG = 13;
	/**
	 * 用户
	 */
	public static final int USER = 15;
	/**
	 * 用户数据权限
	 */
	public static final int USER_DATA_AUTH = 17;
	/**
	 * 注册邮局
	 */
	public static final int POST_CLIENT = 19;

	public static String toString(int objectType) {
		String str = "";
		switch (objectType) {
		case ObjectType.COUNTRY: {
			str = "国家二字代码";
		}
			break;
		case ObjectType.DATA_AUTH: {
			str = "数据权限";
		}
			break;
		case ObjectType.DETAIIL_LIST: {
			str = "清单";
		}
			break;
		case ObjectType.TRUNKING_LINE: {
			str = "航线";
		}
			break;
		case ObjectType.ITEMS: {
			str = "包裹";
		}
			break;
		case ObjectType.ORG: {
			str = "机构";
		}
			break;
		case ObjectType.PACKAGE: {
			str = "邮包";
		}
			break;
		case ObjectType.USER: {
			str = "用户";
		}
			break;
		case ObjectType.USER_DATA_AUTH: {
			str = "用户数据权限";
		}
			break;
		case ObjectType.POST_CLIENT: {
			str = "注册邮局";
		}
			break;
		}
		return str;
	}

}
