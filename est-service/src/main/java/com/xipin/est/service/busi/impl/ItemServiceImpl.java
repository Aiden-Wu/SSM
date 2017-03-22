package com.xipin.est.service.busi.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UploadExcelBean;
import com.xipin.est.db.cache.ICommSetCache;
import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.dao.ICountryDao;
import com.xipin.est.db.dao.IItemsDao;
import com.xipin.est.db.dao.IOrgDao;
import com.xipin.est.db.dao.IUserDao;
import com.xipin.est.db.po.DetailListPo;
import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.db.po.PackagePo;
import com.xipin.est.db.po.user.UserOrgPo;
import com.xipin.est.model.PostOfficeEnName;
import com.xipin.est.model.eum.DataStatusEnum;
import com.xipin.est.service.base.inf.BaseService;
import com.xipin.est.service.busi.inf.ItemService;
import com.xipin.est.service.impl.item.check.DataForExcelCheck;
import com.xipin.est.service.impl.item.check.PostOfficeStaticRuleEnum;
import com.xipin.est.service.impl.item.check.PostOfficeTypeName;
import com.xipin.est.service.impl.item.check.RedisConstant;
import com.xipin.est.service.vo.excel.check.CheckResult;
import com.xipin.est.service.vo.excel.check.CheckResultDataVO;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.date.DateUtils;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.serialize.ObjectSerializeUtils;

@Service("itemService")
public class ItemServiceImpl extends BaseService<ItemServiceImpl> implements ItemService{
	
	@Autowired
	private IItemsDao iItemsDao;
	
	@Autowired
	private ICommStringCache commStringCache;

	@Autowired
	private ICommSetCache commSetCace;
	
	@Autowired
	private ICountryDao countryDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IOrgDao orgDao;
	
	@Override
	public CheckResultDataVO checkExcelData(UploadExcelBean uploadExcelBean, List<String[]> excelData) {
//		{//
//			String noStr = commStringCache.getAndSet(RedisConstant.LOT_NUM_SET_ING, uploadExcelBean.getDispatchNo(), RedisConstant.LOT_NUM_TIMEOUT);
//			if(!StringUtils.isEmpty(noStr)){//TODO 等待处理完成
//				throw new BusinessException("当前现在正在处理其他批次,稍等5分钟再提交");
//			}
//		}
		{
			if(commSetCace.exists(RedisConstant.LOT_NUM_SET, uploadExcelBean.getDispatchNo())){
				throw new BusinessException(MsgEnum.S_DISPATCH_EXISTS.getVal());
			}
		}
		CheckResultDataVO vo = new CheckResultDataVO();
		HashMap<Short, List<CheckResult>> map = null;
		PostOfficeStaticRuleEnum e = PostOfficeStaticRuleEnum.选择.get(uploadExcelBean.getPostId() + "", uploadExcelBean.getDispatchType());
		DetailListPo dpo = new DetailListPo();
		if(e == null){
			e = PostOfficeStaticRuleEnum.马邮;
			//commStringCache.delete(RedisConstant.LOT_NUM_SET_ING);
			//throw new BusinessException("该邮局未配置上传校验内容，暂时不予上传!");
		}
		{//检查excel模板（列数是否相同），如果模板通过了就设置dpo数据，没通过就返回错误
			List<CheckResult> rsltList = this.checkTemplateAndSetData(e, dpo, uploadExcelBean, excelData);
			if(rsltList != null && !rsltList.isEmpty()){
				map = new HashMap<>();
				map.put(rsltList.get(0).getType(), rsltList);
				vo.setMap(map);
				HashMap<Short, Integer> totalMap = new HashMap<>();
				totalMap.put(rsltList.get(0).getType(), rsltList.size());
				vo.setTotalMap(totalMap);
				return vo;
			}
		}
		List<String> countryCode = countryDao.getTwoCode();
		DataForExcelCheck data = new DataForExcelCheck(null, countryCode, uploadExcelBean.getCustomerNo(), dpo.getDispatchType(), dpo.getTruckingNo(), commSetCace, uploadExcelBean.getDispatchNo());
		{
			data.setPpiNo(uploadExcelBean.getPpiNo());
			data.setRefRegx(this.createRefRegx(dpo.getJgOrgId(), dpo.getServiceType(), dpo.getDispatchType()));
			data.setBmCode(orgDao.getByKey(dpo.getBmOrgId()).getNo());
			data.setServiceType(dpo.getServiceType());
			data.setLanuage(data.getLanuage());
		}
		int i = 0;
		int pre = computeProcessBar(excelData.size());
		if(pre > 0){
			this.processBar(uploadExcelBean.getUuid(), "0", "D");
		}
		for(PackagePo p : dpo.getPackagePoList()){
			data.setBagNo(p.getPackageNo());
			data.setTargetCountryCode(p.getCountryCode());
			data.setBagRegx(this.createBagNoRegx(dpo.getJgOrgId(), dpo.getServiceType(), p.getCountryCode()));
			for(ItemsPo item : p.getItemsPoList()){
				i++;
				if(pre > 0 && i%pre == 0){//"D"标识正在处理数据
					this.processBar(uploadExcelBean.getUuid(), i/pre/100.0 + "", "D");
				}
				data.setItem(item);
				//会把相关的错误信息放到data中的map
				e.check(data);
				if(StringUtils.isEmpty(item.getReferenceId())){
					item.setReferenceId(this.createESTNo());
				}
			}
		}
		vo.setUuid(uploadExcelBean.getUuid());
		if(data.getMap() == null || data.getMap().size() == 0){
			vo.setDpo(dpo);
			vo.setBagNoSet(data.getBagNoSet());
			vo.setRefIdSet(data.getRefIdSet());
			vo.setDispatchNo(uploadExcelBean.getDispatchNo());
			vo.setSealSet(data.getSealSet());
		} else {
			vo.setMap(data.getMap());
			vo.setTotalMap(data.getTotalMap());
			//commStringCache.delete(RedisConstant.LOT_NUM_SET_ING);
		}
		return vo;
	}
	
