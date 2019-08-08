/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "Category")
public class CategoryEntity implements  Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_ID")
    private int cateId;
    
    @Column(name = "Category_Name")
    private String cateName;
    
    @Column(name = "Detail")
    private String cateDetail;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<CoursesEntity> courses;

    public CategoryEntity() {
    }

    public CategoryEntity(String cateName, String cateDetail) {
        this.cateName = cateName;
        this.cateDetail = cateDetail;
    }

  

    public List<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesEntity> courses) {
        this.courses = courses;
    }
    
    
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDetail() {
        return cateDetail;
    }

    public void setCateDetail(String cateDetail) {
        this.cateDetail = cateDetail;
    }
    
    
}
