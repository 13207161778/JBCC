<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/19
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:form action="loginbefore" method="POST">

  <s:textfield name="username" label="用户名"/>

 <s:textfield name="password" label="密码"/>
    <s:submit value="提交"/>
</s:form>
</body>
</html>
