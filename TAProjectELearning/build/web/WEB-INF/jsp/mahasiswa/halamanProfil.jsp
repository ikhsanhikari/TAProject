<%-- 
    Document   : halamanProfil
    Created on : Mar 29, 2018, 11:25:06 PM
    Author     : Sou
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
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="halamanAwal.htm">Good Learner </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
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
            Halaman profile ${nama}
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
                        <td>${nama}</td>
                    </tr>
          
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
                    <tr>
                        <td>Email</td>
                        <td>:</td>
                        <td>${listUser.email}  </td>
                    </tr>
                    <tr>
                        <td>Nomor Telepon</td>
                        <td>:</td>
                        <td>${listUser.phone1}  </td>
                    </tr>
                    <tr>
                        <td>Institution</td>
                        <td>:</td>
                        <td>${listUser.institution}  </td>
                    </tr>
                    <tr>
                        <td>Jurusan</td>
                        <td>:</td>
                        <td>${listUser.department}  </td>
                    </tr>
                    <tr>
                        <td>Alamat</td>
                        <td>:</td>
                        <td>${listUser.address}  </td>
                    </tr>
                    <tr>
                        <td>Kota</td>
                        <td>:</td>
                        <td>${listUser.city}  </td>
                    </tr>
                </table>
                    <!--<br/>-->
            </div>
            <div class="widget-content ">Berikut adalah model untuk Knowledge mu :</div>
            <div class="widget-content">
                Model untuk materi Sekuensial :
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="data" items="${listModelSekuensial}">
                            <tr>
                                <td>${data[0]}</td>
                                <td>${data[1]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
                    
            <div class="widget-content">
                Model untuk materi Kondisional :
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="data" items="${listModelKondisional}">
                            <tr>
                                <td>${data[0]}</td>
                                <td>${data[1]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
                    
            <div class="widget-content">
                Model untuk materi Perulangan :
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="data" items="${listModelPerulangan}">
                            <tr>
                                <td>${data[0]}</td>
                                <td>${data[1]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <a href="edit_profil.htm" class="btn btn-primary pull-right">Ubah Profil</a>
            <!-- /shortcuts --> 
        </div>
<!--        <pre>
  Keterangan Tambahan : 
  Email               : ${listUser.email}                   Jurusan       : ${listUser.department} 
  Nomor Telepon       : ${listUser.phone1}                  Alamat        : ${listUser.address} 
  Institution         : ${listUser.institution}             Kota          : ${listUser.city}
        </pre>-->
        <!-- /widget-content --> 

        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
        <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
        <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
    </body>
</html>