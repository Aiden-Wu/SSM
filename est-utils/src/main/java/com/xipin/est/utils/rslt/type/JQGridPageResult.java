package com.xipin.est.utils.rslt.type;

import org.springframework.beans.BeanUtils;


public class JQGridPageResult<T> {

	private Long startTime;
	private Long costTime;
	private String code;
	private String info;
	protected T rows;
	private String havePage;
	private Integer page;// 当前页
	private Integer records;// 总记录数量
	private Integer rowNum;// pageSize
	private Integer total;// 页数至少是一页

	public JQGridPageResult(Result<T> rslt) {
		BeanUtils.copyProperties(rslt, this);
		this.page = rslt.getCurPage();
		this.total = rslt.getTotalPage();
		this.rowNum = rslt.getPageSize();
		this.rows = rslt.getData();
		this.records = rslt.getCount();
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getCostTime() {
		return costTime;
	}

	public void setCostTime(Long costTime) {
		this.costTime = costTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	public String getHavePage() {
		return havePage;
	}

	public void setHavePage(String havePage) {
		this.havePage = havePage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
