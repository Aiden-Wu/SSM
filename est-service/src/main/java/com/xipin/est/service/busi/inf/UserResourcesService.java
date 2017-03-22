package com.xipin.est.service.busi.inf;

import java.util.List;

import com.xipin.est.db.po.resources.ResourcesPo;


/**
 * 用户权限管理
 * @author JiaJia.Song 
 * @date May 18, 2016 9:50:56 AM
 */
public interface UserResourcesService {
    
	
    /**
     * 修改用户权限
     * @param userId
     * @param resourcesIds 
     * @return
     * @throws Exception    
     * @return Result<UserResources>    返回类型
     *
     */
	public void updateUserResources(Long userId,
			Long[] resourcesIds) throws Exception ;

	/**
	 * 查询用户所拥有的权限，返回目录树JSON格式
	 * @return    
	 * @return String    返回类型
	 *
	 */
    public String queryResourceTreeByUser(Long userId);
    
    /**
     * 权限过滤，判断用户是否有某个功能的操作权限
     * @param url
     * @return    
     * @return boolean    返回类型
     *
     */
    public boolean isPermission(Long id,String url);

	public List<ResourcesPo> queryMenu(Long userId);
}
