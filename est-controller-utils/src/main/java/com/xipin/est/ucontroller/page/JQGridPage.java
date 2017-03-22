package com.xipin.est.ucontroller.page;

import java.util.List;

import com.xipin.est.utils.bean.PageBean;

public class JQGridPage<T> {

	private Integer total;// 页数至少是一页
	private Integer page;
	private Integer records;
	private List<T> rows;
	private Integer rowNum;

	public JQGridPage(PageBean<T> page) {
		this.page = page.getCurPage();
		this.total = page.getTotalPage();
		this.rowNum = page.getPageSize();
		this.rows = page.getData();
		this.records = page.getCount();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

}
