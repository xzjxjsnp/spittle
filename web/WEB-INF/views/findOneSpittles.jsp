<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuzj001
  Date: 2018/6/4
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find One Spittle</title>
</head>
<body>
    <h1>Find One Spittle</h1>

    <c:forEach items="${spittle}" var="spittle">
        <li id="spittle_<c:out value="spittle.id"/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"/></span>
                <span class="spittleLocation">
                    <c:out value="${spittle.latitude}"/>,
                    <c:out value="${spittle.longitude}"/>
                </span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
