/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.PromotionsEntity;
import com.mycompany.graduate_project.enums.PromotionStatusEnum;
import com.mycompany.graduate_project.model.Promotion;
import com.mycompany.graduate_project.repository.PromotionRepository;
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
public class PromotionService {
    
    @Autowired
    private PromotionRepository promotionRepository;
    
    public List<Promotion> getLstPromotion(){
        List<PromotionsEntity> lstPromotionsEntity = (List<PromotionsEntity>) promotionRepository.findAll();
        List<Promotion> lstPromotion = new ArrayList<>();
        if (lstPromotionsEntity != null && lstPromotionsEntity.size() >0) {
            for (PromotionsEntity promotionsEntity : lstPromotionsEntity) {
                lstPromotion.add(ConvertData.convertPromotionFromPromotionEntity(promotionsEntity));
            }
        }
        return lstPromotion;
    }
    
    public List<Promotion> getLstPromotionAvailable(){
        List<PromotionsEntity> lstPromotionsEntity = (List<PromotionsEntity>) promotionRepository.findByPromotionStatusEnum(PromotionStatusEnum.Open);
        List<Promotion> lstPromotion = new ArrayList<>();
        if (lstPromotionsEntity != null && lstPromotionsEntity.size() >0) {
            for (PromotionsEntity promotionsEntity : lstPromotionsEntity) {
                lstPromotion.add(ConvertData.convertPromotionFromPromotionEntity(promotionsEntity));
            }
        }
        return lstPromotion;
    }
    
    public int addNewPromotion(Promotion promotion) throws ParseException{
        PromotionsEntity promotionsEntity = ConvertData.convertPromotionEntityFromPromotion(promotion);
        promotionRepository.save(promotionsEntity);        
        return promotionsEntity.getPromotionId();
    }
    
    public void deletePromotion(int promotionId){
        promotionRepository.delete(promotionId);
    }
    public Promotion findPromotion(int promotionId){
        PromotionsEntity promotionsEntity = promotionRepository.findOne(promotionId);
        Promotion promotion = ConvertData.convertPromotionFromPromotionEntity(promotionsEntity);
        return promotion;
        
    }
}
