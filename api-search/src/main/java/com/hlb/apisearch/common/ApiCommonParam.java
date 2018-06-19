/**
 * 
 */
package com.hlb.apisearch.common;

public class ApiCommonParam {
	private String channelId;// 频道ID
	private Integer pageSize = 20;// 每页数量
	private Integer pageCount = 1;// 分页

	public ApiCommonParam() {
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	

	public Integer getPageCount() {
		if(pageCount <= 0) pageCount = 1;
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageSize() {
		if(pageSize > 1000) return 1000;
		if(pageSize <= 0) return 20;
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
