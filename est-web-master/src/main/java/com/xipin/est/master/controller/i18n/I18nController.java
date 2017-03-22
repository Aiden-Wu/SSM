package com.xipin.est.master.controller.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.xipin.est.master.controller.BaseController;


@Controller
@RequestMapping("/i18n")
public class I18nController extends BaseController<I18nController>{
	
	@Autowired
	private CookieLocaleResolver localeResolver;
	
	@RequestMapping("/switchLanguage.html")
	public ModelAndView language(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="langType", defaultValue="zh") String langType){
		
		langType=langType.toLowerCase();
		if(langType==null||langType.equals("")){
			return new ModelAndView("redirect:/main.html");
		}else{
			if(langType.equals("zh")){
				Locale locale = new Locale("zh", "CN"); 
				localeResolver.setLocale(request, response, locale );
			}else if(langType.equals("en")){
				Locale locale = new Locale("en", "US"); 
				localeResolver.setLocale(request, response, locale );
			}else{
				localeResolver.setLocale(request, response, Locale.CHINA );
			}
		}
		
		return new ModelAndView("redirect:/toLogin.html");
	}
	

}
