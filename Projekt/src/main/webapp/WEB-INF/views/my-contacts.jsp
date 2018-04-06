<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>My contacts</title>
    </head>
    <body>
        <h1>My contacts</h1>
        <a href="${path}/home">Home</a>
        <a href="${path}/my-contacts">My contacts</a>
        <a href="${path}/add-new-contact">Add new contact</a>
        <a href="<c:url value="/logoutProcess" />">Log out</a>
        <form method="POST">
            <table>
                <tr>
                    <td>First name</td>
                    <td><input path="firstname" /></td>

                </tr>
                <tr>
                    <td>Last name</td>
                    <td><input path="lastname" /></td>
                </tr>
                <tr>
                <td>Category</td>
                <td><select>
                    <option>${categoryList1}</option>
                </select></td>
                </tr>
                <!--            <tr>    
                                    <td>Birthdate</td>
                                    <td><input path="birthdate" /></td>
                                </tr>-->
                <tr>
                    <td><button type="submit">Search</button></td>
                </tr>
            </table>
        </form>

        <c:if test="${!empty contactsList}">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Category</th>
                    <th></th>
                </tr>
                <c:forEach items="${contactsList}" var="contact">

                    <tr>
                        <td><c:out value="${contact.fName}" /></td>
                        <td><c:out value="${contact.lName}" /></td>
                        <td><c:out value="${contact.role}" /></td>
                    </tr>

                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
