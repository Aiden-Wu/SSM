package com.xipin.est.master.controller.resources;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.inf.UserManager;
import com.xipin.est.manager.resources.UserResourcesManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.ucontroller.ajax.AjaxUtils;

/**
 * 权限controller
 * @author JiaJia.Song 
 * @date May 16, 2016 11:36:06 AM
 */
@Controller
@RequestMapping("/resources")
public class UserResourcesController extends BaseController<UserResourcesController> {
	
	@Resource
	private UserManager userManager;
	
	@Resource
	private UserResourcesManager userResourcesManager;
	
	@RequestMapping("/list.html")
	public ModelAndView toDoingList(ModelAndView mav) {
		mav.setViewName("manager/org/auth");
		return mav;
	}
	
	/**
	 * 修改用户权限
	 * @param userId
	 * @param resourcesIds  用户所有权限放入一个数组中
	 * @param response    
	 * @return void    返回类型
	 * @throws Exception 
	 *
	 */
	@RequestMapping(value = "/update.html")
	public void add(@NotNull Long userId,@NotNull Long[] resourcesIds,HttpServletResponse response) throws Exception{
     	AjaxUtils.write(response, userResourcesManager.update(userId,resourcesIds));
	}
	
	/**
	 * 查询权限目录树
	 * @param userId
	 * @param response
	 * @throws Exception    
	 * @return void    返回类型
	 *
	 */
	@RequestMapping(value = "/query.html")
	public void query(Long userId,HttpServletResponse response) throws Exception{
		AjaxUtils.write(response,userResourcesManager.queryResourceTreeByUser(userId));
	}
	
	/**
	 * 查询目录树
	 * @param userId
	 * @param response
	 * @throws Exception    
	 * @return void    返回类型
	 *
	 */
	@RequestMapping(value = "/menu.html")
	public void menu(HttpServletResponse response) throws Exception{
		UserPo user = getUser();
		AjaxUtils.write(response,userResourcesManager.queryMenu(user.getId()));
	}
	
}
