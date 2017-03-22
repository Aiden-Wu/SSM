package com.xipin.est.service.busi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.log.LogListBean;
import com.xipin.est.db.log.dao.ILogDao;
import com.xipin.est.db.po.log.LogPo;
import com.xipin.est.service.busi.inf.LogService;
import com.xipin.est.utils.bean.PageBean;

/**
 * 
 * <p>Description: 日志操作接口实现类</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Service("logService")
public class LogServiceImpl implements LogService {
	
	@Autowired
	private ILogDao logDao;

	@Override
	public PageBean<LogPo> queryLogList(LogListBean logListBean, PageBean<LogPo> page) {
		logListBean.setBeginIndex(page.getStart());
		logListBean.setPageSize(page.getPageSize());
		List<LogPo> list = logDao.queryLogList(logListBean);
		page.setCount(logDao.queryLogCount(logListBean));
		page.setData(list);
		return page;
	}

}
