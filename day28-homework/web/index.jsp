<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="dao.Decide" %>
<%@ page import="bean.Book" %><%--
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
    <%

      if(session.getAttribute("username")==null){
          %>
        <h1><a href="Login.html">请登录</a></h1>
    <%
      }else {
          %>
        <label>用户名:</label>
    <label>
      <%= session.getAttribute("username")%>
    </label><br>
    <label>密码：</label>
    <label>
      <%= session.getAttribute("userpassword")%>
    </label>
    <%
      }
    %>
     <table border="1">
       <tr>
         <th> 书ID </th>
         <th> 书名 </th>
         <th> 作者 </th>
         <th> 价格 </th>
       </tr>
       <%
         List<Book> books = Decide.decide();
         for(int i = 0;i<books.size();i++){
           Book book = books.get(i);

       %>

            <tr>
              <td>
                <%

                     out.write(book.getBid());
                  if(book.getBid().equals("1")){
                    session.setAttribute("bname","朝花夕拾");
                  }

              %>
              </td>
              <td>
                <a href=" bookmessage.jsp">
                <%
                  out.write(book.getBname());

                %>
                </a>
              </td>
              <td>
                <%

                  out.write(book.getAutor());

                %>
              </td>
              <td>
                <%
                  out.write(book.getPay());
                  }
                %>
              </td>
       </tr>

     </table>


<br>
  <a href="Login.jsp"><button>退出</button></a>
  </body>
<script type="text/javascript">

  $('button').click(function () {

  })
</script>
</html>
