package com.xipin.est.master.controller.post;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.post.PostManager;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.StringParam;
import com.xipin.est.master.param.post.DetailListListParam;
import com.xipin.est.master.param.post.InputCN35Param;
import com.xipin.est.master.param.post.InputCN38Param;
import com.xipin.est.master.param.post.InputWeightParam;
import com.xipin.est.master.param.post.PackageListParam;
import com.xipin.est.model.PostOfficeEnName;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.ucontroller.excel.ExcelExportUtil;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.param.Param;
import com.xipin.est.utils.rslt.type.JQGridPageResult;

/**
 * 
 * <p>Description: 邮局业务控制器</p>
 * @date 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController<PostController> {

	@Autowired
	private PostManager postManager;

	@Autowired
	private OrgManager orgManager;

	/**
	 * 误差值范围
	 */
	private static final double ERROR_RANGE = 0.2;

	@RequestMapping("/pendingList.html")
	public ModelAndView toPendingList(ModelAndView mav) {
		mav.addObject("rslt", JSONObject.fromObject(orgManager.getJGByUserIdP(getUser().getId())));
		mav.addObject("errorRange", ERROR_RANGE);
		mav.setViewName("post/pending/list");
		return mav;
	}

	@RequestMapping("/doingList.html")
	public ModelAndView toDoingList(ModelAndView mav) {
		mav.addObject("rslt", JSONObject.fromObject(orgManager.getJGByUserIdP(getUser().getId())));
		mav.addObject("errorRange", ERROR_RANGE);
		mav.setViewName("post/doing/list");
		return mav;
	}

	@RequestMapping("/finishList.html")
	public ModelAndView toFinishList(ModelAndView mav) {
		mav.addObject("rslt", JSONObject.fromObject(orgManager.getJGByUserIdP(getUser().getId())));
		mav.addObject("errorRange", ERROR_RANGE);
		mav.setViewName("post/finish/list");
		return mav;
	}

	@RequestMapping("/finishDetail.html")
	public ModelAndView toFinishDetail(ModelAndView mav) {
		mav.addObject("errorRange", ERROR_RANGE);
		mav.setViewName("post/finish/detail");
		return mav;
	}

	@RequestMapping("/allList.html")
	public ModelAndView toAllList(ModelAndView mav) {
		mav.addObject("rslt", JSONObject.fromObject(orgManager.getJGByUserIdP(getUser().getId())));
		mav.addObject("errorRange", ERROR_RANGE);
		mav.setViewName("post/all/list");
		return mav;
	}

	/**
	 * 
	 * 方法用途: 获取待处理列表<br>
	 */
	@RequestMapping(value = "/list/pending.html", method = RequestMethod.POST)
	public void pendinglist(@Valid DetailListListParam detailListListParam, BindingResult bindRslt, HttpServletResponse response) {
		UserPo user = getUser();
		detailListListParam.setMeId(user.getId());
		detailListListParam.setPostofficeEnName(PostOfficeEnName.选择.getEnName(user.getPid()));
		AjaxUtils.write(response, new JQGridPageResult<>(postManager.queryPendingTaskList(detailListListParam.initBean(), detailListListParam.initPage())));
	}

	/**
	 * 
	 * 方法用途: 获取处理中列表<br>
	 */
	@RequestMapping(value = "/list/doing.html", method = RequestMethod.POST)
	public void doinglist(@Valid DetailListListParam detailListListParam, BindingResult bindRslt, HttpServletResponse response) {
		UserPo user = getUser();
		detailListListParam.setMeId(user.getId());
		detailListListParam.setPostofficeEnName(PostOfficeEnName.选择.getEnName(user.getPid()));
		AjaxUtils.write(response, new JQGridPageResult<>(postManager.queryDoingTaskList(detailListListParam.initBean(), detailListListParam.initPage())));
	}

	/**
	 * 
	 * 方法用途: 获取已完成列表<br>
	 */
	@RequestMapping(value = "/list/finish.html", method = RequestMethod.POST)
	public void finishList(@Valid DetailListListParam detailListListParam, BindingResult bindRslt, HttpServletResponse response) {
		UserPo user = getUser();
		detailListListParam.setMeId(user.getId());
		detailListListParam.setPostofficeEnName(PostOfficeEnName.选择.getEnName(user.getPid()));
		AjaxUtils.write(response, new JQGridPageResult<>(postManager.queryFinishTaskList(detailListListParam.initBean(), detailListListParam.initPage())));
	}

	/**
	 * 
	 * 方法用途: 获取清单总览列表<br>
	 */
	@RequestMapping(value = "/list/query.html", method = RequestMethod.POST)
	public void querylist(@Valid DetailListListParam detailListListParam, BindingResult bindRslt, HttpServletResponse response) {
		UserPo user = getUser();
		detailListListParam.setMeId(user.getId());
		detailListListParam.setPostofficeEnName(PostOfficeEnName.选择.getEnName(user.getPid()));
		AjaxUtils.write(response, new JQGridPageResult<>(postManager.queryTaskList(detailListListParam.initBean(), detailListListParam.initPage())));
	}

	/**
	 * 
	 * 方法用途: 获取邮包列表<br>
	 */
	@RequestMapping(value = "/package.html", method = RequestMethod.POST)
	public void packageList(@Validated(Param.Delete.class) PackageListParam packageListParam, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(postManager.queryPackageList(packageListParam.initBean(), packageListParam.initPage())));
	}

	/**
	 * 
	 * 方法用途: 批量录入重量<br>
	 */
	@RequestMapping(value = "/inputWeigt.html", method = RequestMethod.POST)
	public void inputWeight(@Valid InputWeightParam inputWeightParam, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, postManager.inputWeight(inputWeightParam.initBean()));
	}

	/**
	 * 
	 * 方法用途: 批量录入CN35<br>
	 */
	@RequestMapping(value = "/inputCN35.html", method = RequestMethod.POST)
	public void inputCN35(@Valid InputCN35Param inputCN35Param, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, postManager.inputCN35(inputCN35Param.initBean()));
	}

	/**
	 * 
	 * 方法用途: 录入CN38<br>
	 */
	@RequestMapping(value = "/inputCN38.html", method = RequestMethod.POST)
	public void inputCN38(@Valid InputCN38Param inputCNParam, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, postManager.inputCN38(inputCNParam.initBean()));
	}

	/**
	 * 
	 * 方法用途: 导出包裹列表<br>
	 */
	@RequestMapping(value = "/exportExcel.html", method = RequestMethod.GET)
	public void exportExcel(@Valid PackageListParam packageListParam, BindingResult bindRslt, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String language = getLanguage();
		Map<String, Object> beanParams = postManager.queryPackageExportData(packageListParam.initBean());
		String templateName = "bag_weight_detail_zh.xls";
//		String fileName = "邮袋重量详情表";
		String fileName = MsgConfig.getMessage(MsgEnum.c_bag_weight_details_list.getVal(), language);
		if ("en_US".equals(language)) {
			templateName = "bag_weight_detail_en.xls";
		}
		ExcelExportUtil.exportExcel(request, response, templateName, fileName, beanParams);
	}

	/**
	 * 
	 * 方法用途: 是否可以录入CN35<br>
	 */
	@RequestMapping(value = "/isInputCN35.html", method = RequestMethod.POST)
	public void isInputCN35(@Valid StringParam dispatchNo, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, postManager.isInputCN35(dispatchNo.getStr()));
	}

	/**
	 * 
	 * 方法用途: 是否可以录入CN38<br>
	 */
	@RequestMapping(value = "/isInputCN38.html", method = RequestMethod.POST)
	public void isInputCN38(@Valid StringParam dispatchNo, BindingResult bindRslt, HttpServletResponse response) {
		AjaxUtils.write(response, postManager.isInputCN38(dispatchNo.getStr()));
	}

}
