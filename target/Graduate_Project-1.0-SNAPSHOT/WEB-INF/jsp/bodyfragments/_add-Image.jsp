<%-- 
    Document   : _add-Image
    Created on : Jan 4, 2018, 9:17:31 AM
    Author     : thanhhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>  
<html>  
    <head>  
        <title>Image File Upload</title>  
    </head>  
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12" style="text-align: center;margin-top: 120px;">
                    <h2>${headerName}</h2>                   
                </div>
            </div>
            <div class="row" style="justify-content: center; margin-top: 20px;">
                <div class="col-xs-12 col-sm-12 col-md-10" >
                    <f:form method="post" action="${contextPath}/admin/${action}" enctype="multipart/form-data" modelAttribute="image">
                        <c:if test="${action == 'update-image'}">
                            <input hidden name="id" value="${image.id}"/>                         
                        </c:if>
                        <div class="form-group">
                            <input name="file" id="fileToUpload" type="file" class="btn btn-default"/>
                        </div>
                        <div class="form-group">
                            <label for="idName">Category: </label>
                            <select name="course.id"> 
                                <c:forEach items="${listCourse}" var="courseItem" >
                                     <c:if test="${image.course.id == courseItem.id}">
                                         <option value="${courseItem.id}" selected="selected">${courseItem.name}</option>
                                    </c:if> 
                                    <c:if test="${image.course.id!= courseItem.id}">
                                        <option value="${courseItem.id}">${courseItem.name}</option>
                                    </c:if> 
                                    
                                </c:forEach>  
                            </select>  
                        </div>
                        <input type="submit" value="Upload" class="btn btn-danger">    
                    </f:form> 

                </div>
            </div>
        </div> 
    </body>  
</html>  
