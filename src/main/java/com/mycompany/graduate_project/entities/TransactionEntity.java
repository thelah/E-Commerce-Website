/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import com.mycompany.graduate_project.enums.PaymentStatusEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "Transaction")
public class TransactionEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
    private int  amount;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transDate;
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;
    
    public TransactionEntity() {
    }

    public TransactionEntity(OrderEntity order, int amount, Date transDate, AccountEntity accountEntity, PaymentStatusEnum status) {
        this.order = order;
        this.amount = amount;
        this.transDate = transDate;
        this.accountEntity = accountEntity;
        this.status = status;
    }
    
    
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    
    
    
}
