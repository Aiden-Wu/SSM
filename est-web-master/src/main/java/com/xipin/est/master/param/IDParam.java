package com.xipin.est.master.param;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: ID参数验证类</p>
 * @date 2016年5月23日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class IDParam extends Param implements BeanParam<IDBean>{

	/**
	 * ID
	 */
	@NotNull(message=ParamConstants.ID_CANNOT_NULL)
	private Long id;

	@Override
	public IDBean initBean() {
		IDBean bean = new IDBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

	/**
	 * {@linkplain #id}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * {@linkplain #id}
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}
