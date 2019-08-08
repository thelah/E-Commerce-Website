<%-- 
    Document   : _contactus
    Created on : Dec 12, 2017, 7:35:19 PM
    Author     : thanhhai
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<head>
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <link type="text/css" rel="stylesheet" 
          href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
    <link href="<c:url value="/resources/css/contact_styles.css" />" rel="stylesheet">
</head>
<body>
    <div class="container" style="margin-top: 5%;">
        <!-- Contact Us -->

        <div class="row">

            <div class="col-lg-6 contact_col" style="margin-top: 70px;">
                <div class="contact_contents">
                    <h1>Contact Us</h1>
                    <p>There are many ways to contact us. You may drop us a line, give us a call or send an email, choose what suits you the most.</p>
                    <div>
                        <p>(+84) 1667 279 794 (Mr. Hai)</p>
                        <p>(+84) 1287 079 479 (Mr. Lanh)</p>
                        <p>LHteam@gmail.com</p>
                    </div>
                    <div>
                        <p>mm</p>
                    </div>
                    <div>
                        <p>Open hours: 8.00-18.00 Mon-Fri</p>
                        <p>Sunday: Closed</p>
                    </div>
                </div>

                <!-- Follow Us -->

                <div class="follow_us_contents">
                    <h1>Follow Us</h1>
                    <ul class="social d-flex flex-row">
                        <li><a href="#" style="background-color: #3a61c9"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                        <li><a href="#" style="background-color: #41a1f6"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                        <li><a href="#" style="background-color: #fb4343"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                        <li><a href="#" style="background-color: #8f6247"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                    </ul>
                </div>

            </div>

            <div class="col-lg-6 get_in_touch_col" style="margin-top: 70px" >
                <div class="get_in_touch_contents">
                    <h1>Get In Touch With Us!</h1>
                    <p>Fill out the form below to receive a free and confidential.</p>
                    <form action="post">
                        <div>
                            <input id="input_name" class="form_input input_name input_ph" type="text" name="name" placeholder="Name" required="required" data-error="Name is required.">
                            <input id="input_email" class="form_input input_email input_ph" type="email" name="email" placeholder="Email" required="required" data-error="Valid email is required.">
                            <input id="input_website" class="form_input input_website input_ph" type="url" name="name" placeholder="Website" required="required" data-error="Name is required.">
                            <textarea id="input_message" class="input_ph input_message" name="message"  placeholder="Message" rows="3" required data-error="Please, write us a message."></textarea>
                        </div>
                        <div>
                            <button id="review_submit" type="submit" class=" message_submit_btn   trans_300" value="Submit">send message</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>
</body>