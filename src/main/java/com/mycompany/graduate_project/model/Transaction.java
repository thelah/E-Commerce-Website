/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import com.mycompany.graduate_project.enums.PaymentStatusEnum;
import java.io.Serializable;

/**
 *
 * @author thanhhai
 */
public class Transaction implements Serializable{
    
    private int id;
    private Order order;
    private int amount;
    private String transDate;
    private Account account;
    private PaymentStatusEnum status;

    public Transaction() {
    }

    public Transaction(int id, Order order, int amount, String transDate, Account account, PaymentStatusEnum status) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.transDate = transDate;
        this.account = account;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }
    
    
}
