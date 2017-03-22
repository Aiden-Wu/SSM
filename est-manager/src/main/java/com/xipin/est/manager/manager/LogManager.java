package com.xipin.est.manager.manager;

import java.util.List;

import com.xipin.est.db.bean.log.LogListBean;
import com.xipin.est.db.po.log.LogPo;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

public interface LogManager {
	
	/**
	 * 
	 * 方法用途: 查询日志列表<br>
	 * 实现步骤: <br>
	 * @param initBean
	 * @param initPage
	 * @return
	 */
	Result<List<LogPo>> queryLogList(LogListBean initBean, PageBean<LogPo> initPage);

}
