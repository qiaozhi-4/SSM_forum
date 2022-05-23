<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
    <%--添加Bootstrap和fontawesome的样式--%>
    <link href="${pageContext.servletContext.contextPath}/css/fontawesome-all.css" rel="stylesheet"/>
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h1>Index主页测试</h1>
    <form action="${pageContext.servletContext.contextPath}/login" method="post">
        账号：<input  name="username" value="admin"><br>
        密码：<input type="password"  name="password" value="123"><br>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>
</div>

<%--添加boostrap和jquery的脚本--%>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fontawesome.js"></script>

</body>
</html>
