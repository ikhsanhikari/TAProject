<%-- 
    Document   : form_tambah_question
    Created on : Mar 9, 2018, 6:39:32 PM
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
<link href="<c:url value="/resources/css/pages/signin.css" />" rel="stylesheet" type="text/css">
<link rel="icon" href="<c:url value="/resources/img/green.png"/>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Assignment</title>
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

        <div class="account-container register">
            <div class="content clearfix">
                <form:form modelAttribute="qaDto" method="POST" action="save_question.htm">
                    <h1>Form Tambah Question Answers</h1>   	
                    <div class="login-fields">
                        <p>Isi form berikut</p>
                        <div class="field">
                            <form:input path="id" placeholder="ID Question"/><br/>
                        </div>
                        <div class="field">
                            <form:select path="id_quiz" >
                                <c:forEach items="${listQuiz}" var="data">
                                    <option value="${data.id}">${data.id}. ${data.name}</option>
                                </c:forEach>
                            </form:select><br/>
                        </div>
                        <div class="field">
                            <form:select path="id_answers" >
                                <c:forEach items="${listAnswer}" var="data">
                                    <option value="${data.id}">${data.id}. ${data.answers}</option>
                                </c:forEach>
                            </form:select><br/>
                        </div>
                        <div class="field">
                            <form:select path="id_level" >
                                <c:forEach items="${listLevel}" var="data">
                                    <option value="${data.id}">${data.id}. ${data.level}</option>
                                </c:forEach>
                            </form:select><br/>
                        </div>
                        <div class="field">
                            <form:select path="id_jenisSoal" >
                                <c:forEach items="${listJenisSoal}" var="data">
                                    <option value="${data.id}">${data.id}. ${data.jenisSoal}</option>
                                </c:forEach>
                            </form:select><br/>
                        </div>
                        <div class="field">
                            <form:select path="id_status" >
                                <option value="1">Benar</option>
                                <option value="0">Salah</option>
                            </form:select><br/>
                        </div>
                        <input type="submit" value="Submit"/>
                    </form:form>
                </div> <!-- .actions -->
            </div>
        </div> <!-- /content -->
    </div> <!-- /account-container -->

    <!--javascript-->
    <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
    <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
    <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
    <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
</body>
</html>
