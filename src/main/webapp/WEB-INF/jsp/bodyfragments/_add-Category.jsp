<%-- 
    Document   : _adminCategory_add
    Created on : Dec 25, 2017, 2:08:38 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Page</title>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/adminPromotion.css" />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12" style="text-align: center;margin-top: 120px;">
                    <h2>${headerName}</h2>                   
                </div>
            </div>
            <div class="row" style="justify-content: center; margin-top: 20px;">
                <div class="col-xs-12 col-sm-12 col-md-10" >
                    <f:form action="${contextPath}/admin/${action}" method="post" modelAttribute="category">
                        <c:if test="${action == 'update-category'}">
                            <input hidden name="id" value="${category.id}"/>                         
                        </c:if>
                        <div class="form-group">
                            <label for="idName">Name: </label>
                            <input type="text" class="form-control" id="idname" name="name" required="true" placeholder="Enter name" value="${category.name}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">Detail: </label>
                            <input type="text" class="form-control" id="idEmail" name="detail" required="true" placeholder="Enter detail" value="${category.detail}"/>
                        </div>

                        <div class="form-group">
                            <input type="submit" value="${btnName}" class="btn btn-danger"/>
                        </div>
                    </f:form>                  
                </div>
            </div>
        </div>
    </body>
</html>
