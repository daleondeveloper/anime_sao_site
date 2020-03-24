"use strict";
$('#autorization_div').ready( function reg_form_autorization(){
        //Prevent default submission of form
        $.ajax({
            beforeSend: function(request) {
                request.setRequestHeader('Authorization',('Bearer_' + localStorage.getItem('token')));
            },
            //header: {'Authorization':('Bearer_' + localStorage.getItem('token'))},
            asyc : true,
            type : "GET",
            url : '/api/v1/image/getAvatar',
            timeout : 1000000,
            success :  function(res) {
                $('#autorization_form').attr('hidden',true);
                if($('#mini_user_setting_menu').attr('hidden')) {
                    $('#mini_user_info_menu').attr('hidden', false);
                    $('#autorization_div_nick_name').html('<h5> ' + res.nickName + ' </h5>');
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