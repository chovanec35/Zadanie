<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration form</h1>
        <a href="${path}/home">Home</a>
        <a href="${path}/login">Login</a>
        
        <form action="" method="post">
            First name <input type="text" name="first-name" value=""/><br/>
            Last name <input type="text" name="last-name" value=""/><br/>
            E-mail <input type="email" name="email" value=""/><br/>
            Birthdate <input type="date" name="birthdate" value=""/><br/>
            Password <input type="password" name="password" value=""/><br/>
            Confirm Password <input type="password" name="conf-password" value=""/><br/>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
