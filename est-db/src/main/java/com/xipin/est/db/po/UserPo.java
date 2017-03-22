package com.xipin.est.db.po;

import java.util.Date;

import com.xipin.est.model.user.User;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.convert.CommConvertUtils;

public class UserPo extends User {

	public String departmentName;
	public String departmentEName;
	public String orgEName;

	private String sessionId;

	private String createDateStr;
	private String updateDateStr;

	private Long pid;
	
	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDate(Date createDate) {
		this.createDateStr = CommConvertUtils.converToStr(createDate,
				Constants.DATETIME_FORMAT);
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDateStr = CommConvertUtils.converToStr(updateDate,
				Constants.DATETIME_FORMAT);
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentEName() {
		return departmentEName;
	}

	public void setDepartmentEName(String departmentEName) {
		this.departmentEName = departmentEName;
	}

	public String getOrgEName() {
		return orgEName;
	}

	public void setOrgEName(String orgEName) {
		this.orgEName = orgEName;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	private static final long serialVersionUID = -6272353652174096595L;

}
