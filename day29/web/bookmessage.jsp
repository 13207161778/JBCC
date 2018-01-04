<%@ page import="utils.JQueryUtils" %>
<%@ page import="utils.JDBCUtils" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanHandler" %>
<%@ page import="bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/3
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <h1>
        <%=
        session.getAttribute("bname")
        %>
    </h1>
    <p>
        《朝花夕拾》原名《旧事重提》，是现代文学家鲁迅的散文集，收录鲁迅于1926年创作的10篇回忆性散文，
        [1]  1928年由北京未名社初版，现编入《鲁迅全集》第2卷。
    </p>
<p>

    此文集作为“回忆的记事”，多侧面地反映了作者鲁迅青少年时期的生活，
    形象地反映了他的性格和志趣的形成经过。前七篇反映他童年时代在绍兴的家庭和私塾中的生活情景，
    后三篇叙述他从家乡到南京，又到日本留学，然后回国教书的经历；揭露了半封建半殖民地社会种种丑恶的不合理现象，同时反映了有抱负的青年知识分子在旧中国茫茫黑夜中，不畏艰险，寻找光明的困难历程
    ，以及抒发了作者对往日亲友、师长的怀念之情[2]  。
</p>
</div>
</body>
</html>
