/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "Courses")
public class CoursesEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Course_Name")
    private String courseName;
    
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private CategoryEntity category;
    
    @Column(name = "Schedule")
    private String schedule;
    
    @Column(name = "Period")
    private String period;
    
    @Column(name = "Price")
    private int price;
    
    @Column(name = "Detail")
    private String detail;
    
    @OneToMany(mappedBy = "courses", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<ImagesEntity> images;
    
    @OneToMany(mappedBy = "coursesEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<OrderDetailEntity> orderDetailEntity;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_promotion_relation", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_promotion_id", referencedColumnName = "id"))
    private Set<PromotionsEntity> promotionsEntity;

    public CoursesEntity() {
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public CoursesEntity(String courseName, CategoryEntity category, String schedule, String period, int price, String detail) {
        this.courseName = courseName;
        this.category = category;
        this.schedule = schedule;
        this.period = period;
        this.price = price;
        this.detail = detail;
    }
    
    

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public int getCourseId() {
        return id;
    }

    public void setCourseId(int courseId) {
        this.id = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<ImagesEntity> getImages() {
        return images;
    }

    public void setImages(List<ImagesEntity> images) {
        this.images = images;
    }

   

    public Set<PromotionsEntity> getPromotionsEntity() {
        return promotionsEntity;
    }

    public void setPromotionsEntity(Set<PromotionsEntity> promotionsEntity) {
        this.promotionsEntity = promotionsEntity;
    }

    

    public List<OrderDetailEntity> getOrderDetailEntity() {
        return orderDetailEntity;
    }

    public void setOrderDetailEntity(List<OrderDetailEntity> orderDetailEntity) {
        this.orderDetailEntity = orderDetailEntity;
    }

    
    
    
    
}
