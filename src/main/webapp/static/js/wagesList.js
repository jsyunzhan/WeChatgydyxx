$(function () {

    // 标题
    $(".listTitle").text(title);

    // 请求
    $.ajax({
        url:path+'/homepage/wages/list',
        type:"GET",dataType:"json",
        success:function (event) {
            console.log(event);
            var _html = "";
            for(var i=0;i<event.length;i++){
                _html += '<div class="listChild" name="'+event[i].id+'"><div>'+event[i].wagesName+'</div><div>'+timestampToTimeAll(event[i].createDate)+'</div></div>';
            }
            $(".list").append(_html);
            showMore(5);

            // 跳转详情
            $(".listChild").click(function () {
                var url = path + '/homepage/wages/details/' + $(this).attr("name");
                window.location.href = url;
            })
        }
    });

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