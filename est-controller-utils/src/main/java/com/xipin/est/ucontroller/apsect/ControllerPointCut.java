package com.xipin.est.ucontroller.apsect;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.xipin.est.ucontroller.actiontype.ActionType;
import com.xipin.est.ucontroller.exception.business.BusinessJSONException;
import com.xipin.est.ucontroller.exception.business.BusinessJSONPException;
import com.xipin.est.ucontroller.exception.business.BusinessPageException;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.ucontroller.exception.param.RequestParamInvalidJSONException;
import com.xipin.est.ucontroller.exception.param.RequestParamInvalidJSONPException;
import com.xipin.est.ucontroller.exception.param.RequestParamInvalidPageException;
import com.xipin.est.ucontroller.exception.system.SystemJSONException;
import com.xipin.est.ucontroller.exception.system.SystemJSONPException;
import com.xipin.est.ucontroller.exception.system.SystemPageException;
import com.xipin.est.ucontroller.ip.RemoteIPUtil;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.param.Param;
import com.xipin.est.utils.rslt.code.ResultStatusCode;

@Component
@Aspect
public class ControllerPointCut {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CookieLocaleResolver localeResolver;
	
	@Pointcut("execution(public * com.xipin.est.*.controller..*.*(..))")
	public void controller() {
	}

	@Before("controller()")
	public void init(JoinPoint jp) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Object[] obs = jp.getArgs();
		Integer actionType = ActionType.DEFAULT.getVal();
		
		{//deal param
			Param param = this.getParam(jp);
			if(param != null){
				param.setSessionId(this.getSIDFromCookie(request));
				param.setRequestIp(RemoteIPUtil.getRemortIP(request));
				param.setLanguage(this.getLanguage(request));
			}
			
			actionType = this.getUserActionType(param, request);
			this.setActionType(param, actionType);
			log.info("=== uri === "+ request.getRequestURI());
			log.info("=== param info === " + param);
		}
		
		for (Object ob : obs) {
			if (ob instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) ob;
				if (bindingResult.hasErrors()) {
					if (actionType == ActionType.JSON.getVal()) {
						throw new RequestParamInvalidJSONException(bindingResult.getFieldError());
					}
					if (actionType == ActionType.PAGE.getVal()) {
						throw new RequestParamInvalidPageException(bindingResult.getFieldError());
					}
					if(actionType == ActionType.JSONP.getVal()){
						throw new RequestParamInvalidJSONPException(bindingResult.getFieldError());
					}
				}
			}
		}
	}

	@AfterThrowing(pointcut = "controller()", throwing="e")
	public void excption(JoinPoint jp, Exception e){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Param param = this.getParam(jp);
		Integer actionType = this.getUserActionType(param, request);
		//request.setAttribute("param", param);
		String lanuage = param == null ? this.getLanguage(request) : param.getLanguage();
		
		request.setAttribute("err", this.getMessage(e, lanuage));
		request.setAttribute("uri", request.getRequestURI());
		request.setAttribute("domain", "//TODO");
		if(e instanceof ParamException){
			log.info("=== param err === " + this.getMessage(e, lanuage));
			request.setAttribute("code", ResultStatusCode.请求参数错误.getCode());
			if(actionType.equals(ActionType.JSON.getVal())){
				throw new RequestParamInvalidJSONException(e.getMessage());
			} else if(actionType.equals(ActionType.PAGE.getVal())){
				throw new RequestParamInvalidPageException(e.getMessage());
			}else{
				throw new RequestParamInvalidJSONPException(e.getMessage());
			}
		} else if(e instanceof BusinessException){
			log.info("=== business err ===" + this.getMessage(e, lanuage));
			request.setAttribute("data", ((BusinessException) e).getData());
			request.setAttribute("code", ResultStatusCode.数据错误.getCode());
			if(actionType.equals(ActionType.JSON.getVal())){
				throw new BusinessJSONException(e.getMessage());
			} else if(actionType.equals(ActionType.PAGE.getVal())){
					throw new BusinessPageException(e.getMessage());
			}else{
				throw new BusinessJSONPException(e.getMessage());
			}
		} else {
			log.error("=== system err ===");
			log.error("", e);
			request.setAttribute("err", MsgConfig.getMessage(MsgEnum.SERVER_ERR.getVal(), lanuage));
			request.setAttribute("code", ResultStatusCode.系统错误.getCode());
			if(actionType.equals(ActionType.JSON.getVal())){
				throw new SystemJSONException(MsgConfig.getMessage(MsgEnum.SERVER_ERR.getVal(), lanuage));
			} else if(actionType.equals(ActionType.JSONP.getVal())){
				throw new SystemJSONPException("上传图片失败，可能由于图片过大!");
			}else{
				throw new SystemPageException(MsgConfig.getMessage(MsgEnum.SERVER_ERR.getVal(), lanuage));
			}
		}
	}
	
	/**
	 * To judge the user is set action type.
	 * 
	 * @param obs
	 * @return
	 */
	private Integer getUserActionType(Param param, HttpServletRequest request) {
		Integer actionType = ActionType.DEFAULT.getVal();
		if(param != null){
			actionType = param.getActionType() == null ? ActionType.DEFAULT.getVal() : param.getActionType();
		}
		// Judge the action type by the request head.
		if (actionType == ActionType.DEFAULT.getVal()) {
			if (isAjaxRequest(request)) {
				actionType = ActionType.JSON.getVal();
			} else {
				actionType = ActionType.PAGE.getVal();
			}
		}
		return actionType;
	}
	
	/**
	 * Set actionType in param
	 * @param jp
	 * @param actionType
	 */
	private void setActionType(Param param, Integer actionType){
		if(param != null){
			param.setActionType(actionType);
		}
	}

	/**
	 * Whether by the request head of the actionType;
	 * @param request
	 * @return
	 */
	private Boolean isAjaxRequest(HttpServletRequest request) {
		Boolean flag = Boolean.FALSE;
		Enumeration<String> e = request.getHeaderNames();
		
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			if (("x-requested-with").equals(name.toLowerCase())) {
				if(request.getHeader("x-requested-with") != null){
					flag = true;
					break;
				}	
			}
		}
		return flag;
	}
	
	/**
	 * 在参数中获取 Param
	 * @param jp
	 * @return
	 */
	private Param getParam(JoinPoint jp){
		Object[] obs = jp.getArgs();
		
		for (Object ob : obs) {
			if(ob instanceof Param){
				return ((Param)ob);
			}
		}
		return null;
	}
	
	private String getSIDFromCookie(HttpServletRequest request){
		String cookieVal = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length != 0){
			for(Cookie cookie : cookies){
				if("estSid".equals(cookie.getName())){
					cookieVal = cookie.getValue();
				}
			}
		}
		return cookieVal;
	}
	
	private String getLanguage(HttpServletRequest request){
		String cookieVal = "zh-CN";
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length != 0){
			for(Cookie cookie : cookies){
				if("Language".equals(cookie.getName()) && !StringUtils.isEmpty(cookie.getValue())){
					cookieVal = cookie.getValue();
				}
			}
		}
		return cookieVal;
	}
	
	private String getMessage(Exception e, String lanuage){
		return MsgConfig.getMessage(e.getMessage(), lanuage);
	}
}
