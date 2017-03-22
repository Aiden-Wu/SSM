package com.xipin.est.utils.contants;

/**
 * 
 * <p>Description: 操作类型</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class OperatorType {

	/**
	 * 新增
	 */
	public static final int INSERT = 1;
	/**
	 * 删除
	 */
	public static final int DELETE = 3;
	/**
	 * 修改
	 */
	public static final int UPDATE = 5;
	/**
	 * 登录
	 */
	public static final int LOGIN = 7;

	public static String toString(int operatorType) {
		String str = "";
		switch (operatorType) {
		case OperatorType.INSERT: {
			str = "新增";
		}
			break;
		case OperatorType.DELETE: {
			str = "删除";
		}
			break;
		case OperatorType.UPDATE: {
			str = "修改";
		}
			break;
		case OperatorType.LOGIN: {
			str = "登录";
		}
			break;
		}
		return str;
	}

}
