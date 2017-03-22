package com.xipin.est.service.busi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.CountryBean;
import com.xipin.est.db.bean.CountryListBean;
import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.dao.ICountryDao;
import com.xipin.est.db.po.CountryPo;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.apsect.annotation.InsertLog;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.service.base.inf.BaseService;
import com.xipin.est.service.busi.inf.CountryService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.ObjectType;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.eum.MsgEnum;

@Service("countryService")
public class CountryServiceImpl extends BaseService<CountryServiceImpl> implements CountryService{
	
	@Autowired
	private ICountryDao countryDao;

	@Override
	public PageBean<CountryPo> queryCountryList(CountryListBean countryListBean, PageBean<CountryPo> page) {
		countryListBean.setBeginIndex(page.getStart());
		countryListBean.setPageSize(page.getPageSize());
		List<CountryPo> list = countryDao.queryCountryList(countryListBean);
		page.setCount(countryDao.queryCountrySum(countryListBean));
		page.setData(list);
		return page;
	}

	@Override
	@InsertLog(description="添加国家", tableName="country", objectType = ObjectType.COUNTRY)
	public void addCountry(CountryBean countryBean) {
		CountryListBean countryListBean = new CountryListBean();
		countryListBean.setKey(countryBean.getCode());
		if(countryDao.queryCountrySum(countryListBean)>0){
			throw new BusinessException(MsgEnum.s_countrycode_repeat.getVal());
		}
		countryDao.addCountry(countryBean);
	}

	@Override
	@DeleteLog(description="删除国家", tableName="country", objectType = ObjectType.COUNTRY)
	public void deleteCountry(IDBean idBean) {
		countryDao.deleteCountry(idBean.getId());
	}

	@Override
	@UpdateLog(description="修改国家", tableName="country", objectType = ObjectType.COUNTRY)
	public void updateCountry(CountryBean countryBean) {
		countryDao.updateCountry(countryBean);
	}

}
