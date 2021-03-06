<%-- 
    Document   : index
    Created on : Mar 15, 2018, 12:09:20 AM
    Author     : Sou
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <title>Halaman Dosen</title>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="admin.htm">Good Learner </a>
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
        <div class="subnavbar">
            <div class="subnavbar-inner">
                <div class="container">
                    <ul class="mainnav">
                        <li class="active"><a href="admin.htm"><i class="icon-dashboard"></i><span>Dashboard</span> </a> </li>
                        <!--<li><a href="view_role.htm"><i class="icon-user-md"></i><span>Role</span> </a> </li>-->
                        <li><a href="view_question.htm"><i class="icon-question"></i><span>Question</span> </a> </li>
                        <li><a href="view_answers.htm"><i class="icon-star"></i><span>Answers</span> </a> </li>
                        <li><a href="view_qa.htm"><i class="icon-tasks"></i><span>Question Answers</span> </a> </li>
                        <!--<li ><a href="view_level.htm"><i class="icon-signal"></i><span>Level</span> </a> </li>-->
                        <!--<li><a href="view_user.htm"><i class="icon-user"></i><span>User</span> </a> </li>-->
                        <li><a href="ubahStatusJumlahSoal.htm"><i class="icon-copy"></i><span>Menentukan Banyak Soal Per Level</span> </a> </li>
                        <li><a href="view_mahasiswa.htm"><i class="icon-eye-open"></i><span>Lihat Data Mahasiswa</span> </a> </li>
                        <li><a href="ubahStatusMateri.htm"><i class="icon-eye-open"></i><span>Status Materi</span> </a> </li>
                        <!--<li><a href="view_majors.htm"><i class="icon-th-large"></i><span>Majors</span> </a> </li>-->
                    </ul>
                </div>
                <!-- /container --> 
            </div>
            <!-- /subnavbar-inner --> 
        </div>
        <!-- /subnavbar -->
        <div>

            <div class="widget">
                <div class="widget-header "> <i class="icon-th-list"></i>
                    <h3>Dashboard</h3>
                </div>
                <div class="widget-content">
                    <center>
                        <h3>Selamat Datang <strong>${nama}</strong> di Halaman Dosen</h3>
                        <p>Anda memilik hak untuk mengakses menu di atas.</p>
                        <img src="resources/img/1.jpg" width="500px" height="500px"/>
                    </center>

                </div>
            </div>

        </div>
    </body>
    <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
    <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
    <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
    <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
</html>
