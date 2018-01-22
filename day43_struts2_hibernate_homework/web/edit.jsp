<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:form action="submitedit" method="POST">
    <s:textfield cssStyle="display: none" name="user.uid" value="%{#request.edit.uid}"/>
    <s:textfield value="%{#request.edit.uname}" name="user.uname" label="用户名"/>
    <s:textfield value="%{#request.edit.age}" name="user.age" label="年龄"/>
    <s:textfield value="%{#request.edit.department}" name="user.department" label="部门"/>
    <s:textfield value="%{#request.edit.time}" name="user.time" label="入职时间"/>
    <s:textfield value="%{#request.edit.adderss}" name="user.adderss" label="住址"/>
    <s:textfield value="%{#request.edit.phone}" name="user.phone" label="电话号码"/>
    <s:submit value="提交"/>
</s:form>
</body>
</html>
