package com.xipin.est.db.bean;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>
 * Description: 包裹列表查询参数
 * </p>
 * 
 * @date 2016年5月10日
 * @author Jianwen Zhu
 * @version 1.0
 *          <p>
 *          Company:XiPinTech
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2015
 *          </p>
 */
public class PackageListBean extends Bean {

	/**
	 * 批次号
	 */
	private String dispatchNo;

	/**
	 * CN35
	 */
	private String CN35;

	/**
	 * 分页开始
	 */
	private Integer beginIndex;

	/**
	 * 分页大小
	 */
	private Integer pageSize;

	private String postofficeEnName;

	private String dispatchType;

	private int from;

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
	 * {@linkplain #cN35}
	 */
	public String getCN35() {
		return CN35;
	}

	/**
	 * {@linkplain #cN35}
	 */
	public void setCN35(String cN35) {
		CN35 = cN35;
	}

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

}
