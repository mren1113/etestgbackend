<%-- 
    Document   : Export-ETSTDC-Select
    Created on : Sep 17, 2020, 3:06:37 PM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
                <div class="card">              
                    <form method="post" action="/etestgbackend/GenETSTDC?Export=ExportNow">
                        <div class="row" style="margin-top: 20px;"> 
                            <div class="col-12" style="text-align: center;">
                                <button type="submit" class="btn btn-dark" ><i class="fa fa-save"></i>Download file</button> 
                                <button type="button" class="btn btn-danger"><i class="fa fa-close"></i> Cancle </button> 
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /# column -->
        </div>
        <!--  /Traffic -->
        <div class="clearfix"></div>

        <!-- .animated -->
    </div>
    <!-- /.content -->
    <div class="clearfix"></div>
    <!-- Footer -->
    <jsp:include page="footer.jsp" />
