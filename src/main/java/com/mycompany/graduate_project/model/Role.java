/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.model;

import com.mycompany.graduate_project.enums.RoleEnum;
import java.io.Serializable;

/**
 *
 * @author thanhhai
 */
public class Role implements Serializable{
     private int id;
     private RoleEnum role;

    public Role() {
    }

    public Role(int id, RoleEnum role) {
        this.id = id;
        this.role = role;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
     
     
}
