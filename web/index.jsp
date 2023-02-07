<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>首页</title>

  <style>
    a{
      text-decoration: none;
      color: black;
      font-size: 18px;
    }

    h1{
      width: 180px;
      height: 38px;
      margin: 100px auto;
      text-align: center;
      line-height: 38px;
      background: seagreen;
      border-radius: 5px;
    }
  </style>

</head>
<body>

<%--  <h3>
    <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
  </h3>--%>

<h1>
  <%--${pageContext.request.contextPath} 用于解决使用相对 路径 时出现的问题，它的作用是取出所部署项目的名字。--%>
  <a href="${pageContext.request.contextPath}/login.jsp">登录页面</a>
</h1>
</body>
</html>

