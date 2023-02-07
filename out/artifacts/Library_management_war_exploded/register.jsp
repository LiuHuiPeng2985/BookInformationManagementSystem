<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
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
    </style>
</head>
<body>
<div class="divForm">
<form action="${pageContext.request.contextPath}/register" method="post">
    账号:<input type="text" name="username" required><br>
    密码:<input type="text" name="password" required><br>
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
