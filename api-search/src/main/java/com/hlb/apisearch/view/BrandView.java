package com.hlb.apisearch.view;

import java.io.Serializable;



public class BrandView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/***/
	public Long id;
	/** 品牌中文名称 */
	public String brandChName = "";
	/** 品牌英文名称 */
	public String brandEnName = "";
	public String brandEnNameLowerCase = "";
	public String brandEnNameUpperCase ="";
	/**品牌类型(0，国内品牌 1，国外品牌)*/
	public Integer brandType;
	/** 经营类型  0，自有品牌 1,代理品牌*/
	public Integer businessType;
	/** 商标类型 */
	public Integer trademarkType;
	/** 品牌logo图片 */
	public String brandLogoImg = "";

	public String brandChToEnName = "";

	public String firstPinyin;
	/**
	 * 新上传的品牌logo
	 */
	public String brandLogoImgNew;
	/**
	 * 是否推荐该品牌,推荐为1,不推荐为0
	 */
	public Integer brandLogoRecommend;

	/**
	 * 频道编号（关联t_category分类编号）
	 * */
	public Long channelId;
	public String channelName;
	/**
	 * 频道名称
	 * */
	public String categoryName;
	
	/**
	 * 是否已删除(0 代表删除  1代表正常)
	 * */
	public String ifDeleted;
	
	private Long categoryId;
	
	private Integer isRecommend;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandChName() {
		return brandChName;
	}

	public void setBrandChName(String brandChName) {
		this.brandChName = brandChName;
	}

	public String getBrandEnName() {
		return brandEnName;
	}

	public void setBrandEnName(String brandEnName) {
		this.brandEnName = brandEnName;
	}

	public Integer getBrandType() {
		return brandType;
	}

	public void setBrandType(Integer brandType) {
		this.brandType = brandType;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public Integer getTrademarkType() {
		return trademarkType;
	}

	public void setTrademarkType(Integer trademarkType) {
		this.trademarkType = trademarkType;
	}

	public String getBrandLogoImg() {
		return brandLogoImg;
	}

	public void setBrandLogoImg(String brandLogoImg) {
		this.brandLogoImg = brandLogoImg;
	}

	public String getBrandChToEnName() {
		return brandChToEnName;
	}

	public void setBrandChToEnName(String brandChToEnName) {
		this.brandChToEnName = brandChToEnName;
	}

	public String getFirstPinyin() {
		return firstPinyin;
	}

	public void setFirstPinyin(String firstPinyin) {
		this.firstPinyin = firstPinyin;
	}

	public String getBrandLogoImgNew() {
		return brandLogoImgNew;
	}

	public void setBrandLogoImgNew(String brandLogoImgNew) {
		this.brandLogoImgNew = brandLogoImgNew;
	}

	public Integer getBrandLogoRecommend() {
		return brandLogoRecommend;
	}

	public void setBrandLogoRecommend(Integer brandLogoRecommend) {
		this.brandLogoRecommend = brandLogoRecommend;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getIfDeleted() {
		return ifDeleted;
	}

	public void setIfDeleted(String ifDeleted) {
		this.ifDeleted = ifDeleted;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	
}
