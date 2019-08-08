/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.controller;

import com.mycompany.graduate_project.entities.AccountEntity;
import com.mycompany.graduate_project.enums.Gender;
import com.mycompany.graduate_project.enums.RoleEnum;
import com.mycompany.graduate_project.model.Account;
import com.mycompany.graduate_project.model.Course;
import com.mycompany.graduate_project.model.Order;
import com.mycompany.graduate_project.model.OrderDetail;
import com.mycompany.graduate_project.model.Role;
import com.mycompany.graduate_project.service.AccountService;
import com.mycompany.graduate_project.service.CourseService;
import com.mycompany.graduate_project.service.OrderDetailService;
import com.mycompany.graduate_project.service.OrderService;
import com.mycompany.graduate_project.service.RoleService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author thanhhai
 */
@Controller
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = {"/", "/home"})
    public String homePage(Model model) {
        return "homePage";
    }

    @RequestMapping("/courses")
    public String courcesPage(Model model) {
        model.addAttribute("cources", courseService.getLstCourse());
        return "coursePage";
    }

    @RequestMapping("/courses/{categoryName}")
    public String courcesByCategoryPage(Model model, @PathVariable(value = "categoryName") String categoryName) {
        model.addAttribute("cources", courseService.getLstCourseByCategory(categoryName));
        return "coursePage";
    }
    //   ******* FOR REGISTER ACCOUNT ********

    @RequestMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("gender", Gender.values());
        model.addAttribute("action", "add-new-account");
        model.addAttribute("btnName", "Register");
        model.addAttribute("headerName", "REGISTER NEW ACCOUNT");
        return "registerPage";
    }

    @RequestMapping(value = {"/add-new-account"}, method = RequestMethod.POST)
    public String addNewAccount(Model model, Account account) throws ParseException {
        List<Role> lstRole = new ArrayList<>();
        lstRole.add(new Role(2, RoleEnum.ROLE_USER));
        account.setListRole(lstRole);
        int accountId = accountService.addNewAccount(account);

        // takes input
        String recipientAddress = account.getEmail();
        String subject = "COURSESHOP - REGISTER NEW MEMBER";
        String message = "Thank you to become a new member of CourceShop, please click on the following link to active your account: "
                + "http://localhost:8080/Graduate_Project/active/" + accountId;

        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);

        // sends the e-mail
        mailSender.send(email);

        if (accountId != 0) {
            return "registerSuccessfulPage";
        } else {
            return "redirect:/admin/register";
        }

    }

    //    ******* FOR ACTIVE ACCOUNT ********
    @RequestMapping("/active/{accountId}")
    public String deletePromotion(Model model, @PathVariable(value = "accountId") int accountId) throws ParseException {
        Account account = accountService.findAccountById(accountId);
        account.setActive(true);
        int id = accountService.addNewAccount(account);
        return "homePage";
    }

    @RequestMapping(value = {"/user/user-page"}, method = RequestMethod.GET)
    public String userPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AccountEntity) {
            AccountEntity accountEntity = (AccountEntity) (principal);
            model.addAttribute("username", accountEntity.getUserName());
            model.addAttribute("accountId", accountEntity.getId());
        }

        return "userPage";
    }

    //    ******* FOR UPDATE ACCOUNT ********
    @RequestMapping("/updateAccount/{accountId}")
    public String updateAccount(Model model, @PathVariable(value = "accountId") int accountId) {
        model.addAttribute("gender", Gender.values());
        model.addAttribute("action", "update-account");
        model.addAttribute("btnName", "Update");
        model.addAttribute("headerName", "CHANGE PERSONAL INFORMATION");
        model.addAttribute("lstRole", roleService.getLstRole());
        model.addAttribute("account", accountService.findAccountById(accountId));

        return "registerPage";
    }

    @RequestMapping(value = {"/update-account"}, method = RequestMethod.POST)
    public String updateAccount(Model model, Account account) throws ParseException {;
        int accountId = accountService.addNewAccount(account);

        if (accountId != 0) {
            return "updateSuccessfulPage";
        } else {
            return "redirect:/admin/register";
        }

    }

    //    ******* FOR CONTACT PAGE********
    @RequestMapping("/contact")
    public String contactPage(Model model) {
        return "contactusPage";
    }

    //    ******* FOR LOGIN PAGE********
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "loginPage";
    }

    //    ******* FOR LOGIN ERROR PAGE********
    @RequestMapping(value = {"/loginError"}, method = RequestMethod.GET)
    public String loginError(Model model) {
        return "loginErrorPage";
    }

    //    ******* FOR COURSE DETAIL PAGE********
    @RequestMapping("/courseDetail")
    public String courseDetailPage(Model model) {
        return "courseDetailPage";
    }

    //    ******* FOR CART PAGE********
    @RequestMapping(value = "/order/{id}")
    public String addOrder(Model model,
            @PathVariable(value = "id") int id,
            HttpSession session) {

//        List<Product> lstOrder = (List<Product>) session.getAttribute("lstOrder");
//        if (lstOrder != null && lstOrder.size() > 0) {
//            lstOrder.add(objSession);
//        } else {
//            lstOrder = new ArrayList<>();
//            lstOrder.add(objSession);
//        }

        Course course = courseService.findCourseById(id); // tim khoa hoc
        if (course != null && course.getId() > 0) {
            Order order = (Order) session.getAttribute("order");
            //List<OrderDetail> lstOrderDetail = new ArrayList<>();
            if (order != null && order.getOrderDetail() != null && order.getOrderDetail().size() > 0) {
                OrderDetail obj = new OrderDetail();
                obj.setCourse(course);
                obj.setQuantity(1);
                order.getOrderDetail().add(obj);
                int totalprice = 0;
                for (OrderDetail orderDetail : order.getOrderDetail()) {
                    //lam sau
//                    if (orderDetail.getId() == order.getId()) {
//
//                    }
                    totalprice = totalprice + (Integer.parseInt(orderDetail.getCourse().getPrice()) * orderDetail.getQuantity());
                }
                order.setTotalMoney(totalprice);

            } else {
                
                OrderDetail obj = new OrderDetail();
                obj.setCourse(course);
                obj.setQuantity(1);
                order = new Order();
                order.getOrderDetail().add(obj);
                order.setTotalMoney(1 * Integer.parseInt(obj.getCourse().getPrice()));
            }
            session.setAttribute("order", order);

        }

        //    session.setAttribute("lstOrder", lstOrder);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart")
    public String addOrder(Model model,
            HttpSession session) {

        model.addAttribute("lstOrderDetail", (List<OrderDetail>) session.getAttribute("lstOrderDetail"));
        model.addAttribute("order", (Order) session.getAttribute("order"));
        //  model.addAttribute("lstOrderDetail", (List<Product>) session.getAttribute("lstOrder"));
        return "cartPage";
    }

    /*@RequestMapping(value = "/order/delete/{delId}")
    public String deteleCourseCart(Model model,
            @PathVariable(value = "delId") int delId,
            HttpSession session
    ) {

        Course course = courseService.findCourseById(delId);
        Order order = (Order) session.getAttribute("order");
        List<OrderDetail> lstOrderDetail = (List<OrderDetail>) session.getAttribute("lstOrderDetail");
        int totalprice = 0;

        for (OrderDetail orderDetail : order.getOrderDetail()) {
            if (orderDetail.getId() == course.getId()) {
                order.getOrderDetail().remove(orderDetail);
                break;
            }
        }
        
        for (OrderDetail orderDetail : order.getOrderDetail()) {
            totalprice = totalprice + (Integer.parseInt(orderDetail.getCourse().getPrice()) * orderDetail.getQuantity());
        }
//        order.setOrderDetail(lstOrderDetail);
        order.setTotalMoney(totalprice);
        session.setAttribute("lstOrder", lstOrderDetail);
        session.setAttribute("order", order);
        return "redirect:/cart";
    }*/

 /*@RequestMapping(value = "/order/addedOrder")
    public String addOrderSuccessful(Model model, HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        List<OrderDetail> lstOrderDetail = (List<OrderDetail>) session.getAttribute("lstOrderDetail");

        List<OrderDetailEntity> lstDetailEntity = new ArrayList<>();
        for (OrderDetail orderDetail : lstOrderDetail) {

            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setId(orderDetail.getProductid().getId());
            imageEntity.setImage(orderDetail.getProductid().getImageEntity());
            
            List<ImageEntity> lstImage = new ArrayList<>();
            lstImage.add(imageEntity);

            CategoriesEntity caE = new CategoriesEntity();
//            caE.setId(orderDetail.getProductid().getId());
            caE.setName(orderDetail.getProductid().getCategories().getName());
            
            ProductEntity pro = new ProductEntity();
            pro.setId(orderDetail.getProductid().getId());
            pro.setName(orderDetail.getProductid().getName());
            pro.setImageEntity(lstImage);
            pro.setPrice(orderDetail.getProductid().getPrice());
            pro.setCategoriesEntity(caE);

            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setId(orderDetail.getId());
            orderDetailEntity.setQuantity(orderDetail.getQuantity());
            orderDetailEntity.setProductEntity(pro);
            lstDetailEntity.add(orderDetailEntity);
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setOrderDetailEntity(lstDetailEntity);
        orderEntity.setTotalMoney(order.getTotalmoney());
        
        session.removeAttribute("lstOrderDetail");
        session.removeAttribute("order");
        
        return "redirect:/cart";
    }*/
}
