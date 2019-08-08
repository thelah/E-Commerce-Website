<%-- 
    Document   : _login
    Created on : Dec 23, 2017, 7:05:53 PM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link type="text/css" rel="stylesheet" 
              href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
        <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container"">
            <div class="row text-center" style="margin-top: 120px;">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <h2>Login</h2>
                </div>
            </div>
            <c:if test="${message !=null}">
                <div class="row">
                    <div class="col-sm-offset-2 col-sm-8">
                        <div class="alert alert-danger">
                            ${message}
                        </div>
                    </div>
                </div>
            </c:if>
            <div class="container" style="margin-top: 30px;">
                <div class="row" style="justify-content:  center;">
                    <form class="login-form" action="<c:url value='j_spring_security_check' />" method='POST'>
                        <div class="form-inline" style="margin-bottom: 20px;">
                            <label for="inputEmail" class="" style="width: 30%;">User Name: </label>
                            <div class="col-sm-8" style="width: 30%;">
                                <input type="text" name="email" class="form-control" id="inputEmail" placeholder="Enter username" required="">
                            </div>
                        </div>
                        <div class="form-inline" style="margin-bottom: 20px;">
                            <label for="inputPassword" class="" style="width: 30%;">Password: </label>
                            <div class="col-sm-8" style="width: 70%;">
                                <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Enter password" required="">
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="remember-me"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-inline text-center">
                            <button type="submit" class="btn btn-danger btn-add" style="margin-right: 100px;">Sign in</button>
                            <button class="btn btn-danger btn-add"
                                    onclick="location.href = '${contextPath}/register'">Register </button>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
