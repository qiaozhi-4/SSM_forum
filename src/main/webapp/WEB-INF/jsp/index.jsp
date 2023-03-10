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
<body style="background-image: linear-gradient(to right, #81F7F3 , #F2F5A9);">
<form action="${pageContext.servletContext.contextPath}/fuzzy" method="post" class="mb-0">
    <div id="div1" class="row">
        <div class="col-2 display-flex-a-j">
            <img src="${pageContext.servletContext.contextPath}/images/109951163327265762.jpg" class="rounded-circle"
                 width="50px">
            <a class="btn btn-link text-white text-decoration-none fs-2"
               href="${pageContext.servletContext.contextPath}/">呆毛音乐</a>
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
                       href="${pageContext.servletContext.contextPath}/myAttention">关注</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/">音乐人</a>
                </li>
                <li class="li-hover px-3 display-flex-a-j fs-5">
                    <a class="biao1 btn btn-link text-white text-decoration-none fs-5"
                       href="${pageContext.servletContext.contextPath}/">下载客户端</a>
                </li>
                <li class="px-3 display-flex-a-j ">
                    <div class="row display-flex-a-j">
                        <div class="col-auto p-0">
                            <input type="text" class="form-control" name="musicName">
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
                            <img src="${pageContext.servletContext.contextPath}/${user.url}" class="rounded-circle"
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
                           href="${pageContext.servletContext.contextPath}/loginPage">
                            登入
                        </a>
                    </c:if>
                </li>
            </ul>
        </div>
    </div>
</form>
<div id="div2" class="row">
    <div class="div2-1"></div>
    <div class="col display-flex-a-j" style="background-image: linear-gradient(to right, #fbc2eb , #a6c1ee);">
        <div class="div2-3-1">
            <ul class="nav">
                <li class="px-5 display-flex-a-j">推荐</li>
                <li class="px-5 display-flex-a-j">排行榜</li>
                <li class="px-5 display-flex-a-j">歌单</li>
                <li class="px-5 display-flex-a-j">主播电台</li>
                <li class="px-5 display-flex-a-j">歌手</li>
            </ul>
        </div>
    </div>
</div>
<div id="carouselExampleDark" class="div3 carousel carousel-dark slide h-50" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="3" aria-label="Slide 4"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="4" aria-label="Slide 5"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468567569.jpg"
                 class="d-block w-100 h-100" alt="..." style="filter: blur(100px)">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468567569.jpg"
                 class="img1 d-block w-75 h-100" alt="...">
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468487275.jpg"
                 class="d-block w-100 h-100" alt="..." style="filter: blur(100px)">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468487275.jpg"
                 class="img1 d-block w-75 h-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468514107.jpg"
                 class="d-block w-100 h-100" alt="..." style="filter: blur(100px)">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468514107.jpg"
                 class="img1 d-block w-75 h-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468538175.jpg"
                 class="d-block w-100 h-100" alt="..." style="filter: blur(100px)">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468538175.jpg"
                 class="img1 d-block w-75 h-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.servletContext.contextPath}/images/109951167468551304.jpg"
                 class="d-block w-100 h-100" alt="..." style="filter: blur(100px)">
            <img src="${pageContext.servletContext.contextPath}/images/拉克丝狗年限定.jpg"
                 class="img1 d-block w-75 h-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<div class="container h-75">
    <div class="h-100">
        <ul class="nav h-100 row" style="color: white">
            <li class="p-lg-3 h-100 col">
                <div class="h-100" style="background-color: #D9889F">
                    <div class="display-flex-a-j fs-1" style="height: 20%">巅峰榜</div>
                    <div class="display-flex-a-j fs-1" style="height: 20%">人气</div>
                    <div class="mx-lg-2" style="margin-bottom: 1.5rem">
                        <div>1. 落</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp艾辰</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>2. 自我的疗伤</div>
                        <div class="">&nbsp&nbsp&nbsp&nbspM哥</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>3. 要远的你</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp221小伙伴</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>4. 冷</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp莫文蔚</div>
                    </div>
                </div>
            </li>
            <li class="p-lg-3 h-100 col">
                <div class="h-100" style="background-color: #7196B0">
                    <div class="display-flex-a-j fs-1" style="height: 20%">巅峰榜</div>
                    <div class="display-flex-a-j fs-1" style="height: 20%">人气</div>
                    <div class="mx-lg-2" style="margin-bottom: 1.5rem">
                        <div>1. 落</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp艾辰</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>2. 自我的疗伤</div>
                        <div class="">&nbsp&nbsp&nbsp&nbspM哥</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>3. 要远的你</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp221小伙伴</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>4. 冷</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp莫文蔚</div>
                    </div>
                </div>
            </li>
            <li class="p-lg-3 h-100 col">
                <div class="h-100" style="background-color: #74BCB1">
                    <div class="display-flex-a-j fs-1" style="height: 20%">巅峰榜</div>
                    <div class="display-flex-a-j fs-1" style="height: 20%">人气</div>
                    <div class="mx-lg-2" style="margin-bottom: 1.5rem">
                        <div>1. 落</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp艾辰</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>2. 自我的疗伤</div>
                        <div class="">&nbsp&nbsp&nbsp&nbspM哥</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>3. 要远的你</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp221小伙伴</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>4. 冷</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp莫文蔚</div>
                    </div>
                </div>
            </li>
            <li class="p-lg-3 h-100 col">
                <div class="h-100" style="background-color: #609399">
                    <div class="display-flex-a-j fs-1" style="height: 20%">巅峰榜</div>
                    <div class="display-flex-a-j fs-1" style="height: 20%">人气</div>
                    <div class="mx-lg-2" style="margin-bottom: 1.5rem">
                        <div>1. 落</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp艾辰</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>2. 自我的疗伤</div>
                        <div class="">&nbsp&nbsp&nbsp&nbspM哥</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>3. 要远的你</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp221小伙伴</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>4. 冷</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp莫文蔚</div>
                    </div>
                </div>
            </li>
            <li class="p-lg-3 h-100 col">
                <div class="h-100" style="background-color: #E7A595">
                    <div class="display-flex-a-j fs-1" style="height: 20%">巅峰榜</div>
                    <div class="display-flex-a-j fs-1" style="height: 20%">人气</div>
                    <div class="mx-lg-2" style="margin-bottom: 1.5rem">
                        <div>1. 落</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp艾辰</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>2. 自我的疗伤</div>
                        <div class="">&nbsp&nbsp&nbsp&nbspM哥</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>3. 要远的你</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp221小伙伴</div>
                    </div>
                    <div class="mx-2 my-4">
                        <div>4. 冷</div>
                        <div class="">&nbsp&nbsp&nbsp&nbsp莫文蔚</div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>

<%--添加boostrap和jquery的脚本--%>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fontawesome.js"></script>
<script>
    $('.toImg').hover(function () {
        $('.li-div').toggleClass('hidden');
    });
</script>
</body>
</html>
