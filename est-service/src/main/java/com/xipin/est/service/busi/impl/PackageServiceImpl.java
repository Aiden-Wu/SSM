package com.xipin.est.service.busi.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.db.bean.PackageInputWeightBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.dao.IItemsDao;
import com.xipin.est.db.dao.IPackageDao;
import com.xipin.est.db.po.PackagePo;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.service.busi.inf.PackageService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ObjectType;

@Service("packageService")
public class PackageServiceImpl implements PackageService {

	@Autowired
	private IPackageDao packageDao;
	
	@Autowired
	private IItemsDao itemDao;

	@Override
	public PageBean<PackageListPo> queryPackageListByParam(PackageListBean packageListBean,
			PageBean<PackageListPo> page) {
		packageListBean.setBeginIndex(0);
		packageListBean.setPageSize(1000);
		List<PackageListPo> list = packageDao.queryPackageListByParam(packageListBean);
		page.setCount(packageDao.queryPackageCount(packageListBean));
		page.setData(list);
		return page;
	}

	@Override
	public void insertPackageBatch(List<PackagePo> packagePoList) {
		if(packagePoList.size() <= Constants.BATCH_INSERT_NUM){
			packageDao.insertPackageBatch(packagePoList);
		}else{
			//List<Thread> tList = new ArrayList<Thread>();
			int t = packagePoList.size()/Constants.BATCH_INSERT_NUM + 1;
			for(int i=0; i < t; i++){
				int fromIndex = i*Constants.BATCH_INSERT_NUM;
				int toIndex = fromIndex + Constants.BATCH_INSERT_NUM;
				if(toIndex > packagePoList.size()){
					toIndex = packagePoList.size();
				}

				 List<PackagePo> tempList = packagePoList.subList(fromIndex, toIndex);	
				 packageDao.insertPackageBatch(tempList);
				 /*	Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						packageDao.insertPackageBatch(tempList);
					}
				});
				tList.add(thread);
			}
			for(Thread st : tList){
				st.start();
			}
			try{
				for(Thread st : tList){
					st.join();
				}
			} catch(Exception e){
				throw new BusinessException("Insert failed!!!");
			}*/
			}	 
		}

	}

	@Override
	public List<PackageListPo> queryPackageListByDispatchNo(String dispatchNo) {
		return packageDao.queryPackageListByDispatchNo(dispatchNo);
	}

	@Override
	@UpdateLog(description="录入邮包重量", objectType=ObjectType.PACKAGE, tableName="package")
	public void inputWeight(PackageInputWeightBean packageInputWeightBean) {
		packageDao.inputWeight(packageInputWeightBean);
	}

	@Override
	public void deletePackageByDispatchNo(List<String> dispatchNoList) {
		
		if(dispatchNoList.size() <= Constants.BATCH_INSERT_NUM){
			packageDao.deletePackageByDispatchNo(dispatchNoList);
		}else{
			int t = dispatchNoList.size()/Constants.BATCH_INSERT_NUM + 1;
			for(int i=0; i<t; i++){
				int startIndex = i*Constants.BATCH_INSERT_NUM;
				int endIndex = startIndex + Constants.BATCH_INSERT_NUM;
				if(endIndex > dispatchNoList.size()){
					endIndex = dispatchNoList.size();
				}
				List<String> tempList = dispatchNoList.subList(startIndex, endIndex);
				packageDao.deletePackageByDispatchNo(tempList);
			}
		}
	}

//	@Override
//	@UpdateLog(description="修改邮袋", objectType=ObjectType.PACKAGE, tableName="package")
//	public void updatePackageInfo(PackageUpdateBean packageUpdateBean) {
//		packageDao.updatePackageInfo(packageUpdateBean);
//	}
	
	

	@Override
	public void updatePackageCn35(PackageUpdateBean packageUpdateBean) {
		packageDao.updatePackageCn35(packageUpdateBean);
	}

