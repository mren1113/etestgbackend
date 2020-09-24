<%-- 
    Document   : header
    Created on : Jul 21, 2020, 11:42:36 PM
    Author     : ru-com7
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="th"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Etesting backend</title>
        <meta name="description" content="Ela Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
        <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="/etestgbackend/admin/assets/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="/etestgbackend/admin/assets/css/style.css">
        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
        <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css" rel="stylesheet" />

        <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
            />


        <style>
            #weatherWidget .currentDesc {
                color: #ffffff!important;
            }
            .traffic-chart {
                min-height: 335px;
            }
            #flotPie1  {
                height: 150px;
            }
            #flotPie1 td {
                padding:3px;
            }
            #flotPie1 table {
                top: 20px!important;
                right: -10px!important;
            }
            .chart-container {
                display: table;
                min-width: 270px ;
                text-align: left;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            #flotLine5  {
                height: 105px;
            }

            #flotBarChart {
                height: 150px;
            }
            #cellPaiChart{
                height: 160px;
            }

            .custom-file-upload {
                border: 1px solid #ccc;
                display: inline-block;
                padding: 6px 12px;
                cursor: pointer;
            }
            .scrollable-menu {
                height: auto;
                max-height: 200px;
                overflow-x: hidden;
            }
        </style>

        <script>
            function myFunction() {
                var txt;
                if (confirm("Confirm to save!")) {
                    txt = "Save OK!";

                    return true;
                } else {
                    txt = "You Cancel!";

                    return false;
                }
                document.getElementById("demo").innerHTML = txt;
            }

            function ChangeText(oFileInput, sTargetID) {

                document.getElementById(sTargetID).value = oFileInput.value;
            }


        </script>
    </head>
    <body>
        <!-- Left Panel -->
        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">
                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="/etestgbackend/admin/main.jsp"><i class="menu-icon fa fa-laptop"></i>Home Control panel </a>
                        </li>
                        <li class="menu-title"><i class="menu-icon fa fa-compass"></i> Components</li><!-- /.menu-title -->
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Setting Components</a>
                            <ul class="sub-menu children dropdown-menu">                            
                                <li><i class="fa fa-puzzle-piece"></i><a href="/etestgbackend/GetAdminCounter">Semester/Year</a></li>
                                <li><i class="fa fa-id-badge"></i></i><a href="/etestgbackend/ShowEditSeat">Files Setting</a></li>
                                <li><i class="fa fa-bars"></i></i><a href="#">xxxxxxxxxx</a></li>


                            </ul>
                        </li> 
                        <li class="menu-title"><i class="menu-icon fa fa-share"></i> Seat Managements</li><!-- /.menu-title -->

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Managements Menu</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li>
                                    <i class="menu-icon fa fa-fort-awesome"></i>
                                    <a href="/etestgbackend/ShowSeatDetail">Seat Setting</a>
                                </li>
                                <li>
                                    <i class="menu-icon fa fa-list-ol"></i>
                                    <a href="/etestgbackend/SeatManagement">กำหนดแถวทสอบ</a>
                                </li>
                                <li>
                                    <i class="menu-icon fa fa-calendar"></i>
                                    <a href="/etestgbackend/DateManagement">กำหนดวัน และที่นั่งสอบ</a>
                                </li>       
                                <li>
                                    <i class="menu-icon fa fa-money"></i>
                                    <a href="/etestgbackend/ReceiptManagement">ปรับสถานะการชำระเงิน</a>
                                </li>
                                <!--li><i class="menu-icon ti-themify-logo"></i><a href="#">xxxxxxxxxx</a></li -->
                            </ul>
                        </li> 
                        <li class="menu-title"><i class="menu-icon fa fa-share-square-o"></i> Export Files</li><!-- /.menu-title -->

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-files-o"></i>Export Files Menu</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-file-text"></i><a href="/etestgbackend/ExportETSTDC">ET_STDC</a></li>
                                <li><i class="menu-icon fa fa-file-text"></i><a href="/etestgbackend/ExportETRU25et">RU25et</a></li>
                                <!--li><i class="menu-icon ti-themify-logo"></i><a href="#">xxxxxxxxxx</a></li -->
                            </ul>
                        </li> 
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside>


        <!-- /#left-panel -->
        <!-- Right Panel -->
        <div id="right-panel" class="right-panel">
            <!-- Header-->
            <header id="header" class="header">
                <div class="top-left">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="./"><img src="/etestgbackend/admin/images/logo.png" alt="Logo"></a>
                        <a class="navbar-brand hidden" href="./"><img src="/etestgbackend/admin/images/logo2.png" alt="Logo"></a>
                        <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                    </div>
                </div>
                <div class="top-right">
                    <div class="header-menu">

                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${user.USER_NAME} &nbsp; <img class="user-avatar rounded-circle" src="/etestgbackend/admin/images/admin.jpg" alt="User Avatar"> 
                            </a>

                            <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="#"><i class="fa fa-power -off"></i>Logout</a>
                            </div>
                        </div>

                    </div>
                </div>
            </header>
            <!-- /#header -->