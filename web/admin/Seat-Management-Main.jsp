<%-- 
    Document   : Seat-Management
    Created on : Aug 27, 2020, 1:49:15 PM
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
                                        <i class="fa fa-puzzle-piece"></i> กำหนดแถวที่นั่งสอบ และจำนวนที่นั่งสอบ/แถว
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
                                                <b> Summer /${getCounterData.STUDY_YEAR}</b>&nbsp;&nbsp;&nbsp;<font color="#0027FF"><b>รวม ${sumSeat} ที่นั่ง</b></font>
                                            </c:when>
                                            <c:otherwise>
                                                <b> เทอม ${getCounterData.STUDY_SEMESTER}/${getCounterData.STUDY_YEAR}</b>&nbsp;&nbsp;&nbsp;<font color="#0027FF"><b>จำนวนที่นั่ง ${sumSeat} ที่นั่ง</b></font>
                                            </c:otherwise>
                                        </c:choose>  
                                    </label>
                                    <a class="btn btn-success"  
                                       style="float: right; width: 100px; margin: 0 26px 0 5px; border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5); color: #fff;"
                                       href="/etestgbackend/SeatManagementInsert?Create=1">
                                        <i class="fa fa-plus-square"></i> เพิ่ม
                                    </a>
                                    <br>
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="container-fluid" style="padding: 30px 10px;">
                                    <div class="col-12 table-responsive-sm">

                                        <table id="datatable" class="table table-striped table-hover table-bordered" style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5);">
                                            <thead class="text-center"  style="background-color: #004085; color: #fff;">
                                                <tr>
                                                    <th scope="col">ลำดับ</th>
                                                    <th scope="col">แถว</th>
                                                    <th scope="col">จำนวนที่นั่ง</th>
                                                    <th scope="col">ห้องสอบ</th>
                                                    <th scope="col">เพิ่มข้อมูลเมื่อ</th>
                                                    <th scope="col">แก้ไขข้อมูลเมื่อ</th>
                                                    <th scope="col">แก้ไข ข้อมูล</th>
                                                    <th scope="col">ลบ ข้อมูล</th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-center">
                                                
                                                <c:forEach items="${BuildRow}" var = "BuildRow" varStatus="count">                                                 
                                                    <tr>
                                                        <td scope="row">${count.count}</td>
                                                        <td>${BuildRow.ROW_EXAM}</td>
                                                        <td>${BuildRow.SEAT_EXAM}</td>
                                                        <td>${BuildRow.BUILD_NO}</td>                                                        
                                                        <td>${BuildRow.INSERT_DATE}</td>
                                                        <td>
                                                             <c:choose>
                                                                <c:when test = "${BuildRow.UPDATE_DATE == null}">
                                                                    ยังไม่มีการแก้ไขข้อมูล
                                                                </c:when>
                                                                <c:otherwise>
                                                                    ${BuildRow.UPDATE_DATE}
                                                                </c:otherwise>
                                                            </c:choose>       
                                                        </td>
                                                        <td>
                                                            <a type="button" class="btn btn-warning" 
                                                               style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5);"
                                                               href="SeatManagementUpdate?Year=${BuildRow.YEAR}&Semester=${BuildRow.SEMESTER}&RowExam=${BuildRow.ROW_EXAM}">
                                                                <i class="fa fa-pencil"></i> แก้ไข 
                                                            </a>
                                                        </td>
                                                        <td>                                                            
                                                            <a type="button" class="btn btn-danger" 
                                                               style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5); color: #fff;"
                                                               onclick="return confirm('คุณต้องการ ลบข้อมูลใช่หรือไม่?');"
                                                               href="SeatManagementDelete?Year=${BuildRow.YEAR}&Semester=${BuildRow.SEMESTER}&RowExam=${BuildRow.ROW_EXAM}&sumSeat=${sumSeat}&seat_exam=${BuildRow.SEAT_EXAM}">
                                                                <i class="fa fa-trash"></i> ลบ 
                                                            </a>                                                            
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


























