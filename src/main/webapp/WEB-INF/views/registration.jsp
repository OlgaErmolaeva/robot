<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><spring:message code="label.form.title"></spring:message></title>
</head>
<body>
    <h1>
        <spring:message code="label.form.title"></spring:message>
    </h1>
    <form:form modelAttribute="user" method="POST" enctype="utf8">
        <br>
        <tr><td>
            <label>
              <spring:message code="label.user.name"></spring:message>
            </label>
        </td>
    <td><form:input path="name" value="" /></td>
    <form:errors path="name" element="div"/>
    </tr>

    <tr><td>
            <label>
                <spring:message code="label.user.login"></spring:message>
            </label>
        </td>
    <td><form:input path="login" value="" /></td>
    <form:errors path="login" element="div" />
    </tr>
    <tr><td>
            <label>
                <spring:message code="label.user.password"></spring:message>
            </label>
        </td>
    <td>
            <form:input path="password" value="" type="password" /></td>
    <form:errors path="password" element="div" />
    </tr>
    <tr><td>
            <label>
                <spring:message code="label.user.confirmPass"></spring:message>
            </label>
        </td>
    <td><form:input path="matchingPassword" value="" type="password" /></td>
    <form:errors element="div" />
    </tr>
        <button type="submit">
          <spring:message code="label.form.submit"></spring:message>
        </button>
    </form:form>
    <br>
    <a href="/loginPage" />
        <spring:message code="label.form.loginLink"></spring:message>
    </a>
</body>
</html>