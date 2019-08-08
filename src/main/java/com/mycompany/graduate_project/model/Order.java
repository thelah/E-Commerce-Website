/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thanhhai
 */
public class Order implements Serializable{
    private int id;
    private String orderDate;
    private int totalMoney;
    private Account account;
    private List <OrderDetail> orderDetail;

    public Order() {
    }

//    public Order(int id, String orderDate, int totalMoney, Account account) {
//        this.id = id;
//        this.orderDate = orderDate;
//        this.totalMoney = totalMoney;
//        this.account = account;
//    }

    public Order(int id, String orderDate, int totalMoney, Account account, List<OrderDetail> orderDetail) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalMoney = totalMoney;
        this.account = account;
        this.orderDetail = orderDetail;
    }

    public Order(int id, String orderDate, int totalMoney, Account account) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalMoney = totalMoney;
        this.account = account;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }
    
    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
