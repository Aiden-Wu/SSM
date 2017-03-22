package com.xipin.est.master.param.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.UserBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class UserAddParam extends Param implements BeanParam<UserBean> {

	
	@NotEmpty(message = ParamConstants.USERNAME_CANNOT_NULL)
	private String username;

	@NotNull(message = ParamConstants.PASSWORD_CANNOT_NULL)
	private String password;

	@NotEmpty(message = ParamConstants.NAME_CANNOT_NULL)
	private String name;

	@NotNull(message = ParamConstants.ORG_ID_CANNOT_NULL)
	private Long orgId;
	
	@NotEmpty(message = ParamConstants.TITLE_CANNOT_NULL)
	private String title;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public UserBean initBean() {
		UserBean bean = new UserBean();
		BeanUtils.copyProperties(this, bean);
		return bean;
	}

}
