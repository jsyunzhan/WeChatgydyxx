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
    <script src="${APP_PATH}/static/js/list.js"></script>
    <title>高邮第一实验小学</title>
</head>
<body>
<div class="wrapper">
    <%--头部--%>
    <div class="header clearfix">
        <%--Logo--%>
        <div class="logo">
            <a href="${APP_PATH}/index.jsp">
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
        <div class="listTitle">搜索结果</div>
        <div class="list">
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
            <div class="listChild">
                <div>搜索结果搜索结果</div>
                <div>06-23</div>
            </div>
        </div>
        <div class="more">
            查看更多<span><img src="${APP_PATH}/static/images/more.png"></span>
        </div>
        <div class="nomore">没有更多了~~</div>
    </div>
    <%--页面底部--%>
    <div class="footer">
        <p>Copyright@2018 http://xxx.org All Rights Reserved.</p>
        <p>高邮市第一实验小学 版权所有</p>
        <p> 苏ICP备11454545号-1 管理网址 </p>
    </div>
</div>
</body>
<script>
    var path  = '<%=request.getContextPath()%>';
    var data = "${url}";
    console.log(data);
</script>
</html>
