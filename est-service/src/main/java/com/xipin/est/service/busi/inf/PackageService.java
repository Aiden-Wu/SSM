package com.xipin.est.service.busi.inf;

import java.util.List;
import java.util.Map;

import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.db.bean.PackageInputWeightBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.po.PackagePo;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.utils.bean.PageBean;


/**
 * 
 * <p>Description: 邮包数据库服务接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface PackageService {

	
	/**
	 * 
	 * 方法用途: 批量插入邮包<br>
	 * 实现步骤: <br>
	 * @param packagePoList
	 */
	void insertPackageBatch(List<PackagePo> packagePoList);
	
	/**
	 * 
	 * 方法用途: 查询邮包列表<br>
	 * 实现步骤: <br>
	 * @param packageListBean
	 * @param page
	 * @return
	 */
	PageBean<PackageListPo> queryPackageListByParam(PackageListBean packageListBean,
			PageBean<PackageListPo> page);

	/**
	 * 
	 * 方法用途: 查询邮包列表<br>
	 * 实现步骤: <br>
	 * @param dispatchNo
	 * @return
	 */
	List<PackageListPo> queryPackageListByDispatchNo(String dispatchNo);
	
	/**
	 * 
	 * 方法用途: 填入实际数量和重量<br>
	 * 实现步骤: <br>
	 * @param packageBean
	 */
	void inputWeight(PackageInputWeightBean packageInputWeightBean);
	
	/**
	 * 
	 * 方法用途: 根据批次号删除邮包<br>
	 * 实现步骤: <br>
	 * @param dispatchNoList
	 */
	void deletePackageByDispatchNo(List<String> dispatchNoList);
	
	
	
	/**
	 * 
	 * 方法用途: 更新包裹信息<br>
	 * 实现步骤: <br>
	 * @param packageUpdateBean
	 */
//	void updatePackageInfo(PackageUpdateBean packageUpdateBean);
	
	void updatePackageCn35(PackageUpdateBean packageUpdateBean);

	PageBean<PackageListPo> queryPackageListForDetailListByParam(
			PackageListBean packageListBean, PageBean<PackageListPo> page);
	
	
//	List<String> queryPackageNoByDispatchNo(String dispatchNo);
	
	List<String> queryPackageNoByDispatchNo(Map<String,Object> map);
	
	List<String> queryPackageNoListByDispatchNo(DetailListDeleteBean detailListDeleteBean);
	
	
	List<String> querySealNoByDispatchNo(Map<String,Object> map);
	
	List<String> querySealNoListByDispatchNo(DetailListDeleteBean detailListDeleteBean);
	
	
	PackageListPo queryPackageInfo(PackageUpdateBean packageUpdateBean);
	
	
	int queryPackageInfoForCn35(UpdateDetailListBean updateDetailListBean);
	
	
	int queryPackageCn35Num(PackageUpdateBean packageUpdateBean);

	void inputCN35(PackageBean packageBean);
	
	void inputCN38(PackageBean packageBean);

}
