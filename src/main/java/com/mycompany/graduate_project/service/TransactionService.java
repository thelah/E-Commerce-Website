/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.TransactionEntity;
import com.mycompany.graduate_project.model.Transaction;
import com.mycompany.graduate_project.repository.TransactionRepository;
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
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    public List<Transaction> getLstTransaction(){
        List<TransactionEntity> lstTransactionEntity = (List<TransactionEntity>) transactionRepository.findAll();
        List<Transaction> lstTransaction = new ArrayList<>();
        if (lstTransactionEntity != null && lstTransactionEntity.size() > 0) {
            for (TransactionEntity transactionEntity : lstTransactionEntity) {
                Transaction transaction = ConvertData.convertTransactionFromTransactionEntity(transactionEntity);
                lstTransaction.add(transaction);
            }
        }
        return lstTransaction;
    }
    
    public int updateTransaction(Transaction transaction) throws ParseException{
        TransactionEntity transactionEntity = ConvertData.convertTransactionEntityFromTransaction(transaction);
        transactionRepository.save(transactionEntity);
        int transactionId = 0;
        if(transactionEntity.getTransactionId()!=0){
            transactionId = transactionEntity.getTransactionId();
        }
        return transactionId;
    }
    
    public Transaction findTransaction(int Id){
        TransactionEntity transactionEntity = transactionRepository.findOne(Id);
        Transaction transaction = ConvertData.convertTransactionFromTransactionEntity(transactionEntity);
        return transaction;
    }
}
