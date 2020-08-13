<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="./css/text.css" rel="stylesheet" />

<jsp:include page="header.jsp" /> 

<!-- /#header -->
<!-- Content -->
<div class="content">
    <!-- Animated -->
    <div class="animated fadeIn">
        <!-- Widgets  -->
        <div class="row"> 

        </div>
        <!-- /Widgets -->
        <!--  Traffic  -->
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-primary float-right " href="ExportETSTDC?export=888"><i class="menu-icon fa fa-file-text"></i>&nbsp;Export Text File</a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6 text-center">
                <div class="card"> 
                    <font class="text-wrap"> 
                    <c:forEach items="${lists}" var="lists">
                        ${lists.stdc_year}${lists.stdc_std_semester}${lists.stdc_std_code}${lists.stdc_std_course_code}&nbsp;&nbsp;&nbsp;${lists.stdc_credit}&nbsp;${lists.stdc_section} &nbsp;${lists.app_date_etest_dd}${lists.app_date_etest_mm}${lists.app_date_etest_yy}${lists.app_period_etest}&nbsp;${lists.app_bld}${lists.app_row}${lists.app_seat}&nbsp;${lists.etest_status}&nbsp;${lists.stdc_grade}&nbsp;${lists.stdc_score_tot}&nbsp;${lists.stdc_score_M}&nbsp;${lists.stdc_score_F}&nbsp;${lists.stdc_score_chsum}<br> 
                    </c:forEach>
                    </font>
                </div>
            </div> 
            <div class="col-lg-3"></div>
        </div> 
    </div> 
</div> 
<jsp:include page="footer.jsp" />
