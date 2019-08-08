/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import com.mycompany.graduate_project.enums.PromotionStatusEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "Promotions")
public class PromotionsEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Name")
    private String promotionName;
    
    @Column(name = "Begin_Date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date beginDate;
    
    @Column(name = "End_Date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "Percent_Discount")
    private float percentDiscount;
    
    @Column(name = "Detail")
    private String promotionDetail;
    
    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private PromotionStatusEnum promotionStatusEnum;
    

    public PromotionsEntity() {
    }

    public PromotionsEntity(String promotionName, Date beginDate, Date endDate, float percentDiscount, String promotionDetail, PromotionStatusEnum promotionStatusEnum) {
        this.promotionName = promotionName;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.percentDiscount = percentDiscount;
        this.promotionDetail = promotionDetail;
        this.promotionStatusEnum = promotionStatusEnum;
    }

    
    
    public int getPromotionId() {
        return id;
    }

    public void setPromotionId(int promotionId) {
        this.id = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(String promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(float percentDiscount) {
        this.percentDiscount = percentDiscount;
    }


    public PromotionStatusEnum getPromotionStatusEnum() {
        return promotionStatusEnum;
    }

    public void setPromotionStatusEnum(PromotionStatusEnum promotionStatusEnum) {
        this.promotionStatusEnum = promotionStatusEnum;
    }

    
    
    
    
}