	private void processBar(String uuid, String pre, String type){
		try{
			commStringCache.set(uuid, type + pre, 30l);
		} catch(Exception e){
			log.error("进度条,更新失败");
			log.error(e);
		}
	}
	
	private int computeProcessBar(int total){
		if(total > 2000){
			return total / 99;
		}
		return 0;
	}

	@Override
	public void insertItemBatch(List<ItemsPo> itemsPoList, String uuid) {
		int pre = this.computeProcessBar(itemsPoList.size());
		if(pre > 0){
			this.processBar(uuid, "0", "I");
		}
		if(itemsPoList.size() <= Constants.BATCH_INSERT_ITEM_NUM){
			iItemsDao.insertItemBatch(itemsPoList);
		}else{
			int t = itemsPoList.size()/Constants.BATCH_INSERT_ITEM_NUM + 1;
			for(int i=0; i<t; i++){
				int startIndex = i*Constants.BATCH_INSERT_ITEM_NUM;
				int endIndex = startIndex + Constants.BATCH_INSERT_ITEM_NUM;
				if(endIndex > itemsPoList.size()){
					endIndex = itemsPoList.size();
				}
				List<ItemsPo> tempList = itemsPoList.subList(startIndex, endIndex);
				iItemsDao.insertItemBatch(tempList);
				this.processBar(uuid, (((i+1)*Constants.BATCH_INSERT_ITEM_NUM)/pre/100.0) + "", "I");
			}
		}
	}
	
	@Override
	public void deleteItemByDispatchNo(List<String> dispatchNoList) {
		
		if(dispatchNoList.size() <= Constants.BATCH_INSERT_NUM){
			iItemsDao.deleteItemByDispatchNo(dispatchNoList);
		}else{
			int t = dispatchNoList.size()/Constants.BATCH_INSERT_NUM + 1;
			for(int i=0; i<t; i++){
				int startIndex = i*Constants.BATCH_INSERT_NUM;
				int endIndex = startIndex + Constants.BATCH_INSERT_NUM;
				if(endIndex > dispatchNoList.size()){
					endIndex = dispatchNoList.size();
				}
				List<String> tempList = dispatchNoList.subList(startIndex, endIndex);
				iItemsDao.deleteItemByDispatchNo(tempList);
			}
		}
		
	}

