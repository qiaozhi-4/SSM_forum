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
<form action="${$}/fuzzy" method="post" class="mb-0">
    <div id="myMusicDiv1" class="row">
        <div class="col-2 display-flex-a-j">
            <img src="${$}/images/109951163327265762.jpg" class="rounded-circle" width="50px">
            <a class="btn btn-link text-white text-decoration-none fs-2"
               href="${$}/">呆毛音乐</a>
        </div>
        <div class="col-1"></div>
        <div class="col div1-3">
            <ul class="nav w-100 h-100 display-flex-a-j">
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/">发现音乐</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/myMusic?name=我喜欢的音乐">我的音乐</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/myAttention">关注</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/">音乐人</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j fs-5">
                    <a class="btn btn-link text-white text-decoration-none fs-5"
                       href="${$}/">下载客户端</a>
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
                <li class="toImg px-3 display-flex-a-j">
                    <c:if test="${not empty  user}">
                        <a class="btn btn-link text-white text-decoration-none">
                            <img src="${$}/${user.url}" class="rounded-circle"
                                 width="40px">
                        </a>
                        <div class="li-div hidden">
                            <div></div>
                            <ul class="p-0">
                                <li class="display-flex-a-j my-2">
                                    <a class="btn btn-link text-white text-decoration-none"
                                       href="${pageContext.servletContext.contextPath}/myIndex">
                                        个人主页
                                    </a>
                                </li>
                                <li class="display-flex-a-j my-2">
                                    <a class="btn btn-link text-white text-decoration-none"
                                       href="${pageContext.servletContext.contextPath}/mySet">
                                        个人设置
                                    </a>
                                </li>
                                <li class="display-flex-a-j my-2">
                                    <a class="btn btn-link text-white text-decoration-none"
                                       href="${pageContext.servletContext.contextPath}/logout">
                                        退出
                                    </a>
                                </li>
                            </ul>
                        </div>
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
    <div class="col display-flex-a-j" style="background-image: linear-gradient(to right, #fbc2eb , #a6c1ee);"></div>
</div>
<div id="fuzzy3" class="">
    <div class="col border border-top-0 border-bottom-0 border-end-0">
        <div class="mmd3-2-1">
            <form action="${$}/fuzzy" method="post" class="mb-0">
                <div class="row formSo">
                    <div class="col-8 p-0">
                        <input id="inputSo" type="text" class="form-control" name="musicName">
                    </div>
                    <div class="col p-0">
                        <button type="submit" id="soSuo"
                                class="btn btn-link text-decoration-none "
                                data-bs-dismiss="modal">搜索
                        </button>
                    </div>
                </div>
            </form>
            <c:if test="${not empty musics}">
                <div class="mmd3-2-1-1">
                    <img src="${$}/${musics[0].imgUrl}" width="100%">
                </div>
            </c:if>
            <div class="mmd3-2-1-3">
                <span class="fs-4">歌曲列表</span>
                <span>搜索'${str}'，找到${musicsInfo.total}首</span>
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
                        <td colspan="2"><a class="text-dark text-decoration-none" href="">${music.name}</a></td>
                        <td><a class="text-dark text-decoration-none" href="">${music.singer}</a></td>
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
    $('.toImg').hover(function () {
        $('.li-div').toggleClass('hidden');
    });
</script>
</body>
</html>
