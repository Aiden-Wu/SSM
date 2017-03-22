package com.xipin.est.db.bean.user;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 修改密码参数类</p>
 * @date 2016年5月19日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class UpdatePasswordBean extends Bean {

	/**
	 * 用户ID
	 */
	private Long id;
	/**
	 * 原始密码
	 */
	private String oldPassword;
	/**
	 * 新密码
	 */
	private String newPassword;

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

	/**
	 * {@linkplain #oldPassword}
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * {@linkplain #oldPassword}
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * {@linkplain #newPassword}
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * {@linkplain #newPassword}
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
