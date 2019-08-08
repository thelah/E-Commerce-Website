<%-- 
    Document   : _courseDetail
    Created on : Jan 13, 2018, 7:23:49 PM
    Author     : The Lah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<title>Course Detail Page</title>-->
        <link href="<c:url value="/resources/css/single_styles.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/single_responsive.css" />" rel="stylesheet">
    </head>
    <body>
        <<div class="container single_product_container">
            <div class="row">
                <div class="col">

                    <!-- Breadcrumbs -->
<!--                    <div class="breadcrumbs d-flex flex-row align-items-center">
                        <ul>
                            <li><a href="index.html">Home</a></li>
                            <li><a href="categories.html"><i class="fa fa-angle-right" aria-hidden="true"></i>IT</a></li>
                            <li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Single Course</a></li>
                        </ul>
                    </div>-->

                </div>
            </div>

            <div class="row">
                <div class="col-lg-7">
                    <div class="single_product_pics">
                        <div class="row">

                            <div class="col-lg-11 image_col order-lg-2 order-1">
                                <div class="single_product_image">
                                    <div class="single_product_image_background" style="background-image:url(images/product_1.png)"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="product_details">
                        <div class="product_details_title">
                            <h2>Learn Japanese: Kanji Basic (full course)</h2>
                            <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                        </div>
                        <div class="free_delivery d-flex flex-row align-items-center justify-content-center">
                            <span class="ti-truck"></span><span>free support</span>
                        </div>
                        <div class="original_price">$590.00</div>
                        <div class="product_price">$520.00</div>
                        <ul class="star_rating">
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        </ul>
                        <div class="product_color">
                            <span>Select Level:</span> &emsp;
                            <input type="radio" name="checkbox" value="" /> Beginner &emsp;
                            <input type="radio" name="checkbox" value="" /> Normal &emsp;
                            <input type="radio" name="checkbox" value="" /> Advanced &emsp;

                        </div>
                        <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
                            <span>Quantity:</span>
                            <div class="quantity_selector">
                                <span class="minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                <span id="quantity_value">1</span>
                                <span class="plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
                            </div>
                            <div class="red_button add_to_cart_button"><a href="#">purchase</a></div>
                            <div class="product_favorite d-flex flex-column align-items-center justify-content-center"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Tabs -->

        <div class="tabs_section_container">

            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="tabs_container">
                            <ul class="tabs d-flex flex-sm-row flex-column align-items-left align-items-md-center justify-content-center">
                                <li class="tab active" data-active-tab="tab_1"><span>Description</span></li>
                                <li class="tab" data-active-tab="tab_2"><span>Additional Information</span></li>
                                <li class="tab" data-active-tab="tab_3"><span>Course Reviews (2)</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">

                        <!-- Tab Description -->

                        <div id="tab_1" class="tab_container active">
                            <div class="row">
                                <div class="col-lg-5 desc_col">
                                    <div class="tab_title">
                                        <h4>Description</h4>
                                    </div>
                                    <div class="tab_text_block">
                                        <h2>Learn Japanese: Kanji Basic (full course)</h2>
                                        <p>Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                                    </div>
                                    <div class="tab_image">
                                        <img src="images/desc_japan_1.jpeg" alt=""/>
                                    </div>
                                    <div class="tab_text_block">
                                        <h2>How to master Japanese Language in 6 months?</h2>
                                        <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis...</p>
                                    </div>
                                </div>
                                <div class="col-lg-5 offset-lg-2 desc_col">
                                    <div class="tab_image">
                                        <img src="images/desc_japan_2.jpeg" alt=""/>
                                    </div>
                                    <div class="tab_text_block">
                                        <h2>Learn Japanese: Basic Communicating</h2>
                                        <p>Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                                    </div>
                                    <div class="tab_image desc_last">
                                        <img src="images/desc_japan_3.jpg" alt=""/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Tab Additional Info -->

                        <div id="tab_2" class="tab_container">
                            <div class="row">
                                <div class="col additional_info_col">
                                    <div class="tab_title additional_info_title">
                                        <h4>Additional Information</h4>
                                    </div>
                                    <p>LECTURER:<span>Lanh Nguyen</span></p>
                                    <p>DURATION:<span>3 months (40 lessons)</span></p>
                                    <p>SCHEDULE:<span>Tuesday, Thursday, Saturday</span></p>
                                    <p>TIME:<span>19:00 - 21:00</span></p>
                                </div>
                            </div>
                        </div>

                        <!-- Tab Reviews -->

                        <div id="tab_3" class="tab_container">
                            <div class="row">

                                <!-- User Reviews -->

                                <div class="col-lg-6 reviews_col">
                                    <div class="tab_title reviews_title">
                                        <h4>Reviews (2)</h4>
                                    </div>

                                    <!-- User Review -->
                                    <div class="user_review_container d-flex flex-column flex-sm-row">
                                        <div class="user">
                                            <div class="user_pic">
                                                <img src="images/3.jpg" alt=""/>
                                            </div>
                                            <div class="user_rating">
                                                <ul class="star_rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="review">
                                            <div class="review_date">3 Jan 2018</div>
                                            <div class="user_name">Layne Nguyen</div>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                        </div>
                                    </div>

                                    <!-- User Review -->
                                    <div class="user_review_container d-flex flex-column flex-sm-row">
                                        <div class="user">
                                            <div class="user_pic">
                                                <img src="images/banner_1.jpg" alt=""/>
                                            </div>
                                            <div class="user_rating">
                                                <ul class="star_rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="review">
                                            <div class="review_date">21 Dec 2017</div>
                                            <div class="user_name">Hai Phan</div>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                        </div>
                                    </div>
                                </div>

                                <!-- Add Review -->

                                <div class="col-lg-6 add_review_col">

                                    <div class="add_review">
                                        <form id="review_form" action="post">
                                            <div>
                                                <h1>Add Review</h1>
                                                <input id="review_name" class="form_input input_name" type="text" name="name" placeholder="Name*" required="required" data-error="Name is required.">
                                                <input id="review_email" class="form_input input_email" type="email" name="email" placeholder="Email*" required="required" data-error="Valid email is required.">
                                            </div>
                                            <div>
                                                <h1>Your Rating:</h1>
                                                <ul class="user_star_rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                                </ul>
                                                <textarea id="review_message" class="input_review" name="message"  placeholder="Your Review" rows="4" required data-error="Please, leave us a review."></textarea>
                                            </div>
                                            <div class="text-left text-sm-right">
                                                <button id="review_submit" type="submit" class="red_button review_submit_btn trans_300" value="Submit">submit</button>
                                            </div>
                                        </form>
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
