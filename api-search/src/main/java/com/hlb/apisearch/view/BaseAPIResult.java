package com.hlb.apisearch.view;

import java.io.Serializable;

import com.hlb.base.core.util.string.StringUtils;

@SuppressWarnings("serial")
public class BaseAPIResult implements Serializable{
	/**
	 * 状态码
	 */
	private String statusCode;
	/**
	 * 返回信息
	 */
	private String msg;

	public BaseAPIResult() {
		this.statusCode="200";
		this.msg="";
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = StringUtils.get(statusCode);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = StringUtils.get(msg);
	}
	
}
