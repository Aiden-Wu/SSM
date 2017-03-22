package com.xipin.est.utils.contants;

/**
 * 
 * <p>Description: 静态变量类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface Constants {
	
	/**
	 * 服务类型——中转
	 */
	int SERVICE_TYPE_TRANSFER = 1;
	
	/**
	 * 服务类型——本地件
	 */
	int SERVICE_TYPE_DIRECT_MAIL = 2;
	
	/**
	 * 邮寄类型-平邮小包
	 */
	int mail_type_surface = 1;
	
	/**
	 * 邮寄类型-平邮小包
	 */
	int mail_type_recorded = 2;
	/**
	 * 日志类型——操作
	 */
	int LOG_TYPE_OPERATOR = 1;
	
	/**
	 * 日志类型——登录
	 */
	int LOG_TYPE_LOGIN = 2;
	
	/**
	 * 日期格式
	 */
	String DATE_FORMAT = "MM/dd/yyyy";
	
	/**
	 * 日期时间格式
	 */
	String DATETIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	
	/**
	 * Long型正则
	 */
	String longMatchesString = "^\\-?\\d+$";
	
	/**
	 * Double型正则
	 */
	String doubleMatchesString = "^\\-?\\d+(\\.\\d+)?$";
	
	
	/**
	 * 批量插入数量
	 */
	int BATCH_INSERT_NUM = 1000;
	
	/**
	 * 批量插入数量
	 */
	int BATCH_INSERT_ITEM_NUM = 2000;
	
	/**
	 * 组织机构级别0-组织机构
	 */
	Byte ORG_LEVEL_ZERO = 0;
	
	/**
	 * 组织机构级别1-客户/邮局
	 */
	Byte ORG_LEVEL_ONE = 1;
	
	/**
	 * 组织机构级别2-机构
	 */
	Byte ORG_LEVEL_TWO = 2;
	
	/**
	 * 组织机构级别3-部门
	 */
	Byte ORG_LEVEL_THREE = 3;
	
	/**
	 * 组织机构类别，客户
	 */
	Byte ORG_TYPE_CLIENT = 1;
	
	/**
	 * 组织机构类别，邮局
	 */
	Byte ORG_TYPE_POST = 0;
	
	String USER_INFO = "user_info";
	
	String SYS_HEAD = "_sys";
	
	/**
	 * 固定邮局ID——巴邮
	 */
	int POST_ID_PY = 6;
}
