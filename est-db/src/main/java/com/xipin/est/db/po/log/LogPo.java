package com.xipin.est.db.po.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ConstantsEscape;
import com.xipin.est.utils.contants.ObjectType;
import com.xipin.est.utils.contants.OperatorType;

/**
 * 
 * <p>Description: 日志展现类</p>
 * @date 2016年5月17日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class LogPo {

	/**
	 * 日志ID
	 */
	private Long Id;
	/**
	 * 时间
	 */
	private String time;
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
	private String operatorType;
	/**
	 * 对象ID
	 */
	private String objectId;
	/**
	 * 对象类型
	 */
	private String objectType;
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
	private String isSuccess;
	/**
	 * 失败原因
	 */
	private String failReason;
	/**
	 * 日志类型
	 */
	private String type;

	/**
	 * {@linkplain #id}
	 */
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
	public String getTime() {
		return time;
	}

	/**
	 * {@linkplain #time}
	 */
	public void setTime(Date time) {
		this.time = new SimpleDateFormat(Constants.DATETIME_FORMAT).format(time);
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
	 * {@linkplain #operatorType}
	 */
	public String getOperatorType() {
		return operatorType;
	}

	/**
	 * {@linkplain #operatorType}
	 */
	public void setOperatorType(Integer operatorType) {
		this.operatorType = OperatorType.toString(operatorType);
	}

	/**
	 * {@linkplain #objectType}
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * {@linkplain #objectType}
	 */
	public void setObjectType(Integer objectType) {
		this.objectType = ObjectType.toString(objectType);
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
	public String getIsSuccess() {
		return isSuccess;
	}

	/**
	 * {@linkplain #isSuccess}
	 */
	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess == 1 ? "是" : "否";
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
	public String getType() {
		return type;
	}

	/**
	 * {@linkplain #type}
	 */
	public void setType(Integer type) {
		this.type = ConstantsEscape.logTypeEscap(type);
	}
}