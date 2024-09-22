package com.sravan.springboot.demo.dto;

import java.util.List;

public class PaginatedResponse<T> {

	private int pageNumber;
	private int pageSize;
	private long totalResults;
	private int totalPages;
	private List<T> pageData;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public PaginatedResponse(int pageNumber, int pageSize, long totalResults, int totalPages, List<T> pageData) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
		this.pageData = pageData;
	}

	@Override
	public String toString() {
		return "PaginatedResponse [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalResults="
				+ totalResults + ", totalPages=" + totalPages + ", pageData=" + pageData + "]";
	}

}