	@Override
	public PageBean<PackageListPo> queryPackageListForDetailListByParam(
			PackageListBean packageListBean, PageBean<PackageListPo> page) {
		packageListBean.setBeginIndex(page.getStart());
		packageListBean.setPageSize(page.getPageSize());
		
//		String dispatchType = packageListBean.getDispatchType();
//		if(!"DE-R".equals(dispatchType)){
//			//非DE-R
//			List<PackageListPo> packageList = packageDao.queryPackageListByParam(packageListBean);
//			page.setCount(packageDao.queryPackageCount(packageListBean));
//			page.setData(packageList);
//		}else{
//			//DE-R
//			List<PackageListPo> itemList = itemDao.queryItemListByDispatchNo(packageListBean);
//			page.setCount(itemDao.queryItemCountByDispatchNo(packageListBean));
//			for (PackageListPo item : itemList) {
//				String bagNo = item.getPackageNo();
//				PackageUpdateBean packageUpdateBean = new PackageUpdateBean();
//				packageUpdateBean.setPackageNo(bagNo);
//				packageUpdateBean.setPostofficeEnName(packageListBean.getPostofficeEnName());
//				packageUpdateBean.setDispatchNo(packageListBean.getDispatchNo());
//				
//				PackageListPo packagePo = packageDao.queryPackageInfo(packageUpdateBean);
//				item.setActualPackageNum(packagePo.getActualPackageNum());
//				item.setActualPackageWeight(packagePo.getActualPackageWeight());
//			}
//			page.setData(itemList);
//		}
		
		
		//非DE-R
		List<PackageListPo> packageList = packageDao.queryPackageListByParam(packageListBean);
		page.setCount(packageDao.queryPackageCount(packageListBean));
		page.setData(packageList);
		
		return page;
	}
	
//	public List<String> queryPackageNoByDispatchNo(String dispatchNo) {
//		return packageDao.queryPackageNoByDispatchNo(dispatchNo);
//	}
	
	

	@Override
	public List<String> queryPackageNoByDispatchNo(Map<String, Object> map) {
		return packageDao.queryPackageNoByDispatchNo(map);
	}

	@Override
	public List<String> queryPackageNoListByDispatchNo(
			DetailListDeleteBean detailListDeleteBean) {
		
		List<String> packageNoList = new ArrayList<>();
		
		PackageUpdateBean packageUpdateBean = new PackageUpdateBean();
		for(int i=0;i<detailListDeleteBean.getList().size();i++){
			packageUpdateBean.setDispatchNo(detailListDeleteBean.getList().get(i));
			packageUpdateBean.setPostofficeEnName(detailListDeleteBean.getPoenList().get(i));
			
			List<String> temp = packageDao.queryPackageNoListByDispatchNo(packageUpdateBean);
			packageNoList.addAll(temp);
		}
		return packageNoList;
	}

	@Override
	public List<String> querySealNoByDispatchNo(Map<String, Object> map) {
		return packageDao.querySealNoByDispatchNo(map);
	}
	

	@Override
	public List<String> querySealNoListByDispatchNo(
			DetailListDeleteBean detailListDeleteBean) {
		List<String> sealNoList = new ArrayList<>();
		
		PackageUpdateBean packageUpdateBean = new PackageUpdateBean();
		for(int i=0;i<detailListDeleteBean.getList().size();i++){
			packageUpdateBean.setDispatchNo(detailListDeleteBean.getList().get(i));
			packageUpdateBean.setPostofficeEnName(detailListDeleteBean.getPoenList().get(i));
			List<String> temp = packageDao.querySealNoListByDispatchNo(packageUpdateBean);
			sealNoList.addAll(temp);
		}
		return sealNoList;
	}

	@Override
	public PackageListPo queryPackageInfo(PackageUpdateBean packageUpdateBean) {
		return packageDao.queryPackageInfo(packageUpdateBean);
	}

	@Override
	public int queryPackageInfoForCn35(UpdateDetailListBean updateDetailListBean) {
		return packageDao.queryPackageInfoForCn35(updateDetailListBean);
	}

	@Override
	public int queryPackageCn35Num(PackageUpdateBean packageUpdateBean) {
		return packageDao.queryPackageCn35Num(packageUpdateBean);
	}

	@Override
	@UpdateLog(description="录入CN35", objectType=ObjectType.PACKAGE, tableName="package")
	public void inputCN35(PackageBean packageBean) {
		packageDao.inputCN35(packageBean);
		itemDao.inputCN35(packageBean);
	}

	@Override
	@UpdateLog(description="录入CN38", objectType=ObjectType.PACKAGE, tableName="package")
	public void inputCN38(PackageBean packageBean) {
		packageDao.inputCN38(packageBean);
		itemDao.inputCN38(packageBean);
	}
	
	
	public void delPackage(){
		//String 
		
	}

}
