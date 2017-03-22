package com.xipin.est.service.busi.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.user.UpdatePasswordBean;
import com.xipin.est.db.dao.IOrgDao;
import com.xipin.est.db.dao.IUserDao;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.model.user.Org;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.apsect.annotation.InsertLog;
import com.xipin.est.service.apsect.annotation.LoginLog;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.service.busi.inf.UserService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.comm.LoginUtils;
import com.xipin.est.utils.comm.NMD5;
import com.xipin.est.utils.contants.ObjectType;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.eum.MsgEnum;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IOrgDao orgDao;
	
	@Override
	public PageBean<UserPo> queryListByBiz(UserBean userBean,PageBean<UserPo> page) {
		userBean.setBeginIndex(page.getStart());
		userBean.setPageSize(page.getPageSize());
		List<UserPo> list = userDao.queryUserForJsp(userBean);
		page.setCount(userDao.queryListCountByBiz(userBean));
		page.setData(list);
		return page;
	}


	@Override
	@UpdateLog(description="修改用户", objectType=ObjectType.USER, tableName="user")
	public void updateByPKSel(UserBean userBean) {
		userDao.updateByPKSel(userBean);
	}

	@Override
	@DeleteLog(description="删除用户", objectType=ObjectType.USER, tableName="user")
	public void delete(IDBean idBean) {
		userDao.delete(idBean.getId());
	}


	@Override
	@LoginLog
	public UserPo login(UserBean userLoginBean) {
		//密码空校验
		if(!StringUtils.hasText(userLoginBean.getPassword())){
			throw new BusinessException(MsgEnum.s_password_not_empty.getVal());
		}
		//1.获取用户salt
		UserBean userBean = new UserBean();
		userBean.setUsername(userLoginBean.getUsername());
//		userBean.setUserStatus((byte)1);
		userBean.setStatus((byte)1);
		List<UserPo> list = userDao.queryListByBiz(userBean);
		if(null != list && list.size() == 1){
			//2.通过用户名+密码查询
			String salt = list.get(0).getSalt();
			String password = userLoginBean.getPassword();
			userLoginBean.setPassword(NMD5.passwordEncode(password,salt));
			userLoginBean.setUserStatus((byte)1);
			List<UserPo> list2 = userDao.queryListByBiz(userLoginBean);
			if(null != list2 && list2.size() == 1){
				String sessionId=LoginUtils.generateSessionId(userLoginBean.getUsername());//生成sid并存入redis
				//将tokenId存入redis,有效期一天
				list2.get(0).setSessionId(sessionId);
				return list2.get(0);
			}else {
				//用户名+密码，多条重复或密码错误
				throw new BusinessException(MsgEnum.s_password_error.getVal());
			}
		} else {
			//用户存在多条数据
			throw new BusinessException(MsgEnum.s_password_error.getVal());
		}
	}

	@Override
	@InsertLog(description="添加用户", objectType=ObjectType.USER, tableName="user")
	public void register(UserBean userLoginBean) {
		//判断机构是否存在
		Org org=orgDao.getByKey(userLoginBean.getOrgId());
		if(org==null){
			throw new BusinessException(MsgEnum.s_parentorg_empty.getVal());
		}
		userLoginBean.setUserType(org.getType());
		//检查用户名是否存在
		UserBean userBean = new UserBean();
		userBean.setUsername(userLoginBean.getUsername());
//		userBean.setUserStatus((byte) 1);
		userBean.setStatus((byte) 1);
		List<UserPo> list = new ArrayList<UserPo>();
		list = userDao.queryListByBiz(userBean);
		if(list.size() != 0){
			throw new BusinessException(MsgEnum.s_username_repeat.getVal());
		}else {
			String password = userLoginBean.getPassword();
			//获取人员编号
			String maxNo=userDao.getMaxUserNoByOrgId(userLoginBean.getOrgId());
			String no="";
			if(StringUtils.isEmpty(maxNo)){
				no=maxNo;
			}else{
				NumberFormat format = NumberFormat.getInstance();
			    format.setMinimumIntegerDigits(6);
			    int i = Integer.parseInt(maxNo.substring(2))+1;
			    no= "RY"  + format.format(i).replace(",", "");
			}
			userLoginBean.setUserType(org.getType());
			userLoginBean.setUserStatus((byte)1);
			userLoginBean.setStatus((byte)1);
			userLoginBean.setNo(no);
			//默认密码，123456
			password = StringUtils.hasText(password)?password:"123456";
			String salt = LoginUtils.generateSalt();
			userLoginBean.setPassword(NMD5.passwordEncode(password, salt));
			userLoginBean.setSalt(salt);
			userLoginBean.setTitle(userLoginBean.getTitle());
			userDao.insert(userLoginBean);
		}
	}

	@Override
	@UpdateLog(objectType=ObjectType.USER, tableName="user", description="重置密码")
	public void modifyPassword(UserBean bean) {
		// 1.1获取用户salt
		bean.setUserStatus((byte) 1);
		String pwd = bean.getPassword();
		bean.setPassword(null);
		List<UserPo> list = userDao.queryListByBiz(bean);
		if (null != list && list.size() == 1) {
			//2.更新信息
			UserPo newUserPo = list.get(0);
			UserBean newUserBean = new UserBean();
			BeanUtils.copyProperties(newUserPo, newUserBean);
			newUserBean.setPassword(NMD5.passwordEncode(pwd, newUserPo.getSalt()));
			userDao.updateByPKSel(newUserBean);
		} else {
			// 用户存在多条数据
			throw new BusinessException(MsgEnum.s_user_repeat.getVal());
		}
	}

	@Override
	@UpdateLog(objectType=ObjectType.USER, tableName="user", description="修改密码")
	public void updatePassword(UpdatePasswordBean updatePasswordBean) {
		UserPo userPo = userDao.getByKey(updatePasswordBean.getId());
		if(userPo == null){
			throw new BusinessException(MsgEnum.s_user_empty.getVal());
		}
		if(userPo.getStatus() != 1){
			throw new BusinessException(MsgEnum.s_userstatus_exception.getVal());
		}
		String oldPassword = NMD5.passwordEncode(updatePasswordBean.getOldPassword(), userPo.getSalt());
		if(!oldPassword.toUpperCase().equals(userPo.getPassword().toUpperCase())){
			throw new BusinessException(MsgEnum.s_password_error.getVal());
		}

		UserBean newUserBean = new UserBean();
		BeanUtils.copyProperties(userPo, newUserBean);
		newUserBean.setPassword(NMD5.passwordEncode(updatePasswordBean.getNewPassword(), userPo.getSalt()));
		userDao.updateByPKSel(newUserBean);
	}

}
