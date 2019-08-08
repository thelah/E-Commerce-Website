<%-- 
    Document   : _adminTransaction
    Created on : Dec 22, 2017, 8:39:20 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Transaction Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="max-width: 1048px;">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center;margin-top: 120px;">
                    <h2>Show List Order</h2>                   
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
                                            <th>Transaction ID</th>
                                            <th>Order_ID</th>
                                            <th>Order_Date</th>
                                            <th>Total Money</th>
                                            <th>Trans_Date</th>
                                            <th>Customer_name</th>
                                            <th>Payment Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Transaction ID</th>
                                            <th>Order_ID</th>
                                            <th>Order_Date</th>
                                            <th>Total Money</th>
                                            <th>Trans_Date</th>
                                            <th>Customer_name</th>
                                            <th>Payment Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="transaction" items="${lstTransaction}">
                                            <tr>
                                                <td>${transaction.id}</td>
                                                <td>${transaction.order.id}</td>
                                                <td>${transaction.order.orderDate}</td>
                                                <td>${transaction.amount}</td>
                                                <td>${transaction.transDate}</td>
                                                <td>${transaction.account.name}</td>  
                                                <td>${transaction.status}</td>
                                                <td>
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/admin/updateTransaction/${transaction.id}'">Update</button>        
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
