/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.entities.RoleEntity;
import com.mycompany.graduate_project.enums.RoleEnum;
import com.mycompany.graduate_project.model.Role;
import com.mycompany.graduate_project.repository.RoleRepositoty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class RoleService {
    
    @Autowired
    private RoleRepositoty roleRepository;
    
    public List<Role> getLstRole(){
       List<RoleEntity> lstRoleEntity = (List<RoleEntity>) roleRepository.findAll();
       List<Role> lstRole = new ArrayList<>();
        if (lstRoleEntity != null && lstRoleEntity.size()>0) {
            for (RoleEntity roleEntity : lstRoleEntity) {
                Role role = new Role(roleEntity.getId(), roleEntity.getRole());
                lstRole.add(role);
            }
        }
        return lstRole;
    }
}
