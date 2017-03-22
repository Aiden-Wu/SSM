package com.xipin.est.model;

/**
 * 
 * <p>Description: 国家二字代码实体类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class Country implements Model {

	private static final long serialVersionUID = -707665187678503370L;

	/**
	 * 国家ID
	 */
	private Long id;
	/**
	 * 国家代码
	 */
	private String code;
	/**
	 * 国家名称（中文）
	 */
	private String zhName;
	/**
	 * 国家名称（英文）
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
