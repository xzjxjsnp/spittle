<%--
  Created by IntelliJ IDEA.
  User: xuzj001
  Date: 2018/6/4
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h1>Register</h1>

    <%--<form action="register" method="post">--%>
    <%--<form action="register" method="post">--%>
        <%--姓：<input type="text" name="LastName" /></br>--%>
        <%--名：<input type="text" name="FirstName" /></br>--%>
        <%--账号：<input type="text" name="username" /></br>--%>
        <%--密码：<input type="password" name="password" /></br>--%>

        <%--<input type="submit" value="注册"/>--%>
    <%--</form>--%>

    <sf:form method="post" commandName="spitter">
        姓:<sf:input path="LastName" /> <p style="color: red"><sf:errors path="LastName" /></p>

        名:<sf:input path="FirstName" /> <p style="color: red"><sf:errors path="FirstName"/></p>

        <%--电子邮箱:<sf:input path="email" /><br/>--%>

        账号:<sf:input path="username" /> <p style="color: red"><sf:errors path="username"/></p>

        密码:<sf:password path="password" /> <p style="color: red"><sf:errors path="password"/></p>

        <input type="submit" value="注册"/>
    </sf:form>
</body>
</html>
