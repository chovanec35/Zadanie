<%-- 
    Document   : add-new-contact
    Created on : 13.3.2018, 9:05:13
    Author     : jchovanec
--%>

<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>New contact</title>

    </head>
    <body>
        <h1>New contact</h1>
        <a href="${path}/my-contacts">My contacts</a>
        <a href="${path}/home">Logout</a>
        <form>
            First name * <input type="text" name="name"><br/>
            Last name * <input type="text" name="last-name"><br/>
            Birthdate <input type="date" name="birthdate"><br/>
            Description <textarea name="text-area" cols="30" rows="3"></textarea><br/>
            Category * <select name="category"><br/>
                <option value="men">Family</option>
                <option value="woman">Friends</option>
                <option value="other">Job</option>
            </select><br/>
            <input type="submit" value="Add new contact">
        </form>
    </body>
</html>
