<%-- 
    Document   : pra_exercise
    Created on : Mar 25, 2018, 12:07:29 AM
    Author     : IT
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
        <title>Pilihan Level Soal</title>
    </head>
    <body onload="setDisabled()">
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="halamanAwal.htm">Good Learner </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Knowledge - <b>${knowledge}</b> | </a>
                            </li>
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                        class="icon-user"></i> ${nama} <b class="caret"></b></a>
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
        <div class="alert alert-block">
            <p>Berikut level soal yang tersedia untuk Knowledge-mu.</p>
            <table>
                <tr>
                    <td>
                        <a href="view_quiz.htm?idLevel=1&idMateri=${idMateri}">
                            <button id="btnLow" disabled class="btn btn-invert">
                                Low
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="view_quiz.htm?idLevel=2&idMateri=${idMateri}">
                            <button id="btnMedium" disabled class="btn btn-invert">
                                Medium
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="view_quiz.htm?idLevel=3&idMateri=${idMateri}">
                            <button id="btnHigh" disabled class="btn btn-invert">
                                High
                            </button>
                        </a>
                    </td>
                <span class="pull-right">${materi}</span>
                </tr>
            </table>
        </div>

        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script>
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script>
        function setDisabled() {
            var btnLow = document.getElementById('btnLow');
            var btnMedium = document.getElementById('btnMedium');
            var btnHigh = document.getElementById('btnHigh');
            btnLow.disabled = ${nilaiDisabledLow};
            btnMedium.disabled = ${nilaiDisabledMedium};
            btnHigh.disabled = ${nilaiDisabledHigh};
        }
        </script>
    </body>
</html>
