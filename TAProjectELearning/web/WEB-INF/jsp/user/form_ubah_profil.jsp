<%-- 
    Document   : form_ubah_profil
    Created on : Jul 15, 2018, 1:31:48 PM
    Author     : hikari
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
<link rel="icon" href="<c:url value="/resources/img/green.png"/>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah User</title>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="admin.htm">Good Learner</a>
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
                                    <li><a href="profilAdmin.htm">Profile</a></li>
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
        <!--<h1>Ubah User</h1>-->
        <form:form modelAttribute="userDto" name="form_user" method="POST" action="update_profil.htm">
            <div class="account-container register">
                <div class="content clearfix">
                    <form action="#" method="post">
                        <h1>Ubah Profil</h1>
                        <div class="login-fields">
                            <div class="field1">
                                <form:input path="id" placeholder="id" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <!--                            <p>Create your free account:</p>-->

                            <div class="field1">
                                <form:input path="username" placeholder="username" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="password" placeholder="password" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="firstname" placeholder="firstname" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="lastname" placeholder="lastname" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="email" placeholder="email" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="phone1" placeholder="phone1" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="institution" placeholder="institution" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="department" placeholder="department" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="address" placeholder="address" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="city" placeholder="city" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="picture" placeholder="picture" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="description" placeholder="description" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:hidden path="idknowledge"   class="login" style="height:40px;"/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:hidden path="id_role"  placeholder="id role" class="login" style="height:40px;"/>
                            </div> <!-- /field -->
                            <form:hidden path="id" placeholder="id" />

                            <form:hidden path="firstaccess" placeholder="firstaccess" />
                            <form:hidden path="lastaccess" placeholder="lastaccess" />
                            <form:hidden path="lastlogin" placeholder="lastlogin" />
                            <form:hidden path="currentlogin" placeholder="currentlogin" />
                            <form:hidden path="timecreated" placeholder="timecreated" />
                            <form:hidden path="timemodified" placeholder="timemodified" />
                             <form:hidden path="idknowledge" placeholder="idknowledge" />
                            <input type="submit" value="Simpan"/>

                        </div> <!-- .actions -->
                    </form>
                </div> <!-- /content -->
            </div> <!-- /account-container -->
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
