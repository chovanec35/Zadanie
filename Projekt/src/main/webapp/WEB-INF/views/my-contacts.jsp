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
        <div class="nav">
            <ul>
                <li><a href="${path}/my-contacts">My contacts</a></li>
                <li><a href="${path}/add-new-contact">Add new contact</a></li>
                <li><a href="<c:url value="/logoutProcess" />">Log out</a></li>
            </ul>
        </div>
        <label style="color: red"> ${message} </label><br>
        <div class="form">
            <form  class="form" method="POST" modelAttribute="contact" action="${path}/searchProcess">
                <div class="container">
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
                </div>
            </form>
        </div>
        <div class="form">
            <form method="POST" modelAttribute="contact" action="${path}/contactListProcess">
                <c:if test="${!empty contactsList}">
                    <div class="container">
                        <table class="table-contacts" >
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
                                    <td><button type="buton" name="infoContact" class="btn btn-primary details contactBtn" value=${contact.contactId} >
                                            Detail
                                        </button></td>
                                    <td><button class="contactBtn" type="submit" name="delContact" value=${contact.contactId} >Delete</button></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </form>
        </div>
        <!-- Modal -->
        <div class="modal">
            <h2>Contact detail</h2>
            --> ${contactL}
            <span class="close">&times</span>
            <table>
                <tr>
                    <td>First name: </td>
                    <td>${contact.firstName}</td>
                </tr>
                <tr>
                    <td>Last name: </td>
                    <td>${contact.lastName}</td>
                </tr>
                <tr>
                    <td>Decription: </td>
                    <td>${contact.description}</td>
                </tr>
                <tr>
                    <td>Birthdate: </td>
                    <td>${contact.birthdate}</td>
                </tr>
                <tr>
                    <td>Creation Date: </td>
                    <td>${contact.creationTs}</td>
                </tr>
            </table>
        </div>
        <script src="resources/theme/js/info.js"></script> 

    </body>
</html>