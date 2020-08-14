<%@ page import = "java.io.*,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<title>เข้าสู่ระบบไม่สำเร็จ!</title>
<jsp:include page="../header.jsp" /> 

<body> 
    <p /> 
<center>
    <h2 class="">
        <c:choose>
            <c:when test = "${x eq '0'}">load data faild</c:when>
            <c:when test = "${x eq '1'}">ccxcxxd</c:when>
            <c:when test = "${x eq '2'}">xxxxxxs</c:when>
        </c:choose></h2>

    <p /> 
    <div class="container warpRow">
        <div class="row">
            <div class="col-md-4 "> </div> 
            <div class="col-md-4 ">
                <button type="submit" class="btn btn-primary" onclick="window.history.go(-1);">กลับไปกรอกข้อมูลใหม่</button>
            </div>         
            <div class="col-md-4 "> </div> 
        </div>    
    </div>  
</center>
 </body>
</html>
