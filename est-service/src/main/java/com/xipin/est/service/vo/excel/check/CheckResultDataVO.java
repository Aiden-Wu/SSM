package com.xipin.est.service.vo.excel.check;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.xipin.est.db.po.DetailListPo;

public class CheckResultDataVO {
	private HashMap<Short, List<CheckResult>> map;
	private HashMap<Short, Integer> totalMap;
	private DetailListPo dpo;
	private HashSet<byte[]> bagNoSet;
	private HashSet<byte[]> refIdSet;
	private HashSet<byte[]> sealSet;
	private String dispatchNo;
	private String uuid;

	public HashMap<Short, List<CheckResult>> getMap() {
		return map;
	}

	public void setMap(HashMap<Short, List<CheckResult>> map) {
		this.map = map;
	}

	public DetailListPo getDpo() {
		return dpo;
	}

	public void setDpo(DetailListPo dpo) {
		this.dpo = dpo;
	}

	public HashSet<byte[]> getBagNoSet() {
		return bagNoSet;
	}

	public void setBagNoSet(HashSet<byte[]> bagNoSet) {
		this.bagNoSet = bagNoSet;
	}

	public HashSet<byte[]> getRefIdSet() {
		return refIdSet;
	}

	public void setRefIdSet(HashSet<byte[]> refIdSet) {
		this.refIdSet = refIdSet;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public HashMap<Short, Integer> getTotalMap() {
		return totalMap;
	}

	public void setTotalMap(HashMap<Short, Integer> totalMap) {
		this.totalMap = totalMap;
	}

	public HashSet<byte[]> getSealSet() {
		return sealSet;
	}

	public void setSealSet(HashSet<byte[]> sealSet) {
		this.sealSet = sealSet;
	}

}
