package com.xipin.est.manager.post;

import java.util.List;
import java.util.Map;

import com.xipin.est.db.bean.DetailListListBean;
import com.xipin.est.db.bean.InputCNBean;
import com.xipin.est.db.bean.InputWeightBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.po.post.DetailListListPo;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

public interface PostManager {

	/**
	 * 
	 * 方法用途: 查询待处理任务列表<br>
	 */
	public Result<List<DetailListListPo>> queryPendingTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询处理中任务列表<br>
	 */
	public Result<List<DetailListListPo>> queryDoingTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询完成任务列表<br>
	 */
	public Result<List<DetailListListPo>> queryFinishTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询清单总览列表<br>
	 */
	public Result<List<DetailListListPo>> queryTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询邮包列表<br>
	 */
	public Result<List<PackageListPo>> queryPackageList(PackageListBean packageListBean,
			PageBean<PackageListPo> page);

	/**
	 * 
	 * 方法用途: 批量录入重量<br>
	 */
	public Result<String> inputWeight(InputWeightBean inputWeightBean);

	/**
	 * 
	 * 方法用途: 导出邮袋列表<br>
	 */
	public Map<String, Object> queryPackageExportData(PackageListBean packageListBean);

	/**
	 * 
	 * 方法用途: 批量录入CN35<br>
	 */
	public Result<String> inputCN35(InputCNBean inputCNBean);

	/**
	 * 
	 * 方法用途: 录入CN38<br>
	 */
	public Result<String> inputCN38(InputCNBean inputCNBean);

	/**
	 * 
	 * 方法用途: 是否可以录入CN35<br>
	 */
	public Result<String> isInputCN35(String dispatchNo);

	/**
	 * 
	 * 方法用途: 是否可以录入CN38<br>
	 */
	public Result<String> isInputCN38(String dispatchNo);

}
