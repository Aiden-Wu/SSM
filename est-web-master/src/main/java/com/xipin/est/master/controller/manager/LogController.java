package com.xipin.est.master.controller.manager;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.manager.manager.LogManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.log.LogListParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

/**
 * 
 * <p>Description: 日志控制器类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController<LogController> {
	
	@Autowired
	private LogManager logManager;
	
	@RequestMapping("/list.html")
	public ModelAndView list(ModelAndView mav){
		mav.setViewName("manager/log/manager");
		return mav;
	}
	
	/**
	 * 
	 * 方法用途: 获取日志列表<br>
	 * 实现步骤: <br>
	 * @param logListPram
	 * @param bindRslt
	 * @param response
	 */
	@RequestMapping(value = "/logList.html", method = RequestMethod.POST)
	public void queryLogList(@Valid LogListParam logListPram, BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, new JQGridPageResult<>(logManager.queryLogList(logListPram.initBean(), logListPram.initPage())));
	}
	
}
