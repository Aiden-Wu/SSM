package com.xipin.est.service.busi.inf;

import java.util.List;
import java.util.Map;

import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.DetailListInputWeightBean;
import com.xipin.est.db.bean.DetailListListBean;
import com.xipin.est.db.bean.DetailListPoBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.po.client.DetailDataListPo;
import com.xipin.est.db.po.post.DetailListListPo;
import com.xipin.est.utils.bean.PageBean;

/**
 * 
 * <p>Description: 预报清单数据库服务接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface DetailListService {

	/**
	 * 
	 * 方法用途: 查询待处理任务列表<br>
	 * 实现步骤: <br>
	 * @param taskListBean 参数Bean
	 * @return 待处理任务列表
	 */
	PageBean<DetailListListPo> queryPendingTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询处理中任务列表<br>
	 * 实现步骤: <br>
	 * @param taskListBean 参数Bean
	 * @return 处理中任务列表
	 */
	PageBean<DetailListListPo> queryDoingTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询完成任务<br>
	 * 实现步骤: <br>
	 * @param taskListBean
	 * @param page
	 * @return
	 */
	PageBean<DetailListListPo> queryFinishTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);

	/**
	 * 
	 * 方法用途: 查询任务列表<br>
	 * 实现步骤: <br>
	 * @param taskListBean 参数Bean
	 * @return 处理中任务列表
	 */
	PageBean<DetailListListPo> queryTaskList(DetailListListBean taskListBean,
			PageBean<DetailListListPo> page);
	
	
	
	/**
	 * 
	 * 方法用途: 查询刚上传的订单列表<br>
	 * 实现步骤: <br>
	 * @param detailListBean
	 * @param page
	 * @return
	 */
	PageBean<DetailDataListPo> getFirstDetailList(DetailListBean detailListBean,
			PageBean<DetailDataListPo> page);
	
	/**
	 * 
	 * 方法用途: 查询已提交的清单列表<br>
	 * 实现步骤: <br>
	 * @param detailListBean
	 * @param page
	 * @return
	 */
	PageBean<DetailDataListPo> gethistoryDetailList(DetailListBean detailListBean,
			PageBean<DetailDataListPo> page);
	
	/**
	 * 
	 * 方法用途: 插入清单<br>
	 * 实现步骤: <br>
	 * @param detailListPo
	 */
	void insertDetailList(DetailListPoBean detailListPoBean);

	/**
	 * 
	 * 方法用途: 删除清单列表<br>
	 * 实现步骤: <br>
	 * @param dispatchNoListss
	 */
	void deleteDetailList(UpdateDetailListBean bean);

	/**
	 * 
	 * 方法用途: 批量结单<br>
	 * 实现步骤: <br>
	 * @param finishDetailListBean
	 */
	void updateDetailStatus(UpdateDetailListBean finishDetailListBean);
	
	/**
	 * 
	 * 方法用途: 更新批次的邮袋数量和总重<br>
	 * 实现步骤: <br>
	 * @param detailListInputWeightBean 
	 */
	void inputWeight(DetailListInputWeightBean detailListInputWeightBean);
	
	/**
	 * 
	 * 方法用途: 清单提交<br>
	 * 实现步骤: <br>
	 * @param dispatchNoList
	 */
	void submitDetailList(UpdateDetailListBean updateDetailListBean);
	
	/**
	 * 
	 *  方法用途: 通过批次号列表，获取清单列表<br>
	 * 实现步骤: <br>
	 * @param dispatchNoList
	 * @return
	 */
	List<DetailListListPo> getDetailListByDispatchNoList(List<String> dispatchNoList, String language);
	
	
	
	DetailDataListPo getDetailListByDispatchNo(Map<String,Object> map);
	
	/**
	 * 
	 * 方法用途: 根据批次号查询预报清单<br>
	 * 实现步骤: <br>
	 * @param dispatchNo
	 * @return
	 */
	DetailListListPo queryDetailListByDispatchNo(String dispatchNo, String language);

	void updateTruckingNo(DetailListUpdateBean bean);

	String isInputCN35(String dispatchNo);

	String isInputCN38(String dispatchNo);
	
	void judgeDetailListIsCanDelete(DetailListDeleteBean detailListDeleteBean);
}
