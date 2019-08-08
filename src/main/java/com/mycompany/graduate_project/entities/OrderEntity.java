/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "OrderCourse")
public class OrderEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    
    private int totalMoney;

    
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<OrderDetailEntity> orderDetails;
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;
    
    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private TransactionEntity transaction;

    public OrderEntity() {
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
    
    
    
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    
}
