package com.xipin.est.master.param.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.user.UpdatePasswordBean;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: 修改密码参数验证类</p>
 * @date 2016年5月19日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class UpdatePasswordParam extends Param implements BeanParam<UpdatePasswordBean> {

	/**
	 * 用户ID
	 */
	@NotNull(message=ParamConstants.USERID_CANNOT_NULL)
	private Long id;
	/**
	 * 原始密码
	 */
	@NotEmpty(message=ParamConstants.OLDPASSWORD_CANNOT_NULL)
	private String oldPassword;
	/**
	 * 新密码
	 */
	@NotEmpty(message=ParamConstants.NEWPASSWORD_CANNOT_NULL)
	private String newPassword;
	/**
	 * 重复密码
	 */
	@NotEmpty(message=ParamConstants.REPASSWORD_CANNOT_NULL)
	private String rePassword;

	@Override
	public UpdatePasswordBean initBean() {
		if(!newPassword.equals(rePassword)){
			throw new ParamException("新密码和重复密码不一致");
		}
		UpdatePasswordBean bean = new UpdatePasswordBean();
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

	/**
	 * {@linkplain #rePassword}
	 */
	public String getRePassword() {
		return rePassword;
	}

	/**
	 * {@linkplain #rePassword}
	 */
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
