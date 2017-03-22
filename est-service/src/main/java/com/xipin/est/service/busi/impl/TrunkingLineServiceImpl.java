package com.xipin.est.service.busi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.dao.TrunkingLineDao;
import com.xipin.est.db.po.manager.TrunkingLinePo;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.apsect.annotation.InsertLog;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.service.busi.inf.TrunkingLineService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.ObjectType;

@Service
public class TrunkingLineServiceImpl implements TrunkingLineService{

	@Autowired
	private TrunkingLineDao trunkingLineDao;
	
	
	@Override
	@InsertLog(description="添加航线", tableName="trunking_line", objectType=ObjectType.TRUNKING_LINE)
	public void addTrunkingLine(TrunkingLineBean trunkingLineBean) {
		trunkingLineDao.addTrunkingLine(trunkingLineBean);
		
	}

	@Override
	@DeleteLog(description="删除航线", tableName="trunking_line", objectType=ObjectType.TRUNKING_LINE)
	public void deleteTrunkingLine(IDBean idBean) {
		trunkingLineDao.deleteTrunkingLine(idBean.getId());
		
	}

	@Override
	@UpdateLog(description="修改航线", tableName="trunking_line", objectType=ObjectType.TRUNKING_LINE)
	public void updateTrunkingLine(TrunkingLineBean trunkingLineBean) {
		trunkingLineDao.updateTrunkingLine(trunkingLineBean);
	}

	@Override
	public PageBean<TrunkingLinePo> getTrunkingLine(
			TrunkingLineBean trunkingLineBean, PageBean<TrunkingLinePo> page) {
		
		trunkingLineBean.setBeginIndex(page.getStart());
		trunkingLineBean.setPageSize(page.getPageSize());
		List<TrunkingLinePo> list = trunkingLineDao.getTrunkingLineList(trunkingLineBean);
		page.setCount(trunkingLineDao.queryTrunkingLineListNum(trunkingLineBean));
		page.setData(list);
		
		return page;
	}

	@Override
	public List<TrunkingLinePo> getTrunkingLineListByUserId(int UserId) {
		return trunkingLineDao.getTrunkingLineListByUserId(UserId);
	}

	@Override
	public List<TrunkingLinePo> getTrunkingLineListByDepartmentID(
			int departmentID) {
		return trunkingLineDao.getTrunkingLineListByDepartmentID(departmentID);
	}
	
	
	
	
	
	

}
