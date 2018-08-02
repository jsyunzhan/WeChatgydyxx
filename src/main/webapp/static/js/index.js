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
            "html": '<div class="searchPop"><div class="searchDetail"><div class="searchIcon"><img src='+path+'"static/images/searchIcon.png"></div><div class="searchInput"><input type="text" placeholder="搜索相关标题"></div><div class="searchBtn">搜索</div></div></div>',
            "width": '',
            "height": '',
            "params": {},
            "events": {}
        },false);
        $("#maskLayer").click(function () {
            popdown(search);
        })
    })

})