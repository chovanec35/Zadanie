<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>Home</title>
        <spring:url value="/resources/theme/css/style.css" var="styles" />
        <link href="${styles}" rel="stylesheet" />
    </head>
    <body>
        ${path}<br>
        
        <h1>Welcome to Home Page!</h1>
        <a href="${path}/home">Home</a>
        <a href="${path}/login">Login</a>
        <a href="${path}/registration">Registration</a>
         <a href=" ${path}/resources/theme/css/styles.css">test</a>
        <c:if test="${user_Id} == 13">
            <a href="<c:url value="/logoutProcess" />">Log out</a>
        </c:if>
        <p>
            Here is description about this application.<br>
        </p>
    </body>
</html>
