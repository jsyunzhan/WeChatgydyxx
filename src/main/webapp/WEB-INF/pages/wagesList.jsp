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
    <link rel="stylesheet" href="${APP_PATH}/static/css/list.css">
    <script src="${APP_PATH}/static/jq/jquery-1.12.4.min.js"></script>
    <script src="${APP_PATH}/static/js/pop.js"></script>
    <script src="${APP_PATH}/static/js/public.js"></script>
    <script src="${APP_PATH}/static/js/wagesList.js"></script>
    <style>
        .listChild div:nth-child(2){
            width: 90px;
        }
    </style>
    <title>高邮第一实验小学</title>
</head>
<body>
<div class="wrapper">
    <%--头部--%>
    <div class="header clearfix">
        <%--Logo--%>
        <div class="logo">
            <a href="${APP_PATH}/home/homepage">
                <img src="${APP_PATH}/static/images/logo.png">
            </a>
        </div>
        <%--搜索--%>
        <div class="search">
            <img src="${APP_PATH}/static/images/search.png">
        </div>
    </div>
    <%--标题--%>
    <div class="titleList">
        <div class="listTitle"></div>
        <div class="list"></div>
        <div class="more">
            查看更多<span><img src="${APP_PATH}/static/images/more.png"></span>
        </div>
        <div class="nomore">没有更多了~~</div>
    </div>
    <%--页面底部--%>
    <div class="footer">
        <p>Copyright@2018 <a href="${APP_PATH}/home/homepage" style="color: #fff;">gydyxx.com</a> All Rights Reserved</p>
        <p>苏ICP备10084223号 管理网址</p>
        <p>
            <img src="${APP_PATH}/static/images/country.png" style="display:inline-block;width:14px;height:14px;vertical-align:top;margin-top: 2px;">
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=32108402000010" style="color: #fff;">苏公网安备 32108402000010号</a>
        </p>
    </div>
</div>
</body>
<script>
    var path  = '<%=request.getContextPath()%>';
    var title = "${title}";
</script>
</html>
