<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>Welcome to Home Page!</h1>
        <a href="${path}/home">Home</a>
        <a href="${path}/login">Login</a>
        <a href="${path}/registration">Registration</a>
        
        <p>
            Here is description about this application.
        </p>
    </body>
</html>
