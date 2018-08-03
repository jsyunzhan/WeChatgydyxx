<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/static/css/public.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/publicPart.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/login.css">
    <script src="${APP_PATH}/static/jq/jquery-1.12.4.min.js"></script>
    <script src="${APP_PATH}/static/js/pop.js"></script>
    <script src="${APP_PATH}/static/js/public.js"></script>
    <script src="${APP_PATH}/static/js/login.js"></script>
    <title>高邮第一实验小学</title>
</head>
<body>
    <div class="wrapper">
        <div class="loginTitle">高邮第一实验小学<br>内网登录</div>
        <div class="loginForm">
            <input type="text" name="username" placeholder="账号" class="username">
            <input type="password" name="password" placeholder="密码" class="password">
            <div class="error"></div>
        </div>
        <div class="submit">登录</div>
    </div>
</body>
<script>
    var path  = '<%=request.getContextPath()%>';
</script>
</html>
