<%-- 
    Document   : _adminOrder
    Created on : Dec 22, 2017, 10:48:41 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Order Page</title>
       
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center; margin-top: 120px;">
                    <h2>Show List Order</h2>                   
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Order Data Table </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Order Date</th>
                                            <th>Total Money</th>
                                            <th>User</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Order Date</th>
                                            <th>Total Money</th>
                                            <th>User</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="order" items="${lstOrder}">
                                            <tr>
                                                <td>${order.id}</td>
                                                <td>${order.orderDate}</td>
                                                <td>${order.totalMoney}</td>
                                                <td>${order.account.name}</td>
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
