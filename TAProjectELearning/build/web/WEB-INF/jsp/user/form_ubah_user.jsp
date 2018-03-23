<%-- 
    Document   : form_ubah_user
    Created on : Mar 9, 2018, 7:11:39 PM
    Author     : Sou
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>Ubah User</h1>
        <form:form modelAttribute="userDto" name="form_user" method="POST" action="update_user.htm">
            <form:input path="id" placeholder="id" /><br/>
            <form:input path="username" placeholder="username" /><br/>
            <form:input path="password" placeholder="password" /><br/>
            <form:input path="firstname" placeholder="firstname" /><br/>
            <form:input path="lastname" placeholder="lastname" /><br/>
            <form:input path="email" placeholder="email" /><br/>
            <form:input path="skype" placeholder="skype" /><br/>
            <form:input path="yahoo" placeholder="yahoo" /><br/>
            <form:input path="phone1" placeholder="phone1" /><br/>
            <form:input path="phone2" placeholder="phone2" /><br/>
            <form:input path="institution" placeholder="institution" /><br/>
            <form:input path="department" placeholder="department" /><br/>
            <form:input path="address" placeholder="address" /><br/>
            <form:input path="city" placeholder="city" /><br/>
            <form:input path="country" placeholder="country" /><br/>
            <form:input path="timezone" placeholder="timezone" /><br/>
            <form:input path="firstaccess" placeholder="firstaccess" /><br/>
            <form:input path="lastaccess" placeholder="lastaccess" /><br/>
            <form:input path="lastlogin" placeholder="lastlogin" /><br/>
            <form:input path="currentlogin" placeholder="currentlogin" /><br/>
            <form:input path="picture" placeholder="picture" /><br/>
            <form:input path="description" placeholder="description" /><br/>
            <form:input path="timecreated" placeholder="timecreated" /><br/>
            <form:input path="timemodified" placeholder="timemodified" /><br/>
            <form:input path="imagealt" placeholder="imagealt" /><br/>
            <form:input path="lastnamephonetic" placeholder="lastnamephonetic" /><br/>
            <form:input path="firstnamephonetic" placeholder="firstnamephonetic" /><br/>
            <form:input path="middlename" placeholder="middlename" /><br/>
            <form:input path="alternatename" placeholder="alternatename" /><br/>
            <form:select path="id_role" >
                <option>Role</option>
                <c:forEach items="${listRole}" var="listData" >
                    <option value="${listData.id}">${listData.name}</option>
                </c:forEach>
            </form:select>
            
            <input type="submit" value="Simpan"/>
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
