package com.xipin.est.service.busi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xipin.est.db.dao.IResourcesDao;
import com.xipin.est.db.dao.IUserDao;
import com.xipin.est.db.dao.IUserResourcesDao;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.db.po.resources.ResourcesPo;
import com.xipin.est.model.UserResources;
import com.xipin.est.service.busi.inf.UserResourcesService;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.eum.MsgEnum;

@Service
public class UserResourcesServiceImpl implements UserResourcesService{

	@Resource
	private IUserResourcesDao userResourcesDao;
	
	@Resource
	private IResourcesDao resourcesDao;
	
	@Resource
	private IUserDao userDao;

	@Override
	public String queryResourceTreeByUser(Long userId) {
		UserPo user=userDao.getByKey(userId);
		String userType = "";
		switch(user.getUserType()){
		case -1:{
			userType = "admin";
		}break;
		case 0:{
			userType = "post";
		}break;
		case 1:{
			userType = "client";
		}break;
		}
        List<ResourcesPo> resourcesList = resourcesDao.queryResourceTreeByUser(userId, userType);
        List<Long> permission=new ArrayList<>();
        if(resourcesList==null||resourcesList.size()==0){
        	return "[]";
        }else{
        	for (ResourcesPo resourcesPo : resourcesList) {
        		if(resourcesPo.getPermission()==1){
        			permission.add(resourcesPo.getId());
        		}
			}
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("resource",resourcesList);
        map.put("permission",permission);
    	String treeJson = JSON.toJSONString(map);
    	return treeJson;
	}  
	
	@Override
	public void updateUserResources(Long userId,
			Long[] resourcesIds) throws Exception {
		UserPo user=userDao.getByKey(userId);
		if(user==null){
			throw new BusinessException(MsgEnum.s_user_empty.getVal());
		}
		//删除用户原有权限
		userResourcesDao.deleteByUserId(userId);
	    //插入用户新权限
		List<UserResources> userResourceslist=new ArrayList<UserResources>();
		for (int i = 0; i < resourcesIds.length; i++) {
			UserResources userResources=new UserResources();
			userResources.setUserId(userId);
			userResources.setResourcesId(resourcesIds[i]);
			userResourceslist.add(userResources);
		}
		userResourcesDao.insertBatch(userResourceslist);
	}

	@Override
	public boolean isPermission(Long userId,String url) {
		List<ResourcesPo> resourcesList = resourcesDao.queryResourceByUser(userId);
		boolean flag=false; //此功能是否需要权限过滤
		for (ResourcesPo resourcesPo : resourcesList) {
			if(url.equals(resourcesPo.getUrl())){
				flag=true;
				break;
			}
		}
		if(flag){
			for (ResourcesPo resourcesPo : resourcesList) {
				if(resourcesPo.getPermission()==0){
					continue;
				}
				if(url.equals(resourcesPo.getUrl())){
					return true;
				}
			}
		}else{
			return true;
		}
		return false;
	}

	@Override
	public List<ResourcesPo> queryMenu(Long userId) {
		List<ResourcesPo> listTmpe = resourcesDao.queryResourceByUser(userId);
		List<ResourcesPo> list = new LinkedList<>();
		for (ResourcesPo resourcesPo : listTmpe) {
			if(resourcesPo.getPermission() == 1){
				list.add(resourcesPo);
			}
		}
		return list;
	}
	

}
