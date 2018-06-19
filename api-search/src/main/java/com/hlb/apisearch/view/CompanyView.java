package com.hlb.apisearch.view;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompanyView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Long id;
	/** 公司名称 */
	public String companyname = "";
	/** 营业执照注册号 */
	public String businessLicenseNum = "";
	/** 营业执照所处省 */
	public String businessLicenseProvince = "";
	/** 营业执照所处市 */
	public String businessLicenseCity = "";
	
	/** 营业执照所处省 名字（冗余）*/
	public String businessLicenseProvinceName = "";
	/** 营业执照所处市 名字（冗余）*/
	public String businessLicenseCityName = "";
	/** 营业执照详细地址 */
	public String businessLicenseAddress = "";
	/** 成立日期 */
	public String establishDate = "1970-01-01";
	/** 营业开始日期 */
	public String businessStartDate = "1970-01-01";
	/** 营业结束日期（长期2099） */
	public String businessEndDate = "1970-01-01";
	/** 公司注册资本（万元RMB） */
	public BigDecimal registrationCapital = BigDecimal.ZERO;
	/** 经营范围 */
	public String businessScope = "";
	/** 法人代表 */
	public String legalRepresentative = "";
	/** 身份证号码 */
	public String identityCard = "";
	/** 公司营业执照照片 */
	public String businessLicenseImg = "";
	/** 法人身份证图片 */
	public String identityCardImg = "";
	/** 组织机构代码前半段 */
	public String organizationCode1 = "";
	/** 组织机构代码后半段 */
	public String organizationCode2 = "";
	/** 组织机构代码生效日期 */
	public String orgCodeEffectiveDate = "1970-01-01";
	/** 组织机构代码失效日期 */
	public String orgCodeExpirationDate = "1970-01-01";
	/** 组织机构代码证 */
	public String orgCodeImg = "";
	/** 纳税人识别号 */
	public String taxpayerIdentificationNum = "";
	/** 纳税人类型(0,一般纳税人,1,小规模纳税人) */
	public Integer taxpayerType = -1;
	/** 税务登记证 */
	public String taxpayerRegistrationImg = "";
	/** 一般纳税人资质证明 */
	public String taxpayerQualificationImg = "";
	/** 银行开户名 */
	public String bankAccountName = "";
	/** 公司银行账号 */
	public String companyBankAccount = "";
	/** 开户银行支行名称 */
	public String bankBranchName = "";
	/** 结算银行开户名 */
	public String settlementBankAccountName = "";
	/** 结算公司银行账号 */
	public String settlementCompanyBankAccount = "";
	/** 结算开户行 */
	public String settlementBankBranchName = "";
	/** 开户许可证图片 */
	public String openingPermitImg = "";
	/** 账号确认函图片 */
	public String accountConfirmImg = "";
	/** 业务联系人 */
	public String businessContactPerson = "";
	/** 业务联系人手机 */
	public String businessContactPhone = "";
	/** 业务联系人邮箱 */
	public String businessContactEmail = "";
	/** 财务联系人 */
	public String financialContactPerson = "";
	/** 财务联系人手机 */
	public String financialContactPhone = "";
	/** 财务联系人邮箱 */
	public String financialContactEmail = "";
	/** 公司办公地址的省 */
	public String companyAddressProvince = "";
	/** 公司办公地址的市 */
	public String companyAddressCity = "";
	/** 公司办公详细地址 */
	public String companyAddressDetail = "";
	/** 公司电话 */
	public String companyPhone = "";
	/** 公司邮箱 */
	public String companyEmail = "";
	/** 消费者官方客服电话 */
	public String customerServicePhone = "";
	/** 企业委托书图片 */
	public String corporateAttorneyImg = "";
	/** 资质审核状态 */
	public Integer aptitudeAuditStatus = 0;
	/** 合同审核状态 */
	public Integer contractAuditStatus = 0;
	/** 扣点比例 */
	public Double deductionRatio = 0.00;
	/** 提交申请审核时间 */
	public String applyAuditTime = "1970-01-01 00:00:00";
	/** 品牌审核状态 */
	public Integer brandAuditStatus = 0;
	/** 货到付款 */
	public Integer cashOnDelivery = 0;
	/** 放置办事处 */
	public Integer putOnOffice = 0;
	/** 经营状态 */
	public Integer businessStatus = 0;

	public String loginphone;
	/** 公司简介 */
	public String companyInfo = "";

	// 签约内容
	public String contractNo;
	public String signTime;
	public String orderOperator;
	public String followOperator;
	public String remark;

	/**
	 * 是否推荐
	 */
	public Integer ifRecommend;

	/**
	 * 频道编号（关联t_category分类编号）
	 * */
	public Long channelId;
	
	//频道中文名
	public String channelName;
	//
	private Long supplierId; // = user id 
	private String provinceName; //所在省
	private String cityName;  //所在市
	
	/**
	 * 推荐排序
	 */
	public Integer recommendOrder;

	/**
	 * 店铺混批条件(件数)
	 */
	private Integer storeMixedNum;

	/**
	 * 店铺混批条件(元)
	 */
	private BigDecimal storeMixedMoney;
	/**
	 * 店铺混批开关 1 已打开 2未打开 本商店是否支持店铺混批  
	 */
	private Integer storeMixedFlag;
	
    private String updateTime = "1970-01-01 00:00:00";
	
	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getBusinessLicenseNum() {
		return businessLicenseNum;
	}

	public void setBusinessLicenseNum(String businessLicenseNum) {
		this.businessLicenseNum = businessLicenseNum;
	}

	public String getBusinessLicenseProvince() {
		return businessLicenseProvince;
	}

	public void setBusinessLicenseProvince(String businessLicenseProvince) {
		this.businessLicenseProvince = businessLicenseProvince;
	}

	public String getBusinessLicenseCity() {
		return businessLicenseCity;
	}

	public void setBusinessLicenseCity(String businessLicenseCity) {
		this.businessLicenseCity = businessLicenseCity;
	}

	public String getBusinessLicenseProvinceName() {
		return businessLicenseProvinceName;
	}

	public void setBusinessLicenseProvinceName(String businessLicenseProvinceName) {
		this.businessLicenseProvinceName = businessLicenseProvinceName;
	}

	public String getBusinessLicenseCityName() {
		return businessLicenseCityName;
	}

	public void setBusinessLicenseCityName(String businessLicenseCityName) {
		this.businessLicenseCityName = businessLicenseCityName;
	}

	public String getBusinessLicenseAddress() {
		return businessLicenseAddress;
	}

	public void setBusinessLicenseAddress(String businessLicenseAddress) {
		this.businessLicenseAddress = businessLicenseAddress;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	public String getBusinessStartDate() {
		return businessStartDate;
	}

	public void setBusinessStartDate(String businessStartDate) {
		this.businessStartDate = businessStartDate;
	}

	public String getBusinessEndDate() {
		return businessEndDate;
	}

	public void setBusinessEndDate(String businessEndDate) {
		this.businessEndDate = businessEndDate;
	}

	public BigDecimal getRegistrationCapital() {
		return registrationCapital;
	}

	public void setRegistrationCapital(BigDecimal registrationCapital) {
		this.registrationCapital = registrationCapital;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getBusinessLicenseImg() {
		return businessLicenseImg;
	}

	public void setBusinessLicenseImg(String businessLicenseImg) {
		this.businessLicenseImg = businessLicenseImg;
	}

	public String getIdentityCardImg() {
		return identityCardImg;
	}

	public void setIdentityCardImg(String identityCardImg) {
		this.identityCardImg = identityCardImg;
	}

	public String getOrganizationCode1() {
		return organizationCode1;
	}

	public void setOrganizationCode1(String organizationCode1) {
		this.organizationCode1 = organizationCode1;
	}

	public String getOrganizationCode2() {
		return organizationCode2;
	}

	public void setOrganizationCode2(String organizationCode2) {
		this.organizationCode2 = organizationCode2;
	}

	public String getOrgCodeEffectiveDate() {
		return orgCodeEffectiveDate;
	}

	public void setOrgCodeEffectiveDate(String orgCodeEffectiveDate) {
		this.orgCodeEffectiveDate = orgCodeEffectiveDate;
	}

	public String getOrgCodeExpirationDate() {
		return orgCodeExpirationDate;
	}

	public void setOrgCodeExpirationDate(String orgCodeExpirationDate) {
		this.orgCodeExpirationDate = orgCodeExpirationDate;
	}

	public String getOrgCodeImg() {
		return orgCodeImg;
	}

	public void setOrgCodeImg(String orgCodeImg) {
		this.orgCodeImg = orgCodeImg;
	}

	public String getTaxpayerIdentificationNum() {
		return taxpayerIdentificationNum;
	}

	public void setTaxpayerIdentificationNum(String taxpayerIdentificationNum) {
		this.taxpayerIdentificationNum = taxpayerIdentificationNum;
	}

	public Integer getTaxpayerType() {
		return taxpayerType;
	}

	public void setTaxpayerType(Integer taxpayerType) {
		this.taxpayerType = taxpayerType;
	}

	public String getTaxpayerRegistrationImg() {
		return taxpayerRegistrationImg;
	}

	public void setTaxpayerRegistrationImg(String taxpayerRegistrationImg) {
		this.taxpayerRegistrationImg = taxpayerRegistrationImg;
	}

	public String getTaxpayerQualificationImg() {
		return taxpayerQualificationImg;
	}

	public void setTaxpayerQualificationImg(String taxpayerQualificationImg) {
		this.taxpayerQualificationImg = taxpayerQualificationImg;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getCompanyBankAccount() {
		return companyBankAccount;
	}

	public void setCompanyBankAccount(String companyBankAccount) {
		this.companyBankAccount = companyBankAccount;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getSettlementBankAccountName() {
		return settlementBankAccountName;
	}

	public void setSettlementBankAccountName(String settlementBankAccountName) {
		this.settlementBankAccountName = settlementBankAccountName;
	}

	public String getSettlementCompanyBankAccount() {
		return settlementCompanyBankAccount;
	}

	public void setSettlementCompanyBankAccount(String settlementCompanyBankAccount) {
		this.settlementCompanyBankAccount = settlementCompanyBankAccount;
	}

	public String getSettlementBankBranchName() {
		return settlementBankBranchName;
	}

	public void setSettlementBankBranchName(String settlementBankBranchName) {
		this.settlementBankBranchName = settlementBankBranchName;
	}

	public String getOpeningPermitImg() {
		return openingPermitImg;
	}

	public void setOpeningPermitImg(String openingPermitImg) {
		this.openingPermitImg = openingPermitImg;
	}

	public String getAccountConfirmImg() {
		return accountConfirmImg;
	}

	public void setAccountConfirmImg(String accountConfirmImg) {
		this.accountConfirmImg = accountConfirmImg;
	}

	public String getBusinessContactPerson() {
		return businessContactPerson;
	}

	public void setBusinessContactPerson(String businessContactPerson) {
		this.businessContactPerson = businessContactPerson;
	}

	public String getBusinessContactPhone() {
		return businessContactPhone;
	}

	public void setBusinessContactPhone(String businessContactPhone) {
		this.businessContactPhone = businessContactPhone;
	}

	public String getBusinessContactEmail() {
		return businessContactEmail;
	}

	public void setBusinessContactEmail(String businessContactEmail) {
		this.businessContactEmail = businessContactEmail;
	}

	public String getFinancialContactPerson() {
		return financialContactPerson;
	}

	public void setFinancialContactPerson(String financialContactPerson) {
		this.financialContactPerson = financialContactPerson;
	}

	public String getFinancialContactPhone() {
		return financialContactPhone;
	}

	public void setFinancialContactPhone(String financialContactPhone) {
		this.financialContactPhone = financialContactPhone;
	}

	public String getFinancialContactEmail() {
		return financialContactEmail;
	}

	public void setFinancialContactEmail(String financialContactEmail) {
		this.financialContactEmail = financialContactEmail;
	}

	public String getCompanyAddressProvince() {
		return companyAddressProvince;
	}

	public void setCompanyAddressProvince(String companyAddressProvince) {
		this.companyAddressProvince = companyAddressProvince;
	}

	public String getCompanyAddressCity() {
		return companyAddressCity;
	}

	public void setCompanyAddressCity(String companyAddressCity) {
		this.companyAddressCity = companyAddressCity;
	}

	public String getCompanyAddressDetail() {
		return companyAddressDetail;
	}

	public void setCompanyAddressDetail(String companyAddressDetail) {
		this.companyAddressDetail = companyAddressDetail;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCustomerServicePhone() {
		return customerServicePhone;
	}

	public void setCustomerServicePhone(String customerServicePhone) {
		this.customerServicePhone = customerServicePhone;
	}

	public String getCorporateAttorneyImg() {
		return corporateAttorneyImg;
	}

	public void setCorporateAttorneyImg(String corporateAttorneyImg) {
		this.corporateAttorneyImg = corporateAttorneyImg;
	}

	public Integer getAptitudeAuditStatus() {
		return aptitudeAuditStatus;
	}

	public void setAptitudeAuditStatus(Integer aptitudeAuditStatus) {
		this.aptitudeAuditStatus = aptitudeAuditStatus;
	}

	public Integer getContractAuditStatus() {
		return contractAuditStatus;
	}

	public void setContractAuditStatus(Integer contractAuditStatus) {
		this.contractAuditStatus = contractAuditStatus;
	}

	public Double getDeductionRatio() {
		return deductionRatio;
	}

	public void setDeductionRatio(Double deductionRatio) {
		this.deductionRatio = deductionRatio;
	}

	public String getApplyAuditTime() {
		return applyAuditTime;
	}

	public void setApplyAuditTime(String applyAuditTime) {
		this.applyAuditTime = applyAuditTime;
	}

	public Integer getBrandAuditStatus() {
		return brandAuditStatus;
	}

	public void setBrandAuditStatus(Integer brandAuditStatus) {
		this.brandAuditStatus = brandAuditStatus;
	}

	public Integer getCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(Integer cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	public Integer getPutOnOffice() {
		return putOnOffice;
	}

	public void setPutOnOffice(Integer putOnOffice) {
		this.putOnOffice = putOnOffice;
	}

	public Integer getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(Integer businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getLoginphone() {
		return loginphone;
	}

	public void setLoginphone(String loginphone) {
		this.loginphone = loginphone;
	}

	public String getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getOrderOperator() {
		return orderOperator;
	}

	public void setOrderOperator(String orderOperator) {
		this.orderOperator = orderOperator;
	}

	public String getFollowOperator() {
		return followOperator;
	}

	public void setFollowOperator(String followOperator) {
		this.followOperator = followOperator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIfRecommend() {
		return ifRecommend;
	}

	public void setIfRecommend(Integer ifRecommend) {
		this.ifRecommend = ifRecommend;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getRecommendOrder() {
		return recommendOrder;
	}

	public void setRecommendOrder(Integer recommendOrder) {
		this.recommendOrder = recommendOrder;
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

	public Integer getStoreMixedFlag() {
		return storeMixedFlag;
	}

	public void setStoreMixedFlag(Integer storeMixedFlag) {
		this.storeMixedFlag = storeMixedFlag;
	}
	
}
