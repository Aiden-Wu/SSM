package com.xipin.est.manager.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.log.LogListBean;
import com.xipin.est.db.po.log.LogPo;
import com.xipin.est.manager.manager.LogManager;
import com.xipin.est.service.busi.inf.LogService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

@Service
public class LogManagerImpl implements LogManager {

	@Autowired
	private LogService logService;

	@Override
	public Result<List<LogPo>> queryLogList(LogListBean initBean, PageBean<LogPo> initPage) {
		Result<List<LogPo>> result = new Result<>();
		PageBean<LogPo> pageBean = logService.queryLogList(initBean, initPage);
		result.initRslt(pageBean);
		return result;
	}

}
