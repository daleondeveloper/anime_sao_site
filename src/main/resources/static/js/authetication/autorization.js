"use strict";
$(function(){
    /*  Submit form using Ajax */
    $('#autorization_button').click(function(e) {

        //Prevent default submission of form
        e.preventDefault();

        //Remove all errors
        $('input').next().remove();

        $.ajax({
            asyc : true,
            type : "POST",
            url : '/api/v1/auth/login',
            data : $('#autorization_form').serialize(),
            dataType : "json",
            timeout : 1000000,
            success :  function(res) {
                $('#registerEmployeeForm').html('<h3>Регістрація успішна</h3><br>' +
                    '<h4>Акаунт ' + res.email + ' зареєстровано.</h4>' + res.token);
                localStorage.setItem('token',res.token);
                alert("Registration Successful" + res.email + " oo");
                html.reload();
            },
            error: function () {
                $('#resultContainer').html('Ошибка. Данные не отправлены.');
            }
        })

    });
    $('#logout').click(function (){
        localStorage.setItem('token','');
    })
});

