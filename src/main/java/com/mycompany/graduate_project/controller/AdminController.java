/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.controller;

import com.mycompany.graduate_project.entities.AccountEntity;
import com.mycompany.graduate_project.enums.Gender;
import com.mycompany.graduate_project.enums.PaymentStatusEnum;
import com.mycompany.graduate_project.enums.PromotionStatusEnum;
import com.mycompany.graduate_project.model.Account;
import com.mycompany.graduate_project.model.Category;
import com.mycompany.graduate_project.model.Course;
import com.mycompany.graduate_project.model.Image;
import com.mycompany.graduate_project.model.Promotion;
import com.mycompany.graduate_project.model.Transaction;
import com.mycompany.graduate_project.service.AccountService;
import com.mycompany.graduate_project.service.CategoryService;
import com.mycompany.graduate_project.service.CourseService;
import com.mycompany.graduate_project.service.ImageService;
import com.mycompany.graduate_project.service.OrderDetailService;
import com.mycompany.graduate_project.service.OrderService;
import com.mycompany.graduate_project.service.PromotionService;
import com.mycompany.graduate_project.service.RoleService;
import com.mycompany.graduate_project.service.TransactionService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thanhhai
 */
@Controller
@RequestMapping(value = "/admin/")
public class AdminController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private PromotionService promotionService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderDetailService orderDetailService;
    
    
    @Autowired
    private TransactionService transactionService;
    
    
    @Autowired
    private RoleService roleService;
    
     @RequestMapping("/adminHome")
    public String showUserAdmin(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AccountEntity) {
            AccountEntity accountEntity = (AccountEntity) (principal);
            model.addAttribute("username",accountEntity.getUserName());
        }
        
        return "adminHomePage";
    }
    
//    ******FOR PROMOTION*******    
    
    @RequestMapping("/adminPromotion")
    public String adminPromotionPage(Model model) {
        model.addAttribute("lstPromotion", promotionService.getLstPromotion());
        return "adminPromotionPage";
    }
    
    @RequestMapping("/add-promotion")
    public String addPromotion(Model model){
        model.addAttribute("headerName", "ADD NEW PROMOTION");
        model.addAttribute("action", "add-new-promotion");
        model.addAttribute("btnName", "Add");
        model.addAttribute("lstStatus", PromotionStatusEnum.values());
        return "addPromotionPage";
    }
    
    @RequestMapping(value = {"/add-new-promotion"}, method = RequestMethod.POST)
    public String addNewPromotion(Model model, Promotion promotion) throws ParseException{
        int promotionId = promotionService.addNewPromotion(promotion);
        if (promotionId != 0) {
            return "redirect:/admin/adminPromotion";
        } else {
            return "redirect:/admin/add-promotion";
        }
        
    }
    
    @RequestMapping("/deletePromotion/{promotionId}")
    public String deletePromotion(Model model, @PathVariable(value = "promotionId") int promotionId){
        promotionService.deletePromotion(promotionId);
        return "redirect:/admin/adminPromotion";
    }
    
    @RequestMapping("/updatePromotion/{promotionId}")
    public String updatePromotion(Model model, @PathVariable(value = "promotionId") int promotionId){
        model.addAttribute("promotion", promotionService.findPromotion(promotionId));
        model.addAttribute("headerName", "UPDATE PROMOTION");
        model.addAttribute("action", "update-promotion");
        model.addAttribute("btnName", "Update");
        model.addAttribute("lstStatus", PromotionStatusEnum.values());
        return "addPromotionPage";
    }
    
    @RequestMapping(value = {"/update-promotion"}, method = RequestMethod.POST)
    public String updateNewPromotion(Model model, Promotion promotion) throws ParseException{
        int promotionId = promotionService.addNewPromotion(promotion);
        if (promotionId != 0) {
            return "redirect:/admin/adminPromotion";
        } else {
            return "redirect:/admin/updatePromotion" + promotion.getId();
        }
    }
    
//     ***************************
    
