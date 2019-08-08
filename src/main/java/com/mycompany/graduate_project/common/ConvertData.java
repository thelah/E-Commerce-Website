/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.common;

import com.mycompany.graduate_project.entities.AccountEntity;
import com.mycompany.graduate_project.entities.CategoryEntity;
import com.mycompany.graduate_project.entities.CoursesEntity;
import com.mycompany.graduate_project.entities.ImagesEntity;
import com.mycompany.graduate_project.entities.OrderDetailEntity;
import com.mycompany.graduate_project.entities.OrderEntity;
import com.mycompany.graduate_project.entities.PromotionsEntity;
import com.mycompany.graduate_project.entities.RoleEntity;
import com.mycompany.graduate_project.entities.TransactionEntity;
import com.mycompany.graduate_project.model.Account;
import com.mycompany.graduate_project.model.Category;
import com.mycompany.graduate_project.model.Course;
import com.mycompany.graduate_project.model.Image;
import com.mycompany.graduate_project.model.Order;
import com.mycompany.graduate_project.model.OrderDetail;
import com.mycompany.graduate_project.model.Promotion;
import com.mycompany.graduate_project.model.Role;
import com.mycompany.graduate_project.model.Transaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author thanhhai
 */
public class ConvertData {
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    //********Category*******
    
    public static Category convertCategoryFromCategoryEntity(CategoryEntity categoryEntity){
        Category category = new Category(
                categoryEntity.getCateId(),
                categoryEntity.getCateName(),
                categoryEntity.getCateDetail());
        return category;
    }
    
    public static CategoryEntity convertCategoryEntityFromCategory(Category category){
        CategoryEntity categoryEntity = new CategoryEntity(
                category.getName(), 
                category.getDetail());
        if (category.getId()!= 0) {
            categoryEntity.setCateId(category.getId());
        }
        return categoryEntity;
    }
    
//    *********Promotion*******
    
    public static Promotion convertPromotionFromPromotionEntity(PromotionsEntity promotionsEntity){
        String beginDate = sdf.format(promotionsEntity.getBeginDate());
        String endDate = sdf.format(promotionsEntity.getEndDate());
        String discount = Float.toString(promotionsEntity.getPercentDiscount());
        Promotion promotion = new Promotion(
                promotionsEntity.getPromotionId(), 
                promotionsEntity.getPromotionName(), 
                beginDate, 
                endDate, 
                discount, 
                promotionsEntity.getPromotionDetail(),
                promotionsEntity.getPromotionStatusEnum());
        return promotion;
    }
    
    public static PromotionsEntity convertPromotionEntityFromPromotion(Promotion promotion) throws ParseException{
        Date bedinDate = sdf.parse(promotion.getBeginDate());
        Date endDate = sdf.parse(promotion.getEndDate());
        float discount = Float.parseFloat(promotion.getDiscount());
        PromotionsEntity promotionsEntity = new PromotionsEntity(
                promotion.getName(), 
                bedinDate, 
                endDate, 
                discount, 
                promotion.getDetail(),
                promotion.getStatus());
        if(promotion.getId() != 0){
            promotionsEntity.setPromotionId(promotion.getId());
        }
        return promotionsEntity;
    }
    
//    *********Course*******
    public static Course convertCourseFromCourseEntity(CoursesEntity coursesEntity){
        String price = String.valueOf(coursesEntity.getPrice());
        Category category = new Category(
                coursesEntity.getCategory().getCateId(), 
                coursesEntity.getCategory().getCateName(), 
                coursesEntity.getCategory().getCateDetail());        
        Course course = new Course(
                coursesEntity.getCourseId(), 
                coursesEntity.getCourseName(), 
                category, 
                coursesEntity.getSchedule(), 
                coursesEntity.getPeriod(), 
                price, 
                coursesEntity.getDetail());
        if(coursesEntity.getPromotionsEntity()!= null && !coursesEntity.getPromotionsEntity().isEmpty()){
            List<Promotion> listPromotion = new ArrayList<>();
            for (PromotionsEntity promotionsEntity : coursesEntity.getPromotionsEntity()) {
                Promotion obj = new Promotion(promotionsEntity.getPromotionId(), promotionsEntity.getPromotionName());
                listPromotion.add(obj);
            }
            course.setLstPromotion(listPromotion);
        }
        if(coursesEntity.getImages()!= null && !coursesEntity.getImages().isEmpty()){
            List<Image> lstImage = new ArrayList<>();
            for (ImagesEntity imagesEntity : coursesEntity.getImages()) {
                Image obj = new Image(imagesEntity.getImageId(), imagesEntity.getUrl());
                lstImage.add(obj);
            }
            course.setLstImages(lstImage);
        }
        return course;
    }
 
