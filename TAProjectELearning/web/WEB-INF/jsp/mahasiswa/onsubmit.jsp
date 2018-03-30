<%-- 
    Document   : onsubmit
    Created on : Mar 29, 2018, 9:03:15 PM
    Author     : Sou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
      rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/pages/dashboard.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/pages/faq.css" />" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Mahasiswa</title>
    </head>
    <body onload="setDisabled()">
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="loginAction.htm">Personalized E-learning </a>
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
            <table>
                <tr>
                    <td>
                        <a href="view_quiz.htm?idLevel=1">
                            <button id="btnLow" disabled class="btn btn-invert">
                                Low
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="view_quiz.htm?idLevel=2">
                            <button id="btnMedium" disabled class="btn btn-invert">
                                Medium
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="view_quiz.htm?idLevel=3">
                            <button id="btnHigh" disabled class="btn btn-invert">
                                High
                            </button>
                        </a>
                    </td>
                    <span class="pull-right">${materi}</span>
                </tr>
            </table>
        </div>


        <div class="main">
            <div class="main-inner">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <div class="widget">
                                <div class="widget-header" style="margin-top:20px">
                                    <i class="icon-tasks"></i>
                                    <h3>Exercise | Level ${idLevel} (${level})</h3>
                                </div> <!-- /widget-header -->
                                <div class="widget-content" style="height:350px">
                                    <form:form modelAttribute="reDto" method="GET" action="random_quiz.htm">
                                        <form:hidden path="id_collerger" />
                                        <input type="hidden" name="idLevel" value="${idLevel}"/>
                                        <c:forEach var="data" items="${listQuiz}" >
                                            Jawaban Untuk Soal <strong> ${data.name} </strong> adalah 
                                        </c:forEach>
                                        <strong>${jawaban_benar} </strong>
                                        <br/>
                                        jawaban Anda : ${jawaban_di_pilih} 
                                        <c:if test="${status==1}">
                                            (Benar)
                                        </c:if>
                                            <c:if test="${status==0}">
                                            (Salah)
                                        </c:if>
                                    </div> <!-- /widget-content -->     
                                    <br/>
<!--                                    <a  class="btn btn-success"  onclick="alertAnswer()">Submit</a>-->
                                    <!--<input class="btn btn-primary" type="submit" value="Submit"/>-->
                                    <c:url value="view_quiz.htm" var="v">
                                        <c:param name="idLevel" value="${idLevel}"></c:param>
                                        <c:param name="idMateri" value="${idMateri}"></c:param>
                                    </c:url>
                                    <a href="${v}" class="btn btn-primary" >Next</a>
                                </form:form>
                                <a href="view_informaion_of_exercise.htm" class="btn btn-success pull-right">Selesai</a>
                            </div> <!-- /widget -->	
                        </div> <!-- /spa12 -->
                    </div> <!-- /row -->
                </div> <!-- /container -->
            </div> <!-- /main-inner -->
        </div> <!-- /main -->

        <!--javascript-->
        <script type="text/javascript">
            function alertTry() {
                var tamp = document.getElementById('hikari');
                tamp.valueOf()
            }
            function alertAnswer() {
//                var x = document.getElementById("divAlert");
//                if (x.style.display === "none") {
//                    x.style.display = "block";
//                } else {
//                    x.style.display = "none";
//                }
                alert('-------'+${idLevel});
            }
        </script>
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

