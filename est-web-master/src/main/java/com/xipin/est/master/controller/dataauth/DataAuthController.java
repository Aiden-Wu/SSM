package com.xipin.est.master.controller.dataauth;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.inf.DataAuthManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.IDParam;
import com.xipin.est.master.param.dataauth.OrgTreeParam;
import com.xipin.est.master.param.user.UserLoginParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

@Controller
@RequestMapping("/dataAuth/")
public class DataAuthController extends BaseController<DataAuthController>{
	
	@Autowired
	private DataAuthManager dataAuthManager;

	/**
	 * 数据授权
	 * @param dataAuthIds 添加的邮局
	 * @param userId 用户id
	 * @param response
	 */
	@RequestMapping(value="auth.html", method = RequestMethod.POST)
	public void auth(@NotNull Long[] dataAuthIds,@NotNull Long userId, HttpServletResponse response){
		AjaxUtils.write(response, dataAuthManager.addAuth(dataAuthIds, userId));
	}
	
	/**
	 * org结构数
	 * @param clientFlag 是否到用户这一级
	 * @param response
	 */
	@RequestMapping(value="orgTree.html")
	public void orgTree(@Valid OrgTreeParam param, BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, dataAuthManager.getOrgTree(param.getClientFlag(), super.getUser().getId()));
	}
	
	/**
	 * 数据权限树
	 * @param clientFlag 是否到用户这一级
	 * @param response
	 */
	@RequestMapping(value="authTree.html")
	public void authTree(@Valid IDParam param, BindingResult bindRslt, HttpServletResponse response){
		UserPo user = getUser();
		AjaxUtils.write(response, dataAuthManager.getAuthTree(user.getId(), param.getId()));
	}
	
	/**
	 * 获取部门下的人员信息
	 * @param orgId 必须是部门级别
	 * @param response
	 */
	@RequestMapping(value="getDepartmentUserList.html", method = RequestMethod.POST)
	public void getDepartmentUserList(UserLoginParam userLoginParam,BindingResult bindRslt ,HttpServletResponse response){
		AjaxUtils.write(response, new JQGridPageResult<>(dataAuthManager.getDepartmentUserList(userLoginParam.getOrgId(),userLoginParam.initPage())));
	}
}
