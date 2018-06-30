<%-- 
    Document   : view_level
    Created on : Mar 9, 2018, 6:36:31 PM
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
        <title>View Level </title>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="index.html">Good Learner </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
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
                        <form class="navbar-search pull-right">
                            <input type="text" class="search-query" placeholder="Search">
                        </form>
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
                        <li ><a href="admin.htm"><i class="icon-dashboard"></i><span>Dashboard</span> </a> </li>
                        <li><a href="view_role.htm"><i class="icon-user-md"></i><span>Role</span> </a> </li>
                        <li><a href="view_question.htm"><i class="icon-question"></i><span>Question</span> </a> </li>
                        <li><a href="view_answers.htm"><i class="icon-star"></i><span>Answers</span> </a> </li>
                        <li><a href="view_qa.htm"><i class="icon-tasks"></i><span>Question Answers</span> </a> </li>
                        <li class="active"><a href="view_level.htm"><i class="icon-signal"></i><span>Level</span> </a> </li>
                        <li><a href="view_user.htm"><i class="icon-user"></i><span>User</span> </a> </li>
                        <li><a href="view_majors.htm"><i class="icon-th-large"></i><span>Majors</span> </a> </li>
                    </ul>
                </div>
                <!-- /container --> 
            </div>
            <!-- /subnavbar-inner --> 
        </div>
        <!-- /subnavbar -->

        <p><a href="form_tambah_level.htm">Tambah Level</a></p>
        <!-- /widget -->
        <div class="widget widget-table action-table">
            <div class="widget-header"> <i class="icon-th-list"></i>
                <h3>Daftar Level</h3>
            </div>
            <!-- /widget-header -->
            <div class="widget-content">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th width="100px"> Id Level </th>
                            <th width="100px"> Level </th>
                            <th class="td-actions"> Action </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="data" items="${listLevel}">
                            <c:url var="delete" value="delete_level.htm">
                                <c:param name="id" value="${data.id}"/>
                            </c:url>
                            <c:url var="update" value="form_ubah_level.htm">
                                <c:param name="id" value="${data.id}"/>
                            </c:url>
                            <tr>
                                <td>${data.id}</td>
                                <td>${data.level}</td>
                                <td class="td-actions"><a href="${update}" class="btn btn-small btn-success"><i class="btn-icon-only icon-edit"> </i></a><a href="${delete}" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- /widget-content --> 
        </div>

        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
        <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
        <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
    </body>
</html>
