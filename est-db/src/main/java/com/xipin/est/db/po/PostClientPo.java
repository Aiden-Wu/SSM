package com.xipin.est.db.po;

import java.util.Date;

import com.xipin.est.model.user.PostClient;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.convert.CommConvertUtils;

public class PostClientPo extends PostClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8822444645657045072L;

	private String createDateStr;
	private String updateDateStr;
	private String no;

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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

}
