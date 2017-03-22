package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 日志对象ID参数</p>
 * @date 2016年5月23日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class LogIDBean extends Bean {
	
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 批次号
	 */
	private String dispatchNo;
	/**
	 * 邮袋号
	 */
	private String packageNo;

	/**
	 * {@linkplain #tableName}
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * {@linkplain #tableName}
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * {@linkplain #id}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * {@linkplain #id}
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #packageNo}
	 */
	public String getPackageNo() {
		return packageNo;
	}

	/**
	 * {@linkplain #packageNo}
	 */
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	
}
