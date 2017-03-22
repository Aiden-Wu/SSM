package com.xipin.est.master.param.user;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.UserBean;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class ResetPasswordParam extends Param implements BeanParam<UserBean>{

	private Long id;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public UserBean initBean() {
		UserBean bean = new UserBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

}
