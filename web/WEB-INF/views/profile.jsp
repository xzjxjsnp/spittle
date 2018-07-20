<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuzj001
  Date: 2018/6/4
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<br>
    <h1>Your Profile</h1>
    <c:out value="${spitter.username}"/><br/>
    <c:out value="${spitter.lastName}" />
    <c:out value="${spitter.firstName}"/>
</html>
