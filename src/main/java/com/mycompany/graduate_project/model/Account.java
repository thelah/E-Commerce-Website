/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import com.mycompany.graduate_project.enums.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thanhhai
 */
public class Account implements Serializable{
    private int id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private String birthDate;
    private List<Role> listRole;
    private boolean active;

    public Account() {
    }

    public Account(int id, String userName, String password, String name, String email, String phone, Gender gender, String birthDate, boolean active) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    

    public List<Role> getListRole() {
        return listRole;
    }

    public void setListRole(List<Role> listRole) {
        this.listRole = listRole;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
