package com.hlb.apisearch.param;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hlb.apisearch.view.ProductView;

public class ProductViewParam extends ProductView {

	//
	private static final long serialVersionUID = 1L;


	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date lastUpdateTimeStart;//供应商搜索  最后更新时间段  开始
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date lastUpdateTimeEnd;//供应商搜索  最后更新时间段  结束
	private Integer availableQuantityStart;//供应商搜索  库存量  开始
	private Integer availableQuantityEnd;//供应商搜索  库存量  结束
	
	private String status; //多状态集合查询,状态之间使用,号分隔. 如1,2,3
	/**
	 * 排除的字段,多个字段用","号隔开
	 */
	private String excludes;
	/**
	 * 返回的字段,多个字段用","号隔开
	 */
	private String includes;
	
	public Date getLastUpdateTimeStart() {
		return lastUpdateTimeStart;
	}
	public void setLastUpdateTimeStart(Date lastUpdateTimeStart) {
		this.lastUpdateTimeStart = lastUpdateTimeStart;
	}
	public Date getLastUpdateTimeEnd() {
		return lastUpdateTimeEnd;
	}
	public void setLastUpdateTimeEnd(Date lastUpdateTimeEnd) {
		this.lastUpdateTimeEnd = lastUpdateTimeEnd;
	}
	public Integer getAvailableQuantityStart() {
		return availableQuantityStart;
	}
	public void setAvailableQuantityStart(Integer availableQuantityStart) {
		this.availableQuantityStart = availableQuantityStart;
	}
	public Integer getAvailableQuantityEnd() {
		return availableQuantityEnd;
	}
	public void setAvailableQuantityEnd(Integer availableQuantityEnd) {
		this.availableQuantityEnd = availableQuantityEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExcludes() {
		return excludes;
	}
	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}
	public String getIncludes() {
		return includes;
	}
	public void setIncludes(String includes) {
		this.includes = includes;
	}
	
	
}
