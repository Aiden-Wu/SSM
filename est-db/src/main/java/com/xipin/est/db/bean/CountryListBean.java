package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 国家代码列表参数类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class CountryListBean extends Bean {

	/**
	 * 关键字
	 */
	private String key;
	
	/**
	 * 分页开始
	 */
	private Integer beginIndex;
	
	/**
	 * 分页大小
	 */
	private Integer pageSize;

	/**
	 * {@linkplain #key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * {@linkplain #key}
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * {@linkplain #beginIndex}
	 */
	public Integer getBeginIndex() {
		return beginIndex;
	}

	/**
	 * {@linkplain #beginIndex}
	 */
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * {@linkplain #pageSize}
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * {@linkplain #pageSize}
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
