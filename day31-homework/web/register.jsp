<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账号注册</title>

    <style type="text/css">

        .div1{
            width: 100%;
            padding-top: 30px;

        }
        .div2{
            float: left;
        }
        .div2 img{
            display: block;
            float: left;
            margin-left: 50px;
        }
        .div2 span{
            display: block;
            float: left;
            margin-left: 8px;
            font-size: 52px;
            margin-top: -10px;
            font-family: 楷体;
        }
        .div6{
            width: 1080px;
            height: 680px;
            float: left;
            margin: 30px;
            position: absolute;
            left: 650px;
            top: 200px;
        }
    </style>
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="div1">
<div class="div2"><img src="img/yun.png"><span>网易云</span><span style="font-family: monospace; font-size: 35px;margin-top: 0px;margin-left: 12px">注册账号</span></div>
</div>
<div><div class="div6">
    <span style="display: block; font-size: 30px;font-weight: bold;margin-left: 260px;margin-top: 30px;">网易云注册</span>
    <div style="margin-top: 30px;margin-left: 100px">
        <form action="/add" method="post">
        <label for="user"   style="font-size:30px;">邮箱名:</label>
        <input id="user" name="username" type="text" placeholder="请输入用户名" onfocus="focus1(this)" onblur="buls(this)" style="width: 350px;height: 40px"><label id="lable1" style="visibility: hidden"></label><br><br><br>
        <label for="password"  style="font-size:30px;">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
        <input id="password" name="userpassword" type="password" placeholder="请输入密码" onfocus="b(this)" onblur="buls1(this)"  style="width: 350px;height: 40px"><label id="lable2" style="visibility: hidden"></label>
        <br>
            <label>性别</label>
            <input type="radio" name="sex" value="man">男
            <input type="radio" name="sex" value="woman">女
            <br>
        <br><br><br><br><br><br>
        <button id="btn" type="submit"   onmousedown="down(this)"  style="width: 460px;height: 40px;background-color: #2f25ff;color: white">注册</button>
        </form>
    </div>
</div>
</div>
</body>
<script type="text/javascript">
    $('#btn').click(function () {
        window.location.href="Login.html";
    });
    var byId;
    var byId1;
    function focus1(ele) {
        ele.style.borderColor="red";
        ele.style.fontSize="30px";
         byId = document.getElementById("lable1");
        byId.innerText="账号必须符合邮箱规范";
        byId.style.visibility="visible";
        byId.style.color="red";
    }
    function b(ele) {
        ele.style.borderColor="red";
        ele.style.fontSize="30px";
         byId1 = document.getElementById("lable2");
        byId1.innerText="密码必须包含数字,小写字母,大写字母";
        byId1.style.visibility="visible";
        byId1.style.color="red";
    }
    function down(ele) {
        ele.style.backgroundColor="gray";

    }
    function buls(ele) {
        ele.style.borderColor="white";
        ele.style.fontSize="13px";
        byId.style.visibility="hidden";
    }
    function buls1(ele) {
        ele.style.borderColor="white";
        ele.style.fontSize="13px";
        byId1.style.visibility="hidden";
    }
</script>
</html>