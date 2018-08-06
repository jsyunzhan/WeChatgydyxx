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
                        $(".error").text(serverResponse.reason);
                        $(".loginForm input").bind("change propertychange input",function () {
                            $(".error").text("");
                        })
                    }
                },
                error: function (xmlHttpReq, textStatus, errorThrow) {

                }
            });
        }
    })



})