package com.xipin.est.master.controller.client;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.client.PostClientAddParam;
import com.xipin.est.master.param.client.PostClientDeleteParam;
import com.xipin.est.master.param.org.OrgParam;
import com.xipin.est.master.param.org.OrgSelectParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

/**
 * 客户信息
 * @author lvjl
 *
 */
@Controller
@RequestMapping("/clientInfo/")
public class ClientInfoController extends BaseController<ClientInfoController>{
	
	@Autowired
	private OrgManager orgManager;
	
	/**
	 * 客户列表
	 */
	@RequestMapping(value = "clientList.html", method = RequestMethod.POST)
	public void clientList(OrgSelectParam orgParam,BindingResult bindRslt,HttpServletResponse response){
		OrgBean orgBean = orgParam.initBean();
//		orgBean.setType(Constants.ORG_TYPE_CLIENT);//类别-客户
//		orgBean.setLevel(Constants.ORG_LEVEL_TWO);//级别-机构
		orgBean.setUserType(super.getUser().getUserType());
		orgBean.setOrgId(super.getUser().getOrgId());
//		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryListByBiz(orgBean, orgParam.initPage())));
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryClientList(orgBean, orgParam.initPage())));
	}
	
	/**
	 * 新增客户
	 */
	@RequestMapping(value = "addClient.html", method = RequestMethod.POST)
	public void addClient(OrgParam orgParam,BindingResult bindRslt, HttpServletResponse response){
		orgParam.setType(Constants.ORG_TYPE_CLIENT);
		orgParam.setLevel(Constants.ORG_LEVEL_TWO);
		orgParam.setParentId((long)2);//2-客户id
		AjaxUtils.write(response, orgManager.add(orgParam.initBean()));
	}
	
	/**
	 * 更新客户信息
	 */
	@RequestMapping(value = "updateClient.html", method = RequestMethod.POST)
	public void updateClient(OrgParam orgParam,BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, orgManager.update(orgParam.initBean()));
	}
	
	/**
	 * 获取客户信息，包含注册邮局信息
	 */
	@RequestMapping(value = "getclient.html", method = RequestMethod.POST)
	public void getclient(@Valid Long clientId, HttpServletResponse response){
		AjaxUtils.write(response, orgManager.getClientInfo(clientId));
	}
	
	/**
	 * 为客户机构添加注册邮局
	 */
	@RequestMapping(value = "addPost.html", method = RequestMethod.POST)
	public void addPost(@Valid PostClientAddParam postClientAddParam,BindingResult bindRslt, HttpServletResponse response){
		PostClientBean postClientBean = postClientAddParam.initBean();
		postClientBean.setCreater(super.getUser().getId());
		postClientBean.setCreaterName(super.getUser().getName());
		AjaxUtils.write(response, orgManager.addPostForClient(postClientBean));
	}
	
	/**
	 * 客户机构删除注册邮局
	 */
	@RequestMapping(value = "deletePost.html", method = RequestMethod.POST)
	public void deletePost(PostClientDeleteParam postClientDeleteParam,BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, orgManager.deletePostForClient(postClientDeleteParam.initBean()));
	}
	
	/**
	 * 删除客户机构，及下属部门
	 */
	@RequestMapping(value = "deleteClient.html", method = RequestMethod.POST)
	public void deleteClient(@Valid Long clientId, HttpServletResponse response){
		AjaxUtils.write(response, orgManager.deleteClient(clientId));
	}
	
}
