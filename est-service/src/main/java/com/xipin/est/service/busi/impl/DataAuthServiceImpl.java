package com.xipin.est.service.busi.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.UserAuthCheckBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.UserDataAuthBean;
import com.xipin.est.db.dao.IDataAuthDao;
import com.xipin.est.db.dao.IOrgDao;
import com.xipin.est.db.dao.IPostClientDao;
import com.xipin.est.db.dao.IUserDao;
import com.xipin.est.db.dao.IUserDataAuthDao;
import com.xipin.est.db.po.DataAuthTreePo;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.service.busi.inf.DataAuthService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.eum.MsgEnum;

@Service
public class DataAuthServiceImpl implements DataAuthService {
	
	@Autowired
	private IDataAuthDao dataAuthDao;
	@Autowired
	private IOrgDao orgDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserDataAuthDao userDataAuthDao;
	@Autowired
	private IPostClientDao postClientDao;

	@Override
	public String getOrgTree(Integer clientFlag, Long userId) {
		//机构列表
		OrgBean orgBean = new OrgBean();
//		orgBean.setStatus(status);//有效状态
		List<OrgPo> list = orgDao.queryListByBiz(orgBean);
		List<Long> orgIdList = new ArrayList<Long>();//过滤人员使用
		for(OrgPo op:list){
			op.setPid(op.getParentId());
			orgIdList.add(op.getId());
		}
		//显示到用户一级
		if(clientFlag == 1){
			//人员列表
			UserBean userBean = new UserBean();
//			userBean.setUserStatus((byte)1);//有效状态
			List<UserPo> userList = userDao.queryListByBiz(userBean);
			//将人员数据以org机构数据放入，id/parentId/name
			for(UserPo up:userList){
				if(orgIdList.contains(up.getOrgId())){
					OrgPo orgPo = new OrgPo();
//					orgPo.setId(up.getId());//与orgId冲突
					orgPo.setParentId(up.getOrgId());
					orgPo.setPid(up.getOrgId());
					orgPo.setName(up.getName());
					list.add(orgPo);
				}
			}
		}
		
		Map<String,Object> map=new HashMap<String,Object>();
        map.put("resource",list);
    	String treeJson = JSON.toJSONString(map);
    	return treeJson;
	}

	@Override
	@Transactional
	public void addAuth(Long[] dataAuthIds, Long userId) {
		//1.校验user是否能单条授权2.删除用户权限，3.付权
		//1.校验
		for(Long dataAuthId:dataAuthIds){
			UserAuthCheckBean userAuthCheckBean = new UserAuthCheckBean();
			userAuthCheckBean.setDataAuthId(dataAuthId);
			userAuthCheckBean.setUserId(userId);
			int checkResult = dataAuthDao.checkUserAuth(userAuthCheckBean);
			if(checkResult < 1){
				throw new BusinessException(MsgEnum.s_authdata_illegality.getVal());
			}
		}
		//2.删除用户所有数据权限
		userDataAuthDao.deleteByUserId(userId);
		//3.授权
		//用户信息
		UserPo userPo = userDao.getByKey(userId);
		if(null == userPo){
			throw new BusinessException(MsgEnum.s_userinfo_error.getVal());
		}
		for(Long id:dataAuthIds){
			UserDataAuthBean userDataAuthBean = new UserDataAuthBean();
			userDataAuthBean.setCreateDate(new Date());
			userDataAuthBean.setDataAuthId(id);
			userDataAuthBean.setUserId(userId);
			userDataAuthBean.setUsername(userPo.getName());
			userDataAuthDao.insertSel(userDataAuthBean);
		}
	}

	@Override
	public String getDataAuthTree(Long userId, Long tUserId){
		List<DataAuthTreePo> dataTree = dataAuthDao.getDataAuthByUser(tUserId);
		List<Long> canAuth = new ArrayList<>();
		if(dataTree != null && dataTree.size() > 0){
			for(DataAuthTreePo datp : dataTree){
				canAuth.add(datp.getDataAuthId());
			}
		}
		List<Long> had = dataAuthDao.checkAuth(tUserId, canAuth);
		Map<String,Object> map=new HashMap<>();
		map.put("resource",dataTree);
        map.put("permission",had);
        return JSON.toJSONString(map);
	}
	
	@Override
	public PageBean<UserPo> getDepartmentUserList(Long orgId, PageBean<UserPo> page) {
		OrgPo orgPo = orgDao.getByKey(orgId);
		if(null != orgPo && Constants.ORG_LEVEL_THREE.byteValue() == orgPo.getLevel().byteValue()){
			UserBean userBean = new UserBean();
			userBean.setOrgId(orgId);
			List<UserPo> list = userDao.queryListByBiz(userBean);
			page.setCount(userDao.queryListCountByBiz(userBean));
			page.setData(list);
			return page;
		}else {
			throw new BusinessException(MsgEnum.s_bminfo_error.getVal());
		}
	}

}
