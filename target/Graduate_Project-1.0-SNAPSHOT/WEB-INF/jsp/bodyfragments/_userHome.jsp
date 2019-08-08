<%-- 
    Document   : _userHome
    Created on : Jan 5, 2018, 9:53:13 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="margin-top: 150px;">
            <div class="row">
                <input value="${username}" hidden/>
                <div class="col-md-12" style="text-align: center; margin-bottom: 20px;">
                    <h2>Welcome to CourseShop: <span style="color: #fe4c50;">${username}</span></h2>
                </div>
                <div class="col-md-12" style="text-align: center; margin-bottom: 20px;">
                    <button class="btn btn-danger" style="margin-top: 30px;"
                            onclick="location.href = '${contextPath}/updateAccount/${accountId}'">Change personal information</button>
                 </div>
                <div class="col-md-12" style="text-align: center; margin-bottom: 20px;"> 
                    <button class="btn btn-danger" style="margin-top: 30px;" 
                            onclick="location.href = '${contextPath}/admin/adminHome'">Go to Admin Page</button>        
                </div>
            </div>
        </div>
    </body>
</html>
