<%-- 
    Document   : form_tambah_user
    Created on : Feb 24, 2018, 11:29:42 AM
    Author     : Sou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/pages/signin.css" />" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
<link rel="icon" href="<c:url value="/resources/img/green.png"/>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Tambah User</title>
    </head>
    <body>
        <form:form modelAttribute="userDto" name="form_user" method="POST" action="save_user.htm">
            <div class="navbar navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container">
                        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a class="brand" href="login.htm">Good Learner</a>	
<!--                        <div class="nav-collapse">
                            <ul class="nav pull-right">
                                <li class="">						
                                    <a href="login.htm" class="">Sudah punya akun? Login sekarang</a>

                                </li>
                                <li class="">						
                                    <a href="index.html" class="">
                                        <i class="icon-chevron-left"></i>Kembali ke Beranda
                                    </a>
                                </li>
                            </ul>
                        </div>/.nav-collapse 	-->
                    </div> <!-- /container -->
                </div> <!-- /navbar-inner -->
            </div> <!-- /navbar -->
    <!--        <p>User Sekarang adalah ${username} dengan password ${password} / silahkan log out untuk menghapus session ini</p>-->
            <div class="account-container register">
                <div class="content clearfix">
                    <form action="#" method="post">
                        <h1>Signup for Free Account</h1>
                        <div class="login-fields">
                            <p>Create your free account:</p>

                            <div class="field1">
                                <form:input path="username" required="true" placeholder="username" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="password" required="true" placeholder="password" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="firstname" required="true" placeholder="firstname" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="lastname" required="true" placeholder="lastname" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input type="email" path="email" required="true" placeholder="email" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="phone1" type="number" required="true" placeholder="phone1" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="institution" required="true" placeholder="institution" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="department" required="true" placeholder="department" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="address" required="true" placeholder="address" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="city" required="true" placeholder="city" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:hidden path="picture" value="1" placeholder="picture" class="login" style="height:40px;"/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:input path="description" required="true" placeholder="description" class="login" style="height:40px;"/><br/>
                            </div> <!-- /field -->
                            <div class="field1">
                                <form:select path="id_role" style="height:40px;" onchange="disableDosen()" id="role">
                                    <!--<option>Role</option>-->
                                    <c:forEach items="${listRole}" var="listData" >
                                        <option value="${listData.id}">${listData.name}</option>
                                    </c:forEach>
                                </form:select>
                            </div> <!-- /field -->
                            <div class="field1">
                                    <form:select path="dosen" style="height:40px;" id="dosen">
                                        <c:forEach items="${listDosen}" var="listData" >
                                            <option value="${listData.id}">${listData.firstname} ${listData.lastname}</option>
                                        </c:forEach>
                                    </form:select>
                            </div> <!-- /field -->
                            <input type="submit" value="Simpan"/>

                        </div> <!-- .actions -->
                    </form>
                </div> <!-- /content -->
            </div> <!-- /account-container -->
        </form:form>

        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
        <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
        <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>
        <script type="text/javascript">
            $( window ).load(function() {
                disableDosen();
            });
            function disableDosen(){
                var role = document.getElementById('role').value;
                console.log("role: " + role);
                if(role != 3){
                    console.log("masuk");
                    $('#dosen').prop('disabled', true);
                } else {
                    console.log("masuk else");
                    $('#dosen').prop('disabled', false);
                }
            }
        </script>
    </body>
</html>
