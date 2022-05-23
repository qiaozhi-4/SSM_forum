<%--
  Created by IntelliJ IDEA.
  User: 18890
  Date: 2022/5/17
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登录成功</h2>
<h3>你好：${user.username}</h3>
<div><a href="logout">退出登陆</a></div>

<shiro:guest>游客显示</shiro:guest>
<shiro:authenticated><shiro:principal/>已登录会显示</shiro:authenticated>
<shiro:hasRole name="admin">角色:管理员</shiro:hasRole>
<shiro:hasRole name="user">角色:普通用户</shiro:hasRole>
</body>

<script src="${pageContext.servletContext.contextPath}/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/static/js/jquery-3.6.0.js"></script>
<script>
</script>
</html>
