<%-- 
    Document   : pilihan_materi_quiz
    Created on : Mar 30, 2018, 7:49:38 PM
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
        <title>Halaman Mahasiswa</title>
    </head>
    <body onload="setDisabled()">
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="index.html">Personalized E-learning </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Knowledge - <b>${knowledge}</b> | </a>
                            </li>
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                        class="icon-cog"></i> Account <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:;">Settings</a></li>
                                    <li><a href="javascript:;">Help</a></li>
                                </ul>
                            </li>
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                        class="icon-user"></i> ${nama} <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:;">Profile</a></li>
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
            <p>Berikut materi yang dapat dipilih.</p>
            <table>
                <tr>
                    <td>
                        <a href="quiz.htm?statusMasuk=1&noSoalParam=1&action=0&idMateri=1">
                            <button id="btnSekuensial" disabled class="btn btn-invert">
                                Sekuensial
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="quiz.htm?statusMasuk=1&noSoalParam=1&action=0&idMateri=2">
                            <button id="btnKondisional" disabled class="btn btn-invert">
                                Kondisional
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="quiz.htm?statusMasuk=1&noSoalParam=1&action=0&idMateri=3">
                            <button id="btnPerulangan" disabled class="btn btn-invert">
                                Perulangan
                            </button>
                        </a>
                    </td>
                </tr>
            </table>
        </div> 

        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script>
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script>
        function setDisabled() {
            var btnSekuensial = document.getElementById('btnSekuensial');
            var btnKondisional = document.getElementById('btnKondisional');
            var btnPerulangan = document.getElementById('btnPerulangan');
            btnSekuensial.disabled = ${nilaiDisabledSekuensial};
            btnKondisional.disabled = ${nilaiDisabledKondisional};
            btnPerulangan.disabled = ${nilaiDisabledPerulangan};
        }
        </script>
    </body>
</html>

