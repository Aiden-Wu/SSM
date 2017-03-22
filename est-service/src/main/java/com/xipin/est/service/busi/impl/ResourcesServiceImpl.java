package com.xipin.est.service.busi.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xipin.est.db.dao.IResourcesDao;
import com.xipin.est.service.busi.inf.ResourcesService;

@Service
public class ResourcesServiceImpl implements ResourcesService{

	@Resource
	private IResourcesDao resourcesDao;
	

	@Override
	public List<String> getResourcesPoListByUserId(Long userId) {
		
		List<String> urlList = resourcesDao.getResourcesPoListByUserId(userId);
		urlList.add("/main.html");
		
		return urlList;
	}
	
	
	
	
}
