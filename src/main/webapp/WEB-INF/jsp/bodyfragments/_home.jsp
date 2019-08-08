<%-- 
    Document   : _home
    Created on : Dec 12, 2017, 7:34:45 PM
    Author     : thanhhai
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<!--   <script src="<c:url value="/resources/js/menu_jquery.js" />"></script>-->
    <link type="text/css" rel="stylesheet" 
          href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
    <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
</head>
<body>
    <!-- Slider -->

    <div class="main_slider" style="background-image:url(<c:url value="/resources/images/bann.jpg"></c:url>)">
        <div class="container fill_height">
            <div class="row align-items-center fill_height">
                <div class="col">
                    <div class="main_slider_content">
                        <h6>Summer Special Discount 2017</h6>
                        <h1>Get up to 30% Off New Courses</h1>
                        <div class="red_button shop_now_button"><a href="#">buy now</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner -->

    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="banner_item align-items-center" style="background-image:url(<c:url value="/resources/images/cau-truc-du-lieu-va-giai-thuat.jpg"></c:url>)">
                        <div class="banner_category">
                            <a href="categories.html">Programming</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="banner_item align-items-center" style="background-image:url(<c:url value="/resources/images/german-language-learning.jpg"></c:url>)">
                        <div class="banner_category">
                            <a href="categories.html">Language</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="banner_item align-items-center" style="background-image:url(<c:url value="/resources/images/xaydungnentangthanhcong.jpg"></c:url>)">
                        <div class="banner_category">
                            <a href="categories.html">Soft skill</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>