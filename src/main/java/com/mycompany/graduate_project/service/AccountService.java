/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.AccountEntity;
import com.mycompany.graduate_project.model.Account;
import com.mycompany.graduate_project.repository.AccountRepository;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public AccountEntity findByUserNameAndPassword(String email, String password) {
        return accountRepository.findByUserNameAndPassword(email, password);
    }
    
    public int addNewAccount(Account account) throws ParseException{
        AccountEntity accountEntity = ConvertData.convertAccountEntityFromAccount(account);
        accountRepository.save(accountEntity);
        int accId = 0;
        if (accountEntity.getId() != 0) {
            accId = accountEntity.getId();
        }
        return accId;
    
    }
    
    public List<Account> getLstAccount(){
        List<AccountEntity> lstAccountEntity = (List<AccountEntity>) accountRepository.findAll();
        List<Account> lstAccount = new ArrayList<>();
        if (lstAccountEntity != null && lstAccountEntity.size() >0) {
            for (AccountEntity accountEntity : lstAccountEntity) {
                lstAccount.add(ConvertData.convertAccountFromAccountEntity(accountEntity));
            }
        }
        return lstAccount;        
    }
    
    public Account findAccountById(int id){
        AccountEntity accountEntity = accountRepository.findOne(id);
        Account account = ConvertData.convertAccountFromAccountEntity(accountEntity);
        return account;
    }
    
    public int updateAccount(Account account) throws ParseException{
        AccountEntity accountEntity = ConvertData.convertAccountEntityFromAccount(account);
        accountRepository.save(accountEntity);
        int accountId = accountEntity.getId();
        return accountId;
    }
}
