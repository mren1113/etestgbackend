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
                    <form method="post" action="/etestgbackend/GenETSTDC?Eport=before">
                        <input type="hidden" name="year" value="${getCounterData.STUDY_YEAR}">
                        <input type="hidden" name="sem" value="${getCounterData.STUDY_SEMESTER}">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-12" style="margin-left: 15px;"><label class="fontvwhead">
                                        <i class="fa fa-puzzle-piece"></i> Export ETSTDC text file.</label><br /> <hr></div>
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
                                <div class="col-2" style="margin-left: 15px;">
                                    <label for="examdate">Select Date:</label>

                                    <select class="form-control"  onfocus='this.size = 5;' onblur='this.size = 1;' 
                                            onchange='this.size = 1; this.blur();' name="examdate" id="examdate" required="true">
                                        <option  value="">---select date---</option>
                                        <c:forEach items = "${getExamDate}"  var = "getExamDate">
                                            <option value="${getExamDate.EXAM_DATE}">${getExamDate.EXAM_DATE}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-2">
                                    <label for="sec">Select Section:</label>
                                    <select class="form-control" name="sec" required="true">
                                        <option  value="">--- เลือกคาบสอบ ---</option>
                                        <option value="0"> -- เลือกทั้งหทด -- </option>
                                        <option value="1"> Section 1</option>
                                        <option value="2"> Section 2</option>
                                        <option value="3"> Section 3</option>
                                        <option value="4"> Section 4</option>
                                    </select>

                                </div> 
                            </div>
                            <div class="row" style="margin-top: 20px;"> 
                                <div class="col-12" style="text-align: center;">
                                    <button type="submit" class="btn btn-dark" ><i class="fa fa-save"></i> Generate</button> 
                                    <button type="button" class="btn btn-danger"><i class="fa fa-close"></i> Cancle </button> 
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