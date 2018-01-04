<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
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
        .div3{
            float: right;
            padding-top: 18px;
        }
        .div3  a{
            font-size: 20px;
            text-decoration-line: none;
        }
        .div4{
            width: 100%;
            height: 880px;
            float: left;

        }
        .div5{
            width: 625px;
            height: 434px;
            display: block;
            position: absolute;
             top: 250px;
            left: 300px;
            /*background: url("../../img/5.PNG") no-repeat;*/
            /*background-image: url("../../img/5.PNG");*/

        }
        .div6{
            width: 580px;
            height: 680px;
            float: left;
            margin: 30px;
            position: absolute;
            left: 1000px;
            top: 165px;
        }
    </style>
    <script type="text/javascript"  src="jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="div1">
    <span id="span" style="display: block; position: fixed; left: 90%;top: 15px;font-size: 16px"> </span>
    <div class="div2"><img src="img/yun.png"><span>网易云</span><span style="font-family: monospace; font-size: 35px;margin-top: 5px;margin-left: 12px">登录</span></div>
    <div class="div3"><a href="#">网易云首页</a> &nbsp;&nbsp;&nbsp;
        |
        &nbsp;&nbsp;&nbsp; <a href="#">帮助文档</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
</div>
<div class="div4">
    <div class="div5" id="div" onmouseover="hover(this)"><span style="display: block;margin-left: 300px;margin-top:50px; color: #11fff0;font-size: 50px;font-family: 楷体">世&nbsp;界&nbsp;科&nbsp;技</span>
        <span style="display: block;margin-left:20px;margin-top:210px; color: #11fff0;font-size: 50px;font-family: 楷体">由&nbsp;你&nbsp;支&nbsp;配</span>
    </div>
    <div class="div6">
        <span style="display: block; font-size: 30px;font-weight: bold;margin-left: 210px;margin-top: 30px;">网易云登录</span>
        <div style="margin-top: 30px;margin-left: 100px">
            <form action="/Login" method="post">
            <input type="text"  id="username" name="username" <% if (application.getAttribute("username")==null)
               { %>  value="请输入用户名"  <%  }else {%> placeholder="${username}"<%}
              %>  onfocus="focut(this)" onblur="buls(this)" style="width: 350px;height: 40px"><br><br><br>
            <input type="password"  id="password" name="userpassword" placeholder="请输入密码" onfocus="focut(this)" onblur="buls(this)" style="width: 350px;height: 40px">
            <br><br><br><br><br><br> <br><br><br><br><br>
            <button type="submit" id="btn" onmousedown="down(this)" onmouseup="up(this)" style="width: 350px;height: 40px;background-color: #2f25ff;color: white">登录</button>
           <br>
            <span style="font-size: 16px;font-family: 楷体;font-weight: bold">还没有账号?</span>
            <a href="/register.jsp">免费注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">忘记密码?</a>
            </form>
        </div>

    </div>
</div>
</body>
<script type="text/javascript">

function focut(ele) {
    ele.style.borderColor="red";
    ele.style.fontSize="30px";
}
function buls(ele) {
    ele.style.borderColor="white";
    ele.style.fontSize="13px";
}
function down(ele) {
    ele.style.backgroundColor="gray";

}
function up(ele) {
    ele.style.backgroundColor="blue";
}
var hour;
var minutes;
var second;
function time() {
    var ele = document.getElementById("span");
    var time = new Date();
    hour=time.getHours();
    minutes=time.getMinutes();
    second=time.getSeconds();
   setInterval(function () {
       second++;
       if(second==60){
           minutes++;
           second=0;
       }else if (minutes==60){
           hour++;
           minutes=0;
       }
       ele.innerText = "当前时间:"+ hour+":"+minutes+":"+second;
   },1000);

}

function circulat() {
    var i = 0;
    var element = document.getElementById("div");
    element.style.background="url(img/4.png)";
   setInterval(function () {
        i++;
        i = i % 5;
        element.style.background="url(img/"+ i +".png"+")";
    },2000);
}
window.onload=time();
window.onload=circulat();


</script>
</html>