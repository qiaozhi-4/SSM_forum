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
<form action="${pageContext.servletContext.contextPath}/mySetSub" method="post" class="mb-0">
    <div id="myMusicDiv3" class="">
        <div class="col border border-top-0 border-bottom-0 border-end-0">
            <div class="mmd3-2-1">
                <div class="pt-3 ps-4">
                    <h1>个人设置</h1>
                </div>
                <div class="ms3-2-1-2 ms-5">
                    <div class="row">
                        <div class="col-2 border display-flex-a-j">基本设置</div>
                        <div class="col-2 border display-flex-a-j">绑定设置</div>
                        <div class="col-2 border display-flex-a-j">隐私设置</div>
                    </div>
                </div>
                <div class="row ms-5 mt-4">
                    <div class="col-8">
                        <div class="row g-3 align-items-center">
                            <div class="col-auto">
                                <label for="inputPassword6" class="col-form-label">昵称</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="inputPassword6" name="name" class="form-control" value="${user.name}"
                                       aria-describedby="passwordHelpInline">
                            </div>
                        </div>
                        <div class="row g-3 align-items-center mt-1">
                            <div class="col-auto">
                                <label for="exampleFormControlTextarea1" class="form-label">个人简介</label>
                            </div>
                            <div class="col-auto mb-3">
                                <textarea class="form-control" name="info" id="exampleFormControlTextarea1"
                                          rows="3">${user.info}</textarea>
                            </div>
                        </div>
                        <div class="row g-3 align-items-center">
                            <div class="col-auto">
                                <label class="col-form-label">性别</label>
                            </div>
                            <div class="col-auto">
                                <input class="form-check-input" id="sex" name="sex" type="radio" checked="checked"
                                       value="男"/>男
                                <input class="form-check-input ms-2" id="sex2" name="sex" type="radio" value="女"/>女
                            </div>
                        </div>
                        <div class="row g-3 align-items-center mt-1">
                            <div class="col">
                                <label class="col-form-label">生日</label>
                            </div>
                            <div class="col-3">
                                <select class="form-select" name="birthday" aria-label="Default select example">
                                    <c:forEach begin="1900" end="2022" step="1" var="i">
                                        <option value="1">${i}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-1">年</div>
                            <div class="col-2">
                                <select class="form-select" name="birthday" aria-label="Default select example">
                                    <c:forEach begin="1" end="12" step="1" var="i">
                                        <option value="1">${i}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-1">月</div>
                            <div class="col-2">
                                <select class="form-select" name="birthday" aria-label="Default select example">
                                    <c:forEach begin="1" end="31" step="1" var="i">
                                        <option value="1">${i}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col">日</div>
                        </div>
                        <div class="row g-3 align-items-center mt-1">
                            <div class="col-auto">
                                <label for="inputPassword63" class="col-form-label">地区</label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="inputPassword63" name="address"  class="form-control" value="${user.address}"
                                       aria-describedby="passwordHelpInline">
                            </div>
                        </div>
                        <div class="mt-3">
                            <button class="btn btn-primary">保存</button>
                        </div>
                    </div>
                    <div class="col">
                        <a class="btn btn-link text-white text-decoration-none">
                            <img src="${$}/${user.url}" class=""
                                 width="100%">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

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