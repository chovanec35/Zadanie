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

        <form method="POST" modelAttribute="user" action="${path}/registrationProcess">
            <table>
<!--                <tr>
                    <td><input path="user_id" type="hidden" name="user_id" value="6" /></td>
                </tr>-->
<!--                <tr>
                    <td><input path="deleted" type="hidden" name="deleted" value="false"/></td>
                </tr>-->
                <tr>
                    <td>First name <input path="firstName" type="text" name="firstName" value=""/></td>
                </tr>
                <tr>
                    <td>Last name <input path="lastName" type="text" name="lastName" value=""/></td>
                </tr>

                <!--                               
                <tr>
                    <td>Birthdate <input type="date" name="birthdate" value=""/></td>                    
                </tr>
                -->

                <tr>
                    <td>E-mail <input path="email" type="email" name="email" value=""/></td>
                </tr> 
                <tr>
                    <td>Password <input path="password" type="password" name="password" value=""/></td>
                </tr>
                <!--                <tr>
                                    <td>Confirm Password <input type="password" name="confirmPassword" value=""/></td>
                                </tr>-->
                <tr>
                    <td><button type="submit">Registration</button></td>
                </tr>
            </table>
        </form>

    </body>
</html>
