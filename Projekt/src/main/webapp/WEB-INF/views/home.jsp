<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
    <%@ include file="parts/header.jsp"%> 
    <body>
        <h1>Welcome to Home Page!</h1>
        <a href="${path}/home">Home</a>
        <a href="${path}/login">Login</a>
        <a href="${path}/registration">Registration</a>
        <section>
        <h2>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</h2>
        
        <p>
            Sed lobortis sagittis elit sed ornare. Pellentesque ut porta metus, ut molestie risus. Suspendisse turpis nibh, eleifend ut mi tempus, pellentesque vehicula lacus. Duis egestas placerat arcu. Vestibulum gravida magna felis, nec volutpat lorem euismod vel. Aenean euismod elit sit amet rhoncus auctor. Mauris nec accumsan turpis. In feugiat, erat eu iaculis ultrices, urna mauris imperdiet sem, sit amet congue ligula dui quis leo. Maecenas orci quam, hendrerit in rutrum eget, hendrerit ut ex. Donec eu cursus sem. 
        </p>
        <p>
            Nullam cursus nisl id leo finibus, ac lacinia velit hendrerit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In faucibus dolor at posuere luctus. Praesent tristique imperdiet lectus ac cursus. Aliquam turpis nisl, lacinia ut fermentum id, sagittis quis lorem. Etiam mattis ligula massa. Nunc malesuada volutpat enim sed cursus. 
        </p> 
        <p>
            Dellentesque ut porta metus, ut molestie risus. Suspendisse turpis nibh, eleifend ut mi tempus, pellentesque vehicula lacus. Duis egestas placerat arcu. Vestibulum gravida magna felis, nec volutpat lorem euismod vel. Aenean euismod elit sit amet rhoncus auctor. Mauris nec accumsan turpis. In feugiat, erat eu iaculis ultrices, urna mauris imperdiet sem, sit amet congue ligula dui quis leo. Maecenas orci quam, hendrerit in rutrum eget, hendrerit ut ex. Donec eu cursus sem. 
        </p>
        </section>
    </body>
</html>