	/**
	 * 检查excel是否缺少列
	 * @param e
	 * @param dpo
	 * @param bean
	 * @param excelData
	 * @return
	 */
	private List<CheckResult> checkTemplateAndSetData(PostOfficeStaticRuleEnum e, DetailListPo dpo, UploadExcelBean bean,List<String[]> excelData){
		List<CheckResult> rsltList = new ArrayList<CheckResult>();
		
		if(excelData == null || excelData.size() < 2){
			rsltList.add(new CheckResult((short)0, MsgConfig.getMessage(MsgEnum.NO_DATA.getVal(), bean.getLanguage()), "EXCEL"));
			return rsltList;
		}
		HashMap<String, Integer> map = new HashMap<>();
		rsltList = e.checkCloumnName(excelData.get(0), map, bean.getLanguage());
		if(rsltList.isEmpty()){
			dpo = this.setDetailListData(dpo, bean, map, excelData, e);
		} 
		return rsltList;
	}
	
	/**
	 * 把excel转换为预报清单对象
	 * @param detailListPo
	 * @param bean
	 * @param map
	 * @param excelData
	 * @return
	 */
	private DetailListPo setDetailListData(DetailListPo detailListPo, UploadExcelBean bean, HashMap<String, Integer> map, List<String[]> excelData, PostOfficeStaticRuleEnum e){
		BeanUtils.copyProperties(bean, detailListPo);
		{
			Timestamp now = new Timestamp(new Date().getTime());
			detailListPo.setAddDate(now);
			detailListPo.setUpdateDate(now);
			detailListPo.setAccountNo(bean.getCustomerNo());
			detailListPo.setBmOrgId(Long.valueOf(bean.getTransportLineId()));
			detailListPo.setJgOrgId(bean.getPostId());
			UserOrgPo uop = userDao.getUserInOrgId(bean.getUserId());
			detailListPo.setCJgOrgId(uop.getJgId());
			detailListPo.setCBmOrgId(uop.getBmId());
			detailListPo.setCustomerName(uop.getJgName());
			detailListPo.setStatus(DataStatusEnum.UPLOAD.getValue());
			detailListPo.setPostofficeEnName(PostOfficeEnName.选择.getEnName(detailListPo.getJgOrgId()));
		}
		Map<String,List<ItemsPo>> bagNoMap = new HashMap<>();
		List<ItemsPo> itemPoList = new ArrayList<>();
		Timestamp now = new Timestamp(new Date().getTime());
		//转换为包裹列表
		String[] mheaders = e.getHeaders();
		for(int i = 1; i < excelData.size(); i++){
			String[] row = excelData.get(i);
			ItemsPo po = new ItemsPo();
			
			/*try{
				po.setSerialNumber(Integer.valueOf(row[map.get(mheaders[0])]));
			} catch(Exception e){
				continue;
			}*/
			po = e.setVaFromExcel(mheaders, row, map); 
			po.setRowNum(i+1);
			
			//以下是冗余信息
			po.setPostoffice(bean.getPostoffice());
			po.setPostofficeEnName(detailListPo.getPostofficeEnName());
			po.setTransportLine(bean.getTransportLine());
			po.setCn35("");
			po.setCountryCode(po.getReceiverCountryCode());
			{
				po.setQuantity(StringUtils.toString(po.getQty()));
			}
			po.setAddWho(bean.getAddWho());
			po.setAddDate(now);
			po.setUpdateDate(now);
			if(StringUtils.isEmpty(po.getCustomerNo())){
				po.setCustomerNo(bean.getCustomerNo());
			}
			if(StringUtils.isEmpty(po.getPpiNo())){
				po.setCustomerNo(bean.getPpiNo());
			}
			itemPoList.add(po);
			
			//把邮包对应的列表拿出来
			List<ItemsPo> bagNoPoList = (List<ItemsPo>) bagNoMap.get(po.getBagNo());
			if(bagNoPoList == null){
				bagNoPoList = new ArrayList<>();
			}
			bagNoPoList.add(po);
			bagNoMap.put(po.getBagNo(), bagNoPoList);
			
		}
		BigDecimal lotTotalQty = BigDecimal.ZERO;
		BigDecimal lotTotalWeight = BigDecimal.ZERO;
		//生成邮包
		List<PackagePo> packagePoList = new ArrayList<>();
		for (Entry<String, List<ItemsPo>> entry : bagNoMap.entrySet()) {
			
			PackagePo packagePo = new PackagePo();
			packagePo.setPackageNo(entry.getKey());
			{
				BeanUtils.copyProperties(detailListPo, packagePo);
			}
			List<ItemsPo> poList = entry.getValue();
			
			BigDecimal totalQty = BigDecimal.ZERO;
			BigDecimal totalWeight = BigDecimal.ZERO;
			for(ItemsPo po : poList){
				totalQty = totalQty.add(po.getQty() == null ? BigDecimal.ONE : po.getQty());
				totalWeight = totalWeight.add(po.getWeight() == null ? BigDecimal.ZERO : po.getWeight());
				if(StringUtils.isEmpty(packagePo.getCountryCode())){
					packagePo.setCountryCode(po.getReceiverCountryCode());
				}
				if(StringUtils.isEmpty(packagePo.getSealNo())){
					packagePo.setSealNo(po.getSealNo());
				}
			}
			packagePo.setEstimatePackageNum(totalQty);
			packagePo.setEstimatePackageWeight(totalWeight);
			lotTotalQty = lotTotalQty.add(totalQty);
			lotTotalWeight = lotTotalWeight.add(totalWeight);
			packagePo.setItemsPoList(poList);
			packagePoList.add(packagePo);
		}
		detailListPo.setPackagePoList(packagePoList);
		detailListPo.setEstimateTotalWeight(lotTotalWeight);
		detailListPo.setEstimateBagNum(new BigDecimal(bagNoMap.size()));
		detailListPo.setCountryCode(packagePoList.get(0).getCountryCode());
		return detailListPo;
	}
	
