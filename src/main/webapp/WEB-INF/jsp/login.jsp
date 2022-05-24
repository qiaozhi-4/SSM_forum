<%--
  Created by IntelliJ IDEA.
  User: 18890
  Date: 2022/5/24
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        *{
            margin:0;
            padding:0;
            font-family:Serif;
            letter-spacing:.05em;
        }
        html{
            height:100%;
        }
        body{
            height:100%;
        }
        .Container{
            height:100%;
            background-image: linear-gradient(to right, #fbc2eb , #a6c1ee);
        }
        .Login-wrapper{
            background-color:#fff;
            width:250px;
            height:500px;
            border-radius:15px;
            padding:0 50px;
            position:relative;
            left:50%;
            top:50%;
            transform:translate(-50%,-50%);
        }
        .Login-wrapper .Header{
            font-size:30px;
            font-weight:bold;
            text-align:center;
            line-height:200px;
        }
        .Login-wrapper .Form-wrapper .input-item{
            display:block;
            width:100%;
            margin-bottom:20px;
            border:0;
            padding:10px;
            border-bottom:1px solid rgb(128,125,125);
            font-size:15px;
            outline:none;
        }
        .Login-wrapper .Form-wrapper .input-item::placeholder{
            text-transform:uppercase;
        }
        .Login-wrapper .Form-wrapper .Btn{
            text-align:center;
            padding:10px;
            width:100%;
            margin-top:40px;
            background-image: linear-gradient(to right, #a6c1ee,#fbc2eb);
            color:#fff;
        }
        .Login-wrapper .Msg{
            text-align:center;
            line-height:80px;
        }
        .Login-wrapper .Msg a{
            text-decoration-line:none;
            color:#a6c1ee;
        }

        .Btn{
            cursor: pointer;/*鼠标样式*/
            border-style: none;
            border-radius:10px;
        }

        .Btn:hover {
            /* 加个发光效果和下面的倒影 */
            /* 模糊度加到了10px */
            box-shadow: 0 0 10px aqua;
        }
    </style>
</head>


<body>
<div class="Container">
    <div class="Login-wrapper">
        <form action="${pageContext.servletContext.contextPath}/login" method="post">
            <div class="Header">Login</div>
            <div class="Form-wrapper">
                <input type="text" name="username" placeholder="账号" class="input-item">
                <input type="password" name="password" placeholder="密码" class="input-item">
                <button type="submit" class="Btn">Login</button>
<%--                <div class="Btn">Login</div>--%>
            </div>
            <div class="Msg">
                没有账号? <a href="${pageContext.servletContext.contextPath}/registerPage">注册</a>
            </div>
        </form>
    </div>
</div>
</body>


</html>
