<%-- 
    Document   : _registerSuccessful
    Created on : Jan 5, 2018, 4:47:27 PM
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
                <div class="col-md-12" style="text-align: center;">
                    <h2 style=" margin-bottom: 50px;">Register Successful !!!</h2>
                    <h4 style=" margin-bottom: 50px;">Please check your email to active your account and join with us</h4>
                    <button class="btn btn-danger" onclick="location.href = '${contextPath}/user/user-page'">Back to login page</button>

                </div>
            </div>

        </div>
    </body>
</html>
