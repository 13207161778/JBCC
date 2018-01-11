<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'msg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

<h1>订单：${id } 以确认收货</h1>
<ul>
<c:forEach items="${bcs }" var="link">
    <li><img src="${link.image}" alt=""></li>
  <li>${link.bname }</li>
  <li>${link.author }</li>
  <li>${link.price }</li>
</c:forEach>
</ul>
  <h3>请在下面给5星好评</h3><br>
  <textarea rows="3" cols="50">

  </textarea>
  </body>
</html>
