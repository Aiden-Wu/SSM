package com.xipin.est.manager.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.po.manager.TrunkingLinePo;
import com.xipin.est.manager.manager.TrunkingLineManager;
import com.xipin.est.service.busi.inf.TrunkingLineService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

@Service
public class TrunkingLineManagerImpl implements TrunkingLineManager{

	@Autowired
	private TrunkingLineService trunkingLineService;
	
	@Override
	public Result<List<TrunkingLinePo>> getTrunkingLine(TrunkingLineBean trunkingLineBean,PageBean<TrunkingLinePo> page) {
		
		Result<List<TrunkingLinePo>> result = new Result<>();
		PageBean<TrunkingLinePo> pageBean = trunkingLineService.getTrunkingLine(trunkingLineBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<String> addTrunkingLine(TrunkingLineBean trunkingLineBean) {
		Result<String> rstl = new Result<String>();
		trunkingLineService.addTrunkingLine(trunkingLineBean);
		return rstl;
	}

	@Override
	public Result<String> deleteTrunkingLine(IDBean idBean) {
		Result<String> rstl = new Result<String>();
		trunkingLineService.deleteTrunkingLine(idBean);
		return rstl;
	}

	@Override
	public Result<String> updateTrunkingLine(TrunkingLineBean trunkingLineBean) {
		Result<String> rstl = new Result<String>();
		trunkingLineService.updateTrunkingLine(trunkingLineBean);
		return rstl;
	}

	@Override
	public Result<List<TrunkingLinePo>> getTrunkingLineListByDepartmentID(
			int departmentID) {
		
		Result<List<TrunkingLinePo>> result = new Result<>();
		List<TrunkingLinePo> trunkingLinePoList = trunkingLineService.getTrunkingLineListByDepartmentID(departmentID);
		result.setData(trunkingLinePoList);
		return result;
	}

}
