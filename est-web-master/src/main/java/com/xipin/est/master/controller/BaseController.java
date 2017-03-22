package com.xipin.est.master.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.ucontroller.ip.RemoteIPUtil;
import com.xipin.est.utils.comm.StringUtils;

public class BaseController<T> {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	protected final static String USER_INFO = "user_info";
	
	@Autowired
	private ICommStringCache iCommStringCache;
	
	/**
	 * 添加session
	 * @param key
	 * @param obj
	 */
	protected void addSession(String key, Object obj) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		HttpSession session = request.getSession();
		session.setAttribute(key, obj);
		//存入redis
		
		iCommStringCache.set(key, JSON.toJSONString(obj), 7200l);
		{
			Cookie sessionIdKey = new Cookie("estSid", key);
			sessionIdKey.setPath("/");
			response.addCookie(sessionIdKey);
		}
	}
	
	protected String getDomain(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getRequestURL().toString().split("/")[2];
		
	}
	
	/**
	 * 获取session值
	 * @param key
	 * @return
	 */
	protected Object getFromSession(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		
		Object obj = null;
		obj = session.getAttribute(key);
		if(obj == null){
			obj = iCommStringCache.get(key);
			if(obj instanceof String){
				return StringUtils.delJsonFromRedis((String)obj);
			}
		}
		return obj;
	}
	
	/**
	 * 移除session
	 * @param key
	 */
	protected void removeSession(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute(key);
		
		//删除redis值
		iCommStringCache.delete(key);
	}
	/**
	 * 获取请求ip
	 */
	protected String getRemoteIp(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = RemoteIPUtil.getRemortIP(request);
		return ip;
	}
	
	protected boolean checkToken(String key, String clientToken){
		String serverToken = this.getFromSession(key) + "";
		if(StringUtils.isEmpty(serverToken) || StringUtils.isEmpty(clientToken)){
			return false;
		}
		if(serverToken.equals(clientToken)){
			return true;
		}
		return false;
	}
	
	protected boolean checkTokenExpire(String key, long time){
		String val = this.getFromSession(key) + "";
		try{
			if(System.currentTimeMillis() - Long.parseLong(val) > time){
				return false;
			}
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	protected String getLanguage(){
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String cookieVal = "zh_CN";
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length != 0){
			for(Cookie cookie : cookies){
				if("Language".equals(cookie.getName())){
					cookieVal = cookie.getValue();
				}
			}
		}
		
		return cookieVal;
	}
	
	protected UserPo getUser(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String cookieVal = null;
		UserPo userPo = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length != 0){
			for(Cookie cookie : cookies){
				if("estSid".equals(cookie.getName())){
					cookieVal = cookie.getValue();
				}
			}
		}else{
			this.toLogin();
		}
		
		String cacheStr = (String) this.getFromSession(cookieVal);
//		if(cacheStr.length() > 2){
//			cacheStr = StringUtils.reDealQuot(cacheStr);
//			cacheStr = cacheStr.substring(1, cacheStr.length() - 1);
//		}
		if(StringUtils.isEmpty(cacheStr)){
			this.toLogin();
		}
		try{
			userPo = JSON.parseObject(cacheStr, UserPo.class);
		} catch(Exception e){
			this.toLogin();
		}
		
		if(userPo == null || userPo.getId() == null){
			this.toLogin();
		}
		
		return userPo;
		
	}
	
	//XXX
	private void toLogin(){
//		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//		try {
//			response.sendRedirect("/toLogin.html");
//			throw new BusinessException("您还未登录");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
}
