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
<div id="div1" class="row">
    <div class="div1-1 display-flex-a-j col-4">
        <form action="${$}/" method="post">
            <div class="row ">
                <div class="col-auto p-0">
                    <input type="text" class="form-control" name="username">
                </div>
                <div class="col-auto p-0">
                    <button type="submit"
                            class="btn btn-link btn-primary text-white text-decoration-none"
                            data-bs-dismiss="modal">搜索
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="div1-2 display-flex-a-j col-2">
        2022/5/24
    </div>
    <div class="div1-3 display-flex-a-j col">
        <ul class="nav w-100">
            <li class="p-md-5 p-lg-3 display-flex-a-j">我的音乐</li>
            <li class="p-md-5 p-lg-3 display-flex-a-j">个人中心</li>
            <li class="p-md-5 p-lg-3 display-flex-a-j">|</li>
            <li class="p-md-5 p-lg-3 display-flex-a-j">
                <img src="${pageContext.servletContext.contextPath}/musicImg/梦醒.jpg">
            </li>
            <li class="p-md-5 p-lg-3 display-flex-a-j">
                未登入
            </li>
            <li class="p-md-5 p-lg-3 display-flex-a-j">
                <button class="btn btn-link btn-primary text-white text-decoration-none">登入</button>
            </li>
        </ul>
    </div>
</div>
<div id="div2" class="row">
    <div class="col bg-danger"></div>
    <div class="col bg-warning"></div>
    <div class="col-9 bg-primary display-flex-a-j">
        <div class="div2-3-1 w-50">
            <ul class="nav">
                <li class="display-flex-a-j" style="padding-right: 20px">*</li>
                <li class="display-flex-a-j">在线播放</li>
                <li class="display-flex-a-j" style="padding-left: 70px;padding-right: 20px">@</li>
                <li class="display-flex-a-j">音乐人</li>
            </ul>
        </div>
    </div>
</div>
<div id="carouselExampleDark" class="carousel carousel-dark slide h-50" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000">
            <img src="${pageContext.servletContext.contextPath}/musicImg/梦醒.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>First slide label</h5>
                <p>Some representative placeholder content for the first slide.</p>
            </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img src="${pageContext.servletContext.contextPath}/musicImg/FLY.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Second slide label</h5>
                <p>Some representative placeholder content for the second slide.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="${pageContext.servletContext.contextPath}/musicImg/海底.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Third slide label</h5>
                <p>Some representative placeholder content for the third slide.</p>
            </div>
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

<%--添加boostrap和jquery的脚本--%>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fontawesome.js"></script>
<script>
</script>
</body>
</html>
