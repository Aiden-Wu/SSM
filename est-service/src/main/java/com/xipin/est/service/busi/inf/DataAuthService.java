package com.xipin.est.service.busi.inf;

import com.xipin.est.db.po.UserPo;
import com.xipin.est.utils.bean.PageBean;

public interface DataAuthService {
	
	/**
	 * 获取机构树，客户（邮局）-机构-部门-用户
	 * @param clientFlag 是否到达“用户”这一层 1-显示，0-不显示
	 * @return 返回树形的json字符串
	 */
	public String getOrgTree(Integer clientFlag, Long userId);
	
	/**
	 * 授权
	 * @param dataAuthIds
	 * @param userId
	 */
	public void addAuth(Long[] dataAuthIds, Long userId);
	
	/**
	 * 获取部门下的用户信息
	 * @param orgId
	 * @return
	 */
	public PageBean<UserPo> getDepartmentUserList(Long orgId, PageBean<UserPo> page);

	String getDataAuthTree(Long userId, Long tUserId);
}
