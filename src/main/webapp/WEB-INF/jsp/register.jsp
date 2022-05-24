<%--
  Created by IntelliJ IDEA.
  User: 18890
  Date: 2022/5/24
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>


<%--添加Bootstrap和fontawesome的样式--%>
    <link href="${pageContext.servletContext.contextPath}/css/fontawesome-all.css" rel="stylesheet"/>
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet"/>

</head>
<body>
<div id="loginDiv">
    <h2>堆叠表单</h2>
    <form actio n="">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">昵称:</label>
            <input type="text" class="form-control" id="name" placeholder="请输入昵称" name="name">
        </div>
        <div class="mb-3 mt-3">
            <label for="username" class="form-label">账号:</label>
            <input type="text" class="form-control" id="username" placeholder="请输入账号" name="username">
        </div>
        <div class="mb-3">
            <label for="pwd1" class="form-label">密码:</label>
            <input type="password" class="form-control" id="pwd1" placeholder="请输入密码" name="password1">
        </div>
        <div class="mb-3">
            <label for="pwd2" class="form-label">确认密码:</label>
            <input type="password" class="form-control" id="pwd2" placeholder="请再次输入密码" name="password2">
        </div>
        <button type="submit" class="btn btn-primary">注册</button>
    </form>
</div>
</body>



<%--添加boostrap和jquery的脚本--%>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fontawesome.js"></script>


</html>
