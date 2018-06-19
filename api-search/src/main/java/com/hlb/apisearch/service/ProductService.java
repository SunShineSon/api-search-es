package com.hlb.apisearch.service;

import com.hlb.apisearch.common.ApiCommonParam;
import com.hlb.apisearch.param.ProductViewParam;
import com.hlb.apisearch.view.ProductListAPIResult;

public interface ProductService {

	/**
	 * 
	 * @param productViewParam
	 * @param apiCommonParam
	 * @param areaId   用户的区域ID
	 * @param keyword  搜索关键词
	 * @param sort     排序字段及方向
	 * @return
	 */
	public ProductListAPIResult search(ProductViewParam productViewParam, ApiCommonParam apiCommonParam, 
			String areaId, String keyword, String sort);

}