    public static CoursesEntity convertCourseEntityFromCourse(Course course){
        int price = Integer.parseInt(course.getPrice());
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCateId(course.getCategory().getId());
        CoursesEntity coursesEntity = new CoursesEntity(
                course.getName(), 
                categoryEntity, 
                course.getSchedule(), 
                course.getPeriod(), 
                price, 
                course.getDetail());
        if (course.getId() != 0) {
            coursesEntity.setCourseId(course.getId());
        }
        if(course.getLstPromotion() != null && !course.getLstPromotion().isEmpty()){
            Set<PromotionsEntity> lstPromotionsEntity = new HashSet<>();
            for(Promotion promotion : course.getLstPromotion()){
                PromotionsEntity promotionsEntity = new PromotionsEntity();
                promotionsEntity.setPromotionId(promotion.getId());
                lstPromotionsEntity.add(promotionsEntity);
            }
           coursesEntity.setPromotionsEntity(lstPromotionsEntity);
        }
        return coursesEntity;
    }

//    *********Account*******    
    
    public static Account convertAccountFromAccountEntity(AccountEntity accountEntity){
        String birthdate = sdf.format(accountEntity.getBirthDate());
        Account account = new Account(
                accountEntity.getId(),
                accountEntity.getUserName(), 
                accountEntity.getPassword(),
                accountEntity.getName(),
                accountEntity.getEmail(), 
                accountEntity.getPhone(), 
                accountEntity.getGender(),
                birthdate,
                accountEntity.isActive());
        if(accountEntity.getRoleEntity() != null && !accountEntity.getRoleEntity().isEmpty()){
            List<Role> listRole = new ArrayList<>();
            for (RoleEntity roleEntity : accountEntity.getRoleEntity()) {
                Role obj = new Role(roleEntity.getId(), roleEntity.getRole());
                listRole.add(obj);
            }
            account.setListRole(listRole);
        }
        return account;
                
    }
    
    public static AccountEntity convertAccountEntityFromAccount(Account account) throws ParseException{
        Date date = sdf.parse(account.getBirthDate());
        AccountEntity accountEntity = new AccountEntity(
                account.getUserName(), 
                account.getPassword(), 
                account.getName(), 
                account.getEmail(), 
                account.getPhone(), 
                account.getGender(), 
                date,
                account.isActive());
        if (account.getId() != 0) {
            accountEntity.setId(account.getId());
        }
              
        if (account.getListRole() != null && !account.getListRole().isEmpty()) {
            Set<RoleEntity> lstRoleEntity = new HashSet<>();
            for (Role role : account.getListRole()) {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setId(role.getId());
                lstRoleEntity.add(roleEntity);
            }
            accountEntity.setRoleEntity(lstRoleEntity);
        }
        return accountEntity;
        
    }
    
//    *********IMAGE******* 
    
    
    public static Image convertImageFromImageEntity(ImagesEntity imagesEntity){
        String price = String.valueOf(imagesEntity.getCourses().getPrice());
        Category category = new Category(
                imagesEntity.getCourses().getCategory().getCateId(), 
                imagesEntity.getCourses().getCategory().getCateName(), 
                imagesEntity.getCourses().getCategory().getCateDetail());
        Course course = new Course(
                imagesEntity.getCourses().getCourseId(), 
                imagesEntity.getCourses().getCourseName(), 
                category, 
                imagesEntity.getCourses().getSchedule(), 
                imagesEntity.getCourses().getPeriod(), 
                price, 
                imagesEntity.getCourses().getDetail());
        Image image = new Image(
                imagesEntity.getImageId(),
                imagesEntity.getUrl(),
                course);
        return image;
    }
    
