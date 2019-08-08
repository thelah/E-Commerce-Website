<%-- 
    Document   : layout-course
    Created on : Jan 9, 2018, 10:09:54 AM
    Author     : The Lah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <link type="text/css" rel="stylesheet" 
          href="<c:url value="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>"/>
    <link href="<c:url value="/resources/css/main_home.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/categories_styles.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/categories_responsive.css" />" rel="stylesheet">
        
</head>

<body>
    <table width="100%">
        <tr>
            <td colspan="2">
                <tiles:insertAttribute name="header" />
            </td>
        </tr>
        <tr>
            <td width="20%" rowspan="2">
                 <tiles:insertAttribute name="menu" />
             </td>
            <td width="80%">
                 <tiles:insertAttribute name="body" />
             </td>
        </tr>
        <tr>
            <td colspan="2">
                 <tiles:insertAttribute name="footer" />
            </td>
        </tr>
    </table>
            
    <!-- Bootstrap core JavaScript-->      
</body>
</html>