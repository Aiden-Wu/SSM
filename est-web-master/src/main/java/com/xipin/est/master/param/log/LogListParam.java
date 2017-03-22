package com.xipin.est.master.param.log;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.log.LogListBean;
import com.xipin.est.db.po.log.LogPo;
import com.xipin.est.ucontroller.date.DateFomatEnum;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

public class LogListParam extends PageParam<LogPo> implements BeanParam<LogListBean> {

	/**
	 * 起始时间
	 */
	private Date beginTime;
	/**
	 * 截至时间
	 */
	private Date endTime;
	/**
	 * 操作人ID
	 */
	private Long operatorId;
	/**
	 * 操作人名称
	 */
	private String operatorName;
	/**
	 * 操作类型
	 */
	private Integer operatorType;
	/**
	 * 对象ID
	 */
	private String objectId;
	/**
	 * 对象类型
	 */
	private Integer objectType;
	/**
	 * 日志类型
	 */
	private Integer type;
	/**
	 * ip
	 */
	private String ip;
	
	@Override
	public LogListBean initBean() {
		LogListBean logListBean = new LogListBean();
		BeanUtils.copyProperties(this, logListBean);
		return logListBean;
	}

	/**
	 * {@linkplain #beginTime}
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * {@linkplain #beginTime}
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = DateFomatEnum.DATETIME.toDate(beginTime, " 00:00:00","起始时间格式错误");
		
	}

	/**
	 * {@linkplain #endTime}
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * {@linkplain #endTime}
	 */
	public void setEndTime(String endTime) {
		this.endTime = DateFomatEnum.DATETIME.toDate(endTime, " 23:59:59","截至时间格式错误");
	}

	/**
	 * {@linkplain #operatorId}
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * {@linkplain #operatorId}
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * {@linkplain #operatorName}
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * {@linkplain #operatorName}
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * {@linkplain #operatorType}
	 */
	public Integer getOperatorType() {
		return operatorType;
	}

	/**
	 * {@linkplain #operatorType}
	 */
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	/**
	 * {@linkplain #objectId}
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * {@linkplain #objectId}
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * {@linkplain #objectType}
	 */
	public Integer getObjectType() {
		return objectType;
	}

	/**
	 * {@linkplain #objectType}
	 */
	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	/**
	 * {@linkplain #type}
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * {@linkplain #type}
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * {@linkplain #ip}
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * {@linkplain #ip}
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

}
