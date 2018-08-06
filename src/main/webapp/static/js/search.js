$(function () {

    // 标题
    $(".listTitle").text(title);

    // 请求
    function search(){
        var _html = "";
        for(var i=0;i<jsString.length;i++){
            _html += '<div class="listChild" name="'+jsString[i].tableId+'" url="'+jsString[i].url+'"><div>'+jsString[i].title+'</div><div>'+timestampToTime(jsString[i].createDate)+'</div></div>';
        }
        $(".list").append(_html);
        showMore(5);

        // 跳转详情
        $(".listChild").click(function () {
            var url = path + $(this).attr("url") + $(this).attr("name");
            window.location.href = url;
        });
    }
    search();


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

})