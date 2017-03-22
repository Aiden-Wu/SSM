package com.xipin.est.master.controller.client;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.bean.UploadExcelBean;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.manager.client.ClientManager;
import com.xipin.est.manager.manager.TrunkingLineManager;
import com.xipin.est.master.controller.BaseController;
import com.xipin.est.master.param.IDParam;
import com.xipin.est.master.param.StringParam;
import com.xipin.est.master.param.client.DetailListDeleteParam;
import com.xipin.est.master.param.client.DetailListParam;
import com.xipin.est.master.param.client.DetailListSubmitParam;
import com.xipin.est.master.param.client.DetailListUpdateParam;
import com.xipin.est.master.param.client.PackageUpdateParam;
import com.xipin.est.master.param.client.UploadExcelParam;
import com.xipin.est.master.param.post.ClientPackageListParam;
import com.xipin.est.service.impl.item.check.PostOfficeStaticRuleEnum;
import com.xipin.est.service.vo.excel.check.CheckResultDataVO;
import com.xipin.est.ucontroller.ajax.AjaxUtils;
import com.xipin.est.ucontroller.excel.ExcelExportUtil;
import com.xipin.est.ucontroller.excel.ExcelImportXLSUtil;
import com.xipin.est.ucontroller.excel.ExcelImportXLSXUtil;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.rslt.type.JQGridPageResult;
import com.xipin.est.utils.rslt.type.Result;

@Controller
@RequestMapping("/client")
public class ClientController extends BaseController<ClientController>{
	
	
	@Autowired
	private ClientManager clientManager;
	
	@Autowired
	private TrunkingLineManager trunkingLineManager;
	
	@Autowired
	private ICommStringCache commStringCache;
	
	@RequestMapping("/toAddOrder.html")
	public ModelAndView toAddOrder(ModelAndView mav){
		mav.addObject("rslt", JSONObject.fromObject(clientManager.toAddOrder(super.getUser().getId())));
		mav.setViewName("client/addOrder");
		return mav;
	}
	
	@RequestMapping("/toOrderList.html")
	public ModelAndView toOrdering(ModelAndView mav){
		mav.addObject("postOfficeList", clientManager.getPostOfficeList(super.getUser().getId()).getData());
		mav.setViewName("client/orderList");
		return mav;
	}
	
	@RequestMapping("/toHistoryOrderList.html")
	public ModelAndView toHistoryOrderList(ModelAndView mav){
		mav.addObject("postOfficeList", clientManager.getPostOfficeList(super.getUser().getId()).getData());
		mav.setViewName("client/historyOrderList");
		return mav;
	}
	
	
	@RequestMapping("/toOrderDetail.html")
	public ModelAndView toOrderDetail(ModelAndView mav){
		mav.setViewName("client/orderDetail");
		return mav;
	}
	
	@RequestMapping("/toHistoryOrderDetail.html")
	public ModelAndView toHistoryOrderDetail(ModelAndView mav){
		mav.setViewName("client/historyOrderDetail");
		return mav;
	}
	
	
	
