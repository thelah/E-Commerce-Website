<%-- 
    Document   : _addCouse
    Created on : Dec 26, 2017, 9:47:59 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Page </title>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/admin_common.css" />" rel="stylesheet">
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
                    <f:form action="${contextPath}/admin/${action}" method="post" modelAttribute="course" enctype="multipart/form-data">
                        <c:if test="${action == 'update-course'}">
                            <input hidden name="id" value="${course.id}"/>                         
                        </c:if>
                        <div class="form-group">
                            <label for="idName">Name: </label>
                            <input type="text" class="form-control" id="idname" name="name" required="true" placeholder="Enter name" value="${course.name}"/>
                        </div>
                        <div class="form-group">
                            <label style="margin-right: 10px;">Category: </label>
                            <select name="category.id">         
                                <c:forEach items="${category}" var="categoryItem" >
                                    <c:if test="${course.category.id == categoryItem.id}">
                                        <option value="${categoryItem.id}" selected="selected">${categoryItem.name}</option>
                                    </c:if> 
                                    <c:if test="${course.category.id != categoryItem.id}">
                                        <option value="${categoryItem.id}">${categoryItem.name}</option>
                                    </c:if>                                                              
                                </c:forEach>                                                                   
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idName">Schedule: </label>
                            <input type="text" class="form-control" id="idname" name="schedule" required="true" placeholder="Enter schedule" value="${course.schedule}"/>
                        </div>
                        <div class="form-group">
                            <label for="idName">Period: </label>
                            <input type="text" class="form-control" id="idname" name="period" required="true" placeholder="Enter period" value="${course.period}"/>
                        </div>
                        <div class="form-group">
                            <label for="idName">Price: </label>
                            <input type="text" class="form-control" id="idname" name="price" required="true" placeholder="Enter price (VND)" value="${course.price}"/>
                        </div>
                        <div class="form-group">
                            <label for="idEmail">Detail: </label>
                            <input type="text" class="form-control" id="idEmail" name="detail"  placeholder="Enter detail" value="${course.detail}"/>
                        </div>
                        <div class="form-group">
                            <label style="margin-right: 10px;">Promotion: </label>
                            <select name="lstPromotion[0].id">
                                <c:forEach var="promotionItem" items="${listPromotion}">
                                    <c:if test="${course.lstPromotion == null}">
                                        <option value="${promotionItem.id}">${promotionItem.name}</option>
                                    </c:if> 
                                    <c:forEach items="${course.lstPromotion}" var="pr" >
                                        <c:if test="${pr.id == promotionItem.id}">
                                            <option value="${promotionItem.id}" selected="selected">${promotionItem.name}</option>
                                        </c:if>
                                        <c:if test="${pr.id != promotionItem.id}">
                                            <option value="${promotionItem.id}" >${promotionItem.name}</option>
                                        </c:if>     
                                    </c:forEach>                                            
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label style="margin-right: 10px;">Choose Image:  </label>
                            <input name="file" id="fileToUpload" type="file" />
                        </div>
                        <div class="form-group">
                            <input type="submit" value="${btnName}" class="btn btn-danger btn-add"/>
                        </div>

                    </f:form> 

                </div>
            </div>
        </div>

    </body>
</html>
