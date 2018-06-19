package com.hlb.apisearch.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse.AnalyzeToken;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.hlb.apisearch.common.ApiCommonParam;
import com.hlb.apisearch.common.ElasticSearchIndexConstants;
import com.hlb.apisearch.common.ElasticSearchUtil;
import com.hlb.apisearch.param.ProductViewParam;
import com.hlb.apisearch.service.ProductService;
import com.hlb.apisearch.view.BrandView;
import com.hlb.apisearch.view.ProductListAPIResult;
import com.hlb.apisearch.view.ProductView;
import com.hlb.apisearch.view.StatusCode;

import io.netty.util.internal.StringUtil;
@Service
public class ProductServiceImpl implements ProductService {

	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	/**
	 * 
	 * @param productViewParam
	 * @param apiCommonParam
	 * @param areaId   用户的区域ID
	 * @param keyword  搜索关键词
	 * @param sort     排序字段及方向,形式如下：  sort=orderNum-desc,minPrice-asc
	 * @return
	 */
	public ProductListAPIResult search(ProductViewParam productViewParam, ApiCommonParam apiCommonParam, String areaId, String keyword, String sort){
		List<ProductView> productViews = new ArrayList<ProductView>();
		ProductListAPIResult result = new ProductListAPIResult();
		if(StringUtil.isNullOrEmpty(keyword)) keyword = "";
		
		TransportClient client = ElasticSearchUtil.getTransportClient();
		//通过别名搜索
		SearchRequestBuilder searchRequestBuilder = client.prepareSearch(ElasticSearchIndexConstants.INDEX_PRODUCT_ALIAS);
		
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		//限制频道
		if(productViewParam.getChannelId() != null && productViewParam.getChannelId() > 0){
			boolQueryBuilder.must(QueryBuilders.termQuery("channelId", String.valueOf(productViewParam.getChannelId())));
		}
		//限制分类: 一级，二级，三级。 传参时三个分类id只允许保留一个.  切记!!!!!
		if(!StringUtils.isEmpty(productViewParam.getCategoryId()) && productViewParam.getCategoryId() > 0){
			boolQueryBuilder.must(QueryBuilders.termQuery("categoryId", String.valueOf(productViewParam.getCategoryId())));
		}
		if(!StringUtils.isEmpty(productViewParam.getSecondCategoryId()) && productViewParam.getSecondCategoryId() > 0){
			boolQueryBuilder.must(QueryBuilders.termQuery("secondCategoryId", String.valueOf(productViewParam.getSecondCategoryId())));
		}
		if(!StringUtils.isEmpty(productViewParam.getThirdCategoryId()) && productViewParam.getThirdCategoryId() > 0){
			boolQueryBuilder.must(QueryBuilders.termQuery("thirdCategoryId", String.valueOf(productViewParam.getThirdCategoryId())));
		}
		//货号
		if(!StringUtils.isEmpty(productViewParam.getGoodsNo())){
			boolQueryBuilder.must(QueryBuilders.termQuery("goodsNo", productViewParam.getGoodsNo()));
		}
		//最后修改时间范围查询
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(!StringUtils.isEmpty(productViewParam.getLastUpdateTimeStart())){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("lastUpdateTime").gte(sdf.format(productViewParam.getLastUpdateTimeStart())));
			
		}
		if(!StringUtils.isEmpty(productViewParam.getLastUpdateTimeEnd())){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("lastUpdateTime").lte(sdf.format(productViewParam.getLastUpdateTimeEnd())));
		}
		//可用库存范围查询
		if(!StringUtils.isEmpty(productViewParam.getAvailableQuantityStart())){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("totalStock").gte(productViewParam.getAvailableQuantityStart()));
		}
		if(!StringUtils.isEmpty(productViewParam.getAvailableQuantityEnd())){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("totalStock").lte(productViewParam.getAvailableQuantityEnd()));
		}
		//最小起订量
		if(!StringUtils.isEmpty(productViewParam.getMinQuantity()) && productViewParam.getMinQuantity() > 0){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("minQuantity").gte(productViewParam.getMinQuantity()));
		}
		//价格范围条件
		if(!StringUtils.isEmpty(productViewParam.getMinPrice())){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("minPrice").gte(productViewParam.getMinPrice()));
		}
		if(!StringUtils.isEmpty(productViewParam.getMaxPrice())){
			boolQueryBuilder.must(QueryBuilders.rangeQuery("minPrice").lte(productViewParam.getMaxPrice()));
		}
		
		// 限制品牌
		if (null != productViewParam.getBrandId() && productViewParam.getBrandId() > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery("brandId", productViewParam.getBrandId()));
		}
		if (!StringUtil.isNullOrEmpty(productViewParam.getBrandname())) {
			boolQueryBuilder.must(QueryBuilders.termQuery("brandname", productViewParam.getBrandname()));
		}
		
		/**
		 * 通过搜索关键词判定是否有品牌名，如果有找到品牌，则赋值给brandId或brandname字段进行第二步的搜索。
		 */
		if((productViewParam.getBrandId() == null || productViewParam.getBrandId() <= 0) 
				&& StringUtil.isNullOrEmpty(productViewParam.getBrandname())
				&& !StringUtil.isNullOrEmpty(keyword)){
			List<BrandView> brandViews = searchBrandByKeyword(client, keyword, productViewParam.getChannelId());
			BoolQueryBuilder boolQueryFilterBuilder = QueryBuilders.boolQuery();
			for(BrandView brandView : brandViews){
				boolQueryFilterBuilder.should(QueryBuilders.termQuery("brandId",brandView.getId()));
				//boolQueryBuilder.filter(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("brandId","11495177333116"))
						//.should(QueryBuilders.termQuery("brandId", "11495435846615")));
				//boolQueryBuilder.filter(QueryBuilders.termQuery("brandId", brandView.getId()));
			}
			boolQueryBuilder.filter(boolQueryFilterBuilder);
			/*if(brandView != null){
				boolQueryBuilder.must(QueryBuilders.termQuery("brandId", brandView.getId()));
				//中文品牌名有可能没有设置，所以不能使用,精确匹配品牌id已足够。
				//boolQueryBuilder.must(QueryBuilders.termQuery("brandname", brandView.getBrandChName()));
			}*/
		}
		
		//限制状态
		if(null != productViewParam.getGoodStatus() && productViewParam.getGoodStatus() > 0){
			boolQueryBuilder.must(QueryBuilders.termQuery("goodStatus", productViewParam.getGoodStatus()));
		}
		//多个状态过滤可考虑用filter
		if(null != productViewParam.getStatus()){
			String[] status = productViewParam.getStatus().split(",");
			for(String st : status){
				boolQueryBuilder.filter(QueryBuilders.termQuery("goodStatus", Integer.parseInt(st)));
			}
			///boolQueryBuilder.filter(QueryBuilders.termQuery("goodStatus", "1"));
			///boolQueryBuilder.filter(QueryBuilders.termQuery("goodStatus", "2"));
			///boolQueryBuilder.filter(QueryBuilders.termQuery("goodStatus", "3"));
		}
		
		
		// 限制供应商
		if (null != productViewParam.getSourceId() && productViewParam.getSourceId() > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery("sourceId", productViewParam.getSourceId()));
		}
		if(!StringUtils.isEmpty(productViewParam.getCompanyLoginphone())){
			boolQueryBuilder.must(QueryBuilders.termQuery("companyLoginphone", productViewParam.getCompanyLoginphone()));
		}
		if (null != productViewParam.getCompanyUserId() && productViewParam.getCompanyUserId() > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery("companyUserId", productViewParam.getCompanyUserId()));
		}
		
		// 限制货源类别
		if (null != productViewParam.getSupplyType() && productViewParam.getSupplyType() > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery("supplyType", productViewParam.getSupplyType()));
		}
		// 是否推荐至首页
		if (null != productViewParam.getIfRecommend() && productViewParam.getIfRecommend() > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery("ifRecommend", productViewParam.getIfRecommend()));
		}
		// 跨境类型
		if (null != productViewParam.getCrossBorderType() && productViewParam.getCrossBorderType() > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery("crossBorderType", productViewParam.getCrossBorderType()));
		}
		//首页推荐商品为现货
		if(productViewParam.getIfRecommend() == 2 && productViewParam.getSupplyType()<0){
			boolQueryBuilder.must(QueryBuilders.termQuery("supplyType", String.valueOf(productViewParam.getSupplyType())));
		}
		//限制发货地区
		if(!StringUtils.isEmpty(productViewParam.getProvince())){
			boolQueryBuilder.must(QueryBuilders.termQuery("province", productViewParam.getProvince()));
		}
		if(!StringUtils.isEmpty(productViewParam.getCity())){
			boolQueryBuilder.must(QueryBuilders.termQuery("city", productViewParam.getCity()));
		}
		if(!StringUtils.isEmpty(productViewParam.getGoodsId())){
			boolQueryBuilder.must(QueryBuilders.termQuery("goodsId", productViewParam.getGoodsId()));
		}
		//款号搜索
		if(!StringUtils.isEmpty(productViewParam.getGoodsNo())){
			boolQueryBuilder.must(QueryBuilders.termQuery("goodsNo", "{款号:"+productViewParam.getGoodsNo()+"}"));
		}
		//质检,单独排序
		if(!StringUtils.isEmpty(productViewParam.getQualityId()) && productViewParam.getQualityId() > 0){
			boolQueryBuilder.must(QueryBuilders.termQuery("qualityId", productViewParam.getQualityId()));
		}
		//排序
		sort(searchRequestBuilder, sort);
		
		//区域限制保护
		if(!StringUtils.isEmpty(areaId)){
			boolQueryBuilder.mustNot(QueryBuilders.termQuery("regionIds", areaId));
		}
		//搜索关键词
		if(!StringUtils.isEmpty(keyword)){
			//暂未解决搜索精确度问题，所以先不用should, 改用must
			/*boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword, "goodsName").boost(10.0f));
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"brandname").boost(1.0f));
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"brandEnName").boost(1.0f));
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"categoryName").boost(1.0f));
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"secondCategoryName").boost(1.0f));
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"thirdCategoryName").boost(1.0f));
			boolQueryBuilder.should(QueryBuilders.multiMatchQuery(keyword,"companyName").boost(1.0f));*/
			//"goodsName","brandname","brandEnName","companyName","categoryName","secondCategoryName","thirdCategoryName"
			boolQueryBuilder.must(QueryBuilders.multiMatchQuery(keyword,"goodsName","brandname","brandEnName").boost(10.0f));
			
		}
		logger.info(boolQueryBuilder);
		//返回指定字段
		String[] includes = null;
		if(!StringUtils.isEmpty(productViewParam.getIncludes())){
			try{
				includes = productViewParam.getIncludes().split(",");
			}catch(Exception ex){
				logger.error("返回指定字段设置有误。字段之间请使用英文逗号隔开!" + productViewParam.getIncludes());
			}
		}
		//排除返回指定字段
		String[] excludes = null;
		if(!StringUtils.isEmpty(productViewParam.getExcludes())){
			try{
				excludes = productViewParam.getExcludes().split(",");
			}catch(Exception ex){
				logger.error("排除返回指定字段设置有误。字段之间请使用英文逗号隔开!" + productViewParam.getExcludes());
			}
		}
		//通过别名查询
		SearchResponse response = searchRequestBuilder.setQuery(boolQueryBuilder)
					.setFrom((apiCommonParam.getPageCount() - 1) * apiCommonParam.getPageSize()).setSize(apiCommonParam.getPageSize())
					.setFetchSource(includes, excludes)
					.execute().actionGet();
		
		ProductView view = new ProductView();
		for(SearchHit hits : response.getHits()){
			view = JSON.parseObject(hits.getSourceAsString(), ProductView.class);
			productViews.add(view);
		}
		
		result.setProductViews(productViews);
		result.setPageNo(apiCommonParam.getPageCount());
		result.setPageSize(apiCommonParam.getPageSize());
		result.setStatusCode(StatusCode.OK);
		Long totalRecords = response.getHits().getTotalHits();
		Long pageCount = totalRecords / apiCommonParam.getPageSize();
		if (totalRecords % apiCommonParam.getPageSize() != 0) {
			pageCount++;
		}
		result.setTotalRecords(totalRecords);
		result.setPageCount(pageCount);
		result.setTook(response.getTookInMillis());
		return result;
	}
	
	/**
	 * 搜索关键词是否有包含品牌词,有则返回一个匹配到的品牌
	 * @param client
	 * @param keyword
	 * @return BrandView  返回第一个匹配到的品牌
	 */
	private List<BrandView> searchBrandByKeyword(TransportClient client, String keyword, Long channelId){
        IndicesAdminClient indicesAdminClient = client.admin().indices();
        AnalyzeRequestBuilder analyzeRequestBuilder = indicesAdminClient.prepareAnalyze(ElasticSearchIndexConstants.INDEX_PRODUCT_ALIAS, keyword);
        analyzeRequestBuilder.setAnalyzer("ik_smart");//ik_smart 或  ik_max_word
        AnalyzeResponse responsea = analyzeRequestBuilder.execute().actionGet();
        List<AnalyzeToken> analyzeTokens = responsea.getTokens();
        QueryBuilder queryBuilder= null;
        SearchResponse response = null;
        SearchHits hits = null;
        BrandView brandView = null;
        List<BrandView> brands = new ArrayList<BrandView>();
        for (AnalyzeToken token : analyzeTokens) {
        	queryBuilder= QueryBuilders.multiMatchQuery(token.getTerm(), "brandChName","brandEnName","brandChToEnName","brandEnNameLowerCase","brandEnNameUpperCase");
        	response = client.prepareSearch(ElasticSearchIndexConstants.INDEX_BRAND_ALIAS).setQuery(queryBuilder).execute().actionGet();
            hits = response.getHits();
            if (hits.totalHits() > 0) {
            	for (SearchHit hit : hits) {
            		brandView = JSON.parseObject(hit.getSourceAsString(), BrandView.class);
            		//if(channelId.compareTo(brandView.getChannelId()) == 0 && "1".equals(brandView.getIfDeleted()))
            		if(channelId.compareTo(brandView.getChannelId()) == 0){
            			brands.add(brandView);
            		}
                }
            }
        }
        return brands;
	}
	
	/**
	 * 根据传入的排序参数进行排序。
	 * @param searchRequestBuilder
	 * @param sort 排序参数，形式如下：  sort=orderNum-desc,minPrice-asc
	 */
	private void sort(SearchRequestBuilder searchRequestBuilder, String sort){
		if(!StringUtils.isEmpty(sort)){
			String[] fields = sort.split(",");
			for(String field : fields){
				if(!StringUtils.isEmpty(field)){
					String[] entity = field.split("-");
					if(entity.length == 2){
						String key = entity[0];
						String value = entity[1];
						if("desc".equals(value)){
							searchRequestBuilder.addSort(key, SortOrder.DESC);
						}else{
							searchRequestBuilder.addSort(key, SortOrder.ASC);
						}
					}
				}
			}
		}
	}
	
}
