"use strict";
$('#autorization_div').ready( function reg_form_autorization(){
        //Prevent default submission of form
        if(localStorage.getItem('token') != null)
        $.ajax({
            beforeSend: function(request) {
                request.setRequestHeader('Authorization',('Bearer_' + localStorage.getItem('token')));
            },
            //header: {'Authorization':('Bearer_' + localStorage.getItem('token'))},
            asyc : true,
            type : "GET",
            url : '/api/v1/user/getUserInfo',
            timeout : 1000000,
            success :  function(res) {
                $('#autorization_form').attr('hidden',true);
                if($('#mini_user_setting_menu').attr('hidden')) {
                    $('#mini_user_info_menu').attr('hidden', false);
                    $('#user_nick_name_txt_left_menu').html( res.nickName );
                    ajaxGetAvatar();
                }else{
                    $('#mini_user_setting_menu').attr('hidden',false);
                    $('#mini_user_info_menu').attr('hidden', true);

                }
            },
            error: function () {
                $('#autorization_form').attr('hidden',false);
                $('#mini_user_info_menu').attr('hidden',true);
                $('#mini_user_setting_menu').attr('hidden',true);

            }
        })


});

function ajaxGetAvatar(){
    $.ajax({
        beforeSend: function(request) {
            request.setRequestHeader('Authorization',('Bearer_' + localStorage.getItem('token')));
        },
        async:"true",
        type: "GET",
        datatype: "json",
        url: "/api/v1/image/getAvatar",
        processData: "false",
        contentType: "false",
        success:function(data) {

            $('#avatarImg').attr('src', 'data:image/jpeg;base64,'+ data);
        },
        error: function(err){

        }

    })
}