/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.OrderDetailEntity;
import com.mycompany.graduate_project.model.OrderDetail;
import com.mycompany.graduate_project.repository.OrderDetailRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getLstOrderDetail() {
        List<OrderDetailEntity> lstOrderDetailEntity = (List<OrderDetailEntity>) orderDetailRepository.findAll();
        List<OrderDetail> lstOrderDetail = new ArrayList<>();
        if (lstOrderDetailEntity != null && lstOrderDetailEntity.size() > 0) {
            for (OrderDetailEntity orderDetailEntity : lstOrderDetailEntity) {
                lstOrderDetail.add(ConvertData.convertOrderDetailFromOrderDetailEntity(orderDetailEntity));
            }
        }
        return lstOrderDetail;
    }
}
