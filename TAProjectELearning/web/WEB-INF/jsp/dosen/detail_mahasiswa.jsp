<%-- 
    Document   : detail_mahasiswa
    Created on : Jul 1, 2018, 1:34:16 PM
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
        <title>Halaman Profil</title>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="index.html">Personalized E-learning </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                        class="icon-cog"></i> Account <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:;">Settings</a></li>
                                    <li><a href="javascript:;">Help</a></li>
                                </ul>
                            </li>
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="icon-user"></i> ${nama} <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="profile.htm">Profile</a></li>
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
        <div class="widget-content ">
            Halaman profile ${listUser.firstname}
            <hr/>
            <div class="brand">
                <table cellpadding="10px">
                    <tr>
                        <td>
                            Username
                        </td>
                        <td>:</td>
                        <td>${listUser.username}</td>
                    </tr>
                    <tr>
                        <td>
                            Nama
                        </td>
                        <td>:</td>
                        <td>${listUser.firstname} ${listUser.lastname}</td>
                    </tr>
                    <!--                    <tr>
                                            <td>
                                                <h3 class="icon-phone"> Nomor Telepon </h3>
                                            </td>
                                            <td><h3>:</h3></td>
                                            <td><h3> ${listUser.phone1}</h3></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3 class="icon-building"> Institution</h3>
                                            </td>
                                            <td><h3>:</h3></td>
                                            <td><h3> ${listUser.institution}</h3></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3 class="icon-building"> Department</h3>
                                            </td>
                                            <td><h3>:</h3></td>
                                            <td><h3> ${listUser.department}</h3></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3 class="icon-road"> Address</h3>
                                            </td>
                                            <td><h3>:</h3></td>
                                            <td><h3> ${listUser.address}</h3></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h3 class="icon-flag"> City</h3>
                                            </td>
                                            <td><h3>:</h3></td>
                                            <td><h3> ${listUser.city}</h3></td>
                                        </tr>-->
                    
                    <tr>
                        <td>
                            Knowledge
                        </td>
                        <td>:</td>
                        <td>${knowledgeUmum}</td>
                    </tr>
                    <tr>
                        <td>
                            Sekuensial
                        </td>
                        <td>:</td>
                        <td>${knowledgeSekuensial}</td>
                    </tr>
                    <tr>
                        <td>
                            Kondisional
                        </td>
                        <td>:</td>
                        <td>${knowledgeKondisional}</td>
                    </tr>
                    <tr>
                        <td>
                            Perulangan
                        </td>
                        <td>:</td>
                        <td>${knowledgePerulangan}</td>
                    </tr>
                </table>

            </div>
            <!-- /shortcuts --> 
        </div>
        <!-- /widget-content --> 

        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
        <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
        <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
    </body>
</html>
