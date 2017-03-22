package com.xipin.est.service.impl.item.check;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.xipin.est.db.cache.ICommSetCache;
import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.service.vo.excel.check.CheckResult;

public class DataForExcelCheck {

	private ItemsPo item;
	private List<String> countryCode;
	private String customerCode;
	private String postType;
	private String trunkNo;
	private String bagNo;
	private String targetCountryCode;
	private HashMap<Short, List<CheckResult>> map;
	private HashSet<byte[]> bagNoSet;
	private HashSet<byte[]> refIdSet;
	private ICommSetCache commSetCache;
	private String dispatchNo;
	private String ppiNo;
	private HashMap<Short, Integer> totalMap;
	private HashSet<String> refIdStrSet;
	private String bagRegx;
	private String refRegx;
	private String dispatchRegx;
	private String serviceType;
	private String bmCode;
	private HashSet<byte[]> sealSet;
	private String lanuage;

	public DataForExcelCheck() {
		this.map = new HashMap<>();
		this.bagNoSet = new HashSet<>();
		this.refIdSet = new HashSet<>();
		this.totalMap = new HashMap<>();
		this.refIdStrSet = new HashSet<>();
		this.sealSet = new HashSet<>();
	}

	public DataForExcelCheck(ItemsPo item, List<String> countryCode,
			String customerCode, String postType, String trunkNo,
			ICommSetCache cache, String dispatchNo) {
		super();
		this.item = item;
		this.countryCode = countryCode;
		this.customerCode = customerCode;
		this.postType = postType;
		this.trunkNo = trunkNo;
		this.map = new HashMap<>();
		this.dispatchNo = dispatchNo;
		this.bagNoSet = new HashSet<>();
		this.refIdSet = new HashSet<>();
		this.totalMap = new HashMap<>();
		this.refIdStrSet = new HashSet<>();
		this.commSetCache = cache;
		this.sealSet = new HashSet<>();
	}

	public ItemsPo getItem() {
		return item;
	}

	public void setItem(ItemsPo item) {
		this.item = item;
	}

	public List<String> getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(List<String> countryCode) {
		this.countryCode = countryCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getTrunkNo() {
		return trunkNo;
	}

	public void setTrunkNo(String trunkNo) {
		this.trunkNo = trunkNo;
	}

	public String getBagNo() {
		return bagNo;
	}

	public void setBagNo(String bagNo) {
		this.bagNo = bagNo;
	}

	public String getTargetCountryCode() {
		return targetCountryCode;
	}

	public void setTargetCountryCode(String targetCountryCode) {
		this.targetCountryCode = targetCountryCode;
	}

	public HashMap<Short, List<CheckResult>> getMap() {
		return map;
	}

	public void setMap(HashMap<Short, List<CheckResult>> map) {
		this.map = map;
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

	public ICommSetCache getCommSetCache() {
		return commSetCache;
	}

	public void setCommSetCache(ICommSetCache commSetCache) {
		this.commSetCache = commSetCache;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	public String getPpiNo() {
		return ppiNo;
	}

	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	public HashMap<Short, Integer> getTotalMap() {
		return totalMap;
	}

	public void setTotalMap(HashMap<Short, Integer> totalMap) {
		this.totalMap = totalMap;
	}

	public HashSet<String> getRefIdStrSet() {
		return refIdStrSet;
	}

	public void setRefIdStrSet(HashSet<String> refIdStrSet) {
		this.refIdStrSet = refIdStrSet;
	}

	public String getBagRegx() {
		return bagRegx;
	}

	public void setBagRegx(String bagRegx) {
		this.bagRegx = bagRegx;
	}

	public String getRefRegx() {
		return refRegx;
	}

	public void setRefRegx(String refRegx) {
		this.refRegx = refRegx;
	}

	public String getDispatchRegx() {
		return dispatchRegx;
	}

	public void setDispatchRegx(String dispatchRegx) {
		this.dispatchRegx = dispatchRegx;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getBmCode() {
		return bmCode;
	}

	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}

	public HashSet<byte[]> getSealSet() {
		return sealSet;
	}

	public void setSealSet(HashSet<byte[]> sealSet) {
		this.sealSet = sealSet;
	}

	public String getLanuage() {
		return lanuage;
	}

	public void setLanuage(String lanuage) {
		this.lanuage = lanuage;
	}

}
