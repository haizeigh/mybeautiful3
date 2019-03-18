package com.company.service.test.model;

import java.util.Date;

public class PayAgreementInfo {
    private Integer id=3;

    private String userName="zhangshan";

    private String payChannel="APPLE";

    private String merchantId="VIP-API";

    private String uniqueIdentifier="20180918163838692458752";

    private String agreementContent="{\"agreementTransactionId\":\"1000000391831824\"}{\"agreementTransactionId\":\"1000000391831824\"}";

    private Date agreementTime=new Date();

    private Date expireTime=new Date();

    private String goodsId="20180918163838692458752";

    private Integer status=1;

    private Boolean isDelete=true;

    private Date createTime=new Date();

    private Date updateTime=new Date();

    private String transmissionKey="20180918163838692458752";

    private String payChannelMerchantNo="20180918163838692458752";

    public String getPayChannelMerchantNo() {
        return payChannelMerchantNo;
    }

    public void setPayChannelMerchantNo(String payChannelMerchantNo) {
        this.payChannelMerchantNo = payChannelMerchantNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier == null ? null : uniqueIdentifier.trim();
    }


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAgreementContent() {
        return agreementContent;
    }

    public void setAgreementContent(String agreementContent) {
        this.agreementContent = agreementContent == null ? null : agreementContent.trim();
    }

    public Date getAgreementTime() {
        return agreementTime;
    }

    public void setAgreementTime(Date agreementTime) {
        this.agreementTime = agreementTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTransmissionKey() {
        return transmissionKey;
    }

    public void setTransmissionKey(String transmissionKey) {
        this.transmissionKey = transmissionKey;
    }
}
