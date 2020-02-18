"use strict";
$(function doReg() {
    /*  Submit form using Ajax */
    $('#registration').click(function(e) {

        $('#registration_error_div').html('');
        // Prevent default submission of form
        e.preventDefault();

        //Remove all errors
        $('input').next().remove();


        var email = $('#registration_password').val();
        var password = $('#registration_password_repeat').val();
       if(email === password) {


            $.ajax({
                asyc: true,
                type: "POST",
                url: '/api/v1/auth/registration',
                data: $('#registerEmployeeForm').serialize(),
                dataType: "json",
                timeout: 1000000,
                success: function () {
                    $('#registerEmployeeForm').html('<h3>Регістрація успішна</h3>');
                },
                error: function () {
                    $('#registration_error_div').html('<h4>Ведені неправильні дані або користувач з таким email уже існує</h4>');
                }
            })
        }else{
            $('#registration_error_div').html('<h4>Ведені паролі відрізняються</h4>');

        }

    });
    $('#registration_div').ready( function (){
        //Prevent default submission of form
        $.ajax({
            beforeSend: function(request) {
                request.setRequestHeader('Authorization',('Bearer_' + localStorage.getItem('token')));
            },
            asyc : true,
            type : "GET",
            url : '/api/v1/user/getUserInfo',
            timeout : 1000000,
            success :  function() {
                $('#registerEmployeeForm').html('<h3>Ви авторизовані</h3>');

            }
        })


    });

});