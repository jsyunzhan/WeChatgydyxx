$(function () {
    // banner轮播
    var banner = new Swiper('.banner',{
        pagination: '.swiper-pagination',
        autoplay: 15000,
        autoplayDisableOnInteraction: false,
        loop: true
    })

    // 功能模块跳转
    $(".Mchild:nth-child(1)").click(function(){
        var url = path + '/homepage/notice/listpage';
        window.location.href = url;
    });
    $(".Mchild:nth-child(2)").click(function(){
        var url = path + '/homepage/news/listpage';
        window.location.href = url;
    });
    $(".Mchild:nth-child(3)").click(function(){
        // var url = path + '/homepage/wages';
        // window.location.href = url;
    });
    $(".Mchild:nth-child(4)").click(function(){
        var url = path + '/homepage/internal/listpage';
        window.location.href = url;
    });
});