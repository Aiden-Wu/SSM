package com.xipin.est.master.param.dataauth;

import javax.validation.constraints.NotNull;

import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.Param;

public class OrgTreeParam extends Param {

	@NotNull(message=ParamConstants.CLIENTFLAG_CANNOT_NULL)
	private Integer clientFlag;

	public Integer getClientFlag() {
		return clientFlag;
	}

	public void setClientFlag(Integer clientFlag) {
		this.clientFlag = clientFlag;
	}

}
