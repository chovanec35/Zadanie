<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <%@ include file="parts/header.jsp"%> 
    <script src="resources/theme/js/info.js"></script>
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
        <div class="row">
            <form  class="form1" method="POST" modelAttribute="contact" action="${path}/searchProcess">
                <div class="container">
                    <h2>Filter</h2>
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

            <div class="form1">
                <h2>Contacts:</h2>
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
                                    <td><input onclick="detailAjax(${contact.contactId})" id="opener" value="Detail" type="submit" name="infoContact" class="btn btn-primary details contactBtn" ></td>
                                    <td><input onclick="deleteAjax(${contact.contactId})" id="opener" value="Delete" type="submit" name="deleteContact" class="btn btn-primary details contactBtn" ></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <ul id="pagin">
                            <li><a href="#">prev</a></li>
                            <c:forEach var = "i" begin = "1" end = "${size}">
                                <li><a href="${path}/my-contacts?page=${i}">${i}</a></li>
                            </c:forEach>
                            <li><a href="#">next</a></li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal" id="result">
            <span class="close" onclick="closeModal()" >&times;</span>
            <h2>Contact detail</h2>
            <table>
                <tr>
                    <td>First name: </td>
                    <td id="fName"></td>
                </tr>
                <tr>
                    <td>Last name: </td>
                    <td id="lName"></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td id="description"></td>
                </tr>
                <tr>
                    <td>Birthdate: </td>
                    <td id="birthdate"></td>
                </tr>
                <tr>
                    <td>Creation Date: </td>
                    <td id="creationTs"></td>
                </tr>
            </table>            
        </div>


    </body>
</html>