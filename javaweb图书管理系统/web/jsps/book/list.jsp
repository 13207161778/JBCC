<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>

  </head>
  
  <body>

<div  class="all">

    <c:forEach var="book" items="${requestScope.books}">
        <div class="icon">
           <a href="http://localhost:8080/book?method=showBook&bname=${book.bname}">
               <img src="${book.image}"/>
            <br>
            <a href="http://localhost:8080/book?method=showBook&bname=${book.bname}">${book.bname}</a>
           </a>

        </div>

    </c:forEach>


    <c:forEach var="sebook" items="${requestScope.SEbooks}">

        <div class="icon">
            <a  href="http://localhost:8080/book?method=showBook&bname=${sebook.bname}">
                <img src="${sebook.image}"><br>
                <a href="http://localhost:8080/book?method=showBook&bname=${sebook.bname}">${sebook.bname}</a>
            </a>
        </div>
        </c:forEach>


    <c:forEach var="eebook" items="${requestScope.EEbooks}">

        <div class="icon">
            <a  href="http://localhost:8080/book?method=showBook&bname=${eebook.bname}">
                <img src="${eebook.image}"><br>
                <a href="http://localhost:8080/book?method=showBook&bname=${eebook.bname}">${eebook.bname}</a>
            </a>
        </div>
    </c:forEach>


    <c:forEach var="jsbook" items="${requestScope.JSbooks}">

        <div class="icon">
            <a href="http://localhost:8080/book?method=showBook&bname=${jsbook.bname}">
                <img src="${jsbook.image}"><br>
                <a href="http://localhost:8080/book?method=showBook&bname=${jsbook.bname}">${jsbook.bname}</a>
            </a>
        </div>
    </c:forEach>

</div>

  </body>

</html>

