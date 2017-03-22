package com.xipin.est.master.controller.manager;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.manager.manager.CountryManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.IDParam;
import com.xipin.est.master.param.country.CountryListParam;
import com.xipin.est.master.param.country.CountryAddParam;
import com.xipin.est.master.param.country.CountryUpdateParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

/**
 * 
 * <p>Description: 国家二字代码控制器类</p>
 * @date 2016年5月16日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Controller
@RequestMapping("/country")
public class CountryController extends BaseController<CountryController> {
	
	@Autowired
	private CountryManager countryManager;
	
	@RequestMapping("/list.html")
	public ModelAndView country(ModelAndView mav){
		mav.setViewName("manager/code/country");
		return mav;
	}
	
	/**
	 * 
	 * 方法用途: 获取国家二字代码列表<br>
	 * 实现步骤: <br>
	 * @param countryListPram
	 * @param bindRslt
	 * @param response
	 */
	@RequestMapping(value = "/countryList.html", method = RequestMethod.POST)
	public void queryCountryList(@Valid CountryListParam countryListPram, BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, new JQGridPageResult<>(countryManager.queryCountryList(countryListPram.initBean(), countryListPram.initPage())));
	}
	
	/**
	 * 
	 * 方法用途: 添加国家代码<br>
	 * 实现步骤: <br>
	 * @param countryParam
	 */
	@RequestMapping(value = "/countryAdd.html", method = RequestMethod.POST)
	public void addCountry(@Valid CountryAddParam countryAddParam, HttpServletResponse response){
		AjaxUtils.write(response, countryManager.addCountry(countryAddParam.initBean()));
	}
	
	/**
	 * 
	 * 方法用途: 删除国家代码<br>
	 * 实现步骤: <br>
	 * @param idParam
	 */
	@RequestMapping(value = "/countryDelete.html", method = RequestMethod.POST)
	public void deleteCountry(@Valid IDParam idParam, HttpServletResponse response){
		AjaxUtils.write(response, countryManager.deleteCountry(idParam.initBean()));
	}
	
	/**
	 * 
	 * 方法用途: 更新国家代码<br>
	 * 实现步骤: <br>
	 * @param countryUpdateParam
	 */
	@RequestMapping(value = "/countryUpdate.html", method = RequestMethod.POST)
	public void updateCountry(@Valid CountryUpdateParam countryUpdateParam, HttpServletResponse response){
		AjaxUtils.write(response, countryManager.updateCountry(countryUpdateParam.initBean()));
	}
	
}
