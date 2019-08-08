/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import java.io.Serializable;

/**
 *
 * @author thanhhai
 */
public class Image implements Serializable{
   private int id;
   private String url;
   private Course course;

    public Image() {
    }

   

    public Image(int id, String url, Course course) {
        this.id = id;
        this.url = url;
        this.course = course;
    }

    public Image(int id, String url) {
        this.id = id;
        this.url = url;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
   
   
}
