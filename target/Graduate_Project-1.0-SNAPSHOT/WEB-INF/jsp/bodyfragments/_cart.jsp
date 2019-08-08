<%-- 
    Document   : _cart
    Created on : Jan 10, 2018, 9:14:11 PM
    Author     : The Lah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->

<!DOCTYPE html>

<html>
    <head>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/contact_styles.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="row" style="text-align: center; padding-top: 120px">
            <div class="col-lg-12">
                <h2>Cart Information</h2>
            </div>
            <div class="col-lg-12" style="padding-top: 40px">
                <div class="col-lg-6 get_in_touch_col table-responsive">
                    <table class="table table-bordered">
                        <thead style="background-color: #fe4c50; color: whitesmoke;">
                            <tr>
                                <th>Image</th>
                                <th>Course Name</th>
                                <th>Price</th>
<!--                                <th>Quantity</th>-->
                                <th></th>
                            </tr>
                        </thead>
                        <tbody style="border: none;">

                            <c:forEach var="orderDetailItem" items="${order.orderDetail}">
                                <tr>
                                    <td style="text-align: center"><img class="card-img-top" style="width: 60%; height: 30%" 
                                                                        src="<c:url value="${orderDetailItem.course.lstImages[0].url}"/>" alt=""></td>
                                    <td>${orderDetailItem.course.name}</td>

                                    <td>${orderDetailItem.course.price} VND</td>

<!--                                    <td>
                                        1
                                    </td>-->

                                    <td>
                                        <button class="btn btn-warning" onclick="
                                                location.href = '${contextPath}/order/delete/${orderDetailItem.course.id}'">Delete</button>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-lg-12">
                <div style="text-align: right">
                    <p style="font-weight: bold; font-size: 30px">Total: ${order.totalMoney} VND</p>
                </div>
            </div>
        </div>

        <div class="row" style="display: inline">
            <div class="col-lg-12">
                <h2>Customer's Information</h2>
            </div>
            <div class="col-lg-12">
                <f:form modelAttribute="customer" action="/check-out" method="post">
                    <div class="form-group">
                        <lable for="idName">Name:</lable>
                        <input type="text" class="form-control" id="idName" name="name"  required="true" placeholder="Enter Name">
                    </div>
                    <div class="form-group">
                        <lable for="idEmail">Email:</lable>
                        <input type="email" class="form-control" id="Email" name="email"  required="true" placeholder="Enter Email">
                    </div>         
                    <div class="form-group">
                        <lable for="idBirth">Birth Day:</lable>
                        <input type="text" class="form-control" id="idBirth" name="birthday"  required="true" placeholder="Enter Birthday">
                    </div>
                    <div class="form-group">
                        <lable for="idAddress">Address:</lable>
                        <input type="text" class="form-control" id="idPassword" name="address" required="true" placeholder="Enter Address">
                    </div>
                    <div class="form-group">
                        <lable for="idPhone">Phone:</lable>
                        <input type="text" class="form-control" id="idPhone" name="phone" required="true" placeholder="Enter Phone">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Check Out" class="btn btn-success">
                    </div>
                </f:form>
            </div>
        </div>
    </body>
</html>
