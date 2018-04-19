<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <%@ include file="parts/header.jsp"%> 
    <body>
        <h1>My contacts</h1>
        <ul>
            <li><a href="${path}/my-contacts">My contacts</a></li>
            <li><a href="${path}/add-new-contact">Add new contact</a></li>
            <li><a href="<c:url value="/logoutProcess" />">Log out</a></li>
        </ul>
        
        <label style="color: red"> ${message} </label><br>
        <form  class="form" method="POST" modelAttribute="contact" action="${path}/searchProcess">
            <table>
                <tr>
                    <td class="text">First name</td>
                    <td><input path="firstName" type="text" name="firstName" ></td>

                </tr>
                <tr>
                    <td class="text">Last name</td>
                    <td><input path="lastName" type="text" name="lastName" ></td>
                </tr>
                <tr>
                    <td class="text">Birthdate</td> 
                    <td><input type="date" path="birthdate" name="birthdate" ></td>
                </tr>
                <tr>
                    <td class="text">Category</td>
                    <td><select textarea path="category" name="category">
                            <option value=""></option>
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.categoryId}"><c:out value="${category.name}" /></option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Search</button></td>
                </tr>
            </table>
        </form>

        <form method="POST" modelAttribute="contact" action="${path}/deleteProcess">
            <c:if test="${!empty contactsList}">
                <table  class="form" class="table-contacts" >
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Category</th>
                        <th>Detail</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${contactsList}" var="contact">

                        <tr>
                            <td><c:out value="${contact.firstName}" /></td>
                            <td><c:out value="${contact.lastName}" /></td>
                            <td><c:out value="${contact.categoryId.name}" /></td>
                            <td><button type="submit" name="infoContact" value=${contact.contactId} >Info</button></td>
                            <td><button type="submit" name="delContact" value=${contact.contactId} >Delete</button></td>
                        </tr>

                    </c:forEach>
                </table>
            </c:if>
        </form>
    </body>
</html>


