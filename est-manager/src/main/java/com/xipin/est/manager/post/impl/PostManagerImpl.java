package com.xipin.est.manager.post.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.xipin.est.db.bean.DetailListInputWeightBean;
import com.xipin.est.db.bean.DetailListListBean;
import com.xipin.est.db.bean.InputCNBean;
import com.xipin.est.db.bean.InputWeightBean;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.db.bean.PackageInputWeightBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.po.post.DetailListListPo;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.manager.post.PostManager;
import com.xipin.est.model.eum.DataStatusEnum;
import com.xipin.est.service.busi.inf.DetailListService;
import com.xipin.est.service.busi.inf.PackageService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.rslt.type.Result;

@Service
public class PostManagerImpl implements PostManager {

	@Autowired
	private DetailListService detailListService;

	@Autowired
	private PackageService packageService;

	@Override
	public Result<List<DetailListListPo>> queryPendingTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		Result<List<DetailListListPo>> result = new Result<>();
		PageBean<DetailListListPo> pageBean = detailListService.queryPendingTaskList(taskListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<DetailListListPo>> queryDoingTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		Result<List<DetailListListPo>> result = new Result<>();
		PageBean<DetailListListPo> pageBean = detailListService.queryDoingTaskList(taskListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<DetailListListPo>> queryFinishTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		Result<List<DetailListListPo>> result = new Result<>();
		PageBean<DetailListListPo> pageBean = detailListService.queryFinishTaskList(taskListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<DetailListListPo>> queryTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		Result<List<DetailListListPo>> result = new Result<>();
		PageBean<DetailListListPo> pageBean = detailListService.queryTaskList(taskListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<PackageListPo>> queryPackageList(PackageListBean packageListBean, PageBean<PackageListPo> page) {
		Result<List<PackageListPo>> result = new Result<>();
		PageBean<PackageListPo> pageBean = packageService.queryPackageListByParam(packageListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	@Transactional
	public Result<String> inputWeight(InputWeightBean inputWeightBean) {
		DetailListInputWeightBean detailListInputWeightBean = inputWeightBean.getDetailListInputWeightBean();
		// 验证录入重量条件
		DetailListListPo detailListPo = detailListService.queryDetailListByDispatchNo(detailListInputWeightBean.getDispatchNo(), "");
		if (detailListPo == null) {
//			throw new BusinessException("清单不存在！");
			throw new BusinessException(MsgEnum.m_detailList_not_exist.getVal());
		}
		if (!DataStatusEnum.INPUTING_WEIGHT.to(detailListPo.getStatus())) {
//			throw new BusinessException("该清单状态不正确！");
			throw new BusinessException(MsgEnum.m_detailList_state_not_correct.getVal());
		}

		// 邮包录入
		List<String> delPackageNo = new ArrayList<>();
		BigDecimal zero3 = new BigDecimal("0.000");
		for (PackageInputWeightBean packageInputWeightBean : inputWeightBean.getPackageList()) {
			if (1 == packageInputWeightBean.getIsFinish() && BigDecimal.ZERO.equals(packageInputWeightBean.getActualPackageNum()) && zero3.equals(packageInputWeightBean.getActualPackageWeight())) {
				delPackageNo.add(packageInputWeightBean.getPackageNo());
			} else {
				packageService.inputWeight(packageInputWeightBean);
			}
		}

		// 清单录入
		if(0 == detailListInputWeightBean.getIsFinish()){
			detailListInputWeightBean.setStatus(DataStatusEnum.INPUTING_WEIGHT.getValue());
		}else if (delPackageNo.size() > 0) {
			detailListInputWeightBean.setStatus(DataStatusEnum.INPUTED_WEIGHT_T.getValue());
			detailListInputWeightBean.setIsBroken(1);
		} else {
			detailListInputWeightBean.setStatus(DataStatusEnum.INPUTED_WEIGHT.getValue());
		}
		detailListService.inputWeight(detailListInputWeightBean);

		Result<String> result = new Result<>();
		return result;
	}

	@Override
	public Map<String, Object> queryPackageExportData(PackageListBean packageListBean) {
		Map<String, Object> map = Maps.newHashMap();
		Map<String, BigDecimal> total = Maps.newHashMap();
		BigDecimal estimatePackageNum = BigDecimal.ZERO;
		BigDecimal actualPackageNum = BigDecimal.ZERO;
		BigDecimal numErrorValue = BigDecimal.ZERO;
		BigDecimal estimatePackageWeight = BigDecimal.ZERO;
		BigDecimal actualPackageWeight = BigDecimal.ZERO;
		BigDecimal errorValue = BigDecimal.ZERO;
		DetailListListPo task = detailListService.queryDetailListByDispatchNo(packageListBean.getDispatchNo(), packageListBean.getLanguage());
		List<PackageListPo> list = packageService.queryPackageListByDispatchNo(packageListBean.getDispatchNo());
		for (PackageListPo packageListPo : list) {
			estimatePackageNum = estimatePackageNum.add(packageListPo.getEstimatePackageNum() == null ? BigDecimal.ZERO : packageListPo.getEstimatePackageNum());
			actualPackageNum = actualPackageNum.add(packageListPo.getActualPackageNum() == null ? BigDecimal.ZERO : packageListPo.getActualPackageNum());
			numErrorValue = numErrorValue.add(packageListPo.getNumErrorValue() == null ? BigDecimal.ZERO : packageListPo.getNumErrorValue());
			estimatePackageWeight = estimatePackageWeight.add(packageListPo.getEstimatePackageWeight() == null ? BigDecimal.ZERO : packageListPo.getEstimatePackageWeight());
			actualPackageWeight = actualPackageWeight.add(packageListPo.getActualPackageWeight() == null ? BigDecimal.ZERO : packageListPo.getActualPackageWeight());
			errorValue = errorValue.add(packageListPo.getErrorValue() == null ? BigDecimal.ZERO : packageListPo.getErrorValue());
		}
		total.put("estimatePackageNum", estimatePackageNum);
		total.put("actualPackageNum", actualPackageNum);
		total.put("numErrorValue", numErrorValue);
		total.put("estimatePackageWeight", estimatePackageWeight);
		total.put("actualPackageWeight", actualPackageWeight);
		total.put("errorValue", errorValue);
		map.put("task", task);
		map.put("list", list);
		map.put("total", total);
		return map;
	}

	@Override
	@Transactional
	public Result<String> inputCN35(InputCNBean inputCNBean) {
		Result<String> result = new Result<>();
		String dispatchNo = inputCNBean.getCNList().get(0).getDispatchNo();
		DetailListListPo detailListPo = detailListService.queryDetailListByDispatchNo(dispatchNo, "");
		if (detailListPo == null) {
//			throw new BusinessException("清单不存在！");
			throw new BusinessException(MsgEnum.m_detailList_not_exist.getVal());
		}
		if (!DataStatusEnum.OPERAT_FINISH.to(detailListPo.getStatus())) {
//			throw new BusinessException("该清单状态不正确！");
			throw new BusinessException(MsgEnum.m_detailList_state_not_correct.getVal());
		}
		if (Constants.SERVICE_TYPE_TRANSFER != detailListPo.getServiceType()) {
//			throw new BusinessException("该清单服务不正确！");
			throw new BusinessException(MsgEnum.m_detailList_service_not_correct.getVal());
		}
		if (!"PZ".equals(detailListPo.getDispatchType())) {
//			throw new BusinessException("该清单产品不正确！");
			throw new BusinessException(MsgEnum.m_detailList_product_not_correct.getVal());
		}
		for (PackageBean packageBean : inputCNBean.getCNList()) {
			packageService.inputCN35(packageBean);
		}
		UpdateDetailListBean finishDetailListBean = new UpdateDetailListBean();
		finishDetailListBean.setDispatchNo(dispatchNo);
		finishDetailListBean.setStatus(DataStatusEnum.OPERAT_FINISH.getValue());
		finishDetailListBean.setStatusTime(new Date());
		BeanUtils.copyProperties(inputCNBean, finishDetailListBean);
		detailListService.updateDetailStatus(finishDetailListBean);
		return result;
	}

	@Override
	@Transactional
	public Result<String> inputCN38(InputCNBean inputCNBean) {
		Result<String> result = new Result<>();
		DetailListListPo detailListPo = detailListService.queryDetailListByDispatchNo(inputCNBean.getDispatchNo(), "");
		if (detailListPo == null) {
//			throw new BusinessException("清单不存在！");
			throw new BusinessException(MsgEnum.m_detailList_not_exist.getVal());
		}
		if (!DataStatusEnum.CN38_FINISH.to(detailListPo.getStatus())) {
//			throw new BusinessException("该清单状态不正确！");
			throw new BusinessException(MsgEnum.m_detailList_state_not_correct.getVal());
		}
		if (Constants.SERVICE_TYPE_TRANSFER != detailListPo.getServiceType()) {
//			throw new BusinessException("该清单服务不正确！");
			throw new BusinessException(MsgEnum.m_detailList_service_not_correct.getVal());
		}
		if (Constants.POST_ID_PY != detailListPo.getJgOrgId()) {
//			throw new BusinessException("该清单所属邮局不正确！");
			throw new BusinessException(MsgEnum.m_detailList_post_office_not_correct.getVal());
		}

		for (PackageBean packageBean : inputCNBean.getCNList()) {
			packageService.inputCN38(packageBean);
			if (packageBean.getIsFinish() == 1) {
				UpdateDetailListBean finishDetailListBean = new UpdateDetailListBean();
				finishDetailListBean.setStatus(DataStatusEnum.CN38_FINISH.getValue());
				finishDetailListBean.setStatusTime(new Date());
				BeanUtils.copyProperties(packageBean, finishDetailListBean);
				detailListService.updateDetailStatus(finishDetailListBean);
			}
		}
		return result;
	}

	@Override
	public Result<String> isInputCN35(String dispatchNo) {
		Result<String> result = new Result<>();
		result.setData(detailListService.isInputCN35(dispatchNo));
		return result;
	}

	@Override
	public Result<String> isInputCN38(String dispatchNo) {
		Result<String> result = new Result<>();
		result.setData(detailListService.isInputCN38(dispatchNo));
		return result;
	}

}