//    ******FOR CATEGORY*******
    
    @RequestMapping("/adminCategory")
    public String adminCategoryPage(Model model) {
        model.addAttribute("lstCategory",categoryService.getLstCategory());
        return "adminCategoryPage";
    }
    
    @RequestMapping("/add-category")
    public String addCategory(Model model){
        model.addAttribute("headerName", "ADD NEW CATEGORY");
        model.addAttribute("action", "add-new-category");
        model.addAttribute("category", new Category());
        model.addAttribute("btnName", "Add");
        return "addCategoryPage";
    }
    
    @RequestMapping(value = {"/add-new-category"}, method = RequestMethod.POST)
    public String addNewCategory(Model model, Category category){
        int cateId = categoryService.addNewCategory(category);
        if (cateId != 0) {
            return "redirect:/admin/adminCategory";
        } else {
            return "redirect:/admin/add-category";
        }
        
    }
    @RequestMapping("/deleteCategory/{cateId}")
    public String deleteCategory(Model model, @PathVariable(value = "cateId") int cateId){
        categoryService.deleteCategory(cateId);
        return "redirect:/admin/adminCategory";
    }
    
    @RequestMapping("/updateCategory/{cateId}")
    public String updateCategory(Model model, @PathVariable(value = "cateId") int cateId){
        model.addAttribute("category", categoryService.findCategory(cateId));
        model.addAttribute("headerName", "UPDATE CATEGORY");
        model.addAttribute("action", "update-category");
        model.addAttribute("btnName", "Update");
        return "addCategoryPage";
    }
    
    @RequestMapping(value = {"/update-category"}, method = RequestMethod.POST)
    public String updateNewCategory(Model model, Category category){
        int cateId = categoryService.addNewCategory(category);
        if (cateId != 0) {
            return "redirect:/admin/adminCategory";
        } else {
            return "redirect:/admin/update" + category.getId();
        }
        
    }
    
//     ***************************
    
//    ******FOR COURSE*******    
    
    @RequestMapping("/adminCourse")
    public String adminCoursePage(Model model) {
        
        model.addAttribute("lstCourse", courseService.getLstCourse());
        return "adminCoursePage";
    }
    
    @RequestMapping("/add-course")
    public String addCourse(Model model){
        model.addAttribute("headerName", "ADD NEW COURSE");
        model.addAttribute("action", "add-new-course");
        model.addAttribute("category", categoryService.getLstCategory());
        model.addAttribute("listPromotion", promotionService.getLstPromotionAvailable());
        model.addAttribute("course", new Course());
        model.addAttribute("btnName", "Add");
        return "addCoursePage";
    }
    
    @RequestMapping(value = {"/add-new-course"}, method = RequestMethod.POST)
    public String addNewCourse(@RequestParam CommonsMultipartFile file, 
            HttpSession session, Model model, Course course)throws Exception{
        
//        ******  For upload file  ******

        String path = "/Users/thanhhai/NetBeansProjects/Graduate_Project/src/main/webapp/resources/theme/images";
        String filename = file.getOriginalFilename();

//        System.out.println(path + " " + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        
  //        ******For add course and image******    
  
        Course course1 = courseService.addNewCourse(course);
        
        Image image = new Image();
        image.setUrl(filename);
        image.setCourse(course1);
        int imgId = imageService.addImage(image);
        
        if (course1.getId() != 0) {
            return "redirect:/admin/adminCourse";
        } else {
            return "redirect:/admin/add-course";
        }
        
    }
    
    @RequestMapping("/deleteCourse/{courseId}")
    public String deleteCourse(Model model, @PathVariable(value = "courseId") int courseId){
        courseService.deleteCourse(courseId);
        return "redirect:/admin/adminCourse";
    }
    
    
    @RequestMapping("/updateCourse/{courseId}")
    public String updateCourse(Model model, @PathVariable(value = "courseId") int courseId){
        model.addAttribute("listPromotion", promotionService.getLstPromotionAvailable());
        model.addAttribute("course", courseService.findCourseById(courseId));
        model.addAttribute("category", categoryService.getLstCategory());
        model.addAttribute("headerName", "UPDATE COURSE");
        model.addAttribute("action", "update-course");
        model.addAttribute("btnName", "Update");
        return "addCoursePage";
    }
    
    @RequestMapping(value = {"/update-course"}, method = RequestMethod.POST)
    public String updateNewCourse(@RequestParam CommonsMultipartFile file, 
            HttpSession session, Model model, Course course) throws Exception{
        
        //        ******For upload file******
        String path = "/Users/thanhhai/NetBeansProjects/Graduate_Project/src/main/webapp/resources/theme/images";
        String filename = file.getOriginalFilename();

//        System.out.println(path + " " + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        
        //        ******For add course and image******    
        Course course1 = courseService.addNewCourse(course);
        Image image = new Image();
        image.setUrl(filename);
        image.setCourse(course1);
        int imgId = imageService.addImage(image);
        if (course1.getId() != 0) {
            return "redirect:/admin/adminCourse";
        } else {
            return "redirect:/admin/add-course";
        }
        
    }
 
//     ***************************    
    
