/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author thanhhai
 */
public class Course implements Serializable{
    private int id;
    private String name;
    private Category category;
    private String schedule;
    private String period;
    private String price;
    private String detail;
    private List<Promotion> lstPromotion;
    private List<Image> lstImages;

    public Course() {
    }
  

    public Course(int id, String name, Category category, String schedule, String period, String price, String detail) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.schedule = schedule;
        this.period = period;
        this.price = price;
        this.detail = detail;
    }

    public Course(int id, String name) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Promotion> getLstPromotion() {
        return lstPromotion;
    }

    public void setLstPromotion(List<Promotion> lstPromotion) {
        this.lstPromotion = lstPromotion;
    }

    public List<Image> getLstImages() {
        return lstImages;
    }

    public void setLstImages(List<Image> lstImages) {
        this.lstImages = lstImages;
    }

    
    
    
}
