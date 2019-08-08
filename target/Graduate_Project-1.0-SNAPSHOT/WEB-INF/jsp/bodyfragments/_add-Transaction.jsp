<%-- 
    Document   : _add-Transaction
    Created on : Jan 2, 2018, 9:07:08 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promotion Page</title>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/admin_common.css" />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12" style="text-align: center; margin-top: 120px;">
                    <h3>${headerName}</h3>                   
                </div>
            </div>
            <div class="row" style="justify-content: center; margin-top: 20px;">
                <div class="col-xs-12 col-sm-12 col-md-10" >
                    <f:form action="${contextPath}/admin/${action}" method="post" modelAttribute="transaction">
                        <c:if test="${action == 'update-transaction'}">
                            <input hidden name="id" value="${transaction.id}"/> 
                            <div class="form-group" hidden>
                                <label for="idEmail">Order date:  </label>
                                <input type="text" class="form-control" id="idEmail" name="order.orderDate"  placeholder="dd/MM/yyyy" value="${transaction.order.orderDate}"/>
                            </div>
                            <div class="form-group" hidden>
                                <label for="idEmail">Total Money:  </label>
                                <input type="text" class="form-control" id="idEmail" name="amount"  placeholder="dd/MM/yyyy" value="${transaction.amount}"/>
                            </div>
                            <div class="form-group" hidden>
                                <label for="idEmail">Account_Id  </label>
                                <input type="text" class="form-control" id="idEmail" name="account.id" placeholder="Enter detail promotion" value="${transaction.account.id}"/>
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="idName">Order ID: </label>
                            <input type="text" class="form-control" id="idname" name="order.id" required="true" placeholder="Enter name" value="${transaction.order.id}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">Transaction_Date  </label>
                            <input type="text" class="form-control" id="idEmail" name="transDate"  placeholder="Enter discount" value="${transaction.transDate}"/>
                        </div>
                        <c:if test="${action == 'update-transaction'}">
                            
                        </c:if>
                        <div class="form-group">
                            <label>Payment Status: </label>
                            <c:forEach var="statusItem" items="${lstStatus}">
                                <c:if test="${transaction.status == statusItem}">
                                    <input type="radio" name="status" value="${statusItem}" checked style="margin-left: 10px;"/> &nbsp; ${statusItem}
                                </c:if>
                                <c:if test="${transaction.status != statusItem}">
                                    <input type="radio" name="status" value="${statusItem}" style="margin-left: 10px;"/> &nbsp; ${statusItem}
                                </c:if> 
                            </c:forEach>                       
                        </div>

                        <div class="form-group">
                            <input type="submit" value="${btnName}" class="btn btn-danger"/>
                        </div>
                    </f:form>                  
                </div>
            </div>
        </div>
    </body>
</body>
</html>
