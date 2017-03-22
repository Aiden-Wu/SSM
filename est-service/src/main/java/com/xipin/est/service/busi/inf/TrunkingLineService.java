package com.xipin.est.service.busi.inf;

import java.util.List;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.po.manager.TrunkingLinePo;
import com.xipin.est.utils.bean.PageBean;

public interface TrunkingLineService {
	
	void addTrunkingLine(TrunkingLineBean trunkingLineBean);
	
	void deleteTrunkingLine(IDBean idBean);
	
	void updateTrunkingLine(TrunkingLineBean trunkingLineBean);
	
	PageBean<TrunkingLinePo> getTrunkingLine(TrunkingLineBean trunkingLineBean,
			PageBean<TrunkingLinePo> page);
	
	List<TrunkingLinePo> getTrunkingLineListByUserId(int UserId);
	
	List<TrunkingLinePo> getTrunkingLineListByDepartmentID(int departmentID);

}
