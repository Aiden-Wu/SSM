package com.xipin.est.master.controller.post;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.org.OrgParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

/**
 * 邮局信息
 * @author lvjl
 *
 */
@Controller
@RequestMapping("/postInfo/")
public class PostInfoController extends BaseController<PostInfoController> {
	
	@Autowired
	private OrgManager orgManager;
	
	/**
	 * 邮局列表
	 */
	@RequestMapping(value = "postList.html", method = RequestMethod.POST)
	public void postList(OrgParam orgParam,BindingResult bindRslt,HttpServletResponse response){
		OrgBean orgBean = new OrgBean();
		orgBean.setType(Constants.ORG_TYPE_POST);//类别-客户
		orgBean.setLevel(Constants.ORG_LEVEL_TWO);//级别-机构
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryListByBiz(orgBean, orgParam.initPage())));
	}
	
	/**
	 * 邮局机构列表
	 */
	@RequestMapping(value = "postOrgList.html", method = RequestMethod.POST)
	public void postOrgList(OrgParam orgParam,BindingResult bindRslt, HttpServletResponse response){
		OrgBean orgBean = new OrgBean();
		orgBean.setParentId(orgParam.getId());
		orgBean.setType(Constants.ORG_TYPE_POST);//类别-邮局
		orgBean.setLevel(Constants.ORG_LEVEL_THREE);//级别-部门
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryListByBiz(orgBean, orgParam.initPage())));
	}
	
	/**
	 * 注册邮局
	 */
	@RequestMapping(value = "addPost.html", method = RequestMethod.POST)
	public void addPost(OrgParam orgParam,BindingResult bindRslt, HttpServletResponse response){
		orgParam.setType(Constants.ORG_TYPE_POST);
		orgParam.setLevel(Constants.ORG_LEVEL_TWO);
		orgParam.setParentId((long)3);//3-邮局id
		AjaxUtils.write(response, orgManager.add(orgParam.initBean()));
	}
	
	/**
	 * 注册邮局部门
	 */
	@RequestMapping(value = "addOrgPost.html", method = RequestMethod.POST)
	public void addOrgPost(OrgParam orgParam,BindingResult bindRslt, HttpServletResponse response){
		orgParam.setType(Constants.ORG_TYPE_POST);
		orgParam.setLevel(Constants.ORG_LEVEL_THREE);
		AjaxUtils.write(response, orgManager.add(orgParam.initBean()));
	}
	
	/**
	 * 更新邮局信息
	 */
	@RequestMapping(value = "updatePost.html", method = RequestMethod.POST)
	public void updatePost(@Valid OrgParam orgParam,BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, orgManager.update(orgParam.initBean()));
	}
	
	/**
	 * 删除邮局
	 */
	@RequestMapping(value = "deletePost.html", method = RequestMethod.POST)
	public void deletePost(@NotNull Long postId, HttpServletResponse response){
		AjaxUtils.write(response, orgManager.deletePost(postId));
	}

}
