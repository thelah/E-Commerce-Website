/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.entities;

import com.mycompany.graduate_project.enums.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author thanhhai
 */
@Entity
@Table(name = "Account")
public class AccountEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "UserName")
    private String userName;
    
    @Column(name = "Password")
    private String password;
    
    private String name;
    private String email;
    private String phone;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    
    @Column(name = "Active")
    private boolean active;
    
    @OneToMany(mappedBy = "accountEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntity;
    
    @OneToMany(mappedBy = "accountEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<TransactionEntity> transactionEntity;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role_relation", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_role_id", referencedColumnName = "id"))
    private Set<RoleEntity> roleEntity;
    
    
    public AccountEntity() {
    }

    public AccountEntity(String userName, String password, String name, String email, String phone, Gender gender, Date birthDate, boolean active) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.active = active;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(Set<RoleEntity> role) {
        this.roleEntity = role;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<OrderEntity> getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(List<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
    }

    public List<TransactionEntity> getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(List<TransactionEntity> transactionEntity) {
        this.transactionEntity = transactionEntity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
    
}
