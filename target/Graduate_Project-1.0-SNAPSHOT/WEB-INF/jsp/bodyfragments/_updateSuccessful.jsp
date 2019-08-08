<%-- 
    Document   : _updateSuccessful
    Created on : Jan 8, 2018, 1:45:12 PM
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
                    <h2 style=" margin-bottom: 50px;">Update Successful !!!</h2>
                    <h4 style=" margin-bottom: 50px;">You have changed your personal information</h4>
                    <button class="btn btn-danger" onclick="location.href = '${contextPath}/user/user-page'">Back to user page</button>
                </div>
            </div>

        </div>
    </body>
</html>