	@RequestMapping(value="/uploadExcel.html",method=RequestMethod.POST)
	public void uploadExcel(@Valid UploadExcelParam param, BindingResult bindingResult, 
			@RequestParam("excelFile") CommonsMultipartFile file, HttpServletResponse response) throws Exception{
		String typeStr = this.checkFile(file);
		UserPo user = super.getUser();
		List<String[]> list = null;
		UploadExcelBean bean = param.initBean();
		try{
			PostOfficeStaticRuleEnum e = PostOfficeStaticRuleEnum.选择.get(bean.getPostId() + "", bean.getDispatchType());
			if("xlsx".equals(typeStr)){
				list = ExcelImportXLSXUtil.readerExcel(file.getInputStream(), "Sheet1", e.getHeaders().length);
			} else {
				list = ExcelImportXLSUtil.readerExcel(file.getInputStream(), e.getHeaders().length);
			}
		} catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(MsgEnum.EXCEL_DATA_INVAILD.getVal());
		}
		bean.setAddWho(user.getUsername());
		bean.setCreatePerson(user.getUsername());
		bean.setUserId(user.getId());
		Result<CheckResultDataVO> rslt = clientManager.handleExcel(bean, list);
		if(rslt.getData().getDpo() == null){
			rslt.getData().setBagNoSet(null);
			rslt.getData().setDpo(null);
			rslt.getData().setRefIdSet(null);
			rslt.getData().setSealSet(null);
			AjaxUtils.writeJSONP(response, rslt);
		} else {//没有错误
			AjaxUtils.writeJSONP(response, clientManager.insertData(bean, rslt.getData().getDpo(), rslt.getData().getDispatchNo(), rslt.getData().getBagNoSet(), rslt.getData().getRefIdSet(), rslt.getData().getSealSet(), rslt.getData().getUuid()));
		}
	}
	
	private String checkFile(CommonsMultipartFile file){
		String partten = ".*(.xls|.xlsx)$";
		String filename = file.getOriginalFilename().toLowerCase();
		Pattern pattern = Pattern.compile(partten);
		Matcher matcher = pattern.matcher(filename);
		if(!matcher.matches()){
			throw new ParamException(MsgEnum.FILE_FORMAT_XLS_OR_XLSX.getVal());
		}
		if(file.getSize()/(1000*1000) > 30){
			throw new ParamException(MsgEnum.FILE_LIMIT_30M.getVal());
		}
		filename.lastIndexOf(".");
		return filename.substring(filename.lastIndexOf(".") + 1, filename.length());
	}
	
	//查询刚上传的清单列表
	@RequestMapping(value = "/list/getFirstDetailList.html", method = RequestMethod.POST)
	public void getFirstDetailList(@Valid DetailListParam detailListParam,BindingResult bindRslt, HttpServletResponse response){
		DetailListBean detailListBean = detailListParam.initBean();
		detailListBean.setUserId(super.getUser().getId());
		AjaxUtils.write(response, new JQGridPageResult<>(clientManager.getFirstDetailList(detailListBean, detailListParam.initPage())));
	}
	
	//查询历史清单列表
	@RequestMapping(value = "/list/getCommitDetailList.html", method = RequestMethod.POST)
	public void getCommitDetailList(@Valid DetailListParam detailListParam,BindingResult bindRslt, HttpServletResponse response){
		DetailListBean detailListBean = detailListParam.initBean();
		detailListBean.setUserId(super.getUser().getId());
		AjaxUtils.write(response, new JQGridPageResult<>(clientManager.getCommitDetailList(detailListBean, detailListParam.initPage())));
	}
	
	//删除清单列表
	@RequestMapping(value = "/list/deleteDetailListByDispatchNo.html", method = RequestMethod.POST)
	public void deleteDetailListByDispatchNo(@Valid DetailListDeleteParam detailListDeleteParam, BindingResult bindRslt,HttpServletResponse response){
		AjaxUtils.write(response, clientManager.deleteDetailList(detailListDeleteParam.initBean()));
	}
	
	//清单提交
	@RequestMapping(value = "/list/submitDetailList.html", method = RequestMethod.POST)
	public void submitDetailList(@Valid DetailListSubmitParam detailListSubmitParam,BindingResult bindRslt,HttpServletResponse response){
		AjaxUtils.write(response, clientManager.submitDetailList(detailListSubmitParam.initBean()));
	}
	
	//清单下载
	@RequestMapping(value = "/list/downloadDetailList.html", method = RequestMethod.GET)
	public void downloadDetailList(String[] dispatchNoArray, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String language = getLanguage();
		Map<String, Object> beanParams = clientManager.getDetailListForExportData(dispatchNoArray, language);
		String templateName = "detail_detail_list_zh.xls";
		String fileName = MsgConfig.getMessage(MsgEnum.c_export_list.getVal(), language);
		if ("en_US".equals(language)) {
			templateName = "detail_detail_list_en.xls";
		}
		ExcelExportUtil.exportExcel(request, response, templateName, fileName, beanParams);
	}
	
	//更新邮包信息
	@RequestMapping(value="/updatePackageInfo.html", method = RequestMethod.POST)
	public void updatePackageInfo(@Valid PackageUpdateParam packageUpdateParam,BindingResult bindRslt,HttpServletResponse response) throws Exception{
		AjaxUtils.write(response, clientManager.updateCN35(packageUpdateParam.initBean()));
	}
	
	@RequestMapping(value="/checkDispatchNo.html" , method = RequestMethod.POST)
	public void checkDispatchNo(@Valid StringParam param, BindingResult bindRslt, HttpServletResponse response){
		AjaxUtils.write(response, clientManager.checkDispatch(param.getStr()));
	}
	
	@RequestMapping(value="/getTrunkingLineListByDepartmentID.html",method = RequestMethod.GET)
	public void getTrunkingLineListByDepartmentID(@Valid IDParam IDParam,BindingResult bindRslt ,HttpServletResponse response){
		AjaxUtils.write(response, trunkingLineManager.getTrunkingLineListByDepartmentID(IDParam.getId().intValue()));
	}
	
	@RequestMapping(value="/updateTruckingNo.html",method = RequestMethod.POST)
	public void updateTruckingNo(@Valid DetailListUpdateParam detailListUpdateParam,BindingResult bindRslt ,HttpServletResponse response){
		AjaxUtils.write(response, clientManager.updateTruckingNo(detailListUpdateParam.initBean()));
	}

	/**
	 * 
	 * 方法用途: 获取邮包列表<br>
	 * 实现步骤: <br>
	 */
	@RequestMapping(value = "/package.html", method = RequestMethod.POST)
	public void packageList(@Valid ClientPackageListParam packageListParam, BindingResult bindRslt,
			HttpServletResponse response) {
		AjaxUtils.write(response, new JQGridPageResult<>(clientManager.queryPackageList(packageListParam.initBean(),
						packageListParam.initPage())));
	}
	
	@RequestMapping("/getUUID.html")
	public void getUUID(HttpServletResponse response){
		AjaxUtils.write(response, StringUtils.getUUID());
	}
	
	@RequestMapping("/checkProcess.html")
	public void checkProcess(String uuid, HttpServletResponse response){
		if(StringUtils.isEmpty(uuid)){
			AjaxUtils.write(response, "0");
		} else {
			String str = commStringCache.get(uuid);
			if(StringUtils.isEmpty(str)){
				str = "0";
			}
			AjaxUtils.write(response, str);
		}
	}
}
