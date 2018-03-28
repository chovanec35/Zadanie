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
        <a href="${path}/my-contacts">My contacts</a>
        <a href="${path}/home">Logout</a>
    <form method="POST">
        <table>
                <tr>
                <td>First name</td>
                <td><input path="firstname" placeholder=${firstName} /></td>

            </tr>
            <tr>
                <td>Last name</td>
                <td><input path="lastname" placeholder= ${lastName} /></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input path="email" placeholder= ${email} /></td>
            </tr>
            <tr>
                <td>Birthdate</td>
                <td><input path="birthdate" placeholder= ${birthdate} /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" name="action" value="Add" />
                    <input type="submit" name="action" value="Edit" />
                    <input type="submit" name="action" value="Delete" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
