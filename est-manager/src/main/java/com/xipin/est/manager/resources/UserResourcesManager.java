package com.xipin.est.manager.resources;

import java.util.List;

import com.xipin.est.db.po.resources.ResourcesPo;
import com.xipin.est.utils.rslt.type.Result;

public interface UserResourcesManager {
    
	/**
	 * 修改用户权限
	 * @param userId
	 * @param resourcesIds
	 * @return
	 * @throws Exception    
	 * @return Result<UserResources>    返回类型
	 *
	 */
	public Result<String> update(Long userId,Long[] resourcesIds)  throws Exception;
	
	
	public Result<String> queryResourceTreeByUser(Long userId);
    /**
     * 用户权限判断
     * @param adminId
     * @param url    
     * @return void    返回类型
     *
     */
	public boolean isPermission(Long adminId, String url);


	/**
	 * 
	 * 方法用途: 查询目录<br>
	 * 实现步骤: <br>
	 * @param id
	 * @return
	 */
	public Result<List<ResourcesPo>> queryMenu(Long userId);
	
	public List<String> getResourcesPoListByUserId(Long userId);
	
	
}
