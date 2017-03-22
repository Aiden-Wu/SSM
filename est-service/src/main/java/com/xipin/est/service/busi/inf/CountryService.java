package com.xipin.est.service.busi.inf;

import com.xipin.est.db.bean.CountryBean;
import com.xipin.est.db.bean.CountryListBean;
import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.po.CountryPo;
import com.xipin.est.utils.bean.PageBean;

/**
 * 
 * <p>Description: 国家代码数据库服务接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface CountryService {
	
	/**
	 * 
	 * 方法用途: 获取国家二字代码列表<br>
	 * 实现步骤: <br>
	 * @param countryListBean
	 * @return
	 */
	PageBean<CountryPo> queryCountryList(CountryListBean countryListBean, PageBean<CountryPo> page);

	/**
	 * 
	 * 方法用途: 新增国家代码<br>
	 * 实现步骤: <br>
	 * @param countryBean
	 */
	void addCountry(CountryBean countryBean);
	
	/**
	 * 
	 * 方法用途: 删除国家代码<br>
	 * 实现步骤: <br>
	 * @param id
	 */
	void deleteCountry(IDBean idBean);

	/**
	 * 
	 * 方法用途: 更新国家代码<br>
	 * 实现步骤: <br>
	 * @param countryBean
	 */
	void updateCountry(CountryBean countryBean);
	
	
}
