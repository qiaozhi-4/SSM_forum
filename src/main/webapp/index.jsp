<%--
  Created by IntelliJ IDEA.
  User: 18890
  Date: 2022/4/27
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <%--    添加bootstrap.css，和fontawesome-all.css的样式--%>
    <link href="${pageContext.servletContext.contextPath}/static/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/static/css/fontawesome-all.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/upload" method="post" enctype="multipart/form-data">
    图片：<input type="file" name="file"><br>
    <button type="submit" class="btn btn-primary">提交</button>
</form>
<form action="${pageContext.servletContext.contextPath}/getUser" method="post">
    请输入你要查询用户的id：<input  name="id" value="3"><br>
    <button type="submit" class="btn btn-primary">提交</button>
</form>

<table class="table table-success table-striped">
    <tr class="order">
        <td>订单号</td>
        <td>订单信息</td>
        <td>订单地址</td>
        <td>订单价格</td>
    </tr>
</table>
<hr>

</body>
<script src="${pageContext.servletContext.contextPath}/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/static/js/jquery-3.6.0.js"></script>
<script>
    let node;
    let orderNode = $('.order');
    $.post('orders')
        .done(function (data) {
            console.log('请求成功')
            console.log(data)
            if (data != null) {
                for (let i = 0; i < data.length; i++) {
                    /*复制表格行节点然后赋值*/
                    node = orderNode.clone()
                    node.children().eq(0).text(data[i].id)
                    node.children().eq(1).text(data[i].info)
                    node.children().eq(2).text(data[i].address)
                    node.children().eq(3).text(data[i].price)
                    //添加到最后面
                    $('tr:last').after(node)
                }
            }
        })
        .fail(data => console.log('请求失败'))
        .fail(data => console.log(data))
</script>
</html>
