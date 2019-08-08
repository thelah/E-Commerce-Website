/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import java.io.Serializable;
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
@Table(name = "OrderDetail")
public class OrderDetailEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;
    private int quantity;
    private int price;
    private int total;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesEntity coursesEntity;

    public OrderDetailEntity() {
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public CoursesEntity getCoursesEntity() {
        return coursesEntity;
    }

    public void setCoursesEntity(CoursesEntity coursesEntity) {
        this.coursesEntity = coursesEntity;
    }

    
    
    
}
