<%-- 
    Document   : Receipt-Management-Main
    Created on : Sep 14, 2020, 1:19:51 PM
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
                <div class="card" style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5);">      

                    <form method="post" action="#">
                        <input type="hidden" name="year" value="${getCounterData.STUDY_YEAR}">
                        <input type="hidden" name="sem" value="${getCounterData.STUDY_SEMESTER}">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-12" style="margin-left: 15px;">
                                    <label class="fontvwhead">
                                        <i class="fa fa-puzzle-piece"></i> ปรับสถานะการชำระเงินของนักศึกษา 
                                    </label>
                                    <br>
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12" style="margin-left: 15px;">
                                    <label style="font-size: 1vw;">
                                        <i class="fa fa-warning" style="color: red;"></i> ปี/ภาคการศึกษาปัจจุบัน
                                        <c:choose>
                                            <c:when test = "${getCounterData.STUDY_SEMESTER == '3'}">
                                                <b> Summer /${getCounterData.STUDY_YEAR}</b>
                                            </c:when>
                                            <c:otherwise>
                                                <b> เทอม ${getCounterData.STUDY_SEMESTER}/${getCounterData.STUDY_YEAR}</b>
                                            </c:otherwise>
                                        </c:choose>  
                                    </label>
                                    <br>
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="container-fluid" style="padding: 30px 10px;">
                                    <div class="col-12 table-responsive-sm">

                                        <table id="datatable" class="table table-striped table-hover table-bordered" style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5);">
                                            <thead class="thead-dark text-center">
                                                <tr>
                                                    <th scope="col">รหัสนักศึกษา</th>
                                                    <th scope="col">ภาคการศึกษา</th>
                                                    <th scope="col">ค่าลงทะเบียน</th>   
                                                    <th scope="col">สถานะการชำระเงิน</th>
                                                    <th scope="col">ปรับสถานะการชำระเงิน</th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-center">

                                                <c:forEach items="${ReceiptData}" var = "ReceiptData" varStatus="count">                                                 
                                                    <tr>
                                                        <td scope="row">${ReceiptData.STD_CODE}</td>
                                                        <td>
                                                            <c:choose>
                                                                <c:when test = "${ReceiptData.RECEIPT_SEMESTER == '3'}">
                                                                    Summer
                                                                </c:when>
                                                                <c:otherwise>
                                                                    เทอม ${ReceiptData.RECEIPT_SEMESTER}
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <td>${ReceiptData.TOTAL_AMOUNT}</td>
                                                        <td>
                                                            <c:choose>
                                                                <c:when test = "${ReceiptData.RECEIPT_PAY_STATUS == 0}">
                                                                    <font color="tomato">ยังไม่ชำระเงิน!</font>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <font color="green">ชำระเงินเรียบร้อยแล้ว</font>
                                                                </c:otherwise>
                                                            </c:choose>       
                                                        </td>
                                                        <td>
                                                            <c:choose>
                                                                <c:when test = "${ReceiptData.RECEIPT_PAY_STATUS == 1}">
                                                                    <a type="button" class="btn btn-success" 
                                                                       style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5);"
                                                                       onclick="return confirm('คุณต้องการ ปรับสถานะการชำระเงินเป็น ***ยังไม่ชำระเงิน!*** ใช่หรือไม่?');"
                                                                       href="ReceiptManagementUpdate?receiptStdCode=${ReceiptData.STD_CODE}&receiptYear=${ReceiptData.RECEIPT_YEAR}&receiptSemester=${ReceiptData.RECEIPT_SEMESTER}&receiptPayStatus=${ReceiptData.RECEIPT_PAY_STATUS}&refKey=${ReceiptData.REF_KEY}">
                                                                        <i class="fa fa-money"></i> ปรับสถานะ 
                                                                    </a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a type="button" class="btn btn-danger" 
                                                                       style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5);"
                                                                       onclick="return confirm('คุณต้องการ ปรับสถานะการชำระเงินเป็น ***ชำระเงินเรียบร้อยแล้ว*** ใช่หรือไม่?');"
                                                                       href="ReceiptManagementUpdate?receiptStdCode=${ReceiptData.STD_CODE}&receiptYear=${ReceiptData.RECEIPT_YEAR}&receiptSemester=${ReceiptData.RECEIPT_SEMESTER}&receiptPayStatus=${ReceiptData.RECEIPT_PAY_STATUS}&refKey=${ReceiptData.REF_KEY}">
                                                                        <i class="fa fa-money"></i> ปรับสถานะ 
                                                                    </a>
                                                                </c:otherwise>
                                                            </c:choose> 

                                                        </td>
                                                    </tr>                                                        

                                                </c:forEach>

                                            </tbody>
                                        </table>                             
                                    </div>
                                </div>
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
