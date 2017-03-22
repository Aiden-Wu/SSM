package com.xipin.est.service.busi.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.DetailListInputWeightBean;
import com.xipin.est.db.bean.DetailListListBean;
import com.xipin.est.db.bean.DetailListPoBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.dao.IDataAuthDao;
import com.xipin.est.db.dao.IDetailListDao;
import com.xipin.est.db.dao.IOrgDao;
import com.xipin.est.db.dao.IPackageDao;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.client.DetailDataListPo;
import com.xipin.est.db.po.post.DetailListListPo;
import com.xipin.est.db.po.post.OrgJGPo;
import com.xipin.est.model.eum.DataStatusEnum;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.apsect.annotation.InsertLog;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.service.busi.inf.DetailListService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ObjectType;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;

@Service
public class DetailListServiceImpl implements DetailListService {

	@Autowired
	private IDetailListDao detailListDao;

	@Autowired
	private IPackageDao packageDao;

	@Autowired
	private IOrgDao orgDao;

	@Autowired
	private IDataAuthDao dataAuthDao;

	@Override
	public PageBean<DetailListListPo> queryPendingTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(DataStatusEnum.COMMIT.getValue());
		statusList.add(DataStatusEnum.INPUTING_WEIGHT.getValue());
		taskListBean.setStatusList(statusList);
		taskListBean.setBeginIndex(page.getStart());
		taskListBean.setPageSize(page.getPageSize());
		taskListBean.setBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 6, null)));
		taskListBean.setcBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 3, taskListBean.getcJgOrgId())));
		List<DetailListListPo> list = detailListDao.queryDetailListList(taskListBean);
		page.setCount(detailListDao.queryDetailListCount(taskListBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<DetailListListPo> queryDoingTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		List<Integer> statusList = new ArrayList<Integer>();
		// taskListBean.setStatus(DataStatusEnum.INPUTED_WEIGHT);
		statusList.add(DataStatusEnum.INPUTED_WEIGHT.getValue());
		statusList.add(DataStatusEnum.INPUTED_WEIGHT_T.getValue());
		taskListBean.setStatusList(statusList);
		// 只有中转的平邮有追踪才会扫CN35
		taskListBean.setServiceType(String.valueOf(Constants.SERVICE_TYPE_TRANSFER));
		taskListBean.setDispatchType("PZ");

		taskListBean.setBeginIndex(page.getStart());
		taskListBean.setPageSize(page.getPageSize());
		taskListBean.setBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 6, null)));
		taskListBean.setcBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 3, taskListBean.getcJgOrgId())));
		List<DetailListListPo> list = detailListDao.queryDetailListList(taskListBean);
		for (DetailListListPo detailListListPo : list) {
			if (detailListListPo != null && Constants.SERVICE_TYPE_TRANSFER == detailListListPo.getServiceType() && "PZ".equals(detailListListPo.getDispatchType())) {
				detailListListPo.setIsInput(1);
			}else{
				detailListListPo.setIsInput(0);
			}
		}
		page.setCount(detailListDao.queryDetailListCount(taskListBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<DetailListListPo> queryFinishTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(DataStatusEnum.INPUTED_WEIGHT.getValue());
		statusList.add(DataStatusEnum.INPUTED_WEIGHT_T.getValue());
		statusList.add(DataStatusEnum.OPERAT_FINISH.getValue());
		statusList.add(DataStatusEnum.CN38_FINISH.getValue());
		taskListBean.setStatusList(statusList);
		// 只有巴邮中转的要录CN38
		// taskListBean.setServiceType(String.valueOf(Constants.SERVICE_TYPE_TRANSFER));
		// taskListBean.setpJgOrgId(Constants.POST_ID_PY);
		taskListBean.setNoServiceType(Constants.SERVICE_TYPE_TRANSFER);
		taskListBean.setNoDispatchType("PZ");

		taskListBean.setBeginIndex(page.getStart());
		taskListBean.setPageSize(page.getPageSize());
		taskListBean.setBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 6, null)));
		taskListBean.setcBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 3, taskListBean.getcJgOrgId())));
		List<DetailListListPo> list = detailListDao.queryDetailListList(taskListBean);
		for (DetailListListPo detailListListPo : list) {
			if (detailListListPo != null && Constants.SERVICE_TYPE_TRANSFER == detailListListPo.getServiceType() && Constants.POST_ID_PY == detailListListPo.getJgOrgId()) {
				detailListListPo.setIsInput(1);
			}else{
				detailListListPo.setIsInput(0);
			}
		}
		page.setCount(detailListDao.queryDetailListCount(taskListBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<DetailListListPo> queryTaskList(DetailListListBean taskListBean, PageBean<DetailListListPo> page) {
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(DataStatusEnum.COMMIT.getValue());
		statusList.add(DataStatusEnum.INPUTING_WEIGHT.getValue());
		statusList.add(DataStatusEnum.INPUTED_WEIGHT.getValue());
		statusList.add(DataStatusEnum.INPUTED_WEIGHT_T.getValue());
		statusList.add(DataStatusEnum.OPERAT_FINISH.getValue());
		statusList.add(DataStatusEnum.CN38_FINISH.getValue());

		taskListBean.setStatusList(statusList);
		taskListBean.setBeginIndex(page.getStart());
		taskListBean.setPageSize(page.getPageSize());
		taskListBean.setBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 6, null)));
		taskListBean.setcBmOrgIds(this.checkIdList(dataAuthDao.queryUserAuthBM(taskListBean.getMeId(), 3, taskListBean.getcJgOrgId())));
		List<DetailListListPo> list = detailListDao.queryDetailListList(taskListBean);
		page.setCount(detailListDao.queryDetailListCount(taskListBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<DetailDataListPo> getFirstDetailList(DetailListBean detailListBean, PageBean<DetailDataListPo> page) {

		detailListBean.setStatus(DataStatusEnum.UPLOAD.getValue());
		detailListBean.setBeginIndex(page.getStart());
		detailListBean.setPageSize(page.getPageSize());
		List<Long> idList = new ArrayList<Long>();
		if (detailListBean.getJgOrgId() != null) {
			idList.add(detailListBean.getJgOrgId());
		}
		//
		List<Long> bmList = this.checkPostAuth(detailListBean.getUserId(), idList);
		List<Long> cbmList = dataAuthDao.getUserBMAuth(detailListBean.getUserId());
		detailListBean.setCbmList(this.checkIdList(cbmList));
		detailListBean.setPostOfficeList(this.checkIdList(bmList));

		List<DetailDataListPo> list = detailListDao.getFirstDetailList(detailListBean);
		page.setCount(detailListDao.queryFirstDetailListNum(detailListBean));
		page.setData(list);
		return page;
	}

	private List<Long> checkIdList(List<Long> list) {
		if (list == null) {
			list = new ArrayList<Long>();
			list.add(-1l);
			return list;
		}
		if (list.isEmpty()) {
			list.add(-1l);
			return list;
		}
		return list;
	}

	private List<Long> checkPostAuth(Long userId, List<Long> postIds) {
		List<OrgJGPo> list = orgDao.getJGByUserId(userId);
		List<Long> pidList = new ArrayList<Long>();
		List<Long> sidList = new ArrayList<>();
		if (postIds == null || postIds.isEmpty()) {
			for (OrgJGPo o : list) {
				pidList.add(o.getPid());
				sidList.add(o.getId());
			}
		} else {
			for (Long id : postIds) {
				boolean flag = false;
				for (OrgJGPo o : list) {
					if (o.getPid().equals(id)) {
						flag = true;
						sidList.add(o.getId());
					}
				}
				if (!flag) {
					throw new BusinessException(MsgEnum.s_post_notauthority.getVal());
				}
			}
		}
		return sidList;
	}

	@Override
	public PageBean<DetailDataListPo> gethistoryDetailList(DetailListBean detailListBean, PageBean<DetailDataListPo> page) {

		detailListBean.setBeginIndex(page.getStart());
		detailListBean.setPageSize(page.getPageSize());
		List<Long> idList = new ArrayList<Long>();
		if (detailListBean.getJgOrgId() != null) {
			idList.add(detailListBean.getJgOrgId());
		}
		//
		List<Long> cbmList = dataAuthDao.getUserBMAuth(detailListBean.getUserId());
		List<Long> postOfficeList = this.checkPostAuth(detailListBean.getUserId(), idList);
		detailListBean.setPostOfficeList(this.checkIdList(postOfficeList));
		detailListBean.setCbmList(this.checkIdList(cbmList));

		List<DetailDataListPo> list = detailListDao.gethistoryDetailList(detailListBean);
		for (DetailDataListPo po : list) {
			int statusFlag = Integer.valueOf(po.getStatus());
			StringBuffer statusContent = new StringBuffer();
			statusContent.append(DataStatusEnum.getEscape(statusFlag, detailListBean.getLanguage()));
			if (DataStatusEnum.COMMIT.getValue() == statusFlag || DataStatusEnum.INPUTING_WEIGHT.getValue() == statusFlag || DataStatusEnum.INPUTED_WEIGHT.getValue() == statusFlag || DataStatusEnum.INPUTED_WEIGHT_T.getValue() == statusFlag || DataStatusEnum.OPERAT_FINISH.getValue() == statusFlag || DataStatusEnum.CN38_FINISH.getValue() == statusFlag) {

				String packageNum = po.getActualBagNum();
				if (!StringUtils.isEmpty(packageNum)) {
					packageNum = (new BigDecimal(packageNum)).intValue() + "";
					statusContent.append("，" + MsgConfig.getMessage(MsgEnum.BAGS.getVal(), detailListBean.getLanguage()) + "：");
					statusContent.append(packageNum);
				}
				String actualTotalWeight = po.getActualTotalWeight();
				if (!StringUtils.isEmpty(actualTotalWeight)) {
					actualTotalWeight = (new BigDecimal(actualTotalWeight)).setScale(3, BigDecimal.ROUND_HALF_UP) + "";
					statusContent.append(" " + MsgConfig.getMessage(MsgEnum.WEIGHT.getVal(), detailListBean.getLanguage()) + "：");
					statusContent.append(actualTotalWeight);
				}

			}
			po.setStatusContent(statusContent.toString());
		}

		page.setCount(detailListDao.queryHistoryDetailListNum(detailListBean));
		page.setData(list);
		return page;
	}

	@Override
	@InsertLog(description = "添加清单", objectType = ObjectType.DETAIIL_LIST, tableName = "detail_list")
	public void insertDetailList(DetailListPoBean detailListPoBean) {
		detailListDao.insertDetailList(detailListPoBean.getDetailListPo());
	}

	@Override
	@DeleteLog(description = "删除清单", objectType = ObjectType.DETAIIL_LIST, tableName = "detail_list")
	public void deleteDetailList(UpdateDetailListBean bean) {
		detailListDao.deleteDetailList(bean.getDispatchNo());
	}

	@Override
	public void updateDetailStatus(UpdateDetailListBean updateDetailListBean) {
		detailListDao.updateDetailStatus(updateDetailListBean);
	}

	@Override
	@UpdateLog(description = "录入清单重量", objectType = ObjectType.DETAIIL_LIST, tableName = "detail_list")
	public void inputWeight(DetailListInputWeightBean detailListInputWeightBean) {
		detailListInputWeightBean.setStatusTime(new Date());
		detailListDao.detailListInputWeight(detailListInputWeightBean);
	}

	@Override
	@UpdateLog(description = "提交预报清单", objectType = ObjectType.DETAIIL_LIST, tableName = "detail_list")
	public void submitDetailList(UpdateDetailListBean updateDetailListBean) {
		// detailListDao.updateDetailStatus(updateDetailListBean);
		detailListDao.submitDetailListForDate(updateDetailListBean);
	}

	@Override
	public List<DetailListListPo> getDetailListByDispatchNoList(List<String> dispatchNoList, String language) {
		List<DetailListListPo> list = detailListDao.getDetailListByDispatchNoList(dispatchNoList, language);
		Map<Long, OrgPo> orgMap = orgDao.queryAll();
		for (DetailListListPo detailListListPo : list) {
			OrgPo jg = orgMap.get(detailListListPo.getJgOrgId());
			if(jg != null){
				if(language.equals("en_US")){
					detailListListPo.setJgOrgName(jg.getEname());
				}else{
					detailListListPo.setJgOrgName(jg.getName());
				}
			}
			OrgPo bm = orgMap.get(detailListListPo.getBmOrgId());
			if(bm != null){
				if(language.equals("en_US")){
					detailListListPo.setBmOrgName(bm.getEname());
				}else{
					detailListListPo.setBmOrgName(bm.getName());
				}
			}
		}
		return list;
	}

	@Override
	public DetailDataListPo getDetailListByDispatchNo(Map<String, Object> map) {
		return detailListDao.getDetailListByDispatchNo(map);
	}

	@Override
	public DetailListListPo queryDetailListByDispatchNo(String dispatchNo, String language) {
		return detailListDao.queryDetailListByDispatchNo(dispatchNo, language);
	}

	@Override
	public void updateTruckingNo(DetailListUpdateBean bean) {
		detailListDao.updateTruckingNo(bean);
	}

	@Override
	public String isInputCN35(String dispatchNo) {
		DetailListListPo detailListPo = detailListDao.queryDetailListByDispatchNo(dispatchNo, "");
		if (detailListPo != null && Constants.SERVICE_TYPE_TRANSFER == detailListPo.getServiceType() && "PZ".equals(detailListPo.getDispatchType())) {
			return "1";
		}
		return "0";
	}

	@Override
	public String isInputCN38(String dispatchNo) {

		DetailListListPo detailListPo = detailListDao.queryDetailListByDispatchNo(dispatchNo, "");
		if (detailListPo != null && Constants.SERVICE_TYPE_TRANSFER == detailListPo.getServiceType() && Constants.POST_ID_PY == detailListPo.getJgOrgId()) {
			return "1";
		}
		return "0";
	}

	@Override
	public void judgeDetailListIsCanDelete(DetailListDeleteBean detailListDeleteBean) {

		DetailListUpdateBean bean = new DetailListUpdateBean();
		for (int i = 0; i < detailListDeleteBean.getList().size(); i++) {
			bean.setDispatchNo(detailListDeleteBean.getList().get(i));
			bean.setPostofficeEnName(detailListDeleteBean.getPoenList().get(i));
			String dispathcNo = detailListDao.queryDispatchNoForNotCanDelete(bean);
			if (!StringUtils.isEmpty(dispathcNo)) {
				throw new BusinessException(MsgEnum.s_postdata_dealt.getVal());
			}
		}

	}

}
