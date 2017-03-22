package com.xipin.est.model;

import java.sql.Timestamp;

/**
 * 
 * <p>Description: 日志实体类</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class Log implements Model {

	private static final long serialVersionUID = 5475071370344967667L;
	/**
	 * 日志ID
	 */
	private Long Id;
	/**
	 * 时间
	 */
	private Timestamp time;
	/**
	 * 日志类型
	 */
	private Integer type;
	/**
	 * 描述
	 */
	private String description;
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
	 * 操作前
	 */
	private String before;
	/**
	 * 操作后
	 */
	private String after;
	/**
	 * IP
	 */
	private String ip;
	/**
	 * 是否成功
	 */
	private Integer isSuccess;
	/**
	 * 失败原因
	 */
	private String failReason;

	/**
	 * {@linkplain #id}
	 */
	@Override
	public Long getId() {
		return Id;
	}

	/**
	 * {@linkplain #id}
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * {@linkplain #time}
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * {@linkplain #time}
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * {@linkplain #description}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * {@linkplain #description}
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * {@linkplain #before}
	 */
	public String getBefore() {
		return before;
	}

	/**
	 * {@linkplain #before}
	 */
	public void setBefore(String before) {
		this.before = before;
	}

	/**
	 * {@linkplain #after}
	 */
	public String getAfter() {
		return after;
	}

	/**
	 * {@linkplain #after}
	 */
	public void setAfter(String after) {
		this.after = after;
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

	/**
	 * {@linkplain #isSuccess}
	 */
	public Integer getIsSuccess() {
		return isSuccess;
	}

	/**
	 * {@linkplain #isSuccess}
	 */
	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * {@linkplain #failReason}
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * {@linkplain #failReason}
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
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

}
