package com.xan.utils;

import java.util.List;

public class PageBean {
	private Integer pageSize; // ҳ���С
	private Integer currentPage; // ��ǰҳ
	private Integer totalCount;	// ������
	private Integer totalPage;	// ��ҳ��
	
	private List list;	// ÿҳ��ʾ������

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
		
		 // ��ȫУ��
		if(this.currentPage == null) {
			this.currentPage =1;
		}
		if(this.pageSize == null) {
			this.pageSize = 8;
		}
		
		// ���� totalpage
		this.totalPage = (int) Math.ceil(1.0*this.totalCount/this.pageSize);
		 
		// ��ȫУ��
		if(this.currentPage>this.totalPage) {
			this.currentPage=this.totalPage;
		}
		if(this.currentPage<1) {
			this.currentPage=1;
		}
	
		
	}
	
	// �����ʵ����
	public Integer getStartIndex() {
		return (this.currentPage -1)*this.pageSize;
	}
	
	
}
