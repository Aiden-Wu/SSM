package com.xipin.est.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.bean.DetailListInputWeightBean;
import com.xipin.est.db.bean.DetailListListBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.UpdateDetailListBean;
import com.xipin.est.db.po.DetailListPo;
import com.xipin.est.db.po.client.DetailDataListPo;
import com.xipin.est.db.po.post.DetailListListPo;

/**
 * 
 * <p>Description: 预报清单数据库操作接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Repository
public interface IDetailListDao {

	/**
	 * 
	 * 方法用途: 查询清单列表<br>
	 * 实现步骤: <br>
	 * @param taskListBean
	 * @return
	 */
	List<DetailListListPo> queryDetailListList(DetailListListBean taskListBean);

	/**
	 * 
	 * 方法用途: 查询清单数量<br>
	 * 实现步骤: <br>
	 * @param taskListBean
	 * @return
	 */
	int queryDetailListCount(DetailListListBean taskListBean);
	
	/**
	 * 
	 * 查询清单数量
	 * @param DetailListBean
	 * @return
	 */
	int queryFirstDetailListNum(DetailListBean detailListBean);
	/**
	 * 
	 * 查询清单数量
	 * @param DetailListBean
	 * @return
	 */
	int queryHistoryDetailListNum(DetailListBean detailListBean);
	
	/**
	 * 
	 * 方法用途: 查询刚开始上传的清单列表<br>
	 * 实现步骤: <br>
	 * @param detailListBean
	 * @return
	 */
	List<DetailDataListPo> getFirstDetailList(DetailListBean detailListBean);
	
	/**
	 * 
	 * 方法用途: 查询历史清单<br>
	 * 实现步骤: <br>
	 * @param detailListBean
	 * @return
	 */
	List<DetailDataListPo> gethistoryDetailList(DetailListBean detailListBean);
	
	/**
	 * 
	 * 方法用途: 插入清单<br>
	 * 实现步骤: <br>
	 * @param detailListPo
	 */
	void insertDetailList(DetailListPo detailListPo);
	
	/**
	 * 
	 * 方法用途: 删除清单<br>
	 * 实现步骤: <br>
	 * @param dispatchNoList
	 */
	public void deleteDetailList(String dispatchNo);
	
	/**
	 * 
	 * 方法用途: 批量结单<br>
	 * 实现步骤: <br>
	 * @param finishDetailListBean
	 */
	void updateDetailStatus(UpdateDetailListBean finishDetailListBean);
	
	/**
	 * 
	 * 方法用途: 提交清单
	 * @param finishDetailListBean
	 */
	void submitDetailListForDate(UpdateDetailListBean finishDetailListBean);
	
	/**
	 * 
	 * 方法用途: 更新批次的邮袋数量和总重<br>
	 * 实现步骤: <br>
	 * @param detailListInputWeightBean 
	 */
	void detailListInputWeight(DetailListInputWeightBean detailListInputWeightBean);

	/**
	 * 
	 * 提交清单列表
	 * @param dispatchNo
	 */
	void submitDetailList(String dispatchNo);
	
	/**
	 * 
	 * 方法用途: 获取清单列表<br>
	 * 实现步骤: <br>
	 * @param dispatchNoList
	 * @return
	 */
	List<DetailListListPo> getDetailListByDispatchNoList(@Param("list") List<String> dispatchNoList, @Param("language") String language);
	
	/**
	 * 
	 * 方法用途: 根据批次号查询未处理的清单<br>
	 * 实现步骤: <br>
	 * @param map
	 * @return
	 */
	DetailDataListPo getDetailListByDispatchNo(Map<String, Object> map);
	
	/**
	 * 
	 * 方法用途: 根据批次号查询预报清单<br>
	 * 实现步骤: <br>
	 * @param dispatchNo
	 * @return
	 */
	DetailListListPo queryDetailListByDispatchNo(@Param("dispatchNo") String dispatchNo, @Param("language") String language);

	void updateTruckingNo(DetailListUpdateBean bean);
	
	String queryDispatchNoForNotCanDelete(DetailListUpdateBean bean);

}
