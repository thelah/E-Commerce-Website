<%-- 
    Document   : _adminImage
    Created on : Dec 27, 2017, 1:52:11 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="max-width: 1048px;">
            <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center; margin-top: 120px;">
                <h2>Manage List Image</h2>                   
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <button class="btn btn-danger btn-add" onclick="
                            location.href = '${contextPath}/admin/add-image'">Add image</button>                  
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Image Data Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>URL: </th>
                                            <th>Course Name:</th>
                                            <th>Category: </th>
                                            <th>Action: </th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>URL: </th>
                                            <th>Course Name:</th>
                                            <th>Category: </th>
                                            <th>Action: </th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="img" items="${listImage}">
                                            <tr>
                                                <td>${img.id}</td>
                                                <td>${img.url}</td>                               
                                                <td>${img.course.name}</td> 
                                                <td>${img.course.category.name}</td> 
                                                <td>
                                                    <button class="btn btn-danger" 
                                                            onclick="location.href = '${contextPath}/admin/deleteImage/${img.id}'">Delete</button>
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/admin/updateImage/${img.id}'">Update</button>        
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
