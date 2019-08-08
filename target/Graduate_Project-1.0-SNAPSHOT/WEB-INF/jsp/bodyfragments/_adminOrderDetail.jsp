<%-- 
    Document   : _adminOrderDetail
    Created on : Dec 28, 2017, 9:18:46 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="max-width: 1048px;">
            <div class="col-xs-12 col-sm-12 col-md-12 title" style="text-align: center; margin-top: 120px;">
                <h2>Show List Order Detail</h2>                   
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
                                            <th>Course: </th>
                                            <th>Quantity:</th>
                                            <th>Price: </th>
                                            <th>Total: </th>
                                            <th>Order ID</th>
<!--                                            <th>Action</th>-->
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Course: </th>
                                            <th>Quantity:</th>
                                            <th>Price: </th>
                                            <th>Total: </th>
                                            <th>Order ID</th>
<!--                                            <th>Action</th>-->
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="orderDetail" items="${lstOrderDetail}">
                                            <tr>
                                                <td>${orderDetail.id}</td>
                                                <td>${orderDetail.course.name}</td>
                                                <td>${orderDetail.quantity}</td>
                                                <td>${orderDetail.price}</td>
                                                <td>${orderDetail.total}</td>
                                                <td>${orderDetail.order.id}</td>
<!--                                                <td>
                                                    <button class="btn btn-danger" 
                                                            onclick="location.href = '${contextPath}/delete/'">Delete</button>
                                                    <button class="btn btn-primary" 
                                                            onclick="location.href = '${contextPath}/update/'">Update</button>        
                                                </td>-->
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
