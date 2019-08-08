/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.OrderEntity;
import com.mycompany.graduate_project.model.Order;
import com.mycompany.graduate_project.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getLstOrder(){
        List<OrderEntity> lstOrderEntity = (List<OrderEntity>) orderRepository.findAll();
        List<Order> lstOrder = new ArrayList<>();
        if (lstOrderEntity != null && lstOrderEntity.size()>0) {
            for (OrderEntity orderEntity : lstOrderEntity) {
                lstOrder.add(ConvertData.convertOrderFromOrderEntity(orderEntity));
            }
        }
        return lstOrder;
    }
}
