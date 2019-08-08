<%-- 
    Document   : _adminCategory
    Created on : Dec 21, 2017, 10:35:17 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Category</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/admin_common.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/adminHome.css" />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center;margin-top: 120px;">
                <h2>Manage List Category</h2>                   
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-md-6">
                    <button class="btn btn-danger btn-add" onclick="
                            location.href = '${contextPath}/admin/add-category'">Add Category</button>                  
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Category Data Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Detail</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Detail</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="category" items="${lstCategory}">
                                            <tr>
                                                <td>${category.id}</td>
                                                <td>${category.name}</td>
                                                <td>${category.detail}</td>
                                                <td>
                                                    <button class="btn btn-danger" 
                                                            onclick="location.href = '${contextPath}/admin/deleteCategory/${category.id}'">Delete</button>
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/admin/updateCategory/${category.id}'">Update</button>        
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>
                </div>
            </div>    
               
        </div>


    </body>
</html>
