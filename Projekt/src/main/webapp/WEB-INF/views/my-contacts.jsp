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
        <a href="<c:url value="/logoutProcess" />">Odhlasit sa</a>
        <p>
            my ID is: ${user_Id}
        </p>
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
                    <td>
                        <select name="category">
                            <option value="empty"></option>
                            <option value="1">Family</option>
                            <option value="2">Friends</option>
                            <option value="3">Job</option>
                        </select>
                    </td>
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
        <c:if test="${!empty userList}">
        <tablel>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Category</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value="${users.category}" /></td>
                </tr>
                
            </c:forEach>
        </tablel>
    </c:if>
</body>
</html>
