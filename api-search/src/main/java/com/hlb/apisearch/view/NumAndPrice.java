package com.hlb.apisearch.view;

import java.io.Serializable;
import java.math.BigDecimal;

public class NumAndPrice implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer orderNum;
	private BigDecimal price;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	
	
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
