package com.xipin.est.manager.inf;

import com.xipin.est.db.po.UserPo;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

/**
 * 数据权限接口
 * @author lvjl
 *
 */
public interface DataAuthManager {
	
	/**
	 * 获取机构树，客户（邮局）-机构-部门-用户
	 * @param clientFlag 是否到达“用户”这一层 1-显示，0-不显示
	 * @return 返回树形的json字符串
	 */
	public Result<String> getOrgTree(Integer clientFlag, Long userId);
	
	/**
	 * 付权
	 * @param dataAuthIds 付权邮局权限数据ids
	 * @param userId 用户id
	 * @return
	 */
	public Result<?> addAuth(Long[] dataAuthIds,Long userId);
	
	/**
	 * 获取权限树
	 * @param userId 用户id
	 * @return 
	 */
	public Result<String> getAuthTree(Long userId, Long meId);
	
	/**
	 * 获取部门下的用户信息
	 * @param orgId
	 * @return
	 */
	public Result<PageBean<UserPo>> getDepartmentUserList(Long orgId, PageBean<UserPo> page);
	
	
}
