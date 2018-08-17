// 日期格式转换
function timestampToTime(timestamp) {
    var date = new Date(timestamp);
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate();
    return M+D;
}

function timestampToTimeAll(timestamp) {
    var date = new Date(timestamp);
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate();
    return Y+M+D;
}

// 居中效果
function center(obj){
    var win_width = $(window).width();
    var win_height = $(window).height();
    var obj_width = $(obj).width();
    var obj_height = $(obj).height();
    $(obj).css({"left":(win_width-obj_width)/2,"top":(win_height-obj_height)/2});
}


(function(doc,win){
    var docEl=doc.documentElement,
        resizeEvt="orientationchange" in window ? 'orientationchange' :'resize',
        recalc=function(){
            var clientWidth=docEl.clientWidth;
            if(!clientWidth) return;
            if(clientWidth > 750) clientWidth=750;
            docEl.style.fontSize=(clientWidth/7.5)+'px';
        }
    if(!doc.addEventListener) return;
    win.addEventListener(resizeEvt,recalc,false);
    doc.addEventListener('DOMContentLoaded',recalc,false);
})(document,window);

$(function () {
    // 搜索弹窗
    initUtils();
    $(".search").click(function () {
        var search = popup({
            "html": '<div class="searchPop"><div class="searchDetail"><div class="searchIcon"><img src="'+path+'/static/images/searchIcon.png"></div><div class="searchInput"><input type="search" placeholder="搜索相关标题"></div><div class="searchBtn">搜索</div></div></div>',
            "width": '',
            "height": '',
            "params": {},
            "events": {}
        },false);
        $(".searchBtn").click(function () {
            var title = $(".searchInput input").val();
            var url = path + "/homepage/home/search?title=" + title;
            window.location.href = url;
        });
        $(document).keydown(function () {
            if (event.keyCode==13 ||event.keyCode==108 ){
                $(".searchBtn").trigger("click");
            }
        })
        $("#maskLayer").click(function () {
            popdown(search);
        });
    });
})