/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.repository;

import com.mycompany.graduate_project.entities.PromotionsEntity;
import com.mycompany.graduate_project.enums.PromotionStatusEnum;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thanhhai
 */
@Repository
public interface PromotionRepository extends CrudRepository<PromotionsEntity, Integer>{
    
    public List<PromotionsEntity> findByPromotionStatusEnum(PromotionStatusEnum promotionStatusEnum);
    
}
