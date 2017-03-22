package com.xipin.est.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.po.PackagePo;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.db.bean.PackageInputWeightBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.po.post.PackageListPo;

/**
 * 
 * <p>Description: 邮包数据库操作接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Repository
public interface IPackageDao {
	
	public void insertPackageBatch(List<PackagePo> packagePoList);
	/**
	 * 
	 * 方法用途: 查询包裹列表<br>
	 * 实现步骤: <br>
	 * @param packageListBean
	 * @return
	 */
	@MapKey("packageNo")
	Map<String, PackageListPo> queryPackageListByParamToMap(PackageListBean packageListBean);
	

	List<PackageListPo> queryPackageListByParam(PackageListBean packageListBean);
	
	/**
	 * 
	 * 方法用途: 查询包裹数量<br>
	 * 实现步骤: <br>
	 * @param packageListBean
	 * @return
	 */
	Integer queryPackageCount(PackageListBean packageListBean);
	
	/**
	 * 
	 * 方法用途: 查询包裹列表<br>
	 * 实现步骤: <br>
	 * @param dispatchNo
	 * @return
	 */
	List<PackageListPo> queryPackageListByDispatchNo(String dispatchNo);
	
	/**
	 * 
	 * 查询邮包编号列表
	 * @param dispatchNo
	 * @return
	 */
	List<String> queryPackageNoByDispatchNo(Map<String,Object> map);
	
	/**
	 * 查询邮包编号列表
	 * @param packageUpdateBean
	 * @return
	 */
	List<String> queryPackageNoListByDispatchNo(PackageUpdateBean packageUpdateBean);
	
	/**
	 * 查询扎袋数列表
	 * @param map
	 * @return
	 */
	List<String> querySealNoByDispatchNo(Map<String, Object> map);
	
	
	List<String> querySealNoListByDispatchNo(PackageUpdateBean packageUpdateBean);
	
	/**
	 * 
	 * 查询邮包数量
	 * @param dispatchNo
	 * @return
	 */
//	int  queryPackageNumByDispatchNo(String dispatchNo);
	
	
	/**
	 * 
	 * 方法用途: 录入实际重量和数量<br>
	 * 实现步骤: <br>
	 * @param packageBean
	 */
	void inputWeight(PackageInputWeightBean packageInputWeightBean);
	
	
	/**
	 * 
	 * 方法用途: 删除邮包<br>
	 * 实现步骤: <br>
	 * @param packageBean
	 * @param dispatchNoList
	 */
	public void deletePackageByDispatchNo(List<String> dispatchNoList);
	
	
	
	/**
	 * 
	 * 更新邮包信息
	 * @param packageUpdateBean
	 */
//	void updatePackageInfo(PackageUpdateBean packageUpdateBean);
	
	
	/**
	 * 
	 * 更新邮包cn35
	 * @param packageUpdateBean
	 */
	void updatePackageCn35(PackageUpdateBean packageUpdateBean);
	
	
	/**
	 * 
	 * 根据批次号和邮包信息查询邮包信息
	 * @param packageUpdateBean
	 * @return
	 */
	public PackageListPo queryPackageInfo(PackageUpdateBean packageUpdateBean);
	
	
	int queryPackageInfoForCn35(UpdateDetailListBean updateDetailListBean);
	
	int queryPackageCn35Num(PackageUpdateBean packageUpdateBean);
	
	void inputCN35(PackageBean packageBean);
	void inputCN38(PackageBean packageBean);
	
	
}
