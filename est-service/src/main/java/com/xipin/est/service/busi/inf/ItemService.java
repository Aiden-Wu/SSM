package com.xipin.est.service.busi.inf;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UploadExcelBean;
import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.service.vo.excel.check.CheckResultDataVO;

public interface ItemService {
	
	CheckResultDataVO checkExcelData(UploadExcelBean uploadExcelBean, List<String[]> excelData);
	
	public void insertItemBatch(List<ItemsPo> itemsPoList, String uuid);
	
	void deleteItemByDispatchNo(List<String> dispatchNoList);

	/**
	 * 生成跟踪号序列
	 * @return
	 */
	String createESTNo();

	boolean getAndSign();
	
	void insertNoInRedis(String dispatchNo, Set<byte[]> bagNoSet, Set<byte[]> refIdSet, Set<byte[]> sealSet);
	
	void checkDispatchNo(String dispatchNo);
	
	List<String> getReferenceIdByparamMap(Map<String,Object> map);
	
	List<String> queryReferenceIdListByDispatchNo(DetailListDeleteBean detailListDeleteBean);
	
	void updateItemCN35(PackageUpdateBean packageUpdateBean);
	
	//更新有值的包裹的cn35
	void updateItemCN35ByBagNo(PackageUpdateBean packageUpdateBean);
	
	public String queryCn35ByReferenceId(PackageUpdateBean packageUpdateBean);

	void updateTruckingNo(DetailListUpdateBean bean);
}
