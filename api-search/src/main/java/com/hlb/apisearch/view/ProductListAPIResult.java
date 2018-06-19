package com.hlb.apisearch.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class ProductListAPIResult extends BaseAPIResult{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductView> productViews;
	private Long totalRecords;
	private Integer pageNo;
	private Integer pageSize;
	private Long pageCount ;	
	private Long took;
	public ProductListAPIResult(){
		super();
		this.productViews=new ArrayList<ProductView>();
		this.totalRecords=0L;
		this.pageNo=0;
		this.pageSize=0;
		this.pageCount=0L;
		this.took = 0L;
	}

	public List<ProductView> getProductViews() {
		return productViews;
	}

	public void setProductViews(List<ProductView> productViews) {
		if(productViews == null){
			productViews = new ArrayList<ProductView>();
		}
		this.productViews = productViews;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		if(totalRecords==null){
			totalRecords=0L;
		}
		this.totalRecords = totalRecords;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		if(pageNo==null){
			pageNo=0;
		}
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize==null){
			pageSize=0;
		}
		this.pageSize = pageSize;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		if(pageCount==null){
			pageCount=0L;
		}
		this.pageCount = pageCount;
	}

	public Long getTook() {
		return took;
	}

	public void setTook(Long took) {
		this.took = took;
	}
	
	
	
}
