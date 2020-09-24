<%-- 
    Document   : Export-ETRU25et-Main
    Created on : Sep 23, 2020, 8:40:27 AM
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
                    <form method="post" action="/etestgbackend/ExportETRU25et?Export=FindExport">
                        <input type="hidden" name="year" value="${getCounterData.STUDY_YEAR}">
                        <input type="hidden" name="sem" value="${getCounterData.STUDY_SEMESTER}">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-12" style="margin-left: 15px;"><label class="fontvwhead">
                                    <i class="fa fa-puzzle-piece"></i> Export RU25et text file.</label>
                                    <br/> 
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-1"></div>
                                <div class="col-11" style="margin-left: 15px;">
                                    <label style="font-size: 1vw;">
                                        <i class="fa fa-warning" style="color: red;"></i> ปี/ภาคการศึกษาปัจจุบัน
                                        <c:choose>
                                            <c:when test = "${getCounterData.STUDY_SEMESTER == '3'}">
                                                <b> Summer /${getCounterData.STUDY_YEAR}</b>
                                            </c:when>
                                            <c:otherwise>
                                                <b> ${getCounterData.STUDY_SEMESTER}/${getCounterData.STUDY_YEAR}</b>
                                            </c:otherwise>
                                        </c:choose>  </label><br /> <hr></div>
                            </div>
                            <div class="row">
                                <div class="col-1"></div>
                                <div class="col-3" style="margin-left: 15px;">
                                    <label for="examdate">เลือก "วัน/เดือน/ปี" ที่เปิดสอบ :</label>

                                    <select class="form-control" name="examdate" id="examdate" required="true">
                                        <option  value="">--- เลือก วัน/เดือน/ปี ---</option>
                                        <option  value="0"> ทั้งหมด </option>
                                        <c:forEach items = "${getExamDate}"  var = "getExamDate">
                                            <option value="${getExamDate.EXAM_DATE}">${getExamDate.EXAM_DATE}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="sec">เลือก "คาบ" ที่เปิดสอบ :</label>
                                    <select class="form-control" name="section" required="true">
                                        <option  value="">--- เลือกคาบสอบ ---</option>
                                        <option value="0"> ทั้งหมด </option>
                                        <option value="1"> คาบ 1 </option>
                                        <option value="2"> คาบ 2 </option>
                                        <option value="3"> คาบ 3 </option>
                                        <option value="4"> คาบ 4 </option>
                                    </select>
                                </div> 
                                <div class="col-3" style="text-align: center; margin-top: 30px;">
                                    <button type="submit" class="btn btn-success" style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5); color: #fff;"><i class="fa fa-save"></i> ดาวน์โหลดไฟล์ </button> 
                                    <button type="reset" class="btn btn-danger" style="border-radius: 0; box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.5); color: #fff;"><i class="fa fa-close"></i> ยกเลิก </button> 
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
