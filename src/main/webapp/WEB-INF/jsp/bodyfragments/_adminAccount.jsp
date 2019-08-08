<%-- 
    Document   : _adminAccount
    Created on : Dec 27, 2017, 6:49:03 PM
    Author     : thanhhai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Account Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="max-width: 1048px;">
            <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center; margin-top: 120px;">
                <h2>Manage List Account</h2>                   
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Account Data Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>UserName: </th>
                                            <th>Full Name:</th>
                                            <th>Email: </th>
                                            <th>Phone: </th>
                                            <th>Gender:</th>
                                            <th>Birth-date: </th>
                                            <th>Role: </th>
                                            <th>Active: </th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>User Name: </th>
                                            <th>Full Name:</th>
                                            <th>Email: </th>
                                            <th>Phone: </th>
                                            <th>Gender:</th>
                                            <th>Birth-date:</th>
                                            <th>Role: </th>
                                            <th>Active: </th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="account" items="${lstAccount}">
                                            <tr>
                                                <td>${account.id}</td>
                                                <td>${account.userName}</td>
                                                <td>${account.name}</td>
                                                <td>${account.email}</td>
                                                <td>${account.phone}</td>
                                                <td>${account.gender}</td>
                                                <td>${account.birthDate}</td>
                                                <td>
                                                    <c:forEach items="${account.listRole}" var="r" >
                                                        <span>${r.role}</span>
                                                    </c:forEach>
                                                </td>
                                                <td>${account.active}</td>
                                                <td>
         
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/admin/updateAccount/${account.id}'">Update</button>        
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
