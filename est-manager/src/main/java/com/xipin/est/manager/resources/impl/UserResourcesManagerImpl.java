package com.xipin.est.manager.resources.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xipin.est.db.po.resources.ResourcesPo;
import com.xipin.est.manager.resources.UserResourcesManager;
import com.xipin.est.service.busi.inf.ResourcesService;
import com.xipin.est.service.busi.inf.UserResourcesService;
import com.xipin.est.utils.rslt.type.Result;

@Service
public class UserResourcesManagerImpl implements UserResourcesManager {

	@Autowired
	private UserResourcesService userResourcesService;
	
	@Autowired
	private ResourcesService resourcesService;

	@Override
	@Transactional
	public Result<String> update(Long userId, Long[] resourcesIds) throws Exception{
		Result<String> result =new Result<String>();
		userResourcesService.updateUserResources(userId,resourcesIds);
		return result;
	}

    

	@Override
	public boolean isPermission(Long userId, String url) {
		return userResourcesService.isPermission(userId, url);
	}



	@Override
	public Result<String> queryResourceTreeByUser(Long userId) {
		Result<String> result=new Result<String>();
		String data=userResourcesService.queryResourceTreeByUser(userId);
		result.setData(data);
		return result;
	}



	@Override
	public Result<List<ResourcesPo>> queryMenu(Long userId) {
		Result<List<ResourcesPo>> result=new Result<List<ResourcesPo>>();
		result.setData(userResourcesService.queryMenu(userId));
		return result;
	}



	@Override
	public List<String> getResourcesPoListByUserId(Long userId) {
		return resourcesService.getResourcesPoListByUserId(userId);
	}


}
