<%-- 
    Document   : index.jsp
    Created on : Feb 24, 2018, 10:56:22 AM
    Author     : Sou
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
      rel="stylesheet">
<link href="<c:url value="resources/css/font-awesome.css"/>" rel="stylesheet">
<link href="<c:url value="resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="resources/css/pages/dashboard.css"/>" rel="stylesheet">
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                        class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="index.html">Good Learner</a>
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
            </div>
        </div>
    </div>
    <h1>Hello ${nama} Passsword anda ${password} anda sebagai ${role} (Dosen)</h1>
    <p><a href="logout.htm">Log Out</a></p>

    <!--javascript-->
    <script src="<c:url value="resources/js/jquery-1.7.2.min.js"/>"></script> 
    <script src="<c:url value="resources/js/excanvas.min.js"/>"></script> 
    <script src="<c:url value="resources/js/chart.min.js"/>" type="text/javascript"></script> 
    <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value="resources/js/full-calendar/fullcalendar.min.js"/>"></script>

    <script src="js/base.js"></script> 
</body>
</html>
