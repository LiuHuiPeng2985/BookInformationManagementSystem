<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        .divForm{
            position: absolute;/*绝对定位*/
            width: 300px;
            height: 200px;

            border: 1px solid #fafafa;
            text-align: center;/*(让div中的内容居中)*/
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;
        }
        a{
            text-decoration: none;
            color: rebeccapurple;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div class="divForm">
                <%--/empproject=serleTS--%>
<form action="${pageContext.request.contextPath}/login" method="post">
    账号:<input type="text" name="username"/><br>
    密码:<input type="text" name="password"/><br>
    验证:<input type="text" name="inputVcode"><img src="${pageContext.request.contextPath}/createCode"/><br/>
    <input type="submit" value="登录">
     &nbsp; &nbsp;
     <a href="${pageContext.request.contextPath}/register.jsp">注册</a>

</form>
</div>
</body>
</html>
