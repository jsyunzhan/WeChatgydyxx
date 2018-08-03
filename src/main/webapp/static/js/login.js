$(function(){
    // 登录验证
    $(".submit").click(function () {
        var username = $(".username").val();
        var password = $(".password").val();
        if(username!=""&&password!=""){

            var data = {loginName:username,password:password};
            $.ajax({
                url: path +'/nameAndUser/login',
                type: 'POST', dataType: "json",
                data: data,
                success: function (serverResponse) {
                    if (serverResponse.success) {
                        location.href = path + "/home/alert";
                    } else {
                        $("#userError").text(serverResponse.reason);
                        $("#userError").addClass("red_1");
                    }
                },
                error: function (xmlHttpReq, textStatus, errorThrow) {

                }
            });
        }

    })

})