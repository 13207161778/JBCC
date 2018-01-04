<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/2
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <label id="label1"></label><br>
  <label id="label2"></label>
  </body>
<script type="text/javascript">
  $.JSON("http://localhost:8080/get",function (data,studes) {
      $.each(data,function (index,value) {
          var name = value['username'];
          var sex = value['sex'];
          $('#label1').text(name);
          $('#label2').text(sex);
      })

  })

</script>
</html>
