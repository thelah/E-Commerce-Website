<%-- 
    Document   : _addPromotion
    Created on : Dec 25, 2017, 9:23:43 PM
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
                    <f:form action="${contextPath}/admin/${action}" method="post" modelAttribute="promotion">
                        <c:if test="${action == 'update-promotion'}">
                            <input hidden name="id" value="${promotion.id}"/>                         
                        </c:if>
                        <div class="form-group">
                            <label for="idName">Name: </label>
                            <input type="text" class="form-control" id="idname" name="name" required="true" placeholder="Enter name" value="${promotion.name}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">Begin date:  </label>
                            <input type="text" class="form-control" id="idEmail" name="beginDate"  placeholder="dd/MM/yyyy" value="${promotion.beginDate}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">End date:  </label>
                            <input type="text" class="form-control" id="idEmail" name="endDate"  placeholder="dd/MM/yyyy" value="${promotion.endDate}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">Discount:  </label>
                            <input type="text" class="form-control" id="idEmail" name="discount"  placeholder="Enter discount" value="${promotion.discount}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">Detail:  </label>
                            <input type="text" class="form-control" id="idEmail" name="detail" placeholder="Enter detail promotion" value="${promotion.detail}"/>
                        </div>
                        <div class="form-group">
                            <label>Status: </label>
                            <c:forEach var="statusItem" items="${lstStatus}">
                                <c:if test="${promotion.status == statusItem}">
                                    <input type="radio" name="status" value="${statusItem}" checked style="margin-left: 10px;"/> &nbsp; ${statusItem}
                                </c:if>
                                <c:if test="${promotion.status != statusItem}">
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
