<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <%@ include file="parts/header.jsp"%> 
    <body>
        <h1>Login</h1>
        <div class="nav">
            <ul>
                <li><a href="${path}/home">Home</a></li>
                <li><a href="${path}/login">Login</a></li>
                <li><a href="${path}/registration">Registration</a></li>
            </ul>
        </div>
        <label style="color: red"> ${message} </label><br>
        <div class="form">
            <form method="POST" modelAttribute="login" action="${path}/loginProcess">

                <div class="container">
                    <table> 
                        <tr>
                            <td class="text">E-mail</td>
                            <td><input path="email" name="email" type="text" placeholder="E-mail"/></td>
                        </tr>
                        <tr>
                            <td class="text">Password</td>
                            <td><input  path="password" name="password" type="password" placeholder="Password"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button type="submit">Login</button></td>
                        </tr>
                        <tr>
                            <td>Not registered? </td><td><a id="account" href="${path}/registration">Create an account</a></td>
                        </tr>                
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>