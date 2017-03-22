package com.xipin.est.master.param.country;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.CountryBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: 更新国家代码参数验证类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class CountryUpdateParam extends Param implements BeanParam<CountryBean> {

	/**
	 * 国家ID
	 */
	@NotNull(message=ParamConstants.ID_CANNOT_NULL)
	private Long id;
	/**
	 * 国家代码
	 */
	@NotEmpty(message=ParamConstants.CODE_CANNOT_EMPTY)
	private String code;
	/**
	 * 中文名称
	 */
	@NotEmpty(message=ParamConstants.ZHNAME_CANNOT_EMPTY)
	private String zhName;
	/**
	 * 英文名称
	 */
	@NotEmpty(message=ParamConstants.ENNAME_CANNOT_EMPTY)
	private String enName;
	
	@Override
	public CountryBean initBean() {
		CountryBean countryBean = new CountryBean();
		BeanUtils.copyProperties(this, countryBean);
		return countryBean;
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