	/**
	 * Format: 20151211	 			00000001		  		
     * 		Timestamp(yyyyMMddhhmmss)	num
	 * @return
	 */
	@Override
	public String createESTNo(){
		String timestamp = DateUtils.getNow24();
		String key = RedisConstant.EST_REF_ID_START + timestamp.substring(0, 8);
		Long saleNum = 0l;
		try{
			saleNum = commStringCache.incr(key, null);
//			saleNum = saleNum*Integer.parseInt(timestamp.substring(6, 8));
//			saleNumStr = saleNum + "";
//			for(int i = 0; i < 7 - (saleNum+"").length(); i++){
//				saleNumStr = "0" + saleNumStr;
//			}
		} catch(DataAccessException e){
			log.error("Redis 连接失败，导致生成单号失败!");
			throw new BusinessException(MsgEnum.S_CREATE_NO_FAILED.getVal());
		}
		
		return timestamp + saleNum;
	}

	@Override
	public boolean getAndSign() {
		return false;
	}

	@Override
	public void insertNoInRedis(String dispatchNo, Set<byte[]> bagNoSet, Set<byte[]> refIdSet, Set<byte[]> sealSet) {
		try{
			commSetCace.setOne(RedisConstant.LOT_NUM_SET, dispatchNo);
		} catch(Exception e){
			log.error("redis 插入批次失败");
			log.error(dispatchNo);
		}
		try{
			commSetCace.set(RedisConstant.BAG_NO_SET, bagNoSet);
		} catch(Exception e){
			log.error("redis 插入邮袋失败");
			log.error(this.setToString(bagNoSet));
		}
		try{
			commSetCace.set(RedisConstant.REF_ID_SET, refIdSet);
		} catch(Exception e){
			log.error("redis 插入跟踪号失败");
			log.error(this.setToString(refIdSet));
		}
		try{
			commSetCace.set(RedisConstant.SEAL_NO_SET, sealSet);
		} catch(Exception e){
			log.error("redis 插入扎袋失败");
			log.error(this.setToString(sealSet));
		}
		try{
			commStringCache.delete(RedisConstant.LOT_NUM_SET_ING);
		} catch(Exception e){
			//Do nothing
		}
	}
	
