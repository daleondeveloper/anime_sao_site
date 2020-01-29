"use strict";
$(function doReg() {
    /*  Submit form using Ajax */
    $('#registration').click(function(e) {

        //Prevent default submission of form
        e.preventDefault();

        //Remove all errors
        $('input').next().remove();

        $.ajax({
            asyc : true,
            type : "POST",
            url : '/api/v1/auth/registration',
            data : $('#registerEmployeeForm').serialize(),
            dataType : "json",
            timeout : 1000000,
            success :  function(res) {
                $('#registerEmployeeForm').html('<h3>Регістрація успішна</h3><br>' +
                    '<h4>Акаунт ' + res.email + ' зареєстровано.</h4>');
                     alert("Registration Successful" + res.email + " oo");
            },
            error: function (res) {
                $('#resultContainer').html('Ошибка. Данные не отправлены.');
            }
        })

    });

});