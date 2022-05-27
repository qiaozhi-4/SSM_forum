<%@ page import="java.net.URLEncoder" %>
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
    <div class="myMusicDiv2-1"></div>
    <div class="col display-flex-a-j" style="background-image: linear-gradient(to right, #fbc2eb , #a6c1ee);"></div>
</div>
<div id="myMusicDiv3" class="row">
    <div class="col-3 myMusicDiv3-1 p-f">
        <div>
            <div class="p-2 row">
                <div class="col-7"><h5>创建的歌单</h5></div>
                <div class="col">
                    <a id="addMusicList" class="btn btn-link text-decoration-none p-0"
                       style="font-size: 0.8rem">添加歌单</a>
                </div>
            </div>
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
                            <c:if test="${musicList.name!='我喜欢的音乐'}">
                                <div class="col">
                                    <a id="alterMusicList" class="conceal btn btn-link text-decoration-none p-0"
                                       data-musicList-id="${musicList.id}">修改</a>
                                    <a id="removeMusicList" class="conceal btn btn-link text-decoration-none p-0"
                                       data-musicList-id="${musicList.id}">删除</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="myMusicDiv3-2 p-f col border border-top-0 border-bottom-0 border-end-0">
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
                        <td colspan="2"><a class="text-dark text-decoration-none" href="">${music.name}</a></td>
                        <td><a class="text-dark text-decoration-none" href="">${music.singer}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div>
    <audio controls>
        <source src="${$}/music/h3R3,高旭 - 他只是经过.mp3" type="audio/mpeg">
    </audio>
</div>

<%--写一个添加员工的弹窗--%>
<div id="addMusicList2" class="modal fade" data-bs-backdrop="static">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <form action="${$}/addMusicList" method="post" class="mb-0">
                <div class="modal-header">
                    <h3 id="orderTitle2" class="modal-title">添加歌单</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <div>

                        <label class="form-label" for="musicListName">歌单名：</label>
                        <input class="form-control" type="text" id="musicListName" name="musicListName"/>

                    </div>
                </div>
                <div class="modal-footer">
                    <button id="updateBtn2" class="btn btn-primary">添加</button>
                    <button id="cancelBtn2" class="btn btn-light" data-bs-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--写一个添加员工的弹窗--%>
<div id="alterMusicList2" class="modal fade" data-bs-backdrop="static">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <form action="${$}/alterMusicList" method="post" class="mb-0">
                <div class="modal-header">
                    <h3 class="modal-title">修改歌单</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <div>
                        <label class="form-label" for="musicListName2">歌单名：</label>
                        <input class="form-control" type="text" id="musicListName2" name="musicListName"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary">修改</button>
                    <button class="btn btn-light" data-bs-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--写一个添加员工的弹窗--%>
<div id="removeMusicList2" class="modal fade" data-bs-backdrop="static">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <form action="${$}/deleteMusicList" method="post" class="mb-0">
                <div class="modal-header">
                    <h3 class="modal-title">删除歌单</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <div>
                        <label class="form-label" for="musicListName">确定删除？</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button  class="btn btn-primary">确定</button>
                    <button  class="btn btn-light" data-bs-dismiss="modal">取消</button>
                </div>
            </form>
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
    $('.myMusicDiv3-1').hover(function () {
        $(this).toggleClass('p-f');
    })
    $('.myMusicDiv3-2').hover(function () {
        $(this).toggleClass('p-f');
    })

    let order = {};
    let modal1 = new bootstrap.Modal(document.querySelector('#addMusicList2'));
    let modal2 = new bootstrap.Modal(document.querySelector('#alterMusicList2'));
    let modal3 = new bootstrap.Modal(document.querySelector('#removeMusicList2'));

    // 添加歌单
    $('#addMusicList').click(function extracted1() {
        modal1.show();
    });

    // 添加歌单
    $('#alterMusicList').click(function extracted1() {
        modal2.show();
        let id = $(this).attr('data-musicList-id');
        $('#alterMusicList2').find('div:eq(0)').find('div:eq(0)').find('from:eq(0)').attr('action','${$}/alterMusicList?id='+id);
    });

    // 添加歌单
    $('#removeMusicList').click(function extracted1() {
        modal3.show();
        let id = $(this).attr('data-musicList-id');
        $('#alterMusicList2').find('div:eq(0)').find('div:eq(0)').find('from:eq(0)').attr('action','${$}/deleteMusicList?id='+id);
    });

</script>
</body>
</html>
