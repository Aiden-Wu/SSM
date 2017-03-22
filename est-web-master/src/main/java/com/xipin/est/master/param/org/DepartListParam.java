package com.xipin.est.master.param.org;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

/**
 * 
 * <p>Description: 邮局部门列表参数验证类</p>
 * @date 2016年5月20日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class DepartListParam extends PageParam<OrgPo> implements BeanParam<OrgBean> {
	
	/**
	 * 父机构ID
	 */
	private Long parentId;

	@Override
	public OrgBean initBean() {
		OrgBean bean = new OrgBean();
		BeanUtils.copyProperties(this, bean);
		//限制为邮局部门级别
		bean.setType((byte)0);
		bean.setLevel((byte)3);
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
