<%-- 
    Document   : _register
    Created on : Dec 18, 2017, 10:40:11 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
    <link type="text/css" rel="stylesheet" 
          href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
    <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12" style="text-align: center; margin-top: 130px;">
                <h2 style="color: #fe4c50;">${headerName}</h2>                 
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12" >
                <f:form action="${contextPath}/${action}" method="post" modelAttribute="account">
                    <c:if test="${action == 'update-account'}">
                        <input hidden name="id" value="${account.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label for="idName">Name: </label>
                        <input type="text" class="form-control" id="idname" name="name" required="true" placeholder="Enter name" value="${account.name}"/>
                    </div>
                    <div class="form-group">
                        <label for="idEmail">Email: </label>
                        <input type="email" class="form-control" id="idEmail" name="email" required="true" placeholder="Enter email" value="${account.email}"/>
                    </div>
                    <div class="form-group">
                        <label for="idPassword">User Name: </label>
                        <input type="text" class="form-control" id="idPassword" name="userName" required="true" placeholder="Enter user name" value="${account.userName}"/>
                    </div>
                    <div class="form-group">
                        <label for="idPassword">Password: </label>
                        <input type="password" class="form-control" id="idPassword" name="password" required="true" placeholder="Enter password" value="${account.password}"/>
                    </div>
                    <div class="form-group">
                        <label for="idDescription:">Phone: </label>
                        <input type="text" class="form-control" id="idPassword" name="phone" required="true" placeholder="Enter phone" value="${account.phone}"/>
                    </div>
                    <div class="form-group">
                        <label for="idBirthday">Birthday (dd/mm/yyyy):</label>
                        <input type="text" class="form-control" id="idBirthday" name="birthDate" required="true" placeholder="Enter birthday" value="${account.birthDate}"/>
                    </div>
                    <div class="form-group">
                        <label>Gender: </label>
                        <c:forEach var="genderItem" items="${gender}">
                            <c:if test="${account.gender == genderItem}">
                                <input type="radio" name="gender" value="${genderItem}" checked/> &nbsp; ${genderItem}
                            </c:if>
                            <c:if test="${account.gender != genderItem}">
                                <div style="margin: 10px;display: inline-block">
                                    <input type="radio" name="gender" value="${genderItem}"/> &nbsp; ${genderItem}
                                </div>
                            </c:if> 
                        </c:forEach>                       
                    </div>

                    <c:if test="${action == 'update-account'}">
                        <div class="form-group" hidden>
                            <label for="idBirthday">Active:</label>
                            <input type="text" class="form-control" name="active" required="true" placeholder="Enter birthday" value="${account.active}"/>
                        </div>
                        <div class="form-group" hidden>
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
                    </c:if>    


                    <div class="form-group">
                        <input type="submit" value="${btnName}" class="btn btn-danger btn-add"/>
                    </div>
                </f:form>                  
            </div>

        </div>
    </div>
</body>
