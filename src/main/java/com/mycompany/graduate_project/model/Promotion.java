/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import com.mycompany.graduate_project.enums.PromotionStatusEnum;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author thanhhai
 */
public class Promotion implements Serializable{
    
    private int id;
    private String name;
    private String beginDate;
    private String endDate;
    private String discount;
    private String detail;
    private PromotionStatusEnum status;

    public Promotion() {
    }

    public Promotion(int id, String name, String beginDate, String endDate, String discount, String detail, PromotionStatusEnum status) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.discount = discount;
        this.detail = detail;
        this.status = status;
    }

    public Promotion(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public PromotionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PromotionStatusEnum status) {
        this.status = status;
    }

    
    
}
