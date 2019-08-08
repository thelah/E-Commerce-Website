<%-- 
    Document   : _header
    Created on : Dec 12, 2017, 7:37:06 PM
    Author     : thanhhai
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<head>
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/menu_jquery.js" />"></script>
    <link type="text/css" rel="stylesheet" 
          href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
    <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
</head>
<body>
    <header style="position: fixed; z-index: 20;width: 100%;">
    <!-- Main Navigation -->
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <div class="main_nav_container">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-right">
                    <div class="logo_container">
                        <a href="${contextPath}/home" onclick="location.href='${contextPath}/home'" >Course<span>shop</span></a>
                    </div>
                    <nav class="navbar">
                        <ul class="navbar_menu">
                            <li><a href="${contextPath}/home" >home</a></li>
                            <li><a href="${contextPath}/courses">shop</a></li>
                            <li><a href="#">promotion</a></li>
<!--                            <li><a href="#">pages</a></li>-->
                            <li><a href="#">blog</a></li>
                            <li><a href="${contextPath}/contact">contact</a></li>
                        </ul>
                        <ul class="navbar_user">
                            <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                            <li><a href="${contextPath}/user/user-page"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                            <li>
                                <a href="${contextPath}/cart">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    </header>
</body>

