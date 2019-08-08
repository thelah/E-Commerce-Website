<%-- 
    Document   : edit-account
    Created on : Dec 30, 2017, 10:38:58 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <div class="col-xs-12 col-sm-12 col-md-8" >
                    <f:form action="${contextPath}/admin/update-account" method="post" modelAttribute="account">
                        <div hidden>
                            <input name="id" value="${account.id}"/>                                               
                            <input name="name" value="${account.name}"/>                                                                        
                            <input name="email" value="${account.email}"/>                                                                        
                            <input name="phone" value="${account.phone}"/>                                                                         
                            <input name="birthDate" value="${account.birthDate}"/>                                                                      
                            <input name="password" value="${account.password}"/>
                            <input name="active" value="${account.active}"/> 
                            <label >Gender: </label>
                            <c:forEach var="genderItem" items="${gender}" >
                                <c:if test="${account.gender == genderItem}">
                                    <input hidden type="radio" name="gender" value="${genderItem}" checked/> &nbsp; ${genderItem}
                                </c:if>
                                <c:if test="${account.gender != genderItem}">
                                    <input hidden type="radio" name="gender" value="${genderItem}"/> &nbsp; ${genderItem}
                                </c:if> 
                            </c:forEach>        
                        </div>
                        <div class="form-group">
                            <label for="idName">UserName: </label>
                            <input type="text" class="form-control" id="idname" name="userName" required="true" placeholder="Enter name" value="${account.userName}"/>
                        </div>
                        <div class="form-group">
                            <label>Role: </label>
                            <select name="listRole[0].id">
                                <c:forEach var="roleItem" items="${lstRole}">
                                    <c:forEach items="${account.listRole}" var="r" >
                                        <c:if test="${r.id == roleItem.id}">
                                            <option value="${roleItem.id}" selected="selected">${roleItem.role}</option>
                                        </c:if>
                                        <c:if test="${r.id != roleItem.id}">
                                            <option value="${roleItem.id}">${roleItem.role}</option>
                                        </c:if> 
                                    </c:forEach>

                                </c:forEach>
                            </select>
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
