package com.xipin.est.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.po.manager.TrunkingLinePo;

@Repository
public interface TrunkingLineDao {
	
	void addTrunkingLine(TrunkingLineBean trunkingLineBean);
	
	void deleteTrunkingLine(Long id);
	
	void updateTrunkingLine(TrunkingLineBean trunkingLineBean);
	
	List<TrunkingLinePo> getTrunkingLineList(TrunkingLineBean trunkingLineBean);
	
	int queryTrunkingLineListNum(TrunkingLineBean TrunkingLineBean);
	
	List<TrunkingLinePo> getTrunkingLineListByUserId(int UserId);
	
	List<TrunkingLinePo> getTrunkingLineListByDepartmentID(int departmentID);

}