	private String setToString(Set<byte[]> set){
		StringBuilder sb = new StringBuilder();
		for(byte[] str : set){
			sb.append(ObjectSerializeUtils.serializeObject(str)).append(",");
		}
		return sb.toString();
	}

	@Override
	public void checkDispatchNo(String dispatchNo) {
		if(commSetCace.exists(RedisConstant.LOT_NUM_SET, dispatchNo)){
			throw new BusinessException(MsgEnum.S_DISPATCH_EXISTS.getVal());
		}
//		if(dispatchNo.equals(commStringCache.get(RedisConstant.LOT_NUM_SET_ING))){
//			throw new BusinessException("该批次号正在处理中，请确认是否有其他操作人员正在上传该批次数据");
//		}
	}


	@Override
	public List<String> getReferenceIdByparamMap(Map<String, Object> map) {
		return iItemsDao.getReferenceIdByparamMap(map);
	}
	
	

	@Override
	public List<String> queryReferenceIdListByDispatchNo(
			DetailListDeleteBean detailListDeleteBean) {
		List<String> referenceIdList = new ArrayList<>();
		PackageUpdateBean packageUpdateBean = new PackageUpdateBean();
		for(int i=0 ;i<detailListDeleteBean.getList().size();i++){
			packageUpdateBean.setDispatchNo(detailListDeleteBean.getList().get(i));
			packageUpdateBean.setPostofficeEnName(detailListDeleteBean.getPoenList().get(i));
			List<String> temp = 
			iItemsDao.queryReferenceIdListByDispatchNo(packageUpdateBean);
			referenceIdList.addAll(temp);
		}
		return referenceIdList;
	}

	@Override
	public void updateItemCN35(PackageUpdateBean packageUpdateBean) {
		iItemsDao.updateItemCN35(packageUpdateBean);
	}
	
	

	@Override
	public void updateItemCN35ByBagNo(PackageUpdateBean packageUpdateBean) {
		iItemsDao.updateItemCN35ByBagNo(packageUpdateBean);
		
	}

	@Override
	public String queryCn35ByReferenceId(PackageUpdateBean packageUpdateBean) {
		return iItemsDao.queryCn35ByReferenceId(packageUpdateBean);
	}

	@Override
	public void updateTruckingNo(DetailListUpdateBean bean) {
		iItemsDao.updateTruckingNo(bean);
	}
	
	private String createDispatchRegx(Long jgId, Long bmId, String serviceType, String postType){
		String regx = "^SY";
		
		return regx;
	}
	
	private String createBagNoRegx(Long jgId, String serviceType, String cc){
		String regx = "^SY[A-Z]{0,1}";
		String ptn = PostOfficeTypeName.选择.getName(jgId, -1L);
		regx += ptn;
		if(serviceType.equals("1")){
			regx += cc;
		}
		if(ptn.equals("TW")){
			regx += "[0-9]{11}";
		} else {
			regx += "[0-9]{10}";
		}
		regx += "$";
		return regx;
	}
	
	private String createRefRegx(Long jgId, String serviceType, String postType){
		String regx = "";
		String ptn = PostOfficeTypeName.选择.getName(jgId, -1L);
		if(!postType.equals("R") && !postType.equals("EMS")){
			if(ptn.equals("MY")){
				regx = "^SY[A-Z]{0,1}" + ptn + "[0-9]{7}$";
			} else {
				regx = "^SY" + ptn + "[0-9]{10}$";
			}
		} else {
			if(serviceType.equals("2") && ptn.equals("MY")){
				regx = "^RC[0-9]{9}" + ptn + "$";
			} else if(serviceType.equals("1") && ptn.equals("MY")){
				regx = "^RN[0-9]{9}" + ptn + "$";
			} else {
				regx = "^RR[0-9]{9}" + ptn + "$";
			}
		}
		return regx;
	}
	
	public static void main(String[] args) {
		String regx = "^SY[A-Z]{1}-VP-[0-9]{4}-R$";
		System.out.println("SYL-VP-0001-R".matches(regx));
	}
	
	
}
