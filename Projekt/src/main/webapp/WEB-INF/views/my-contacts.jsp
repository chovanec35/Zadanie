<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="size" value="${size}"/>
<c:set var="countContacts" value="${countContacts}"/>

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
            <form  class="form1" method="POST" modelAttribute="contact" action="${path}/my-contacts">
                <div class="container">
                    <h2>Filter:</h2>
                    <table>
                        <tr>
                            <td class="text">First name</td>
                            <td><input path="firstName" type="text" name="firstName" value="${contactDto.firstName}"></td>
                        </tr>
                        <tr>
                            <td class="text">Last name</td>
                            <td><input path="lastName" type="text" name="lastName" value="${contactDto.lastName}"></td>
                        </tr>
                        <tr>
                            <td class="text">Birthdate</td> 
                            <td><input type="date" path="birthdate" name="birthdate" value="${contactDto.birthdate}"></td>
                        </tr>
                        <tr>
                            <td class="text">Category</td>
                            <td><select textarea path="category" name="category">
                                    <option value=""></option>a
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

                <div class="container" id="contactstable">
                    <table class="table-contacts" >
                        <tr>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Category</th>
                            <th>Detail</th>
                            <th>Delete</th>
                        </tr>
                        <c:if test="${!empty contactsList}">
                            <c:forEach items="${contactsList}" var="contact">
                                <tr class="contactrecord">
                                    <td><c:out value="${contact.firstName}" /></td>
                                    <td><c:out value="${contact.lastName}" /></td>
                                    <td><c:out value="${contact.categoryId.name}" /></td>
                                    <td><input onclick="detailAjax(${contact.contactId})" id="opener" value="Detail" type="submit" name="infoContact" class="btn btn-primary details contactBtn" ></td>
                                    <td><input onclick="deleteAjax(${contact.contactId})" id="opener" value="Delete" type="submit" name="deleteContact" class="btn btn-primary details contactBtn" ></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                    <div class="container">
                        <nav aria-label="Page navigation">
                            <ul class="pagination" id="pagination"></ul>
                        </nav>
                    </div>
                </div>

            </div>
        </div>
        <!-- Modal -->
        <div class="overlay" id="overlay">
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

            <div id="modalDialog">
                <p class="message">
                    Do you want to delete this contact?
                </p>
            </div>  
        </div>
    </div>
</body>
</html>

<script>
    var totalPages = '${size}';
    var countContacts = '${countContacts}';
    <%@ include file="/resources/theme/js/info.js" %>
    <%@ include file="/resources/theme/js/jquery.simplePagination.js" %>
</script>

