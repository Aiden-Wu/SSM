package com.xipin.est.service.busi.inf;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.user.UpdatePasswordBean;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.utils.bean.PageBean;

/**
 * @author lvjl
 *
 */
public interface UserService {
	
	/**
	 * 登录
	 * @param userLoginBean
	 * @return
	 */
	public UserPo login(UserBean userLoginBean);
	
	/**
	 * 注册
	 * @param userLoginBean
	 */
	public void register(UserBean userLoginBean);
	
	/**
	 * 修改密码
	 * @param userLoginBean
	 * @return
	 */
	public void modifyPassword(UserBean userLoginBean);
	
	/**
	 * 条件查询
	 * @param userPo
	 * @return
	 */
	public PageBean<UserPo> queryListByBiz(UserBean userBean,PageBean<UserPo> page);
	
	
	/**
	 * 非空字段更新
	 * @param userPo
	 */
	public void updateByPKSel(UserBean userBean);
	
	/**
	 * 
	 * 方法用途: 删除用户<br>
	 * 实现步骤: <br>
	 * @param idBean
	 */
	void delete(IDBean idBean);
	
	/**
	 * 
	 * 方法用途: 修改密码<br>
	 * 实现步骤: <br>
	 * @param updatePasswordBean
	 */
	public void updatePassword(UpdatePasswordBean updatePasswordBean);
}
