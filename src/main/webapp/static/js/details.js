$(function () {
    // 标题
    $(".listTitle").text(title);

    // 正文
    var dd=details.replace(/<p>/g,"<div>");
    dd=dd.replace(/<\/p>/g,"</div>");
    $(".Paging").html(dd);
})