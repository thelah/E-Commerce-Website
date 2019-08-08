<%-- 
    Document   : _adminHeader
    Created on : Jan 5, 2018, 8:21:01 PM
    Author     : thanhhai
--%>

<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<head>

</head>
<body>
    <header style="position: fixed; z-index: 20;width: 100%;top: 0;">
        <!-- Main Navigation -->
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="main_nav_container">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-right">
                        <div class="logo_container">
                            <a href="${contextPath}/home" onclick="location.href = '${contextPath}/home'" >Course<span>shop</span></a>
                        </div>
                        <nav class="navbar">
                            <ul class="navbar_menu">
                                <li><a href="${contextPath}/home" >home</a></li>
                                <li><a href="${contextPath}/courses">shop</a></li>
                                <li><a href="#">promotion</a></li>
                                <li><a href="#">blog</a></li>
                                <li><a href="${contextPath}/contact">contact</a></li>
                            </ul>
                            <ul class="navbar_user">
                                <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="modal" data-target="#exampleModal" href="#">
                                        <i class="fa fa-fw fa-sign-out"></i></a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>                         
    </header>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="${contextPath}/logout">Logout</a>
                </div>
            </div>
        </div>
    </div>                        
</body>