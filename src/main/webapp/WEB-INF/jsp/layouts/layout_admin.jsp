<%-- 
    Document   : layout_admin
    Created on : Dec 24, 2017, 7:22:33 PM
    Author     : thanhhai
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
        <link href="<c:url value="/resources/css/adminHome.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/admin_common.css" />" rel="stylesheet">
        
        <!-- Page level plugin CSS-->
        <link href="<c:url value="/resources/extend/vendor/datatables/dataTables.bootstrap4.css" />"rel="stylesheet">
</head>

<body>
    <table width="100%">
        <tr>
            <td colspan="2">
                <tiles:insertAttribute name="header" />
            </td>
        </tr>
        <tr>
            <td width="20%"  rowspan="2">
                 <tiles:insertAttribute name="menu" />
             </td>
            <td width="80%">
                 <tiles:insertAttribute name="body" />
             </td>
        </tr>
        <tr>
            <td  >
                 <tiles:insertAttribute name="footer" />
            </td>
        </tr>
    </table>
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="/resources/extend/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/extend/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
    <!-- Core plugin JavaScript-->
    <script src=" <c:url value="/resources/extend/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
    <!-- Page level plugin JavaScript-->
    <script src="<c:url value="/resources/extend/vendor/datatables/jquery.dataTables.js"/>"></script>
    <script src="<c:url value="/resources/extend/vendor/datatables/dataTables.bootstrap4.js"/>"></script>
    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/resources/extend/js/sb-admin.min.js"/>"></script>
    <!-- Custom scripts for this page-->
    <script src="<c:url value="/resources/extend/js/sb-admin-datatables.min.js"/>"></script>        
</body>
</html>