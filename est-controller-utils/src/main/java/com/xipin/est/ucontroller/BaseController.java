package com.xipin.est.ucontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xipin.est.ucontroller.ip.RemoteIPUtil;

public class BaseController<T> {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	protected final static String USER_INFO = "user_info";
	
	/**
	 * 添加session
	 * @param key
	 * @param obj
	 */
	protected void addSession(String key, Object obj) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(key, obj);
		Integer.valueOf(1);
	}
	
	/**
	 * 获取session值
	 * @param key
	 * @return
	 */
	protected Object getFromSession(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return session.getAttribute(key);
	}
	/**
	 * 移除session
	 * @param key
	 */
	protected void removeSession(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute(key);
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
	
}
