<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="header.jsp" /> 

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
                    <form method="post" action="/etestgbackend/SaveFile"  enctype="multipart/form-data">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-12" style="margin-left: 15px;"><label class="fontvwhead"><i class="fa fa-puzzle-piece"></i> Upload files</label><br /> <hr></div>
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
                           
                               <div class="row" style="margin-top: 25px;">                                 
                                <div class="col-2" style="text-align: right;">
                                    <label for="fiscalyear" class="fontvw" style="font-weight: bold;">File วิชาที่เปิด:</label> 
                                </div>   
                                 <div class="col-5" >                                     
                                     <input type="file" class="form-control" name="file_course" required />
                                     <label for="fiscalyear" class="fontvw" style="color: red; font-size: 12px">**File ET_COURSE_OPEN.csv</label> 
                                </div> 
                                <div class="col-5" style="text-align: center;">  </div>   
                            </div>
                            <div class="row" style="margin-top: 25px;">                                 
                                <div class="col-2" style="text-align: right;">
                                    <label for="fiscalyear" class="fontvw" style="font-weight: bold;">File จำนวนที่นั่ง:</label> 
                                </div>   
                                 <div class="col-5" >                                     
                                     <input type="file" class="form-control"  name="file_seat" required />
                                     <label for="fiscalyear" class="fontvw" style="color: red; font-size: 12px">**File ET_EXAM_SEAT.csv</label> 
                                </div> 
                                <div class="col-5" style="text-align: center;">  </div>   
                            </div>
                            <div class="row" style="margin-top: 25px;">                                 
                                <div class="col-2" style="text-align: right;">
                                    <label for="fiscalyear" class="fontvw" style="font-weight: bold;">File จำนวนคาบ:</label> 
                                </div>   
                                 <div class="col-5" >                                     
                                     <input type="file" class="form-control"  name="file_rowseat" required />
                                     <label for="fiscalyear" class="fontvw" style="color: red; font-size: 12px">**File ET_EXAM_DATE.csv</label> 
                                </div> 
                                <div class="col-5" style="text-align: center;">  </div>   
                            </div>
                            <div class="row" style="margin-top: 25px;">                                 
                                <div class="col-2" style="text-align: right;">
                                    <label for="fiscalyear" class="fontvw" style="font-weight: bold;">File ลำดับที่นั่ง:</label> 
                                </div>   
                                 <div class="col-5" >                                     
                                     <input type="file" class="form-control"  name="file_build" required />
                                     <label for="fiscalyear" class="fontvw" style="color: red; font-size: 12px">**File ET_BUILE_ROW.csv</label> 
                                </div> 
                                <div class="col-5" style="text-align: center;">  </div>   
                            </div>
                          
                           
                              
                            <div class="row" style="text-align: center;">                                 
                                <div class="col-12" style="text-align: center;">
                                    <center>
                                    <label for="bt" class="fontvw" >&nbsp;</label><br /> 
                                    <button type="submit" class="btn btn-primary" ><i class="fa fa-save"></i> บันทึกข้อมูล</button>
                                    <button type="button" class="btn btn-danger"><i class="fa fa-home"></i> Back </button> 
                                    <label id="demo" ></label> 
                                    </center>
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
    <!-- Footer -->
    <jsp:include page="footer.jsp" />