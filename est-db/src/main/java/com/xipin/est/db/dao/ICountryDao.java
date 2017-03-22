package com.xipin.est.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.CountryBean;
import com.xipin.est.db.bean.CountryListBean;
import com.xipin.est.db.po.CountryPo;

/**
 * 
 * <p>Description: 国家代码数据库操作接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Repository
public interface ICountryDao{
	
	/**
	 * 
	 * 方法用途: 查询国家二字代码列表<br>
	 * 实现步骤: <br>
	 * @return
	 */
	List<CountryPo> queryCountryList(CountryListBean countryListBean);
	
	/**
	 * 
	 * 方法用途: 查询国家二字代码数量<br>
	 * 实现步骤: <br>
	 * @param countryListBean
	 * @return
	 */
	int queryCountrySum(CountryListBean countryListBean);
	
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
	void deleteCountry(Long id);

	/**
	 * 
	 * 方法用途: 更新国家代码<br>
	 * 实现步骤: <br>
	 * @param countryBean
	 */
	void updateCountry(CountryBean countryBean);
	
	/**
	 * 获取所有二字代码
	 * @return
	 */
	List<String> getTwoCode();
	
}
