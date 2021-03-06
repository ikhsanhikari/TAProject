<%-- 
    Document   : quiz
    Created on : Mar 27, 2018, 10:13:41 PM
    Author     : IT
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
<link rel="icon" href="<c:url value="/resources/img/green.png"/>"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Quiz</title>
    </head>
    <body onload="setDisabled()">
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                            class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="halamanAwal.htm">Good Learner </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Knowledge - <b>${knowledge}</b> | </a>
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

        <div class="alert alert-info">
            Anda saat ini sedang menjalankan sesi <strong>Quiz</strong>.<br>
            Time Out : <span id="countdowntimer">60</span>
            <span class="pull-right">${materi}</span>
        </div>

        <div class="main">
            <div class="main-inner">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <div class="widget">
                                <div class="widget-header" style="margin-top:20px">
                                    <i class="icon-tasks"></i>
                                    <h3>Quiz | ${no}</h3>
                                    <h3 style="text-align:right">Id = ${id} . ${level}</h3>
                                </div> <!-- /widget-header -->

                                <div class="widget-content" style="height:350px">
                                    <form:form modelAttribute="reDto" method="GET" id="formQuiz" action="quiz.htm">
                                        <form:hidden path="id_collerger"/>
                                        <input type="hidden" name="noSoalParam" value="${no}"/>
                                        <input type="hidden" name="statusMasuk" value="0"/>
                                        <input type="hidden" name="action" value="Submit"/>
                                        <input type="hidden" name="idMateri" value="${idMateri}"/>
                                        <c:forEach var="data" items="${listQuiz}">
                                            <pre>${data.name} </pre>  
                                            <br/>
                                            
                                            <c:forEach var="dataA" items="${listAnswer}" >
                                                <form:radiobutton path="id_answer" value="${dataA.id_answer}"></form:radiobutton> . ${dataA.answer}<br/>
                                            </c:forEach>
                                            <c:if test="${stat==0}">
                                                <form:input path="short_answer" placeholder="Jawaban"/>
                                            </c:if>
                                        </c:forEach>
                                    </div> <!-- /widget-content -->     
                                    <br/>
                                    <!--<a href="view_historis.htm" class="btn btn-success">Selesai</a>-->
                                    <!--<input id="btnPrevious" type="submit" name="action" value="Previous" class="btn btn-primary"/>-->
                                    <input id="btnNext" type="submit" class="btn btn-primary"/>
                                </form:form>
                            </div> <!-- /widget -->	
                        </div> <!-- /spa12 -->
                    </div> <!-- /row -->
                </div> <!-- /container -->
            </div> <!-- /main-inner -->
        </div> <!-- /main -->

        <!--javascript-->
        <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script>
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
        <script>
            function setDisabled() {
                var btnPrevious = document.getElementById('btnPrevious');
                var btnNext = document.getElementById('btnNext');
                btnPrevious.disabled = true;
                btnNext.disabled = false;
            }
            
        </script>
        <script type="text/javascript">
            var timeleft = 60;
            var downloadTimer = setInterval(function(){
            timeleft--;

            document.getElementById("countdowntimer").textContent = timeleft;
            if(timeleft <= 0)
                clearInterval(downloadTimer);
                if(timeleft===0){
//                    alert("jadi");
                    $("#formQuiz").submit();
                }
            },1000);
        </script>
    </body>
</html>