//    ******FOR ACCOUNT*******  
    
    @RequestMapping("/adminAccount")
    public String adminAccountPage(Model model) {
        model.addAttribute("lstAccount", accountService.getLstAccount());
        return "adminAccountPage";
    }
    
    @RequestMapping("/updateAccount/{accountId}")
    public String updateAccount(Model model, @PathVariable(value = "accountId") int accountId){
        model.addAttribute("lstRole", roleService.getLstRole());
        model.addAttribute("account", accountService.findAccountById(accountId));
        model.addAttribute("headerName", "UPDATE ACCOUNT");
        model.addAttribute("action", "update-account");
        model.addAttribute("gender", Gender.values());
        model.addAttribute("btnName", "Update");
        return "updateAccountPage";
    }
    
    @RequestMapping(value = {"/update-account"}, method = RequestMethod.POST)
    public String updateNewAccount(Model model, Account account) throws ParseException{
        int accountId = accountService.addNewAccount(account);
        if (accountId != 0) {
            return "redirect:/admin/adminAccount";
        } else {
            return "redirect:/admin/updateAccount" + account.getId();
        }
        
    }
//     ***************************     
    
//    ******FOR IMAGE*******   
    
    @RequestMapping("/adminImage")
    public String adminImagePage(Model model) {
        model.addAttribute("listImage",imageService.getLstImage());
        return "adminImagePage";
    }
    
    @RequestMapping("/add-image")
    public String addImagePage(Model model) {
        model.addAttribute("listCourse",courseService.getLstCourse());
        model.addAttribute("action", "add-new-image");
        model.addAttribute("image", new Image());
        model.addAttribute("headerName", "ADD NEW IMAGE");
        return "addImagePage";
    }
    
    @RequestMapping(value = {"/add-new-image"}, method = RequestMethod.POST)
    public String saveimage(@RequestParam CommonsMultipartFile file,
            HttpSession session, Model model, Image image) throws Exception {

        String path = "/Users/thanhhai/NetBeansProjects/Graduate_Project/src/main/webapp/resources/theme/images";
        String filename = file.getOriginalFilename();

//        System.out.println(path + " " + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        image.setUrl(filename);
        int imgId = imageService.addImage(image);

        return "redirect:/admin/adminImage";
    }
    
    @RequestMapping("/deleteImage/{imageId}")
    public String deleteImage(Model model, @PathVariable(value = "imageId") int imageId){
        imageService.deleteImage(imageId);
        return "redirect:/admin/adminImage";
    }
    
     @RequestMapping("/updateImage/{imageId}")
    public String updateImage(Model model, @PathVariable(value = "imageId") int imageId) {
        model.addAttribute("action", "update-image");
        model.addAttribute("listCourse",courseService.getLstCourse());
        model.addAttribute("image", imageService.findImageById(imageId));
        model.addAttribute("headerName", "UPDATE IMAGE");
        return "addImagePage";
    }
    
    @RequestMapping(value = {"/update-image"}, method = RequestMethod.POST)
    public String updateImage(@RequestParam CommonsMultipartFile file,
            HttpSession session, Model model, Image image) throws Exception {

        String path = "/Users/thanhhai/NetBeansProjects/Graduate_Project/src/main/webapp/resources/theme/images";
        String filename = file.getOriginalFilename();

//        System.out.println(path + " " + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        image.setUrl(filename);
        int imgId = imageService.addImage(image);

        return "redirect:/admin/adminImage";
    }
   
    
//    ******   FOR ORDER   *******   
    
    @RequestMapping("/adminOrder")
    public String adminOrderPage(Model model) {
        model.addAttribute("lstOrder",orderService.getLstOrder() );
        return "adminOrderPage";
    }

//    ******FOR ORDER DETAIL*******   
    
    @RequestMapping("/adminOrderDetail")
    public String adminOrderDetailPage(Model model) {
        model.addAttribute("lstOrderDetail",orderDetailService.getLstOrderDetail());
        return "adminOrderDetailPage";
    }

//    ******FOR TRANSACTION*******
    
    @RequestMapping("/adminTransaction")
    public String adminTransactionPage(Model model) {
        model.addAttribute("lstTransaction", transactionService.getLstTransaction());
        return "adminTransactionPage";
    }
    
    @RequestMapping("/updateTransaction/{TransactionId}")
    public String updateTransaction(Model model, @PathVariable(value = "TransactionId") int transactionId){
        model.addAttribute("transaction", transactionService.findTransaction(transactionId));
        model.addAttribute("headerName", "UPDATE TRANSACTION");
        model.addAttribute("action", "update-transaction");
        model.addAttribute("btnName", "Update");
        model.addAttribute("lstStatus", PaymentStatusEnum.values());
        return "addTransactionPage";
    }
    
    @RequestMapping(value = {"/update-transaction"}, method = RequestMethod.POST)
    public String updateNewTransaction(Model model, Transaction transaction) throws ParseException{
        int transationId = transactionService.updateTransaction(transaction);
        if (transationId != 0) {
            return "redirect:/admin/adminTransaction";
        } else {
            return "redirect:/admin/updateTransaction" + transaction.getId();
        }
    }   
}
