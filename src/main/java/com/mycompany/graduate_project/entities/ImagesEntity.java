/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "Images" )
public class ImagesEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    
    @Column(name = "URL")
    private String url;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesEntity courses;

    public ImagesEntity() {
    }

    public ImagesEntity(String url, CoursesEntity courses) {
        this.url = url;
        this.courses = courses;
    }
    
    
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CoursesEntity getCourses() {
        return courses;
    }

    public void setCourses(CoursesEntity courses) {
        this.courses = courses;
    }
    
    
}
