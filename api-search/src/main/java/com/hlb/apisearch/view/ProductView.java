package com.hlb.apisearch.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class ProductView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long shareId;//共识拥有者
	private Long goodsId;//商品ID
	private Long id;//商品ID
	private String goodsName ;//商品名称
	private String goodsNo; //款号
	private String detailDescriptionText;//商品描述--已弃用
	private  String measurementUnit = "";//计量单位
	private Integer stockNum;//库存
	private Integer  availableStockNum ;//可用库存
	private Integer saleNum;//已销售数量/已预购数量
	
	private BigDecimal suggestedPrice=new BigDecimal("0.00");//零售价、吊牌价
	private Integer mimimumOrderQuantity;//单笔起订量(最小起订量)
	private Integer singleMinNum;//老数据-将逐步废弃使用
	private Integer earnest=0;//定金比例百分比
	
	private Integer sevenThirty;//值为7是七天内, 值为30为三十天内的商品
	
	private Integer ifDelete;//0未删,1已删 
	private Integer goodStatus;//状态 1：草稿 2：审核中 3：未审核通过 5：审核通过(待上架) 6：销售中 7：待入库
	private Integer supplyType = -1;//货源类别 1现货2预售 ,3拼单 ,5活动
	private Integer ifRecommend = 0;// 0不推荐  1推荐  2首页推荐 
	private Integer recommendOrder = 0;//首页推荐排序
	private Double unitWeight;//单位重量
	
	/** 发货时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date publishDate;//发货时间
	public Integer ifFreePost;// 兼容ios，运费模板   0商家包邮 1不包邮  2平台包邮
	
	
	/** 拼单结束时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date pindanEndDate;// 拼单结束时间 
	private Integer preEstablishedQuantity;//预购/拼单成立数量
	/** 预购结束时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date preEndDate;//预购结束时间
	/** 尾款支付截止时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date finalPaymentDate;//尾款支付截止时间
	
	private List<String> carouselImages=new ArrayList<String>();//图片列表
	private List<NumAndPrice> orderNumAndPrice=new ArrayList<NumAndPrice>();//APP起订量与价格展示
	private String orderNumAndPriceJson; //json方式存储orderNumAndPrice
	
	
	//private List<StockDetail> listStockDetail=new ArrayList<StockDetail>();//库存及已售数量
    //lixs
	private Long qualityId;//品质等级ID
	private Integer qualitySort; //品质等级排序
	private String qualityName;//品质等级名称
	 /**
	  * 商品规格标题
	  */
	 private List<String> pTitles;
	

	 private Integer sortType;//排序  1.综合排序 2.价格升序 3.销量排序 4.价格降序 5 品质
	 //拿样
	 private Long sampleId;//拿样价格ID
	 private BigDecimal samplePrice=new BigDecimal("0");//拿样价格
	 private BigDecimal sampleDiscount=new BigDecimal("0");//拿样满减折扣-二次拿货15后后，应减金额
	 private String sampleDiscountStr;//拿样满减折扣-二次拿货15后后，应减金额--APP描述显示
	 private Integer sampleStock;//样品总库存
	 private Integer sampleAvailableNum;//样品可用库存
     private String sampleFreightTempletStr;//样品运费说明
     private Integer sampleSaleNum;//样品销量
     private String sampleRule;//样品拿样规则说明
	   
    private Long seckillId;//2.4版:秒杀ID
	private String seckillStartTime;//2.4版:秒杀开始时间
	private String seckillEndTime;//2.4版:秒杀结束时间
	private BigDecimal seckillPrice;//2.4版:秒杀价格
	private Integer seckillQuotaNumber;//2.4版:秒杀限购量


	// 状态中文信息
    public String goodStatusTd;

	/** 可售数量 */
	public Integer availableQuantity;


	/** 预售支付定金开始时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date preStartDate;

	/** 预售支付尾款开始时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public java.util.Date finalPaymentStartDate;

	/** 预售支付尾款后几天发货 */
	public Integer presellDeliveryDay;

	/** 预售支付方式  1：分阶段付款 2：全款 */
	public Integer presellPayType;
	
	/** 商品详情图片 */
	public String imageDetails;

	/** 商品详情 */
	public String detailDescription;

	/** 发货地址(对应地址表ID) */
	public Long deliveryAddress = 0L;
	
	/** 备注 */
	public String remark = "";
	
	/** 最后修改时间 */
	public java.util.Date lastUpdateTime;
	
	

	/** 价格区间中最小价格 */
	public Double minPrice;
	/** 价格区间中最大价格 */
	public Double maxPrice;
	/** 预售最低定金 */
	public BigDecimal minEarnestAmount = BigDecimal.ZERO;
	/** 最低总价 */
	public BigDecimal minTotalAmount = BigDecimal.ZERO;
	/** 最高优惠金额 */
	public BigDecimal maxDiscountAmount = BigDecimal.ZERO;

	public Integer quantityOrdered;//已订数量
	
	/**
	 * 供应商相关
	 */
	/** 源拥有者 */
	public Long sourceId = 0L;
	public String companyLoginphone;
	public String companyImg;
	public String companyId;
	private Long companyUserId; //供应商的userId
	public String companyName;//供应商名称
	/**
	 * 频道ID
	 */
	private Long channelId;
	private String channelName;
	
	/**
	 * 类目
	 */
	//商品所属分类id
	public Long categoryId = 0L;
	public Long secondCategoryId = 0L;
	public Long thirdCategoryId = 0L;
	//商品所属分类名称
	public String categoryName = "";
	public String secondCategoryName;
	public String thirdCategoryName;
	
	
	/**
	 * 品牌
	 */
	private Long brandId;//品牌ID
	public String brandname;
	public String brandEnName;
	
	/**
	 * 区域限制
	 */
	public List<String> regionIds; 
	public List<String> regionNames;
	
	/**
	 * 运费
	 */
	
	/** 是否使用运费模板(0,不使用卖家承担运费,1,使用) */
	public Integer ifUseTemplate;
	/** 运费模板(对应运费模板ID) */
	public Long freightTemplate;
	public String freighttempletName;
	
	public String province;
	public String city;
	public String area;
	public String deliverProvice;//发货所在省
	public String deliverCity;//发货所在市
	
	
	// 已售或者已订量
	public Integer orderNum;
	/**
	 * 统计出来的起订量(关联t_price_section 表做统计)
	 */
	public Integer  countMinNum;
	public Integer totalStock;
	// 可用库存
	public Integer availableStock;

	public String nowtime = DateUtil.timeFormat(new Date());
	
	private Integer hasSetSample;		//是否设置过样品
	private Integer bought;
	private Integer categoryOrder;//分类排序序列
	private Date categoryOrderTime;//分类排序时间
	private Integer goodsAssociatedSort;
	private Integer preOrder;//预售排序序列
	private Date preOrderTime;//预售排序时间

	/** 最小起订量 */
	private Integer minQuantity;
	private String qualityCaption;//等级说明
	private Integer isActivity;
	private Integer totalCount;
	

	private java.util.Date firstInsaleTime;
	private java.util.Date firstPassTime; //发布时间，以第一次审核通过为准
	
	private Integer alarmFlag;//商品警报标记  1按总库存报警 2按SKU库存报警
	private Integer alarmTotalValue;//商品警报值  alarm_flag=1 则为按总库存警报，alarm_flag=2 则为SKU库存报警值总和
	private Integer supplierOrder;//供应商后台商品排序
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date supplierOrderTime;//供应商后台商品排序时间
	
	
	//4.1相关
	// '单品混批开关 1 已打开 2未打开'
	private Integer itemMixedFlag;
	// '单品混批条件(件数)'
	private Integer itemMixedNum;
	//'单品混批条件(元)'
	private BigDecimal itemMixedMoney;
	//'店铺混批开关 1支持(是) 2不支持(否)  此商品是否支持店铺混批',
	private Integer storeMixedFlag;
	//'店铺混批条件(件数)',
	private Integer storeMixedNum;
	//'店铺混批条件(元)',
	private BigDecimal storeMixedMoney;
	////店铺混批描述
	private String storeMixedDesc;
	//单品混批描述
	private String itemMixedDesc;
		
	//'报价方式  1按数量  2按规格'
	private Integer priceQuoteFlag;
	//按产品sku报价
	private NumAndPrice orderNumAndPriceBySku;//APP起订量与价格展示
	private String orderNumAndPriceSkuJson;//json方式存储orderNumAndPriceSku
	/**跨境 **/
	// '是否进口商品,1:是,2:否'
	private Integer ifImport;
	//原产国家
	private String nativeCountry;
	//原产国家logo图片地址
	private String countryImgUrl;
	//跨境类型：1:完税商品,2:保税商品,3:境外直邮
	private Integer crossBorderType;
	//进口口岸
	private String importPort;
	//报关单号 
	private String declareOrderNum;
	//海关综合税
	private BigDecimal customsTax;
	//预计进口税
	private BigDecimal importTax;
	//预计到达天数
	private Integer arrivalDay;
	//进口详情链接
	private String importDetailUrl;
	//终端商默认收货城市
	private String defaultRecieveCity;
	
	private Integer productFlag; //商品标识：1普通商品，2E农贷商品
	private Integer repaymentPeriod; //E农贷支付，还款期数
	
	/**
	 * 属性集合
	 * @return
	 */
	private String goodsSelecteds;
	//国内、境外、保税区发货地址统一字段
	private String deliveryArea;
		
	public String getDeliveryArea() {
		return deliveryArea;
	}
	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}
	
	public Long getShareId() {
		return shareId;
	}
	public void setShareId(Long shareId) {
		this.shareId = shareId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getDetailDescriptionText() {
		return detailDescriptionText;
	}
	public void setDetailDescriptionText(String detailDescriptionText) {
		this.detailDescriptionText = detailDescriptionText;
	}
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	public Integer getStockNum() {
		return stockNum;
	}
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
	public Integer getAvailableStockNum() {
		return availableStockNum;
	}
	public void setAvailableStockNum(Integer availableStockNum) {
		this.availableStockNum = availableStockNum;
	}
	public Integer getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
	public BigDecimal getSuggestedPrice() {
		return suggestedPrice;
	}
	public void setSuggestedPrice(BigDecimal suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}
	public Integer getMimimumOrderQuantity() {
		return mimimumOrderQuantity;
	}
	public void setMimimumOrderQuantity(Integer mimimumOrderQuantity) {
		this.mimimumOrderQuantity = mimimumOrderQuantity;
	}
	public Integer getSingleMinNum() {
		return singleMinNum;
	}
	public void setSingleMinNum(Integer singleMinNum) {
		this.singleMinNum = singleMinNum;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getEarnest() {
		return earnest;
	}
	public void setEarnest(Integer earnest) {
		this.earnest = earnest;
	}
	public Integer getSevenThirty() {
		return sevenThirty;
	}
	public void setSevenThirty(Integer sevenThirty) {
		this.sevenThirty = sevenThirty;
	}
	public Integer getIfDelete() {
		return ifDelete;
	}
	public void setIfDelete(Integer ifDelete) {
		this.ifDelete = ifDelete;
	}
	public Integer getGoodStatus() {
		return goodStatus;
	}
	public void setGoodStatus(Integer goodStatus) {
		this.goodStatus = goodStatus;
	}
	public Integer getSupplyType() {
		return supplyType;
	}
	public void setSupplyType(Integer supplyType) {
		this.supplyType = supplyType;
	}
	public Integer getIfRecommend() {
		return ifRecommend;
	}
	public void setIfRecommend(Integer ifRecommend) {
		this.ifRecommend = ifRecommend;
	}
	public Integer getRecommendOrder() {
		return recommendOrder;
	}
	public void setRecommendOrder(Integer recommendOrder) {
		this.recommendOrder = recommendOrder;
	}
	public Double getUnitWeight() {
		return unitWeight;
	}
	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public Integer getIfFreePost() {
		return ifFreePost;
	}
	public void setIfFreePost(Integer ifFreePost) {
		this.ifFreePost = ifFreePost;
	}

	public Integer getPreEstablishedQuantity() {
		return preEstablishedQuantity;
	}
	public void setPreEstablishedQuantity(Integer preEstablishedQuantity) {
		this.preEstablishedQuantity = preEstablishedQuantity;
	}

	public java.util.Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}
	public java.util.Date getPindanEndDate() {
		return pindanEndDate;
	}
	public void setPindanEndDate(java.util.Date pindanEndDate) {
		this.pindanEndDate = pindanEndDate;
	}
	public java.util.Date getPreEndDate() {
		return preEndDate;
	}
	public void setPreEndDate(java.util.Date preEndDate) {
		this.preEndDate = preEndDate;
	}
	public java.util.Date getFinalPaymentDate() {
		return finalPaymentDate;
	}
	public void setFinalPaymentDate(java.util.Date finalPaymentDate) {
		this.finalPaymentDate = finalPaymentDate;
	}
	public List<String> getCarouselImages() {
		return carouselImages;
	}
	public void setCarouselImages(List<String> carouselImages) {
		this.carouselImages = carouselImages;
	}
	public Long getQualityId() {
		return qualityId;
	}
	public void setQualityId(Long qualityId) {
		this.qualityId = qualityId;
	}
	public String getQualityName() {
		return qualityName;
	}
	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}
	public List<String> getpTitles() {
		return pTitles;
	}
	public void setpTitles(List<String> pTitles) {
		this.pTitles = pTitles;
	}

	public Integer getSortType() {
		return sortType;
	}
	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}
	public Long getSampleId() {
		return sampleId;
	}
	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}
	public BigDecimal getSamplePrice() {
		return samplePrice;
	}
	public void setSamplePrice(BigDecimal samplePrice) {
		this.samplePrice = samplePrice;
	}
	public BigDecimal getSampleDiscount() {
		return sampleDiscount;
	}
	public void setSampleDiscount(BigDecimal sampleDiscount) {
		this.sampleDiscount = sampleDiscount;
	}
	public String getSampleDiscountStr() {
		return sampleDiscountStr;
	}
	public void setSampleDiscountStr(String sampleDiscountStr) {
		this.sampleDiscountStr = sampleDiscountStr;
	}
	public Integer getSampleStock() {
		return sampleStock;
	}
	public void setSampleStock(Integer sampleStock) {
		this.sampleStock = sampleStock;
	}
	public Integer getSampleAvailableNum() {
		return sampleAvailableNum;
	}
	public void setSampleAvailableNum(Integer sampleAvailableNum) {
		this.sampleAvailableNum = sampleAvailableNum;
	}
	public String getSampleFreightTempletStr() {
		return sampleFreightTempletStr;
	}
	public void setSampleFreightTempletStr(String sampleFreightTempletStr) {
		this.sampleFreightTempletStr = sampleFreightTempletStr;
	}
	public Integer getSampleSaleNum() {
		return sampleSaleNum;
	}
	public void setSampleSaleNum(Integer sampleSaleNum) {
		this.sampleSaleNum = sampleSaleNum;
	}
	public String getSampleRule() {
		return sampleRule;
	}
	public void setSampleRule(String sampleRule) {
		this.sampleRule = sampleRule;
	}
	public Long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}
	public String getSeckillStartTime() {
		return seckillStartTime;
	}
	public void setSeckillStartTime(String seckillStartTime) {
		this.seckillStartTime = seckillStartTime;
	}
	public String getSeckillEndTime() {
		return seckillEndTime;
	}
	public void setSeckillEndTime(String seckillEndTime) {
		this.seckillEndTime = seckillEndTime;
	}
	public BigDecimal getSeckillPrice() {
		return seckillPrice;
	}
	public void setSeckillPrice(BigDecimal seckillPrice) {
		this.seckillPrice = seckillPrice;
	}
	public Integer getSeckillQuotaNumber() {
		return seckillQuotaNumber;
	}
	public void setSeckillQuotaNumber(Integer seckillQuotaNumber) {
		this.seckillQuotaNumber = seckillQuotaNumber;
	}
	public String getGoodStatusTd() {
		return goodStatusTd;
	}
	public void setGoodStatusTd(String goodStatusTd) {
		this.goodStatusTd = goodStatusTd;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public java.util.Date getPreStartDate() {
		return preStartDate;
	}
	public void setPreStartDate(java.util.Date preStartDate) {
		this.preStartDate = preStartDate;
	}
	public java.util.Date getFinalPaymentStartDate() {
		return finalPaymentStartDate;
	}
	public void setFinalPaymentStartDate(java.util.Date finalPaymentStartDate) {
		this.finalPaymentStartDate = finalPaymentStartDate;
	}
	public Integer getPresellDeliveryDay() {
		return presellDeliveryDay;
	}
	public void setPresellDeliveryDay(Integer presellDeliveryDay) {
		this.presellDeliveryDay = presellDeliveryDay;
	}
	public Integer getPresellPayType() {
		return presellPayType;
	}
	public void setPresellPayType(Integer presellPayType) {
		this.presellPayType = presellPayType;
	}


	public String getImageDetails() {
		return imageDetails;
	}
	public void setImageDetails(String imageDetails) {
		this.imageDetails = imageDetails;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public Long getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Long deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public BigDecimal getMaxDiscountAmount() {
		return maxDiscountAmount;
	}
	public void setMaxDiscountAmount(BigDecimal maxDiscountAmount) {
		this.maxDiscountAmount = maxDiscountAmount;
	}
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public String getCompanyLoginphone() {
		return companyLoginphone;
	}
	public void setCompanyLoginphone(String companyLoginphone) {
		this.companyLoginphone = companyLoginphone;
	}
	public String getCompanyImg() {
		return companyImg;
	}
	public void setCompanyImg(String companyImg) {
		this.companyImg = companyImg;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getSecondCategoryId() {
		return secondCategoryId;
	}
	public void setSecondCategoryId(Long secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}
	public Long getThirdCategoryId() {
		return thirdCategoryId;
	}
	public void setThirdCategoryId(Long thirdCategoryId) {
		this.thirdCategoryId = thirdCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getSecondCategoryName() {
		return secondCategoryName;
	}
	public void setSecondCategoryName(String secondCategoryName) {
		this.secondCategoryName = secondCategoryName;
	}
	public String getThirdCategoryName() {
		return thirdCategoryName;
	}
	public void setThirdCategoryName(String thirdCategoryName) {
		this.thirdCategoryName = thirdCategoryName;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getBrandEnName() {
		return brandEnName;
	}
	public void setBrandEnName(String brandEnName) {
		this.brandEnName = brandEnName;
	}
	public List<String> getRegionIds() {
		return regionIds;
	}
	public void setRegionIds(List<String> regionIds) {
		this.regionIds = regionIds;
	}
	public List<String> getRegionNames() {
		return regionNames;
	}
	public void setRegionNames(List<String> regionNames) {
		this.regionNames = regionNames;
	}
	public Integer getIfUseTemplate() {
		return ifUseTemplate;
	}
	public void setIfUseTemplate(Integer ifUseTemplate) {
		this.ifUseTemplate = ifUseTemplate;
	}
	public Long getFreightTemplate() {
		return freightTemplate;
	}
	public void setFreightTemplate(Long freightTemplate) {
		this.freightTemplate = freightTemplate;
	}
	public String getFreighttempletName() {
		return freighttempletName;
	}
	public void setFreighttempletName(String freighttempletName) {
		this.freighttempletName = freighttempletName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDeliverProvice() {
		return deliverProvice;
	}
	public void setDeliverProvice(String deliverProvice) {
		this.deliverProvice = deliverProvice;
	}
	public String getDeliverCity() {
		return deliverCity;
	}
	public void setDeliverCity(String deliverCity) {
		this.deliverCity = deliverCity;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getCountMinNum() {
		return countMinNum;
	}
	public void setCountMinNum(Integer countMinNum) {
		this.countMinNum = countMinNum;
	}
	public Integer getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(Integer totalStock) {
		this.totalStock = totalStock;
	}
	public Integer getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	public Integer getHasSetSample() {
		return hasSetSample;
	}
	public void setHasSetSample(Integer hasSetSample) {
		this.hasSetSample = hasSetSample;
	}
	public Integer getBought() {
		return bought;
	}
	public void setBought(Integer bought) {
		this.bought = bought;
	}
	public Integer getCategoryOrder() {
		return categoryOrder;
	}
	public void setCategoryOrder(Integer categoryOrder) {
		this.categoryOrder = categoryOrder;
	}
	public Date getCategoryOrderTime() {
		return categoryOrderTime;
	}
	public void setCategoryOrderTime(Date categoryOrderTime) {
		this.categoryOrderTime = categoryOrderTime;
	}
	public Integer getGoodsAssociatedSort() {
		return goodsAssociatedSort;
	}
	public void setGoodsAssociatedSort(Integer goodsAssociatedSort) {
		this.goodsAssociatedSort = goodsAssociatedSort;
	}
	public Integer getPreOrder() {
		return preOrder;
	}
	public void setPreOrder(Integer preOrder) {
		this.preOrder = preOrder;
	}
	public Date getPreOrderTime() {
		return preOrderTime;
	}
	public void setPreOrderTime(Date preOrderTime) {
		this.preOrderTime = preOrderTime;
	}
	public Integer getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}
	public String getQualityCaption() {
		return qualityCaption;
	}
	public void setQualityCaption(String qualityCaption) {
		this.qualityCaption = qualityCaption;
	}
	public Integer getIsActivity() {
		return isActivity;
	}
	public void setIsActivity(Integer isActivity) {
		this.isActivity = isActivity;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public java.util.Date getFirstInsaleTime() {
		return firstInsaleTime;
	}
	public void setFirstInsaleTime(java.util.Date firstInsaleTime) {
		this.firstInsaleTime = firstInsaleTime;
	}
	public Integer getAlarmFlag() {
		return alarmFlag;
	}
	public void setAlarmFlag(Integer alarmFlag) {
		this.alarmFlag = alarmFlag;
	}
	public Integer getAlarmTotalValue() {
		return alarmTotalValue;
	}
	public void setAlarmTotalValue(Integer alarmTotalValue) {
		this.alarmTotalValue = alarmTotalValue;
	}
	public Integer getSupplierOrder() {
		return supplierOrder;
	}
	public void setSupplierOrder(Integer supplierOrder) {
		this.supplierOrder = supplierOrder;
	}
	public Date getSupplierOrderTime() {
		return supplierOrderTime;
	}
	public void setSupplierOrderTime(Date supplierOrderTime) {
		this.supplierOrderTime = supplierOrderTime;
	}
	public Integer getItemMixedFlag() {
		return itemMixedFlag;
	}
	public void setItemMixedFlag(Integer itemMixedFlag) {
		this.itemMixedFlag = itemMixedFlag;
	}
	public Integer getItemMixedNum() {
		return itemMixedNum;
	}
	public void setItemMixedNum(Integer itemMixedNum) {
		this.itemMixedNum = itemMixedNum;
	}
	public BigDecimal getItemMixedMoney() {
		return itemMixedMoney;
	}
	public void setItemMixedMoney(BigDecimal itemMixedMoney) {
		this.itemMixedMoney = itemMixedMoney;
	}
	public Integer getStoreMixedFlag() {
		return storeMixedFlag;
	}
	public void setStoreMixedFlag(Integer storeMixedFlag) {
		this.storeMixedFlag = storeMixedFlag;
	}
	public Integer getStoreMixedNum() {
		return storeMixedNum;
	}
	public void setStoreMixedNum(Integer storeMixedNum) {
		this.storeMixedNum = storeMixedNum;
	}
	public BigDecimal getStoreMixedMoney() {
		return storeMixedMoney;
	}
	public void setStoreMixedMoney(BigDecimal storeMixedMoney) {
		this.storeMixedMoney = storeMixedMoney;
	}
	public String getStoreMixedDesc() {
		return storeMixedDesc;
	}
	public void setStoreMixedDesc(String storeMixedDesc) {
		this.storeMixedDesc = storeMixedDesc;
	}
	public String getItemMixedDesc() {
		return itemMixedDesc;
	}
	public void setItemMixedDesc(String itemMixedDesc) {
		this.itemMixedDesc = itemMixedDesc;
	}
	public Integer getPriceQuoteFlag() {
		return priceQuoteFlag;
	}
	public void setPriceQuoteFlag(Integer priceQuoteFlag) {
		this.priceQuoteFlag = priceQuoteFlag;
	}
	public NumAndPrice getOrderNumAndPriceBySku() {
		return orderNumAndPriceBySku;
	}
	public void setOrderNumAndPriceBySku(NumAndPrice orderNumAndPriceBySku) {
		this.orderNumAndPriceBySku = orderNumAndPriceBySku;
	}
	public Integer getIfImport() {
		return ifImport;
	}
	public void setIfImport(Integer ifImport) {
		this.ifImport = ifImport;
	}
	public String getNativeCountry() {
		return nativeCountry;
	}
	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}
	public String getCountryImgUrl() {
		return countryImgUrl;
	}
	public void setCountryImgUrl(String countryImgUrl) {
		this.countryImgUrl = countryImgUrl;
	}
	public Integer getCrossBorderType() {
		return crossBorderType;
	}
	public void setCrossBorderType(Integer crossBorderType) {
		this.crossBorderType = crossBorderType;
	}
	public String getImportPort() {
		return importPort;
	}
	public void setImportPort(String importPort) {
		this.importPort = importPort;
	}
	public String getDeclareOrderNum() {
		return declareOrderNum;
	}
	public void setDeclareOrderNum(String declareOrderNum) {
		this.declareOrderNum = declareOrderNum;
	}
	public BigDecimal getCustomsTax() {
		return customsTax;
	}
	public void setCustomsTax(BigDecimal customsTax) {
		this.customsTax = customsTax;
	}
	public BigDecimal getImportTax() {
		return importTax;
	}
	public void setImportTax(BigDecimal importTax) {
		this.importTax = importTax;
	}
	public Integer getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(Integer arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public String getImportDetailUrl() {
		return importDetailUrl;
	}
	public void setImportDetailUrl(String importDetailUrl) {
		this.importDetailUrl = importDetailUrl;
	}
	public String getDefaultRecieveCity() {
		return defaultRecieveCity;
	}
	public void setDefaultRecieveCity(String defaultRecieveCity) {
		this.defaultRecieveCity = defaultRecieveCity;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public Integer getQualitySort() {
		return qualitySort;
	}
	public void setQualitySort(Integer qualitySort) {
		this.qualitySort = qualitySort;
	}
	public List<NumAndPrice> getOrderNumAndPrice() {
		return orderNumAndPrice;
	}
	public void setOrderNumAndPrice(List<NumAndPrice> orderNumAndPrice) {
		this.orderNumAndPrice = orderNumAndPrice;
	}
	public BigDecimal getMinEarnestAmount() {
		return minEarnestAmount;
	}
	public void setMinEarnestAmount(BigDecimal minEarnestAmount) {
		this.minEarnestAmount = minEarnestAmount;
	}
	public BigDecimal getMinTotalAmount() {
		return minTotalAmount;
	}
	public void setMinTotalAmount(BigDecimal minTotalAmount) {
		this.minTotalAmount = minTotalAmount;
	}
	public String getGoodsSelecteds() {
		return goodsSelecteds;
	}
	public void setGoodsSelecteds(String goodsSelecteds) {
		this.goodsSelecteds = goodsSelecteds;
	}
	public String getOrderNumAndPriceJson() {
		return orderNumAndPriceJson;
	}
	public void setOrderNumAndPriceJson(String orderNumAndPriceJson) {
		this.orderNumAndPriceJson = orderNumAndPriceJson;
	}
	public String getOrderNumAndPriceSkuJson() {
		return orderNumAndPriceSkuJson;
	}
	public void setOrderNumAndPriceSkuJson(String orderNumAndPriceSkuJson) {
		this.orderNumAndPriceSkuJson = orderNumAndPriceSkuJson;
	}
	public Long getCompanyUserId() {
		return companyUserId;
	}
	public void setCompanyUserId(Long companyUserId) {
		this.companyUserId = companyUserId;
	}
	public java.util.Date getFirstPassTime() {
		return firstPassTime;
	}
	public void setFirstPassTime(java.util.Date firstPassTime) {
		this.firstPassTime = firstPassTime;
	}
	public Integer getProductFlag() {
		return productFlag;
	}
	public void setProductFlag(Integer productFlag) {
		this.productFlag = productFlag;
	}
	public Integer getRepaymentPeriod() {
		return repaymentPeriod;
	}
	public void setRepaymentPeriod(Integer repaymentPeriod) {
		this.repaymentPeriod = repaymentPeriod;
	}
}
