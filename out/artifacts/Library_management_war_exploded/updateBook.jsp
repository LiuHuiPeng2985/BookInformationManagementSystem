<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>

    <%--BootStrap 美化界面--%>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/UpdateBookController" method="post">
        <%--坏处:编号需要固定 不推荐 不过没有那么繁琐,自行选择--%>
        <%--<div class="form-group">
             <label >书籍编号:</label>
             <input type="text" name="bookId" class="form-control" required>
        </div>--%>
            <%--隐藏书籍编号的表单 自带传来的参数--%>

            <input id="bookId" type="hidden" name="bookId">
        <div class="form-group">
            <label >书籍名称:</label>
            <input type="text" name="bookName" class="form-control" required>
        </div>

        <div class="form-group">
            <label >书籍数量:</label>
            <input type="text" name="bookCounts" class="form-control" required>
        </div>

        <div class="form-group">
            <label >书籍描述:</label>
            <input type="text" name="detail" class="form-control" required>
        </div>

        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>

<script>
    function GetQueryString(name) {
        var reg = new RegExp( "(^|&)" + name + "=([^&]*)(&|$)" , "i" );
        var r = window.location.search.substr(1).match(reg);
        if (r!= null ) return (r[2]); return null ;
    }

    // 获取到url后面拼接的参数并复制给了id
    var b = GetQueryString("bookId")
    document.getElementById('bookId').value=b;
</script>
</body>
</html>
