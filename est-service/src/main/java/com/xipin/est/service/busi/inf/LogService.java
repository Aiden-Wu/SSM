package com.xipin.est.service.busi.inf;

import com.xipin.est.db.bean.log.LogListBean;
import com.xipin.est.db.po.log.LogPo;
import com.xipin.est.utils.bean.PageBean;

/**
 * 
 * <p>Description: 日志操作接口类</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface LogService {
	
	/**
	 * 
	 * 方法用途: 查询日志列表<br>
	 * 实现步骤: <br>
	 * @param logBean
	 * @param page
	 * @return
	 */
	PageBean<LogPo> queryLogList(LogListBean logListBean, PageBean<LogPo> page);
	
}
