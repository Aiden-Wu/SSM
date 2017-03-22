package com.xipin.est.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.db.po.post.PackageListPo;

/**
 * 
 * <p>Description: 包裹数据库操作接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Repository
public interface IItemsDao {
	
	public void insertItemBatch(List<ItemsPo> itemsPoList);
	
	public void deleteItemByDispatchNo(List<String> dispatchNoList);
	
	public List<String> getReferenceIdByparamMap(Map<String, Object> map);
	
	List<String> queryReferenceIdListByDispatchNo(PackageUpdateBean packageUpdateBean);

	public List<PackageListPo> queryItemListByDispatchNo(PackageListBean packageListBean);

	public int queryItemCountByDispatchNo(PackageListBean packageListBean);
	
	public void updateItemCN35(PackageUpdateBean packageUpdateBean);
	
	public void updateItemCN38(PackageBean packageUpdateBean);
	
	public void updateItemCN35ByBagNo(PackageUpdateBean packageUpdateBean);
	
	public String queryCn35ByReferenceId(PackageUpdateBean packageUpdateBean);

	public void updateTruckingNo(DetailListUpdateBean bean);

	public void inputCN35(PackageBean packageBean);
	public void inputCN38(PackageBean packageBean);

}
