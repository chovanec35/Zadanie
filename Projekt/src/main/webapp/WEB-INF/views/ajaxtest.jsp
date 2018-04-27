<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <%@ include file="parts/header.jsp"%> 
        <TITLE>Crunchify - Spring MVC Example with AJAX call</TITLE>
    </head>

    <body>
        <!--<form method="POST" modelAttribute="user" class="form-horizontal">-->
        <!--<div id="result">Tuuuu < /div>-->
            <button onclick="crunchifyAjax()" type="submit" >DETAIL</button>

            <!--</form>-->
            -- - > ${contact}
            < /body>
</html>