$(function () {
    // 标题
    $(".listTitle").text(title);

    // 正文
    var data = {picturePath:picturePath};
    var _html = "";
    if(picturePath!=""){
        $.ajax({
            url:path + "/home/picture/show",
            type:"POST",contentType: "application/json",data:JSON.stringify(data),async:false,
            success:function(event){
                for (var i=0;i<event.length;i++){
                    _html += '<div class="imgDetial"><img src="data:image/gif;base64,'+event[i]+'"></div>';
                }
            }
        })
    }
    var dd=details.replace(/<p>/g,"<div>");
    dd=dd.replace(/<\/p>/g,"</div>");
    _html += dd;
    $(".textCon").html(_html);

    // 发表时间
    var time = timestampToTimeAll(createDate);
    $(".textInfor div:nth-child(1) span").text(time);

    // 上一篇下一篇
    $(".preBtn").attr("name",prev);
    $(".nextBtn").attr("name",next);
    $(".Paging div").click(function () {
        var id = $(this).attr("name");
        if (id!=0){
            var url = path + '/homepage/'+ urlPart + '/details/' + id;
            window.location.href = url;
        }
    })
})