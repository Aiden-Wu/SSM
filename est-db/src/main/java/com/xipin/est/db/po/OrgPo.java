package com.xipin.est.db.po;

import java.sql.Timestamp;

import com.xipin.est.model.user.Org;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.convert.CommConvertUtils;

public class OrgPo extends Org {

	private static final long serialVersionUID = 1023341142918855925L;

	private String createDateStr;
	private String updateDateStr;
	private Long pid;
	

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDateStr = CommConvertUtils.converToStr(createDate, Constants.DATETIME_FORMAT);
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDateStr = CommConvertUtils.converToStr(updateDate, Constants.DATETIME_FORMAT);
	}

}
