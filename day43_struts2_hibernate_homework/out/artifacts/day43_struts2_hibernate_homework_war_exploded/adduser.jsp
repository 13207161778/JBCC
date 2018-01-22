<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <style type="text/css">
        label{
            color: red;
            display: inline-block;
        }
    </style>
</head>
<body>
<%--<s:form action="add" method="POST">--%>
    <%--<s:textfield name="user.uname" label="用户名"/>--%>
   <%--<s:textfield name="user.age" label=" 年龄" />--%>
    <%--<s:textfield name="user.department" label="职业"/>--%>
    <%--<s:textfield name="user.time" label="入职时间"/>--%>
   <%--<s:textfield name="user.adderss" label=" 住址"/>--%>
   <%--<s:textfield name="user.phone" label=" 电话号码"/>--%>
    <%--<s:submit value="提交"/>--%>
<%--</s:form>--%>
<form action="add.action" method="post">
    用户名:    <input type="text" name="user.uname">&nbsp;<label><s:fielderror fieldName="user.uname"/> </label><br>
    年龄：     <input type="text" name="user.age">&nbsp;<label><s:fielderror fieldName="user.age"/> </label><br>
    部门: <input type="text" name="user.department">&nbsp;<label><s:fielderror fieldName="user.department"/> </label><br>
    入职时间:<input type="text" name="user.time">&nbsp;<label><s:fielderror fieldName="user.time"/> </label><br>
    住址:<input type="text" name="user.adderss">&nbsp;<label><s:fielderror fieldName="user.adderss"/> </label><br>
    电话号码:<input type="text" name="user.phone">&nbsp;<label><s:fielderror fieldName="user.phone"/> </label><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
