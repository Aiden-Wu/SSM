package com.xipin.est.utils.bean;

import java.util.List;

public class PageBean<T> {

	private Integer start;
	private Integer count;
	private Integer totalPage=1;//页数至少是一页
	private Integer pageSize=10;
	private Integer curPage = 1;
	private List<T> data;

	protected static final Integer DEFAULT_PAGE_SIZE = 10;

	public PageBean() {
	}

	public PageBean(int pageSize, int curPage) {
		this.curPage = curPage >= 1 ? curPage : 1;
		this.pageSize = pageSize;
		if(this.pageSize <= 0){
			this.pageSize = PageBean.DEFAULT_PAGE_SIZE;
		}
		this.start = this.pageSize * (this.curPage-1);
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.totalPage = count % this.pageSize == 0 ? count/this.pageSize : count/this.pageSize + 1;
		this.count = count;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
