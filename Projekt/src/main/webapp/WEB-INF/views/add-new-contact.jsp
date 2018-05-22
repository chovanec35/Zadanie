<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <%@ include file="parts/header.jsp"%> 
    <body>
        <h1>New contact</h1>
        <ul>
            <li><a href="${path}/my-contacts">My contacts</a></li>
            <li><a href="${path}/add-new-contact">Add new contact</a></li>
            <li><a href="<c:url value="/logoutProcess" />">Log out</a></li>
        </ul>
        <label style="color: red; font-size: 20px"> ${success} </label><br>
        <form  class="form" method="POST" modelAttribute="contact" action="${path}/newContactProcess">
            <table>
                <tr>
                    <td class="text">First name *</td> 
                    <td><input path="firstName" type="text" name="firstName" value="" required="true"></td>
                </tr>
                <tr>
                    <td class="text">Last name *</td> 
                    <td><input path="lastName" type="text" name="lastName" value="" required="true"></td>
                </tr>
                <tr>
                    <td class="text">Birthdate</td> 
                    <td><input type="date" path="birthdate" name="birthdate" value="" ></td>
                    <td><form:errors path="birthdate" class="error" /></td>
                </tr>
                <tr>
                    <td class="text">Description</td> 
                    <td><textarea path="description" name="description" cols="30" rows="3"></textarea></td>
                </tr>              
                <tr>
                    <td class="text">Category</td>
                    <td><select textarea path="category" name="category">
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.categoryId}"><c:out value="${category.name}" /></option>
                            </c:forEach>
                        </select></td>                        
                </tr>
                <tr>
                    <td></td>
                    <td><button onclick="addContact()" type="submit" >Add new contact</button></td>
                </tr>
            </table>
        </form>
        <div class="overlay" id="overlay1">
            <div id="modalDeleteUser">
                <p class="message">
                    Contact added!
                </p>
            </div>
        </div>
    </body>
</html> 
