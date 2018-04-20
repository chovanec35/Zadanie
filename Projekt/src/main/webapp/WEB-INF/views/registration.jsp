<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <%@ include file="parts/header.jsp"%> 
    <body>
        <h1>Registration form</h1>
        <div class="nav">
            <ul>
                <li><a href="${path}/home">Home</a></li>
                <li><a href="${path}/login">Login</a></li>
                <li><a href="${path}/registration">Registration</a></li>
            </ul>
        </div>
        <form:form  class="form" method="POST" modelAttribute="user" action="${path}/registrationProcess">
            <table>
                <tr>
                    <td class="text">First name</td>
                    <td><input path="firstName" type="text" name="firstName" value="" required="true" /></td>
                    <td><form:errors path="firstName" class="error" /></td>
                </tr>
                <tr>
                    <td class="text">Last name </td>
                    <td><input path="lastName" type="text" name="lastName" value="" required="true" /></td>
                    <td><form:errors path="lastName" class="error" /></td>
                </tr>
                <tr>
                    <td class="text">Birthdate</td> 
                    <td><input type="date" path="birthdate" name="birthdate" value="" required="true" /></td>       
                    <td><form:errors path="birthdate" class="error" /></td>
                </tr>
                <tr>
                    <td class="text">E-mail </td>
                    <td><input path="email" type="email" name="email" value="" required="true" /></td>
                    <td><form:errors path="email" class="error" /></td>
                </tr> 
                <tr>
                    <td class="text">Password </td>
                    <td><input path="password" type="password" name="password" value="" required="true" /></td>
                    <td><form:errors path="password" class="error" /></td>
                </tr>
                <tr>
                    <td class="text">Confirm Password</td>
                    <td><input path="confirmPassword" type="password" name="confirmPassword" value="" required="true" /></td>
                    <td><form:errors path="confirmPassword" class="error" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Registration</button></td>
                </tr>
            </table>
        </form:form>

    </body>
</html>
