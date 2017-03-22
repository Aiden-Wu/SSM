package com.xipin.est.db.bean;

import java.util.Date;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 更新状态参数</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class UpdateDetailListBean extends Bean {
	
	/**
	 * 批次号列表
	 */
	private String dispatchNo;
	
	/**
	 * 完成状态
	 */
	private Integer status;
	
	/**
	 * 完成时间
	 */
	private Date statusTime;
	
	
	private Date submitDate;
	
	/**
	 * 邮局英文名
	 */
	private String postofficeEnName;

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * {@linkplain #status}
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * {@linkplain #statusTime}
	 */
	public Date getStatusTime() {
		return statusTime;
	}

	/**
	 * {@linkplain #statusTime}
	 */
	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	
	
	

}
