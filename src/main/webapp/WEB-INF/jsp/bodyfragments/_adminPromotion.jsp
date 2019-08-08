<%-- 
    Document   : _adminPromotion
    Created on : Dec 21, 2017, 8:45:08 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center;margin-top: 120px;">
                    <h2>Manage List Promotion</h2>                   
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <button class="btn btn-danger btn-add" onclick="
                            location.href = '${contextPath}/admin/add-promotion'">Add Promotion</button>                  
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Promotion Data Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Begin date</th>
                                            <th>End date</th>
                                            <th>Discount</th>
                                            <th>Detail</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Begin date</th>
                                            <th>End date</th>
                                            <th>Discount</th>
                                            <th>Detail</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="promotion" items="${lstPromotion}">
                                            <tr>
                                                <td>${promotion.id}</td>
                                                <td>${promotion.name}</td>
                                                <td>${promotion.beginDate}</td>
                                                <td>${promotion.endDate}</td>
                                                <td>${promotion.discount} </td>
                                                <td>${promotion.detail}</td>
                                                <td>${promotion.status}</td>
                                                <td>
                                                    <button class="btn btn-danger" 
                                                            onclick="location.href = '${contextPath}/admin/deletePromotion/${promotion.id}'">Delete</button>
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/admin/updatePromotion/${promotion.id}'">Update</button>        
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
