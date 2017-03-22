package com.xipin.est.master.controller.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.db.po.org.OrgListPo;
import com.xipin.est.manager.manager.TrunkingLineManager;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.IDParam;
import com.xipin.est.master.param.manager.AddTrunkingLineParam;
import com.xipin.est.master.param.manager.TrunkingLineParam;
import com.xipin.est.master.param.manager.UpdateTrunkingLineParam;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

@Controller
@RequestMapping("/estmanager")
public class ManagerController extends BaseController<ManagerController>{
	
	@Autowired
	private TrunkingLineManager trunkingLineManager;
	
	@Autowired
	private OrgManager orgManager;
	
	
	@RequestMapping("/org.html")
	public ModelAndView orgManager(ModelAndView mav){
		mav.setViewName("manager/org/org");
		return mav;
	}
	
	@RequestMapping("/user.html")
	public ModelAndView userManager(ModelAndView mav){
		mav.setViewName("manager/org/user");
		return mav;
	}
	
	@RequestMapping("/auth.html")
	public ModelAndView authManager(ModelAndView mav){
		mav.setViewName("manager/org/auth");
		return mav;
	}
	
	@RequestMapping("/dataAuth.html")
	public ModelAndView dataAuthManager(ModelAndView mav){
		mav.setViewName("manager/org/dataAuth");
		return mav;
	}
	
	@RequestMapping("/client/basic.html")
	public ModelAndView clientBasic(ModelAndView mav){
		
		UserPo userPo = super.getUser();
		OrgListPo  orgListPo = orgManager.getOrgPoListByUserId(userPo.getId());
		mav.addObject("orgListPo", orgListPo);
		
		mav.addObject("userType", super.getUser().getUserType());
		
		//获取邮局
		List<OrgPo> orgPoList = orgManager.getOrgForPostoffice();
		mav.addObject("orgPoList", orgPoList);
		mav.setViewName("manager/client/basic");
		return mav;
	}
	
	@RequestMapping("/log.html")
	public ModelAndView log(ModelAndView mav){
		mav.setViewName("manager/log/manager");
		return mav;
	}
	
	@RequestMapping(value="/getTrunkingLine.html", method = RequestMethod.POST)
	public void getTrunkingLine(@Valid TrunkingLineParam trunkingLineParam,BindingResult bindRslt,
			HttpServletResponse response) throws Exception{
		AjaxUtils.write(response, new JQGridPageResult<>(trunkingLineManager.getTrunkingLine(trunkingLineParam.initBean(), trunkingLineParam.initPage())));
	}
	
	@RequestMapping(value="/addTrunkingLine.html", method = RequestMethod.POST)
	public void addTrunkingLine(@Valid AddTrunkingLineParam addTrunkingLineParam,BindingResult bindRslt,
			HttpServletResponse response,HttpServletRequest request) throws Exception{
		
		UserPo userPo = super.getUser();
		TrunkingLineBean trunkingLineBean = addTrunkingLineParam.initBean();
		trunkingLineBean.setCreateName(userPo.getUsername());
		trunkingLineBean.setCreater(BigDecimal.valueOf(userPo.getId()));
		trunkingLineBean.setCreateDate(new Date());
		
		AjaxUtils.write(response, trunkingLineManager.addTrunkingLine(trunkingLineBean));
	}
	
	@RequestMapping(value="/updateTrunkingLine.html", method = RequestMethod.POST)
	public void updateTrunkingLine(@Valid UpdateTrunkingLineParam updateTrunkingLineParam,BindingResult bindRslt,
			HttpServletResponse response) throws Exception{
		AjaxUtils.write(response, trunkingLineManager.updateTrunkingLine(updateTrunkingLineParam.initBean()));
	}
	
	@RequestMapping(value="/deleteTrunkingLine.html", method = RequestMethod.GET)
	public void deleteTrunkingLine(IDParam param, HttpServletResponse response) throws Exception{
		AjaxUtils.write(response, trunkingLineManager.deleteTrunkingLine(param.initBean()));
	}
	
}
