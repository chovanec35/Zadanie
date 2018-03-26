<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <a href="${path}/home">Home</a>
        <a href="${path}/login">Login</a>

        <form method="POST" action="${path}/login">

            <div>
                <input path="email" name="email" type="text" placeholder="E-mail"/><br>
                <input path="password" name="password" type="password" placeholder="Password"/><br>

                <button type="submit">Log In</button>
                <h4> <a href="${path}/registration">Create an account</a></h4>
            </div>

        </form>
    </body>
</html>