package com.xipin.est.db.bean.log;

import java.util.Date;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 日志列表参数类</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class LogListBean extends Bean {

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
	/**
	 * 分页起始位置
	 */
	private Integer beginIndex;
	/**
	 * 分页大小
	 */
	private Integer pageSize;

	/**
	 * {@linkplain #beginTime}
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * {@linkplain #beginTime}
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
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
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 * {@linkplain #beginIndex}
	 */
	public Integer getBeginIndex() {
		return beginIndex;
	}

	/**
	 * {@linkplain #beginIndex}
	 */
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * {@linkplain #pageSize}
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * {@linkplain #pageSize}
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
