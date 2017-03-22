package com.xipin.est.db.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.po.resources.ResourcesPo;

/**
 * 目录权限
 * @author JiaJia.Song 
 * @date May 17, 2016 2:35:11 PM
 */
@Repository
public interface IResourcesDao {
	
	
	
	/**
	 * 查询所有资源权限，当用户拥有某个资源的权限时，peimission字段为1
	 * @param userId
	 * @return    
	 * @return List<ResourcesPo>    返回类型
	 *
	 */
	public List<ResourcesPo> queryResourceByUser(Long userId);

	
	
	public List<String> getResourcesPoListByUserId(Long userId);

	List<ResourcesPo> queryResourceTreeByUser(@Param("userId")Long userId, @Param("userType")String userType);
	
}
