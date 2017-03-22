package com.xipin.est.master.param.country;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.CountryListBean;
import com.xipin.est.db.po.CountryPo;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

/**
 * 
 * <p>Description: 国家二字代码参数验证类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class CountryListParam extends PageParam<CountryPo> implements BeanParam<CountryListBean>{
	
	/**
	 * 关键字
	 */
	private String key;

	@Override
	public CountryListBean initBean() {
		CountryListBean countryListBean = new CountryListBean();
		BeanUtils.copyProperties(this, countryListBean);
		return countryListBean;
	}

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

}
