package com.xipin.est.manager.dataauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.inf.DataAuthManager;
import com.xipin.est.service.busi.inf.DataAuthService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

/**
 * @author lvjl
 *
 */
@Service
public class DataAuthManagerImpl implements DataAuthManager {
	
	@Autowired
	private DataAuthService dataAuthService;

	@Override
	public Result<String> getOrgTree(Integer clientFlag, Long userId) {
		Result<String> result = new Result<String>();
		result.setData(dataAuthService.getOrgTree(clientFlag, userId));
		return result;
	}

	@Override
	public Result<?> addAuth(Long[] dataAuthIds, Long userId) {
		Result<String> result = new Result<>();
		dataAuthService.addAuth(dataAuthIds, userId);
		return result;
	}

	@Override
	public Result<String> getAuthTree(Long curUserId, Long tUserId) {
		Result<String> result = new Result<>();
		result.setData(dataAuthService.getDataAuthTree(curUserId, tUserId));
		return result;
	}

	@Override
	public Result<PageBean<UserPo>> getDepartmentUserList(Long orgId, PageBean<UserPo> page) {
		Result<PageBean<UserPo>> result = new Result<PageBean<UserPo>>();
		result.setData(dataAuthService.getDepartmentUserList(orgId, page));
		return result;
	}

}
