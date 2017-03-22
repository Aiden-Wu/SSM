package com.xipin.est.master.param.user;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.UserBean;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class UserUpdateParam extends Param implements BeanParam<UserBean> {

	private Long id;

	private String name;

	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public UserBean initBean() {
		UserBean userbean = new UserBean();
		BeanUtils.copyProperties(this, userbean);
		return userbean;
	}

}
