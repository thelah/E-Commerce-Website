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
public class OrderDetail implements Serializable{
    
    private int id;
    private Course course;
    private Order order;
    private int price;
    private int quantity;
    private int total;
    

    public OrderDetail() {
    }

    public OrderDetail(int id, Course course, Order order, int price, int quantity, int total) {
        this.id = id;
        this.course = course;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderDetail(int id, Course course, int price, int quantity, int total) {
        this.id = id;
        this.course = course;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
    
    
    
}
