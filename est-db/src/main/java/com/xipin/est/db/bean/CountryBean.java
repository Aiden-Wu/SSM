package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 国家代码参数类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class CountryBean extends Bean {

	/**
	 * 国家ID
	 */
	private Long id;
	/**
	 * 国家代码
	 */
	private String code;
	/**
	 * 中文名称
	 */
	private String zhName;
	/**
	 * 英文名称
	 */
	private String enName;

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
	 * {@linkplain #code}
	 */
	public String getCode() {
		return code;
	}

	/**
	 * {@linkplain #code}
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * {@linkplain #zhName}
	 */
	public String getZhName() {
		return zhName;
	}

	/**
	 * {@linkplain #zhName}
	 */
	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	/**
	 * {@linkplain #enName}
	 */
	public String getEnName() {
		return enName;
	}

	/**
	 * {@linkplain #enName}
	 */
	public void setEnName(String enName) {
		this.enName = enName;
	}

}
