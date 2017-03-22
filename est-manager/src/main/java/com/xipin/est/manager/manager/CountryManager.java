package com.xipin.est.manager.manager;

import java.util.List;

import com.xipin.est.db.bean.CountryBean;
import com.xipin.est.db.bean.CountryListBean;
import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.po.CountryPo;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

public interface CountryManager {
	
	/**
	 * 
	 * 方法用途: 查询国家二字代码<br>
	 * 实现步骤: <br>
	 * @param initBean
	 * @param initPage
	 * @return
	 */
	Result<List<CountryPo>> queryCountryList(CountryListBean initBean, PageBean<CountryPo> initPage);

	/**
	 * 
	 * 方法用途: 新增国家代码<br>
	 * 实现步骤: <br>
	 * @param countryBean
	 */
	Result<String> addCountry(CountryBean countryBean);
	
	/**
	 * 
	 * 方法用途: 删除国家代码<br>
	 * 实现步骤: <br>
	 * @param id
	 */
	Result<String> deleteCountry(IDBean idBean);

	/**
	 * 
	 * 方法用途: 更新国家代码<br>
	 * 实现步骤: <br>
	 * @param countryBean
	 */
	Result<String> updateCountry(CountryBean countryBean);

}
