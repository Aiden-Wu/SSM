package com.xipin.est.manager.client.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.DetailListPoBean;
import com.xipin.est.db.bean.DetailListSubmitBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.bean.UploadExcelBean;
import com.xipin.est.db.cache.ICommSetCache;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.po.DetailListPo;
import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.db.po.PackagePo;
import com.xipin.est.db.po.client.DetailDataListPo;
import com.xipin.est.db.po.post.DetailListListPo;
import com.xipin.est.db.po.post.OrgJGPo;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.manager.client.ClientManager;
import com.xipin.est.manager.inf.BaseManager;
import com.xipin.est.model.eum.DataStatusEnum;
import com.xipin.est.service.busi.inf.CountryService;
import com.xipin.est.service.busi.inf.DetailListService;
import com.xipin.est.service.busi.inf.ItemService;
import com.xipin.est.service.busi.inf.LogService;
import com.xipin.est.service.busi.inf.OrgService;
import com.xipin.est.service.busi.inf.PackageService;
import com.xipin.est.service.impl.item.check.RedisConstant;
import com.xipin.est.service.vo.excel.check.CheckResultDataVO;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.rslt.type.Result;
import com.xipin.est.utils.serialize.ObjectSerializeUtils;

@Service("clientManager")
public class ClientManagerImpl extends BaseManager<ClientManagerImpl> implements ClientManager{
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private DetailListService detailListService;
	
	@Autowired
	private LogService sysLogService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private ICommStringCache commStringCache;
	
	@Autowired
	private ICommSetCache commSetCasche;
	
	@Override
	public Result<CheckResultDataVO> handleExcel(UploadExcelBean uploadExcelBean, List<String[]> excelData) {
		Result<CheckResultDataVO> rslt = new Result<>();
		try{
			rslt.setData(itemService.checkExcelData(uploadExcelBean, excelData));
		} catch(Exception e){
			e.printStackTrace();
			log.error(e);
			throw new BusinessException(e.getMessage());
		} finally{
			commStringCache.delete(RedisConstant.LOT_NUM_SET_ING);
		}
		return rslt;
	}

	@Override
	@Transactional
	public Result<String> insertData(UploadExcelBean bean, DetailListPo detailListPo, String dispatchNo, Set<byte[]> bagNoSet, Set<byte[]> refIdSet, Set<byte[]> sealSet, String uuid) {
		Result<String> rslt = new Result<>();
		//取出邮包信息
		List<PackagePo> packagePoList = detailListPo.getPackagePoList();
		
		//取出包裹信息
		List<ItemsPo> itemsPoList = new ArrayList<>();
		for(PackagePo packagePo : packagePoList){
			itemsPoList.addAll(packagePo.getItemsPoList());
		}
		
		//批量插入包裹
		itemService.insertItemBatch(itemsPoList, uuid);
		//批量插入邮袋
		packageService.insertPackageBatch(packagePoList);
		//插入清单
		detailListPo.setPackagePoList(null);
		DetailListPoBean detailListPoBean = new DetailListPoBean();
		BeanUtils.copyProperties(bean, detailListPoBean);
		detailListPoBean.setDispatchNo(dispatchNo);
		detailListPoBean.setDetailListPo(detailListPo);
		detailListService.insertDetailList(detailListPoBean);
		itemService.insertNoInRedis(dispatchNo, bagNoSet, refIdSet, sealSet);
//		rslt.setData("上传数据成功！一共添加了：" + detailListPo.getEstimateBagNum() + "个邮袋，共" + detailListPo.getEstimateTotalWeight() + "KG");
		rslt.setData(MsgConfig.getMessage(MsgEnum.m_upload_success_remind_1.getVal(),bean.getLanguage()) + detailListPo.getEstimateBagNum() + MsgConfig.getMessage(MsgEnum.m_upload_success_remind_2.getVal(), bean.getLanguage()) + detailListPo.getEstimateTotalWeight() + "KG");
		return rslt;
	}

