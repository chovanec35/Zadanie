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
        <a href="${path}/add-new-contact">Add new contact</a>
        <a href="${path}/home">Logout</a>
        
        <form method="POST" modelAttribute="contact" action="${path}/newContactProcess">
            <table>
                <tr>
                    <td>First name *</td> 
                    <td><input path="firstName" type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td>Last name *</td> 
                    <td><input path="lastName" type="text" name="lastName"></td>
                </tr>
                <!--                <tr>
                                    <td>Birthdate <input type="date" name="birthdate"></td>
                                </tr>-->
                <tr>
                    <td>Description</td> 
                    <td><textarea path="description" name="text-area" cols="30" rows="3"></textarea></td>
                </tr>              
                <tr>
                    <td>Category *</td> 
                    <td><select path="category" name="category">
                            <option value="1">Family</option>
                            <option value="2">Friends</option>
                            <option value="3">Job</option>
                        </select></td>
                </tr>
                <tr>
                    <td><button type="submit">Add new conntact</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
