/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.repository;

import com.mycompany.graduate_project.entities.AccountEntity;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author thanhhai
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Integer>{
    public AccountEntity findByUserNameAndPassword(String email, String password);
    
    
}
