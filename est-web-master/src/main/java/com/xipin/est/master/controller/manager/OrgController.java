package com.xipin.est.master.controller.manager;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.IDPageParam;
import com.xipin.est.master.param.IDParam;
import com.xipin.est.master.param.StringParam;
import com.xipin.est.master.param.org.DepartAddParam;
import com.xipin.est.master.param.org.DepartListParam;
import com.xipin.est.master.param.org.OrgListParam;
import com.xipin.est.master.param.org.OrgParam;
import com.xipin.est.master.param.org.PostListParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.param.Param.Insert;
import com.xipin.est.utils.param.Param.Update;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

/**
 * 
 * <p>Description: 机构控制器</p>
 * @date 2016年5月20日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Controller
@RequestMapping("/org")
public class OrgController extends BaseController<OrgController> {

	@Autowired
	private OrgManager orgManager;

	@RequestMapping("/post/basic.html")
	public ModelAndView postBasic(ModelAndView mav) {
		mav.addObject("userType", super.getUser().getUserType());
		mav.setViewName("manager/post/basic");
		return mav;
	}

	@RequestMapping("/post/depart.html")
	public ModelAndView postDepart(@Valid StringParam param, BindingResult bindRslt, ModelAndView mav) {
		String postId = param.getStr();
		if (StringUtils.isEmpty(postId)) {
			postId = "-1";
		}
		mav.setViewName("manager/post/depart");
		mav.addObject("postId", postId);
		mav.addObject("userType", super.getUser().getUserType());
		return mav;
	}

	@RequestMapping("/list.html")
	public ModelAndView toDoingList(ModelAndView mav) {
		mav.setViewName("manager/org/org");
		return mav;
	}

	/**
	 * 
	 * 方法用途: 获取邮局列表<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/post/list.html", method = RequestMethod.POST)
	public void queryPostList(@Valid PostListParam param, BindingResult bindRslt, HttpServletResponse response) {

		OrgBean orgBean = param.initBean();
		orgBean.setUserId(super.getUser().getId());
		orgBean.setOrgId(super.getUser().getOrgId());
		orgBean.setUserType(super.getUser().getUserType());

		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryPostList(orgBean, param.initPage())));
	}

	/**
	 * 
	 * 方法用途: 获取部门列表<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/depart/list.html", method = RequestMethod.POST)
	public void queryDepartList(@Valid DepartListParam param, BindingResult bindRslt, HttpServletResponse response) {

		OrgBean orgBean = param.initBean();
		orgBean.setUserId(super.getUser().getId());
		orgBean.setUserType(super.getUser().getUserType());
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryDepartList(orgBean, param.initPage())));

	}

	/**
	 * 
	 * 方法用途: 添加部门<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/depart/add.html", method = RequestMethod.POST)
	public void addDepart(@Valid DepartAddParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.add(param.initBean())));
	}

	/**
	 * 
	 * 方法用途: 新增机构<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public void add(@Validated({ Insert.class }) OrgParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.add(param.initBean())));
	}

	/**
	 * 
	 * 方法用途: 修改机构<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/update.html", method = RequestMethod.POST)
	public void update(@Validated({ Update.class }) OrgParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.update(param.initBean())));
	}

	/**
	 * 
	 * 方法用途: 删除机构<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/delete.html", method = RequestMethod.POST)
	public void delete(@Valid IDParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.delete(param.initBean())));
	}

	@RequestMapping(value = "/getPostOfficeByClientId.html", method = RequestMethod.POST)
	public void getPostOfficeByClientId(@Valid IDPageParam param, BindingResult bindRslt, HttpServletResponse response) {

		PostClientBean postClientBean = new PostClientBean();
		postClientBean.setClientId(param.getId());
		// AjaxUtils.write(response, new
		// JQGridPageResult<>(orgManager.getPostClientPoByClientId(postClientBean)));
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.getPostClientPo(param.initPage(), postClientBean)));

	}

	/**
	 * 
	 * 方法用途: 查询机构<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/query.html", method = RequestMethod.POST)
	public void query(@Valid OrgListParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryOrgList(param.initBean(), param.initPage())));
	}

	/**
	 * 
	 * 方法用途: 获取编号<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/queryNo.html", method = RequestMethod.POST)
	public void queryNo(@Valid IDParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(orgManager.queryNo(param.getId())));
	}

	@RequestMapping(value = "/deletePostClientById.html", method = RequestMethod.POST)
	public void deletePostClientById(@Valid IDParam param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, orgManager.deletePostClientById(param.initBean()));
	}

}
