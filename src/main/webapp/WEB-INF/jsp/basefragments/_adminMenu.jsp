<%-- 
    Document   : _menu
    Created on : Dec 12, 2017, 7:37:46 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/admin_common.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/adminHome.css" />" rel="stylesheet">
    </head>
    <body>
        <aside style="position: fixed;top: 20px;">
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="containner">
            <div>
                <div class="vertical-menu" style="margin-top: 120px;">
                <a href="${contextPath}/admin/adminAccount">Manage Account</a>    
                <a href="${contextPath}/admin/adminCategory">Manage Category</a>
                <a href="${contextPath}/admin/adminCourse">Manage Courses</a>
                <a href="${contextPath}/admin/adminPromotion">Manage Promotion</a>
                <a href="${contextPath}/admin/adminImage">Manage Image</a>
                <a href="${contextPath}/admin/adminOrder">Manage Order</a>
                <a href="${contextPath}/admin/adminOrderDetail">Manage Order Detail</a>
                <a href="${contextPath}/admin/adminTransaction">Manage Transaction</a>
            </div>
        </div>
        </div>
        </aside>
    </body>
</html>
