$(function () {
    // banner轮播
    var banner = new Swiper('.banner',{
        pagination: '.swiper-pagination',
        autoplay: 15000,
        autoplayDisableOnInteraction: false,
        loop: true
    })

    // 搜索弹窗
    initUtils();
    $(".search").click(function () {
        var search = popup({
            "html": '<div class="searchPop"><div class="searchDetail"><div class="searchIcon"><img src='+path+'"/static/images/searchIcon.png"></div><div class="searchInput"><input type="text" placeholder="搜索相关标题"></div><div class="searchBtn">搜索</div></div></div>',
            "width": '',
            "height": '',
            "params": {},
            "events": {}
        },false);
        $("#maskLayer").click(function () {
            popdown(search);
        })
    })

    // 功能模块跳转
    $(".Mchild:nth-child(1)").click(function(){
        var url = path + '/home/notice/listpage';
        window.location.href = url;
    });
    $(".Mchild:nth-child(2)").click(function(){
        var url = path + 'home/news/listpage';
        window.location.href = url;
    });
    $(".Mchild:nth-child(3)").click(function(){
        var url = path + 'home/wages';
        window.location.href = url;
    })

})