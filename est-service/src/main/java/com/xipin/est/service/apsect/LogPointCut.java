package com.xipin.est.service.apsect;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.xipin.est.db.bean.LogIDBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.log.LogBean;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.dao.IObjectDao;
import com.xipin.est.db.log.dao.ILogDao;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.apsect.annotation.InsertLog;
import com.xipin.est.service.apsect.annotation.LoginLog;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.utils.bean.Bean;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ObjectType;
import com.xipin.est.utils.contants.OperatorType;

/**
 * 
 * <p>Description: 日志切点操作类</p>
 * @date 2016年5月18日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Aspect
@Component
public class LogPointCut {

	@Autowired
	private ILogDao logDao;

	@Autowired
	private IObjectDao objectDao;

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ICommStringCache iCommStringCache;

	@Pointcut(value = "@annotation(insertLog)", argNames = "insertLog")
	public void insertLog(InsertLog insertLog) {

	}

	@Pointcut(value = "@annotation(updateLog)", argNames = "updateLog")
	public void updateLog(UpdateLog updateLog) {

	}

	@Pointcut(value = "@annotation(deleteLog)", argNames = "deleteLog")
	public void deleteLog(DeleteLog deleteLog) {

	}

	@Pointcut(value = "@annotation(loginLog)", argNames = "loginLog")
	public void loginLog(LoginLog loginLog) {

	}

	/**
	 * 
	 * 方法用途: 添加<br>
	 * 实现步骤: <br>
	 * @param pjp
	 * @throws Exception
	 */
	@AfterReturning("insertLog(insertLog)")
	public void insert(JoinPoint jp, InsertLog insertLog) {
		try {
			Object[] args = jp.getArgs();
			Object afterObject = args[0];

			LogBean logBean = initLogBean(afterObject);
			logBean.setOperatorType(OperatorType.INSERT);
			logBean.setDescription(insertLog.description());
			logBean.setObjectType(insertLog.objectType());

			logBean.setObjectId(getObejctId(logBean.getObjectType(), afterObject));
			logBean.setAfter(getObjectJsonString(logBean, insertLog.tableName()));

			logDao.insert(logBean);
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 
	 * 方法用途: 更新<br>
	 * 实现步骤: <br>
	 * @param pjp
	 * @param updateLog
	 * @throws Throwable
	 */
	@Around("updateLog(updateLog)")
	public void update(ProceedingJoinPoint pjp, UpdateLog updateLog) throws Throwable {
		try {
			Object[] args = pjp.getArgs();
			Object afterObject = args[0];

			LogBean logBean = initLogBean(afterObject);
			logBean.setOperatorType(OperatorType.UPDATE);
			logBean.setDescription(updateLog.description());
			logBean.setObjectType(updateLog.objectType());

			logBean.setObjectId(getObejctId(logBean.getObjectType(), afterObject));
			logBean.setBefore(getObjectJsonString(logBean, updateLog.tableName()));
			pjp.proceed();
			logBean.setAfter(getObjectJsonString(logBean, updateLog.tableName()));

			logDao.insert(logBean);
		} catch (Exception e) {
			log.error(e);
			pjp.proceed();
		}
	}

	/**
	 * 
	 * 方法用途: 删除<br>
	 * 实现步骤: <br>
	 * @param pjp
	 * @throws Exception
	 */
	@Before("deleteLog(deleteLog)")
	public void delete(JoinPoint jp, DeleteLog deleteLog) {
		try {
			Object[] args = jp.getArgs();
			Object afterObject = args[0];

			LogBean logBean = initLogBean(afterObject);
			logBean.setOperatorType(OperatorType.DELETE);
			logBean.setDescription(deleteLog.description());
			logBean.setObjectType(deleteLog.objectType());

			logBean.setObjectId(getObejctId(logBean.getObjectType(), afterObject));
			logBean.setBefore(getObjectJsonString(logBean, deleteLog.tableName()));

			logDao.insert(logBean);
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 
	 * 方法用途: 登录成功日志<br>
	 * 实现步骤: <br>
	 * @throws Exception
	 */
	@AfterReturning(pointcut = "loginLog(loginLog)", returning = "userPo")
	public void loginSuccess(JoinPoint jp, LoginLog loginLog, UserPo userPo) {
		try {
			Object[] args = jp.getArgs();
			Object afterObject = args[0];
			if (afterObject instanceof UserBean) {
				LogBean logBean = initLogBean(afterObject);
				logBean.setOperatorType(OperatorType.LOGIN);
				logBean.setOperatorId(userPo.getId());
				logBean.setOperatorName(userPo.getName());
				logBean.setType(Constants.LOG_TYPE_LOGIN);
				logBean.setObjectType(ObjectType.USER);
				logBean.setDescription("登录成功");

				logDao.insert(logBean);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 
	 * 方法用途: 登录失败日志<br>
	 * 实现步骤: <br>
	 * @throws Exception
	 */
	@AfterThrowing(pointcut = "loginLog(loginLog)", throwing = "e")
	public void loginFail(JoinPoint jp, LoginLog loginLog, Exception e) {
		try {
			Object[] args = jp.getArgs();
			Object afterObject = args[0];
			if (afterObject instanceof UserBean) {
				UserBean userBean = (UserBean) afterObject;
				LogBean logBean = initLogBean(afterObject);
				logBean.setOperatorType(OperatorType.LOGIN);
				logBean.setOperatorName(userBean.getUsername());
				logBean.setBefore(JSONObject.fromObject(userBean).toString());
				logBean.setIsSuccess(0);
				logBean.setFailReason(e.getMessage());
				logBean.setType(Constants.LOG_TYPE_LOGIN);
				logBean.setObjectType(ObjectType.USER);
				logBean.setDescription("登录失败");

				logDao.insert(logBean);
			}
		} catch (Exception ex) {
			log.error(ex);
		}
	}

	/**
	 * 
	 * 方法用途: 初始化日志对象<br>
	 * 实现步骤: <br>
	 */
	private LogBean initLogBean(Object beanObejct) {
		LogBean logBean = new LogBean();
		if (beanObejct instanceof Bean) {
			Bean bean = (Bean) beanObejct;
			logBean.setIp(bean.getRequestIp());
			String userJsonString = StringUtils.delJsonFromRedis(iCommStringCache.get(bean
					.getSessionId()));
			if (!StringUtils.isEmpty(userJsonString)) {
				UserPo userPo = JSON.parseObject(userJsonString, UserPo.class);
				if (userPo != null) {
					logBean.setOperatorId(userPo.getId());
					logBean.setOperatorName(userPo.getName());
				}
			}
		}
		logBean.setTime(new Date());
		logBean.setIsSuccess(1);
		logBean.setType(Constants.LOG_TYPE_OPERATOR);
		return logBean;
	}

	/**
	 * 
	 * 方法用途: 获取对象<br>
	 * 实现步骤: <br>
	 * @param logBean
	 */
	private String getObjectJsonString(LogBean logBean, String tableName) throws Exception {
		Map<String, Object> object = new HashMap<String, Object>();

		JSONObject idJson = JSONObject.fromObject(logBean.getObjectId());
		LogIDBean idBean = new LogIDBean();
		idBean.setTableName(tableName);
		switch (logBean.getObjectType()) {
		case ObjectType.DETAIIL_LIST: {
			idBean.setDispatchNo(idJson.getString("dispatchNo"));
		}
			break;
		case ObjectType.PACKAGE: {
			idBean.setDispatchNo(idJson.getString("dispatchNo"));
			idBean.setPackageNo(idJson.getString("packageNo"));
		}
			break;
		case ObjectType.ITEMS: {
			// TODO 获取包裹(暂无)
		}
			break;
		default: {
			idBean.setId(idJson.getLong("id"));
		}
			break;
		}
		object = objectDao.get(idBean);

		return JSONObject.fromObject(object).toString();
	}

	private String getObejctId(int objectType, Object afterObject) throws Exception {
		JSONObject idJson = new JSONObject();
		switch (objectType) {
		case ObjectType.DETAIIL_LIST: {
			idJson.put("dispatchNo",
					afterObject.getClass().getMethod("getDispatchNo").invoke(afterObject)
							.toString());
		}
			break;
		case ObjectType.PACKAGE: {
			idJson.put("dispatchNo",
					afterObject.getClass().getMethod("getDispatchNo").invoke(afterObject)
							.toString());
			idJson.put("packageNo",
					afterObject.getClass().getMethod("getPackageNo").invoke(afterObject).toString());
		}
			break;
		case ObjectType.ITEMS: {
			// TODO 获取包裹ID(暂无)
		}
			break;
		default: {
			idJson.put("id", afterObject.getClass().getMethod("getId").invoke(afterObject));
		}
			break;
		}
		return idJson.toString();
	}

}
