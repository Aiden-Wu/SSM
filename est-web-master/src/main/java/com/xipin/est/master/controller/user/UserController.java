package com.xipin.est.master.controller.user;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.inf.UserManager;
import com.xipin.est.manager.resources.UserResourcesManager;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.IDParam;
import com.xipin.est.master.param.user.ResetPasswordParam;
import com.xipin.est.master.param.user.UpdatePasswordParam;
import com.xipin.est.master.param.user.UserAddParam;
import com.xipin.est.master.param.user.UserLoginParam;
import com.xipin.est.master.param.user.UserUpdateParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.rslt.type.JQGridPageResult;
import com.xipin.est.utils.rslt.type.Result;

@Controller
@RequestMapping("/")
public class UserController extends BaseController<UserController>{
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private ICommStringCache iCommStringCache;
	
	@Autowired
	private UserResourcesManager userResourcesManager;

	@Autowired
	private OrgManager orgManager;
	
	@RequestMapping("/toLogin.html")
	public ModelAndView toLogin(ModelAndView mav){
//		iCommStringCache.delete(RedisConstant.LOT_NUM_SET);
//		iCommStringCache.delete(RedisConstant.REF_ID_SET);
//		iCommStringCache.delete(RedisConstant.BAG_NO_SET);
//		iCommStringCache.delete(RedisConstant.SEAL_NO_SET);
		
//		String a = iCommStringCache.get(RedisConstant.LOT_NUM_SET);
//		String b = iCommStringCache.get(RedisConstant.REF_ID_SET);
//		String c = iCommStringCache.get(RedisConstant.BAG_NO_SET);
		
		
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/main.html")
	public ModelAndView toMain(ModelAndView mav){
		mav.setViewName("main");
		UserPo user = super.getUser();
		mav.addObject(Constants.USER_INFO, user);
		return mav;
	}
	
	@RequestMapping("/welcome.html")
	public ModelAndView toWelcome(ModelAndView mav){
		mav.setViewName("welcome");
		return mav;
	}
	
	@RequestMapping(value="/login.html", method=RequestMethod.POST)
	public void login(@Valid UserLoginParam param, BindingResult bRstl, HttpServletResponse response){
	    Result<UserPo> result=userManager.login(param.initBean());
	    String cookieID = result.getData().getSessionId();
	    
	    UserPo cacheUserPo = new UserPo();
	    cacheUserPo.setId(result.getData().getId());
	    cacheUserPo.setName(result.getData().getName());
	    cacheUserPo.setUsername(result.getData().getUsername());
	    cacheUserPo.setTitle(result.getData().getTitle());
	    cacheUserPo.setUserType(result.getData().getUserType());
	    cacheUserPo.setOrgId(result.getData().getOrgId());
	    {
	    	OrgPo po = orgManager.get(result.getData().getOrgId());
	    	cacheUserPo.setPid(po.getParentId());
	    }
	    //存入session
	    this.addSession(cookieID, JSON.toJSONString(cacheUserPo));
	    
	    List<String> resources = userResourcesManager.getResourcesPoListByUserId(cacheUserPo.getId());
	    iCommStringCache.set("resource_user_"+cacheUserPo.getId(), JSONArray.fromObject(resources).toString(), 7200l);
		AjaxUtils.write(response, result);
		
	}
	
	@RequestMapping(value="/logOut.html", method=RequestMethod.GET)
	public void quit(HttpServletRequest request,HttpServletResponse response){
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length != 0){
			for(Cookie cookie : cookies){
				if("estSid".equals(cookie.getName())){
					this.removeSession(cookie.getValue());
				}
			}
		}
		AjaxUtils.write(response, "1");
	}
	
	
	@RequestMapping(value="/user/resetPassword.html", method=RequestMethod.POST)
	public void resetPassword(@Valid ResetPasswordParam param, BindingResult bRstl, HttpServletResponse response){
		AjaxUtils.write(response, userManager.modifyPassword(param.initBean()));
	}
	
	/**
	 * 
	 * 方法用途: 修改密码<br>
	 * 实现步骤: <br>
	 * @param param
	 * @param bRstl
	 * @param response
	 */
	@RequestMapping(value="/user/updatePwd.html", method=RequestMethod.POST)
	public void updatePwd(@Valid UpdatePasswordParam param, BindingResult bRstl, HttpServletResponse response){
		AjaxUtils.write(response, userManager.updatePassword(param.initBean()));
	}
	
	@RequestMapping(value="/user/add.html", method=RequestMethod.POST)
	public void add(@Valid UserAddParam param, BindingResult bRstl, HttpServletResponse response){
		AjaxUtils.write(response, userManager.register(param.initBean()));
	}
	
	@RequestMapping(value="/user/del.html", method=RequestMethod.POST)
	public void del(@Valid IDParam idParam, BindingResult bRstl, HttpServletResponse response){
		AjaxUtils.write(response, userManager.deleteUser(idParam.initBean()));
	}
	
	@RequestMapping(value="user/update.html", method=RequestMethod.POST)
	public void update(@Valid UserUpdateParam param, BindingResult bRstl, HttpServletResponse response){
		AjaxUtils.write(response, userManager.updateUser(param.initBean()));
	}
	
	@RequestMapping(value="/user/query.html", method=RequestMethod.POST)
	public void query(@Valid UserLoginParam param, BindingResult bRstl, HttpServletResponse response){
		param.setStatus((byte)1);
		Result<List<UserPo>> list=userManager.queryListByBiz(param.initBean(),param.initPage());
		AjaxUtils.write(response,new JQGridPageResult<>(list));
	}
}
