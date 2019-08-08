<%-- 
    Document   : _adminCourse
    Created on : Dec 22, 2017, 8:46:21 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Course</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/admin_common.css" />" rel="stylesheet">

    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="max-width: 1048px;">
            <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center; margin-top: 120px;">
                <h2>Manage List Course</h2>                   
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-md-6">
                    <button class="btn btn-danger btn-add" onclick="
                            location.href = '${contextPath}/admin/add-course'">Add Course</button>                  
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Course Data Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Category</th>
                                            <th>Schedule</th>
                                            <th>Period</th>
                                            <th>Price (VND)</th>
                                            <th>Detail</th>
                                            <th>Promotion</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Category</th>
                                            <th>Schedule</th>
                                            <th>Period</th>
                                            <th>Price (VND)</th>
                                            <th>Detail</th>
                                            <th>Promotion</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="course" items="${lstCourse}">
                                            <tr>
                                                <td>${course.id}</td>
                                                <td>${course.name}</td>
                                                <td>${course.category.name}</td>
                                                <td>${course.schedule}</td>
                                                <td>${course.period}</td>
                                                <td>${course.price}</td>
                                                <td>${course.detail}</td>
                                                <td>
                                                    <c:forEach items="${course.lstPromotion}" var="promotionItem" >
                                                        <span>${promotionItem.name}</span>
                                                    </c:forEach>
                                                </td>
                                                <td>
                                                    <button class="btn btn-danger" 
                                                            onclick="location.href = '${contextPath}/admin/deleteCourse/${course.id}'">Delete</button>
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/admin/updateCourse/${course.id}'">Update</button>        
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
