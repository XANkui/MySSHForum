package com.xan.utils;

import java.util.List;

public class PageBean {
	private Integer pageSize; // 页面大小
	private Integer currentPage; // 当前页
	private Integer totalCount;	// 总条数
	private Integer totalPage;	// 总页数
	
	private List list;	// 每页显示的数据

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	

	@Override
	public String toString() {
		return "PageBean [pageSize=" + pageSize + ", currentPage=" + currentPage + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}

	public PageBean(Integer pageSize, Integer currentPage, Integer totalCount) {
	
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
		 // 安全校验
		if(this.currentPage == null) {
			this.currentPage =1;
		}
		if(this.pageSize == null) {
			this.pageSize = 8;
		}
		
		// 计算 totalpage
		this.totalPage = (int) Math.ceil(1.0*this.totalCount/this.pageSize);
		 
		// 安全校验
		if(this.currentPage>this.totalPage) {
			this.currentPage=this.totalPage;
		}
		if(this.currentPage<1) {
			this.currentPage=1;
		}
	
		
	}
	
	// 获得其实索引
	public Integer getStartIndex() {
		return (this.currentPage -1)*this.pageSize;
	}
	
	
}
