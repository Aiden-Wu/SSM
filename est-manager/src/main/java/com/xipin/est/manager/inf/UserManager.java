package com.xipin.est.manager.inf;

import java.util.List;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.user.UpdatePasswordBean;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

/**
 * 用户manager
 * @author lvjl
 *
 */
public interface UserManager {
	
	/**
	 * 登录
	 * @param userLoginBean
	 * @return
	 */
	public Result<UserPo> login(UserBean userLoginBean);
	
	/**
	 * 注册
	 * @param userBean
	 * @return
	 */
	public Result<UserPo> register(UserBean userBean);
	
	/**
	 * 修改密码
	 * @param userBean
	 * @return
	 */
	public Result<UserPo> modifyPassword(UserBean userBean);
	
	/**
	 * 条件查询
	 * @param userBean
	 * @return
	 */
	public Result<List<UserPo>> queryListByBiz(UserBean userBean, PageBean<UserPo> page);
	
	/**
	 * 删除-逻辑删除
	 * @param id
	 * @return
	 */
	public Result<UserPo> deleteUser(IDBean idBean);
	
	/**
	 * 修改
	 * @param userBean
	 * @return
	 */
	public Result<UserPo> updateUser(UserBean userBean);
	
	/**
	 * 修改密码
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return
	 */
	public Result<String> updatePassword(UpdatePasswordBean updatePasswordBean);
}
