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
        <a href="${path}/registration">Registration</a><br>

        <label style="color: red"> ${message} </label><br>
        <form method="POST" modelAttribute="login" action="${path}/my-contacts">
            <table>
                <tr>
                    <td>E-mail</td>
                    <td><input path="email" name="email" type="text" placeholder="E-mail"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input  path="password" name="password" type="password" placeholder="Password"/></td>
                </tr>
                <tr>
                    <td><button type="submit">Login</button></td>
                </tr>
                <tr>
                    <td><h4><a href="${path}/registration">Create an account</a></h4></td>
                </tr>                
            </table>
        </form>
        <table>
            
        </table>
    </body>
</html>