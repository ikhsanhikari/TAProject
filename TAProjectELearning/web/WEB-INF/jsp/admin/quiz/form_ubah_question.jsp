<%-- 
    Document   : form_ubah_question
    Created on : Mar 9, 2018, 6:42:28 PM
    Author     : Sou
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Ubah Question</title>
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

        <div class="account-container register">
            <div class="content clearfix">
                <form:form modelAttribute="questionDto" method="POST" action="update_question.htm">
                    <h1>Form Ubah Question</h1>   	
                    <div class="login-fields">
                        <p>Isi form berikut</p>
                        <div class="field">
                            <form:input path="id" readonly="true" placeholder="ID Question"/><br/>
                        </div>
                        <div class="field">
                            <form:textarea path="name"  cols="10px" rows="5px" required="true"></form:textarea>
                        
                            <%--<form:input path="name" style="height:40px;" placeholder="Question"/>--%>
                        </div>
                        <div class="field">
                            <form:textarea  path="description"  placeholder="Description"  cols="10px" rows="5px"></form:textarea>
                        </div>
                        <div class="field">                            
                            <form:select path="id_matery" style="height:40px;"  id="id_matery">
                                <option  value="1">Sequensial </option>
                                <option  value="2">Kondisional</option>
                                <option  value="3">Perulangan </option>
                            </form:select>
                        </div>
                        <div class="field">
                            <form:select path="id_category" style="height:40px;" id="id_category">
                                <option value="1">Quiz</option>
                                <option value="2">Exercise</option>
                            </form:select>
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
    <script type="text/javascript">
        var idx = ${questionDto.id_matery};
        if(idx == 1){
            $("#id_matery").val(1);
        }else if(idx==2){
            $("#id_matery").val(2);
        }else{
            $("#id_matery").val(3);
        }
        
        var idxC = ${questionDto.id_category};
        if(idxC == 1){
            $("#id_category").val(1);
        }else{
            $("#id_category").val(2);
        }
        
    </script>
</body>
</html>
