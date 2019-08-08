<%-- 
    Document   : _userMenu
    Created on : Jan 9, 2018, 10:17:18 AM
    Author     : The Lah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>

    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container product_section_container">
            <div class="row">
                <div class="col product_section clearfix">
                    <div class="sidebar">
                        <div class="sidebar_section">
                            <div class="sidebar_title">
                                <h5>Course Category</h5>
                            </div>
                            <ul class="sidebar_categories">
                                <li class="active"><a href="${contextPath}/courses/IT"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span>IT</a></li>
                                <li><a href="${contextPath}/courses/Language">Language</a></li>
                                <li><a href="${contextPath}/courses/SoftSkills">Soft Skill</a></li>
                                <li><a href="#">Other</a></li>
                            </ul>
                        </div>

                        <!-- Availability -->
                        <div class="sidebar_section">
                            <div class="sidebar_title">
                                <h5>Availability</h5>
                            </div>
                            <ul class="checkboxes">
                                <li class="active"><i class="fa fa-square" aria-hidden="true"></i><span>Current</span></li>
                                <li><i class="fa fa-square-o" aria-hidden="true"></i><span>Coming Soon</span></li>
                                <li><i class="fa fa-square-o" aria-hidden="true"></i><span>Best Seller</span></li>
                                <li><i class="fa fa-square-o" aria-hidden="true"></i><span>Best Price</span></li>
                                <li><i class="fa fa-square-o" aria-hidden="true"></i><span>Free</span></li>
                            </ul>
                        </div>                       
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
