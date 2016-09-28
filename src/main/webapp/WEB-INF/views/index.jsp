<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-8">
    <title>Robot</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">Library to search books<b class="caret"></b></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="../fetch/EMPIK">Empik</a></li>
                        <li><a href="../fetch/PUBLIO">Publio</a></li>
                        <li><a href="../fetch/PACT">Pact</a></li>
                        <li><a href="../fetch/HELION">Helion</a></li>
                    </ul>
                </li>
                <form class="navbar-form navbar-left">
                    <div class="dropdown">
                        <button class="btn btn-warning" type="button" id="dropdownMenu1" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="true">
                            Update information about promotions
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a href="../onDemand/EMPIK">Empik</a></li>
                            <li><a href="../onDemand/PUBLIO">Publio</a></li>
                            <li><a href="../onDemand/PACT">Pact</a></li>
                            <li><a href="../onDemand/HELION">Helion</a></li>
                        </ul>
                    </div>
                </form>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <div class="form-group">
                    <form id="login" action="/myProfile" method="get" class="navbar-form navbar-right">

                    </form>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <a href="javascript:document.getElementById('login').submit()" class="btn btn-success">Login</a>
                        <a href="../../register" class="btn btn-info">Sign up</a>
                    </c:if>

                    <c:url value="/logout" var="logoutUrl"/>
                    <form id="logout" action="${logoutUrl}" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="javascript:document.getElementById('logout').submit()"
                           class="btn btn-danger">Logout</a>
                        <a href="/myProfile" class="btn btn-info">My Profile</a>
                    </c:if>
            </ul>
        </div>
    </div>

</nav>
<h1> SHOW ${userName}</h1>
</body>
</html>