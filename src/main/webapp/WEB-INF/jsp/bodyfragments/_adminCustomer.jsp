<%-- 
    Document   : _adminCustomer
    Created on : Dec 22, 2017, 9:37:04 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin_Customer Page</title>
        <link type="text/css" rel="stylesheet" 
          href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/adminPromotion.css" />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center;">
                    <h2>Show List Customer</h2>                   
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-12 col-sm-6 col-md-6">
<!--                    <button class="btn btn-success btn-add" onclick="
                            location.href='${contextPath}/'">Add Promotion</button>                  -->
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <div style="float: right">
                        <form action="search" method="post">
                            <div class="form-inline">
                                <div class="form-group">
                                    <input name="searchName" class="form-control"
                                           type="text" placeholder="search"/>
                                </div>
                                <button type="submit" class="btn btn-default">Search</button>
                            </div>
                        </form>
                    </div>                  
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="table-responsive">
                        <table class=" table table-bordered">
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Gender</th>
                                <th>Birth-date</th>
                                <th>Username</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var="user" items="${list}">
                                <tr>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.password}</td>
                                    <td>${user.description}</td>
                                    <td>${user.birthday}</td>
                                    <td>${user.country.name}</td>
                                    <td>${user.smoking}</td>
                                    <td>${user.gender}</td>
                                    <td>
                                        <button class="btn btn-warning" 
                                                onclick="location.href = '${contextPath}/delete/${user.id}'">Delete</button>
                                        <button class="btn btn-primary" 
                                                onclick="location.href = '${contextPath}/update/${user.id}'">Update</button>        
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-12 col-sm-12 col-md-12" style="text-align: center;">
                    <button class="btn btn-danger btn-add" onclick="
                            location.href = '${contextPath}/adminHome'">Back to Admin Home</button>                  
                </div>
            </div>    
        </div>
    </body>
</html>
