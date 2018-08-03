$(function () {

    // 标题
    $(".listTitle").text(title);

    // 请求
    $.ajax({
        url:path+'/home/'+ data + '/list',
        type:"GET",dataType:"json",
        success:function (event) {
            console.log(event);
            var _html = "";
            for(var i=0;i<event.length;i++){
                _html += '<div class="listChild"><div>'+event[i].title+'</div><div>'+timestampToTime(event[i].createDate)+'</div></div>';
            }
            $(".list").append(_html);
            showMore(5);
        }
    });

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

    // 更多
    function showMore(showNum){
        var count = 0;
        $(".listChild").hide();
        for(var i=0;i<$(".listChild").length;i++){
            if(i<showNum){
                $($(".listChild")[i]).show();
            }else{
                $(".more").show();
                break;
            }
        }
        $(".more").click(function(){
            count++;
            for(var i=5;i<5+count*showNum;i++){
                if(i<$(".listChild").length){
                    $($(".listChild")[i]).show();
                }else{
                    $(".more").hide();
                    $(".nomore").show();
                    break;
                }
            }
        })
    }
    showMore(5);

    // 更多
    function showMore(showNum){
        var count = 0;
        $(".listChild").hide();
        for(var i=0;i<$(".listChild").length;i++){
            if(i<showNum){
                $($(".listChild")[i]).show();
            }else{
                $(".more").show();
                break;
            }
        }
        $(".more").click(function(){
            count++;
            for(var i=5;i<5+count*showNum;i++){
                if(i<$(".listChild").length){
                    $($(".listChild")[i]).show();
                }else{
                    $(".more").hide();
                    $(".nomore").show();
                    break;
                }
            }
        })
    }

})