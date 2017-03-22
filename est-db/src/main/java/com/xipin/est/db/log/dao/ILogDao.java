package com.xipin.est.db.log.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.log.LogBean;
import com.xipin.est.db.bean.log.LogListBean;
import com.xipin.est.db.po.log.LogPo;

/**
 * 
 * <p>Description: 日志数据库操作接口类</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Repository
public interface ILogDao {
	
	/**
	 * 
	 * 方法用途: 添加日志<br>
	 * 实现步骤: <br>
	 */
	void insert(LogBean logBean);
	
	/**
	 * 
	 * 方法用途: 查询日志数量<br>
	 * 实现步骤: <br>
	 * @param logListBean
	 * @return
	 */
	int queryLogCount(LogListBean logListBean);
	
	/**
	 * 
	 * 方法用途: 查询日志列表<br>
	 * 实现步骤: <br>
	 * @param logListBean
	 * @return
	 */
	List<LogPo> queryLogList(LogListBean logListBean);
	
}
