package com.hlb.apisearch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlb.apisearch.common.ApiCommonParam;
import com.hlb.apisearch.param.ProductViewParam;
import com.hlb.apisearch.service.ProductService;
import com.hlb.apisearch.view.ProductListAPIResult;

@Controller
@RequestMapping("goods/")
public class ProductSearchController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "test", method = {RequestMethod.GET})
	public void test(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.getWriter().write("work");
	}
	
	/**
	 * 通用搜索（首页推荐商品，首页分类搜索，搜索框搜索)
	 * @param request
	 * @param response
	 * @param productViewParam
	 * @param apiCommonParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "search", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ProductListAPIResult searchGoods(HttpServletRequest request, HttpServletResponse response,
			ProductViewParam productViewParam, ApiCommonParam apiCommonParam)throws Exception{
		
		//ProductListAPIResult result = new ProductListAPIResult();
		//用户的区域,用于区域限制功能。
		String areaId = request.getParameter("areaId");
		//搜索关键词
		String keyword = request.getParameter("keyword");
		String sort = request.getParameter("sort");
		return productService.search(productViewParam, apiCommonParam, areaId, keyword, sort);
	}
}
