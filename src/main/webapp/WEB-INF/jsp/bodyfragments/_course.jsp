<%-- 
    Document   : _shop
    Created on : Jan 7, 2018, 8:55:24 PM
    Author     : The Lah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course</title>
<!--        <link href="<c:url value="/resources/css/categories_styles.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/categories_responsive.css" />" rel="stylesheet">-->
        
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container product_section_container">
            <div class="row">
                <div class="col product_section clearfix">
                    <!-- Main Content -->
                    <div class="main_content">

                        <!-- Courses -->
                        <div class="products_iso">
                            <div class="row">
                                <div class="col">

                                    <!-- Product Sorting -->
                                    <div class="product_sorting_container product_sorting_container_top">
                                        <ul class="product_sorting">
                                            <li>
                                                <span class="type_sorting_text">Default Sorting</span>
                                                <i class="fa fa-angle-down"></i>
                                                <ul class="sorting_type">
                                                    <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "original-order" }'><span>Default Sorting</span></li>
                                                    <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'><span>Price</span></li>
                                                    <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'><span>Product Name</span></li>
                                                </ul>
                                            </li>
                                            <li>
                                                <span>Show</span>
                                                <span class="num_sorting_text">6</span>
                                                <i class="fa fa-angle-down"></i>
                                                <ul class="sorting_num">
                                                    <li class="num_sorting_btn"><span>6</span></li>
                                                    <li class="num_sorting_btn"><span>12</span></li>
                                                    <li class="num_sorting_btn"><span>24</span></li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <div class="pages d-flex flex-row align-items-center">
                                            <div class="page_current">
                                                <span>1</span>
                                                <ul class="page_selection">
                                                    <li><a href="#">1</a></li>
                                                    <li><a href="#">2</a></li>
                                                    <li><a href="#">3</a></li>
                                                </ul>
                                            </div>
                                            <div class="page_total"><span>of</span> 3</div>
                                            <div id="next_page" class="page_next"><a href="#"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a></div>
                                        </div>

                                    </div>

                                    <!-- Product Grid -->
                                    <div class="product-grid">

                                        <ul class="nav nav-pills nav-stacked">

                                        </ul>

                                        <c:forEach var="courcesItem" items="${cources}">
                                            <div class="product-item men">
                                                <a href="${contextPath}/courseDetail">
                                                    <div class="product discount product_filter">
                                                        <div class="product_image">
                                                            <img  src="<c:url value="${courcesItem.lstImages[0].url}" />" alt=""/>
                                                        </div>
                                                        <div class="favorite favorite_left"></div>
                                                        <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                                                        <div class="product_info">
                                                            <h6 class="product_name">${courcesItem.name}</h6>
                                                            <div class="product_price">${courcesItem.price} VND</div>
                                                        </div>
                                                    </div>
                                                </a>
                                                <div class="red_button add_to_cart_button"><a href="${contextPath}/order/${courcesItem.id}">add to cart</a></div>
                                            </div>
                                        </c:forEach>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
