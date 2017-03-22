package com.xipin.est.manager.manager;

import java.util.List;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.po.manager.TrunkingLinePo;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

public interface TrunkingLineManager {
	
	public Result<List<TrunkingLinePo>> getTrunkingLine(TrunkingLineBean trunkingLineBean,PageBean<TrunkingLinePo> page);

	public Result<String> addTrunkingLine(TrunkingLineBean trunkingLineBean);
	
	public Result<String> deleteTrunkingLine(IDBean idBean);
	
	public Result<String> updateTrunkingLine(TrunkingLineBean trunkingLineBean);
	
	Result<List<TrunkingLinePo>> getTrunkingLineListByDepartmentID(int departmentID);

}
