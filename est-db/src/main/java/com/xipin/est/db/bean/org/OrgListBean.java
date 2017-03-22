package com.xipin.est.db.bean.org;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 机构列表参数类</p>
 * @date 2016年5月21日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class OrgListBean extends Bean {

	/**
	 * 父机构ID
	 */
	private Long parentId;
	/**
	 * 分页起始位置
	 */
	private Integer beginIndex;
	/**
	 * 分页大小
	 */
	private Integer pageSize;

	/**
	 * {@linkplain #parentId}
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * {@linkplain #parentId}
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

}
