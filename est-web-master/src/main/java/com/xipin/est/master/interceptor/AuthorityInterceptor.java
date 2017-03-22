package com.xipin.est.master.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.resources.UserResourcesManager;
import com.xipin.est.ucontroller.ip.RemoteIPUtil;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.rslt.code.ResultStatusCode;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private UserResourcesManager userResourcesManager;
	
	@Autowired
	private ICommStringCache iCommStringCache;

	private final Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String code=""; //错误代码
		String url = request.getRequestURI();
		String proName = request.getContextPath();
		url = url.substring(url.indexOf(proName) + proName.length());
		if (url == null) {
			log.info("非法请求:" + url);
			log.info("请求者IP:" + RemoteIPUtil.getRemortIP(request));
			code= ResultStatusCode.非法请求.getCode();
		}
		String[] notFilter = new String[] {"/login.html","/toLogin.html","/user/updatePwd.html","/i18n/switchLanguage.html","/resources/menu.html","/logOut.html", "/welcome.html"};  // 不拦截的uri
        for (String s : notFilter) {
            if (url.equals(s)) {
            	return true;
            }
        }
		if("".equals(code)){
			//session校验
	        // 请求的uri
			UserPo user=new UserPo();
			Cookie[] cookers =request.getCookies();
			if(cookers==null ||cookers.length==0){
				code= ResultStatusCode.登录超时.getCode();
			}else{
				for (Cookie cookie : cookers) {
					if("estSid".equals(cookie.getName())){
						String value=iCommStringCache.get(cookie.getValue());
						if(value!=null &&value.length()>0){
							user =JSON.parseObject(StringUtils.delJsonFromRedis(value), UserPo.class);
							iCommStringCache.expire(cookie.getValue(), 7200l);
						}
					}
				}
				if(user.getId()==null){
					code= ResultStatusCode.登录超时.getCode();
				}
			}
			if("".equals(code)){
				//权限校验
				String resourcesString = iCommStringCache.get("resource_user_"+user.getId());
				if(StringUtils.isEmpty(resourcesString)){
					toLogin(request, response);
					return false;
				}else if (!JSONArray.fromObject(resourcesString).contains(url)){
					toLogin(request, response);
					System.out.println("==========无权限============="+url);
					return false;
				}
			}
		}
		if(!"".equals(code)){  //请求无法通过拦截器
			toLogin(request, response);
			return false;
		}
		return true;
	}


	private void toLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (this.isAjaxRequest(request)) {
			response.setContentType("text/javascript;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("<html><script>window.location.href='/toLogin.html';</script></html>");
			out.flush();
			out.close(); 
		} else {
			response.sendRedirect("/toLogin.html");
		}
	}
	

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	private Boolean isAjaxRequest(HttpServletRequest request) {
		Boolean flag = Boolean.FALSE;
		Enumeration<String> e = request.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			if (("x-requested-with").equals(name.toLowerCase())) {
				if (request.getHeader("x-requested-with") != null) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

}
