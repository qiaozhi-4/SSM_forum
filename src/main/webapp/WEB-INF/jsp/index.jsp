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
    <table class="table table-hover table-striped">
        <caption><i class="fas fa-bell"></i>所有用户列表（AJAX+JSON）</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>余额</th>
        </tr>
        </thead>
        <tbody id="users">
        </tbody>
    </table>
</div>

<%--添加boostrap和jquery的脚本--%>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fontawesome.js"></script>

<%--自定义脚本--%>
<script>
    // js脚本
    $.post("${pageContext.servletContext.contextPath}/users")
        .done(function (result) {
            console.log("加载成功：", result);
            if (! result.success) {
                alert("加载失败"); // 自定义
                return;
            }
            // 循环加载用户显示到页面
            for (let user of result.data) {
                // 先定义每个用户的标签字符串
                let tr = '<tr><td>' + user.id
                    + '</td><td>' + user.username
                    + '</td><td>' + user.money + '</td></tr>';
                // 然后作为节点追加到table节点
                $('#users').append(tr);
            }
        })
        .fail(function (err) {
            console.log("加载失败：", err);
        });
</script>
</body>
</html>
