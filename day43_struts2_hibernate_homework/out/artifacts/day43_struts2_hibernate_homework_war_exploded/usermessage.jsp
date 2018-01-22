<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<table border="1">
    <tr>
        <th>用户名</th>
        <th>年龄</th>
        <th>部门</th>
        <th>入职时间</th>
        <th>住址</th>
        <th>电话号码</th>
    </tr>
    <s:iterator var="user" value="%{#request.findusers}">

        <tr>
            <th style="display: none"><s:property value="#user.uid"/> </th>
            <th><s:property value="#user.uname"/> </th>
            <th><s:property value="#user.age"/> </th>
            <th><s:property value="#user.department"/> </th>
            <th><s:property value="#user.time"/> </th>
            <th><s:property value="#user.adderss"/> </th>
            <th><s:property value="#user.phone"/> </th>
            <th>
                <a href="edit.action?name1=<s:property value="#user.uid"/> " >编辑</a>
            </th>
        </tr>

    </s:iterator>
</table>
</body>
</html>
