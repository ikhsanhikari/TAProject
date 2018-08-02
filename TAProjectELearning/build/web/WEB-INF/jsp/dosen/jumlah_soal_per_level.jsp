<%-- 
    Document   : jumlah_soal_per_level
    Created on : Jun 30, 2018, 10:08:46 AM
    Author     : hikari
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
      rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/pages/dashboard.css" />" rel="stylesheet">
<link rel="icon" href="<c:url value="/resources/img/green.png"/>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jumlah Soal Per level</title>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="viewDosen.htm">Good Learner </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                        class="icon-user"></i> ${nama} <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="profilDosen.htm">Profile</a></li>
                                    <li><a href="logout.htm">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse --> 
                </div>
                <!-- /container --> 
            </div>
            <!-- /navbar-inner --> 
        </div>
        <!-- /navbar -->
        <div class="alert alert-info">
            Status Jumlah Soal Per Level Saat Ini : <strong>${status}</strong><br/>
            Silahkan Pilih Jumlah Soal di Bawah ini untuk Mengubah
        </div>
        
        <div class="widget-content span12">
            <div class="shortcuts"> 
                <a href="ubahJumlah.htm?jumlah=2" class="shortcut"><i class="shortcut-icon icon-question"></i>
                    <span class="shortcut-label"> <strong>2</strong> Soal Per Level</span> 
                </a>
                <a href="ubahJumlah.htm?jumlah=3" class="shortcut"><i class="shortcut-icon icon-question"></i>
                    <span class="shortcut-label"> <strong>3</strong> Soal Per Level</span> 
                </a>
                <a href="ubahJumlah.htm?jumlah=4" class="shortcut"><i class="shortcut-icon icon-question"></i>
                    <span class="shortcut-label"> <strong>4</strong> Soal Per Level</span> 
                </a>
<!--                <a href="ubahJumlah.htm?jumlah=5" class="shortcut"><i class="shortcut-icon icon-question"></i>
                    <span class="shortcut-label"> <strong>5</strong> Soal Per Level</span> 
                </a>
                <a href="ubahJumlah.htm?jumlah=6" class="shortcut"><i class="shortcut-icon icon-question"></i>
                    <span class="shortcut-label"> <strong>6</strong> Soal Per Level</span> 
                </a>
                <a href="ubahJumlah.htm?jumlah=7" class="shortcut"><i class="shortcut-icon icon-question"></i>
                    <span class="shortcut-label"> <strong>7</strong> Soal Per Level</span> 
                </a>-->
            </div>
            <br/>
            <a  href="viewDosen.htm" class="btn btn-primary pull-right">Selesai</a>
            
            <!-- /shortcuts --> 
        </div>
        <!-- /widget-content --> 
        <br/>
        
        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
        <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
        <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
    </body>
</html>
