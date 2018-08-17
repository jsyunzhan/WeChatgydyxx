$(function () {
    // banner轮播
    $.ajax({
        url:path+'/homepage/banner/list',
        type:"GET",dataType:"json",
        success:function (event) {
            var _html = "";
            for(var i=0;i<event.length;i++){
                var num = i;
                var picturePath = event[i].picturePath;
                var data = {picturePath:picturePath};
                if(picturePath!=""){
                    $.ajax({
                        url:path + "/home/picture/show",
                        type:"POST",contentType: "application/json",data:JSON.stringify(data),async:false,
                        success:function(r){
                            for (var j=0;j<r.length;j++){
                                _html += '<div class="swiper-slide" name="'+event[num].id+'"><img src="data:image/gif;base64,'+r[j]+'"><p>'+event[num].title+'</p></div>';
                            }
                        }
                    })
                }
            }
            $(".banner .swiper-wrapper").append(_html);
            // swiper轮播
            var banner = new Swiper('.banner',{
                pagination: '.swiper-pagination',
                autoplay: 15000,
                autoplayDisableOnInteraction: false,
                loop: true
            });
            // 跳转详情
            $(".banner .swiper-wrapper .swiper-slide").click(function () {
                var url = path + '/homepage/banner/details/' + $(this).attr("name");
                window.location.href = url;
            })
        }
    });

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
        var url = path + '/homepage/wages/listpagee';
        window.location.href = url;
    });
    $(".Mchild:nth-child(4)").click(function(){
        var url = path + '/homepage/internal/listpage';
        window.location.href = url;
    });
});