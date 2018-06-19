package com.hlb.apisearch.view;

public interface StatusCode {
	public final static String OP_FAILURE = "1";	//操作失败
	
	public final static String OK = "200";			//处理成功
	public final static String OK_NOTHING = "205";	//处理成功，但不做实际处理。
	public final static String NO_PARAMS = "400";		//参数错误
	public final static String Forbidden = "403";	//禁止访问
	public final static String NODATA = "300";  //无数据
	public final static String NOAUTH = "502";//没权限
	
	
}
