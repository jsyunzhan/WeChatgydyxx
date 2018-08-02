<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="static/swiper/swiper.min.css">
    <link rel="stylesheet" href="static/css/public.css">
    <link rel="stylesheet" href="static/css/index.css">
    <script src="static/jq/jquery-1.12.4.min.js"></script>
    <script src="static/swiper/swiper.min.js"></script>
    <script src="static/js/pop.js"></script>
    <script src="static/js/public.js"></script>
    <script src="static/js/index.js"></script>
    <title>高邮第一实验小学</title>
</head>

<body>
    <div class="wrapper">
        <%--头部--%>
        <div class="header clearfix">
            <%--Logo--%>
            <div class="logo">
                <img src="static/images/logo.png">
            </div>
            <%--搜索--%>
            <div class="search">
                <img src="static/images/search.png">
            </div>
        </div>
        <%--banner--%>
        <div class="swiper-container banner">
            <div class="swiper-wrapper clearfix">
                <div class="swiper-slide">
                    <img src="static/images/banner.png">
                    <p>我是第一个banner</p>
                </div>
                <div class="swiper-slide">
                    <img src="static/images/banner.png">
                    <p>我是第二个banner</p>
                </div>
            </div>
            <div class="swiper-pagination"></div>
        </div>
        <div class="module clearfix">
            <a href="javascript:;">
                <div class="Mchild">
                    <img src="static/images/notice.png">
                    <p>通知公告</p>
                </div>
            </a>
            <a href="javascript:;">
                <div class="Mchild">
                    <img src="static/images/news.png">
                    <p>新闻中心</p>
                </div>
            </a>
            <a href="javascript:;">
                <div class="Mchild">
                    <img src="static/images/money.png">
                    <p>教师工资</p>
                </div>
            </a>
            <a href="javascript:;">
                <div class="Mchild">
                    <img src="static/images/publicity.png">
                    <p>内部公示</p>
                </div>
            </a>
        </div>
        <div class="footer">
            <p>Copyright@2018 http://xxx.org All Rights Reserved.</p>
            <p>高邮市第一实验小学 版权所有</p>
            <p> 苏ICP备11454545号-1 管理网址 </p>
        </div>
    </div>
</body>
<script>
    var path  = '<%=request.getContextPath()%>';
</script>
</html>
