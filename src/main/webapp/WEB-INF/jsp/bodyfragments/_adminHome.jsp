<%-- 
    Document   : _adminHome
    Created on : Dec 20, 2017, 7:44:26 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container" style="margin-top: 150px; height: 300px;">
            <div class="row">
                <div class="col-md-12" style="text-align: center; margin-bottom: 20px;">
                    <h2>Welcome to Admin Page: <span style="color: #fe4c50;">${username}</span></h2>
                </div>
            </div>

        </div>
    </body>
</html>
