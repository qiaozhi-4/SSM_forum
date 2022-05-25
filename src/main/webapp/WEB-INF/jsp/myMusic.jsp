<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
    <%--添加Bootstrap和fontawesome的样式--%>
    <link href="${$}/css/fontawesome-all.css" rel="stylesheet"/>
    <link href="${$}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${$}/css/userDefined.css" rel="stylesheet"/>
</head>
<body>
<form action="${$}/" method="post" class="mb-0">
    <div id="myMusicDiv1" class="row">
        <div class="col-2 display-flex-a-j">
            <img src="${$}/images/log.png" class="rounded-circle" width="50px">
            <a class="btn btn-link text-white text-decoration-none fs-2"
               href="${$}/">香菜音乐</a>
        </div>
        <div class="col-1"></div>
        <div class="col div1-3">
            <ul class="nav w-100 h-100 display-flex-a-j">
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/">发现音乐</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/myMusic?name=我喜欢的音乐">我的音乐</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/orderServlet">关注</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/orderServlet">音乐人</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j fs-5">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/orderServlet">下载客户端</a>
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
                        <a class="biao1 btn btn-link text-white text-decoration-none"
                           href="${$}/orderServlet">
                            <img src="${$}/${user.url}" class="rounded-circle"
                                 width="40px">
                        </a>
                    </c:if>
                    <c:if test="${empty user}">
                        <a class="btn btn-secondary btn-link text-white text-decoration-none"
                           href="${$}/loginPage">
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
<div id="myMusicDiv3" class="row h-100">
    <div class="col-4">
        <div>
            <h5>创建的歌单</h5>
            <c:forEach items="${musicLists}" var="musicList">
                <div class="mmd-3-3 row">
                    <div class="col-3 p-0 display-flex-a-j ps-2">
                        <img src="${$}/${musics[0].imgUrl}" width="50px"
                             height="50px">
                    </div>
                    <div class="col p-0">
                        <div class="h-50 pt-2">${musicList.name}</div>
                        <div class="h-50 pt-2 row">
                            <div class="col-6">${musicsInfo.total}首</div>
                            <div class="col">
                                <a class="btn btn-link text-decoration-none p-0">修改</a>
                                <a class="btn btn-link text-decoration-none p-0">删除</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="col border border-top-0 border-bottom-0 border-end-0">
        <div class="mmd3-2-1">
            <div class="mmd3-2-1-1">
                <img src="${$}/${musics[3].imgUrl}" width="100%">
            </div>
            <div class="mmd3-2-1-2">
                <div class="display-flex-a-j"><b>歌单</b></div>
                <div></div>
                <span>${musicLists[0].name}</span>
            </div>
            <div class="mmd3-2-1-3">
                <span class="fs-4">歌曲列表</span>
                <span>${musicsInfo.total}首</span>
            </div>
            <div class="mmd3-2-1-4">
                <span>播放次数：</span>
            </div>
        </div>
        <div style="height: 2px; background-image: linear-gradient(to right, #fbc2eb , #a6c1ee);"></div>
        <div class="mmd3-2-2">
            <table class="table">
                <thead>
                <tr>
                    <td></td>
                    <td>歌曲标题</td>
                    <td></td>
                    <td>歌手</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${musics}" var="music" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td colspan="2">${music.name}</td>
                        <td>${music.singer}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--添加boostrap和jquery的脚本--%>
<script src="${$}/js/jquery-3.6.0.js"></script>
<script src="${$}/js/bootstrap.bundle.js"></script>
<script src="${$}/js/fontawesome.js"></script>
<script>
</script>
</body>
</html>
