<%-- 
    Document   : login
    Created on : Feb 12, 2018, 6:39:12 PM
    Author     : Sou
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <title>Form Login</title>
    </head>
    <body>
        <form:form modelAttribute="loginDto" name="formLogin" action="loginAction.htm" method="GET">
            <div class="navbar navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container">
                        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a class="brand" href="index.htm">Good Learner</a>
                        <div class="nav-collapse">
                            <ul class="nav pull-right">
                                <li class="">						
                                    <a href="signup.htm" class="">Buat Akun</a>
                                </li>
<!--                                <li class="">						
                                    <a href="index.html" class="">
                                        <i class="icon-chevron-left"></i>
                                        Kembali ke Beranda
                                    </a>
                                </li>-->
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="account-container">
                    <div class="content clearfix">
                        <form action="#" method="post">
                            <h1>Member Login</h1>	
                            <div class="login-fields">
                                <p>Isi form berikut</p>
                                <div class="field">
                                    <label for="username">Username</label>
                                    <form:input class="login username-field" path="username" style="height:40px;"/>
                                </div> <!-- /field -->

                                <div class="field">
                                    <label for="password">Password:</label>
                                    <form:input path="password" type="password" class="login password-field" style="height:40px;"/>
                                </div> <!-- /password -->
                            </div> <!-- /login-fields -->
                            <div class="login-actions">
                                <span class="login-checkbox">
                                    <label class="choice" style="font-size: 11px; color: red" for="Field">${pesan}</label>
                                </span>
                                <input class="button btn btn-success btn-large" type="submit" value="Masuk"/>
                            </div> <!-- .actions -->
                        </form>
                    </div> <!-- /content -->
                </div> <!-- /account-container -->
                <div class="login-extra">
                </div> <!-- /login-extra -->
            </form:form>

            <script type="text/javascript" href="<c:url value="/resources/js/jquery-1.7.2.min.js" />"></script>
            <script type="text/javascript" href="<c:url value="/resources/js/bootstrap.js" />"></script>
            <script type="text/javascript" href="<c:url value="/resources/js/signin.js" />"></script>
    </body>
</html>
