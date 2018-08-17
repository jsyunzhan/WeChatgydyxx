$(function () {
    // 标题
    $(".listTitle").text(title);

    var _html = "";
    _html += '<div class="wages clearfix"><div class="wagesName">姓名</div><div class="wagesData">'+name+'</div></div>';
    _html += '<div class="wages clearfix"><div class="wagesName">发放时间</div><div class="wagesData">'+createDate+'</div></div>';
    details = details.split(";");
    console.log(details);
    for (var i=0;i<details.length-1;i++){
        var detail = details[i].split(":");
        _html += '<div class="wages clearfix"><div class="wagesName">'+detail[0]+'</div><div class="wagesData">'+detail[1]+'</div></div>';
    }
    $(".wagesList").append(_html);

    // 发表时间
    var time = timestampToTimeAll(createDate);
    $(".textInfor div:nth-child(1) span").text(time);

    // 上一篇下一篇
    $(".preBtn").attr("name",prev);
    $(".nextBtn").attr("name",next);
    $(".preBtn").attr("urlPart",prevUrl);
    $(".nextBtn").attr("urlPart",nextUrl);
    $(".preBtn").attr("urlPart",prevUrl);
    $(".nextBtn").attr("urlPart",nextUrl);
    $(".preBtn").text("上一篇："+prevTitle);
    $(".nextBtn").text("下一篇："+nextTitle);
    if(prev == 0){
        $(".preBtn").hide();
    }
    if (next == 0){
        $(".nextBtn").hide();
    }
    $(".Paging div").click(function () {
        var id = $(this).attr("name");
        if (id!=0){
            var url = path + '/homepage/wages/details/' + id;
            window.location.href = url;
        }
    })
})