    public static ImagesEntity convertImageEntityFromImage(Image image){
        CoursesEntity coursesEntity = new CoursesEntity();
        coursesEntity.setCourseId(image.getCourse().getId());
        ImagesEntity imagesEntity = new ImagesEntity(
                "/resources/images/"+image.getUrl(),
                coursesEntity);
        if (image.getId() != 0) {
            imagesEntity.setImageId(image.getId());
        }
        return imagesEntity;
    }

//    *********ORDER*******     
    
    public static Order convertOrderFromOrderEntity(OrderEntity orderEntity){
        String orderDate = sdf.format(orderEntity.getOrderDate());
        String birthDate = sdf.format(orderEntity.getAccountEntity().getBirthDate());
        Account account = new Account(
               orderEntity.getAccountEntity().getId(), 
               orderEntity.getAccountEntity().getUserName(), 
               orderEntity.getAccountEntity().getPassword(),
               orderEntity.getAccountEntity().getName(), 
               orderEntity.getAccountEntity().getEmail(), 
               orderEntity.getAccountEntity().getPhone(), 
               orderEntity.getAccountEntity().getGender(), 
               birthDate,
               orderEntity.getAccountEntity().isActive());
        
        Order order = new Order(orderEntity.getOrderId(), 
                orderDate, 
                orderEntity.getTotalMoney(), 
                account);      
        List<OrderDetail> lstOrderDetail = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : orderEntity.getOrderDetails()) {            
            OrderDetail obj = new OrderDetail(
                    orderDetailEntity.getOrderDetailId(), 
                    new Course(orderDetailEntity.getCoursesEntity().getCourseId(), orderDetailEntity.getCoursesEntity().getCourseName()),
                    orderDetailEntity.getPrice(), 
                    orderDetailEntity.getQuantity(), 
                    orderDetailEntity.getTotal());
            lstOrderDetail.add(obj);
        }
        order.setOrderDetail(lstOrderDetail);
        
        return order;
    }
    
 //    *********ORDER DETAIL*******      
    
    public static OrderDetail convertOrderDetailFromOrderDetailEntity(OrderDetailEntity orderDetailEntity){
        String orderDate = sdf.format(orderDetailEntity.getOrder().getOrderDate());
        Course course = new Course(
                orderDetailEntity.getCoursesEntity().getCourseId(), 
                orderDetailEntity.getCoursesEntity().getCourseName());
        Account account = new Account();
        
        account.setId(orderDetailEntity.getOrder().getAccountEntity().getId());
        Order order = new Order(
                orderDetailEntity.getOrder().getOrderId(), 
                orderDate, 
                orderDetailEntity.getOrder().getTotalMoney(), 
                account);
        OrderDetail orderDetail = new OrderDetail(
                orderDetailEntity.getOrderDetailId(), 
                course, 
                order, 
                orderDetailEntity.getPrice(), 
                orderDetailEntity.getQuantity(),
                orderDetailEntity.getTotal());
        return orderDetail;
    }
    
//    *********TRANSACTION*******       
    
    public static Transaction convertTransactionFromTransactionEntity(TransactionEntity transactionEntity){
        String orderDate = sdf.format(transactionEntity.getOrder().getOrderDate());
        String transDate = sdf.format(transactionEntity.getTransDate());
        
        Order order = new Order();
        order.setId(transactionEntity.getOrder().getOrderId());
        order.setOrderDate(orderDate);
        
        Account account = new Account();
        account.setId(transactionEntity.getAccountEntity().getId());
        account.setName(transactionEntity.getAccountEntity().getName());
        
        Transaction transaction = new Transaction(
                transactionEntity.getTransactionId(), 
                order, 
                transactionEntity.getAmount(), 
                transDate, 
                account, 
                transactionEntity.getStatus());
        return transaction;
    }
    
    public static TransactionEntity convertTransactionEntityFromTransaction(Transaction transaction) throws ParseException{
        Date transDate = sdf.parse(transaction.getTransDate());
        
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(transaction.getOrder().getId());
        
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(transaction.getAccount().getId());
        
        TransactionEntity transactionEntity = new TransactionEntity(
                orderEntity, 
                transaction.getAmount(), 
                transDate, 
                accountEntity, 
                transaction.getStatus());
        if (transaction.getId() != 0) {
            transactionEntity.setTransactionId(transaction.getId());
        }
        return transactionEntity;
    }
}
