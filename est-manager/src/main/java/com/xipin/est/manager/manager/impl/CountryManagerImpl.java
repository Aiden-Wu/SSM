package com.xipin.est.manager.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.CountryBean;
import com.xipin.est.db.bean.CountryListBean;
import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.po.CountryPo;
import com.xipin.est.manager.manager.CountryManager;
import com.xipin.est.service.busi.inf.CountryService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

@Service
public class CountryManagerImpl implements CountryManager {

	@Autowired
	private CountryService countryService;

	@Override
	public Result<List<CountryPo>> queryCountryList(CountryListBean countryListBean,
			PageBean<CountryPo> page) {
		Result<List<CountryPo>> result = new Result<>();
		PageBean<CountryPo> pageBean = countryService.queryCountryList(countryListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<String> addCountry(CountryBean countryBean) {
		Result<String> result = new Result<>();
		countryService.addCountry(countryBean);
		return result;
	}

	@Override
	public Result<String> deleteCountry(IDBean idBean) {
		Result<String> result = new Result<>();
		countryService.deleteCountry(idBean);
		return result;
	}

	@Override
	public Result<String> updateCountry(CountryBean countryBean) {
		Result<String> result = new Result<>();
		countryService.updateCountry(countryBean);
		return result;
	}

}
