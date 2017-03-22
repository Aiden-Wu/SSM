package com.xipin.est.master.param.org;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.org.OrgListBean;
import com.xipin.est.db.po.org.OrgListPo;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

/**
 * 
 * <p>Description: 机构列表参数验证类</p>
 * @date 2016年5月21日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class OrgListParam extends PageParam<OrgListPo> implements BeanParam<OrgListBean> {

	/**
	 * 父机构ID
	 */
	private Long parentId;

	@Override
	public OrgListBean initBean() {
		OrgListBean bean = new OrgListBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

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

}
