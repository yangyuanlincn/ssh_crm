package com.linn.domain;

import java.util.List;

public class PageBean<T> {
	private List<T> list;
	private Integer currPage;//当前页
	private Integer pageSize;//每页条数
	private Integer totalPage;//总页数
	private Integer totalCount;//总条数
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		
		return (int) Math.ceil((totalCount*1.0)/pageSize);
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
