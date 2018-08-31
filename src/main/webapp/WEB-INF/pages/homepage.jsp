<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/static/swiper/swiper.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/public.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/publicPart.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/index.css">
    <script src="${APP_PATH}/static/jq/jquery-1.12.4.min.js"></script>
    <script src="${APP_PATH}/static/swiper/swiper.min.js"></script>
    <script src="${APP_PATH}/static/js/pop.js"></script>
    <script src="${APP_PATH}/static/js/public.js"></script>
    <script src="${APP_PATH}/static/js/index.js"></script>
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
        <%--banner--%>
        <div class="swiper-container banner">
            <div class="swiper-wrapper clearfix">
            </div>
            <div class="swiper-pagination"></div>
        </div>
        <div class="module clearfix">
            <div class="Mchild">
                <img src="${APP_PATH}/static/images/notice.png">
                <p>通知公告</p>
            </div>
            <div class="Mchild">
                <img src="${APP_PATH}/static/images/news.png">
                <p>新闻中心</p>
            </div>
            <div class="Mchild">
                <img src="${APP_PATH}/static/images/money.png">
                <p>教师工资</p>
            </div>
            <div class="Mchild">
                <img src="${APP_PATH}/static/images/publicity.png">
                <p>内部公示</p>
            </div>
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

</script>
</html>
