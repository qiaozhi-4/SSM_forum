<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
    <%--添加Bootstrap和fontawesome的样式--%>
    <link href="${pageContext.servletContext.contextPath}/css/fontawesome-all.css" rel="stylesheet"/>
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.servletContext.contextPath}/css/userDefined.css" rel="stylesheet"/>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/" method="post" class="mb-0">
    <div id="myMusicDiv1" class="row">
        <div class="col-2 display-flex-a-j">
            <img src="${pageContext.servletContext.contextPath}/images/log.png" class="rounded-circle" width="50px">
            <a class="btn btn-link text-white text-decoration-none fs-2"
               href="${pageContext.servletContext.contextPath}/">香菜音乐</a>
        </div>
        <div class="col-1"></div>
        <div class="col div1-3">
            <ul class="nav w-100 h-100 display-flex-a-j">
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/">发现音乐</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/myMusic?name=我喜欢的音乐">我的音乐</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/orderServlet">关注</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/orderServlet">音乐人</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j fs-5">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/orderServlet">下载客户端</a>
                </li>
                <li class="px-3 display-flex-a-j ">
                    <div class="row display-flex-a-j">
                        <div class="col-auto p-0">
                            <input type="text" class="form-control" name="username">
                        </div>
                        <div class="col-auto p-0">
                            <button type="submit"
                                    class="btn btn-link text-white text-decoration-none "
                                    data-bs-dismiss="modal">搜索
                            </button>
                        </div>
                    </div>
                </li>
                <li class="px-3 display-flex-a-j">
                    <c:if test="${not empty  user}">
                        <a class="biao1 btn btn-link text-white text-decoration-none"href="${pageContext.servletContext.contextPath}/orderServlet">
                            <img src="${pageContext.servletContext.contextPath}/${user.url}" class="rounded-circle" width="40px">
                        </a>
                    </c:if>
                    <c:if test="${empty user}">
                        <a class="btn btn-secondary btn-link text-white text-decoration-none"href="${pageContext.servletContext.contextPath}/loginPage">
                            登入
                        </a>
                    </c:if>
                </li>
            </ul>
        </div>
    </div>
</form>
<div id="myMusicDiv2" class="row">
    <div class="myMusicDiv2-1"></div>
    <div class="col display-flex-a-j" style="background-image: linear-gradient(to right, #fbc2eb , #a6c1ee);"></div>
</div>
<div id="myMusicDiv3" class="row">
    <div class="col-4">
        <div>
            <h5>创建的歌单</h5>
            <ul class="p-0 ">
                <c:forEach items="${musicLists}" var="musicList" >
                    <li>
                        <div class="row">
                            <div class="col-4 p-0">
                                <img src="${pageContext.servletContext.contextPath}/${musics[0].imgUrl}" class="rounded-circle" width="100%">
                            </div>
                            <div class="col">
                                <div class="h-50 pt-2">${musicList.name}</div>
                                <div class="h-50 pt-2">${musics.size()}首</div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col"></div>
</div>

<%--添加boostrap和jquery的脚本--%>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fontawesome.js"></script>
<script>
</script>
</body>
</html>
