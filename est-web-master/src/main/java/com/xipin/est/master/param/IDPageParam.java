package com.xipin.est.master.param;

import javax.validation.constraints.NotNull;

import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.PageParam;

public class IDPageParam extends PageParam<PostClientPo> {

	/**
	 * ID
	 */
	@NotNull(message = ParamConstants.ID_CANNOT_NULL)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
