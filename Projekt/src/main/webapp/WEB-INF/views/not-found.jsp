<%-- 
    Document   : notfound
    Created on : 13.3.2018, 11:02:31
    Author     : jchovanec
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <%@ include file="parts/header.jsp"%> 
    <body>
        <h1>Please login</h1>
        <div class="nav">
            <ul>
                <li><a href="${path}/home">Home</a></li>
                <li><a href="${path}/login">Login</a></li>
                <li><a href="${path}/registration">Registration</a></li>
            </ul>
        </div>
    </body>
</html>