	@Override
	public Result<List<DetailDataListPo>> getFirstDetailList(
			DetailListBean detailListBean, PageBean<DetailDataListPo> page) {
		
		Result<List<DetailDataListPo>> result = new Result<>();
		PageBean<DetailDataListPo> pageBean = detailListService.getFirstDetailList(detailListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<DetailDataListPo>> getCommitDetailList(
			DetailListBean detailListBean, PageBean<DetailDataListPo> page) {
		
		Result<List<DetailDataListPo>> result = new Result<>();
		PageBean<DetailDataListPo> pageBean = detailListService.gethistoryDetailList(detailListBean, page);
		result.initRslt(pageBean);
		return result;
	}
	
	
	@Override
	@Transactional
	public Result<String> deleteDetailList(
			DetailListDeleteBean detailListDeleteBean) {
		Result<String> rslt = new Result<String>();
		
		//判断清单能否删除
		detailListService.judgeDetailListIsCanDelete(detailListDeleteBean);
		//根据批次号获取邮包列表
		List<String> packageNOList = packageService.queryPackageNoListByDispatchNo(detailListDeleteBean);
		//根据批次号获取扎带数列表
		List<String> sealNoList = packageService.querySealNoListByDispatchNo(detailListDeleteBean);
		//根据批次号获取包裹跟踪号列表
		List<String> referenceIdList = itemService.queryReferenceIdListByDispatchNo(detailListDeleteBean);
		
		//删除包裹
		itemService.deleteItemByDispatchNo(detailListDeleteBean.getList());
		//删除邮包
		packageService.deletePackageByDispatchNo(detailListDeleteBean.getList());
		
		//删除清单
		{
			UpdateDetailListBean bean = new UpdateDetailListBean();
			for(String dispatchNo : detailListDeleteBean.getList()){
				bean.setDispatchNo(dispatchNo);
				detailListService.deleteDetailList(bean);
			}
		}
		
		{// 删除redis
			commSetCasche.delete(RedisConstant.LOT_NUM_SET, this.strToByte(detailListDeleteBean.getList()));
			commSetCasche.delete(RedisConstant.BAG_NO_SET, this.strToByte(packageNOList));
			commSetCasche.delete(RedisConstant.REF_ID_SET, this.strToByte(referenceIdList));
			
			if(sealNoList != null && sealNoList.size() != 0){
				commSetCasche.delete(RedisConstant.SEAL_NO_SET, this.strToByte(sealNoList));
			}
		}
		
		return rslt;
	}

	private List<byte[]> strToByte(Collection<String> collection){
		if(collection == null){
			return null;
		}
		List<byte[]> list = new ArrayList<byte[]>();
		for(String str : collection){
			list.add(ObjectSerializeUtils.serializeObject(str));
		}
		
		return list;
	}
	
	@Override
	public Result<String> submitDetailList(DetailListSubmitBean detailListSubmitBean) {
		Result<String> rslt = new Result<String>();
		UpdateDetailListBean bean = new UpdateDetailListBean();
		
		BeanUtils.copyProperties(detailListSubmitBean, bean);
		bean.setStatus(DataStatusEnum.COMMIT.getValue());
		
		Date newDate = new Date();
		bean.setStatusTime(newDate);
		bean.setSubmitDate(newDate);
		
		for(int i=0; i<detailListSubmitBean.getList().size(); i++){
			bean.setDispatchNo(detailListSubmitBean.getList().get(i));
			bean.setPostofficeEnName(detailListSubmitBean.getPoenList().get(i));
			detailListService.submitDetailList(bean);
		}
		return rslt;
	}

	@Override
	public Map<String, Object> getDetailListForExportData(String[] dispatchNoArray, String language) {
		Map<String, Object> map = Maps.newHashMap();
		List<String> dispatchNoList = new ArrayList<>();
		Collections.addAll(dispatchNoList, dispatchNoArray);
		List<DetailListListPo> list = detailListService.getDetailListByDispatchNoList(dispatchNoList, language);
		map.put("list", list);
		return map;
	}

	@Override
	@Transactional
	public Result<String> updateCN35(PackageUpdateBean packageUpdateBean) {
		Result<String> rslt = new Result<String>();
		
		//同一批次下面的邮包的cn35要唯一
		int cn35Num = packageService.queryPackageCn35Num(packageUpdateBean);
		if(cn35Num > 0){
//			throw new BusinessException("cn35已存在");
			throw new BusinessException(MsgEnum.m_cn35_exist.getVal());
		}
		//暂时全部都是非DE-R
		packageUpdateBean.setReferenceId(null);
		packageService.updatePackageCn35(packageUpdateBean);
		itemService.updateItemCN35(packageUpdateBean);
		
		return rslt;
	}

	@Override
	public Result<List<OrgJGPo>> toAddOrder(Long userId) {
		Result<List<OrgJGPo>> rslt = new Result<>();
		rslt.setData(orgService.getOrJGInfoByUser(userId));
		return rslt;
	}

	@Override
	public Result<String> checkDispatch(String dispatchNo) {
		Result<String> rslt = new Result<>();
		itemService.checkDispatchNo(dispatchNo);
		return rslt;
	}

	@Override
	public Result<List<OrgJGPo>> getPostOfficeList(Long userId) {
		Result<List<OrgJGPo>> rslt = new Result<List<OrgJGPo>>();
		List<OrgJGPo> list = orgService.getJGByUserIdP(userId);
		rslt.setData(list);
		return rslt;
	}

	@Override
	public Result<List<PackageListPo>> queryPackageList(PackageListBean packageListBean, PageBean<PackageListPo> page) {
		Result<List<PackageListPo>> result = new Result<>();
		PageBean<PackageListPo> pageBean = packageService.queryPackageListForDetailListByParam(packageListBean,page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	@Transactional
	public Result<String> updateTruckingNo(DetailListUpdateBean bean) {
		Result<String> rslt = new Result<>();
		detailListService.updateTruckingNo(bean);
		itemService.updateTruckingNo(bean);
		return rslt;
	}
	
}

