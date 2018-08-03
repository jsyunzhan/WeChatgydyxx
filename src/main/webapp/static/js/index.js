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
        var url = path + '/home/notice/listpage';
        window.location.href = url;
    });
    $(".Mchild:nth-child(2)").click(function(){
        var url = path + '/home/news/listpage';
        window.location.href = url;
    });
    $(".Mchild:nth-child(3)").click(function(){
        var url = path + '/home/wages';
        window.location.href = url;
    })

    $(".Mchild:nth-child(3)").click(function(){
        var url = path + '/home/wages/listpage';
        window.location.href = url;
    })
})