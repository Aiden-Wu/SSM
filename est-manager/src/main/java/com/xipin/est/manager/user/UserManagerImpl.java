package com.xipin.est.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.user.UpdatePasswordBean;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.inf.UserManager;
import com.xipin.est.service.busi.inf.UserService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

/**
 * @author lvjl
 *
 */
@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserService userService;

	@Override
	public Result<UserPo> login(UserBean userLoginBean) {
		Result<UserPo> result = new Result<UserPo>();
		result.setData(userService.login(userLoginBean));
		return result;
	}

	@Override
	public Result<UserPo> register(UserBean userBean) {
		Result<UserPo> result = new Result<UserPo>();
		userService.register(userBean);
		return result;
	}

	@Override
	public Result<UserPo> modifyPassword(UserBean bean) {
		Result<UserPo> result = new Result<UserPo>();
		userService.modifyPassword(bean);
		return result;
	}

	@Override
	public Result<List<UserPo>> queryListByBiz(UserBean userBean,PageBean<UserPo> page) {
		Result<List<UserPo>> result = new Result<>();
		PageBean<UserPo> pageBean = userService.queryListByBiz(userBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<UserPo> deleteUser(IDBean idBean) {
		Result<UserPo> result = new Result<UserPo>();
		userService.delete(idBean);
		return result;
	}

	@Override
	public Result<UserPo> updateUser(UserBean userBean) {
		Result<UserPo> result = new Result<UserPo>();
		userService.updateByPKSel(userBean);
		return result;
	}

	@Override
	public Result<String> updatePassword(UpdatePasswordBean updatePasswordBean) {
		Result<String> result = new Result<>();
		userService.updatePassword(updatePasswordBean);
		return result;
	}

}
