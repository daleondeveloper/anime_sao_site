"use strict";
import{TEST_CONSTANS} from './utils/constans.js';

$(function doAjaxPost() {
    $('#registration').click(function (e) {
// get the form values
        var email = $('#email').val();
        var password = $('#password').val();
        var obj = new Object();
        obj.email = email;
        obj.password = password;
        var jsonString = JSON.stringify(obj);

        //Prevent default submission of form
        e.preventDefault();

        //Remove previous errors
        $('input').next('span').remove();

        $.ajax({
            url: '/api/v1/auth',
            data: $('#registerEmployeeForm').serialize(),
            dataType : "json",
            type : "POST",
            success: function (res) {
                if (res.validated) {
                    //take your successful action here; you may want to redirect to another page
                    alert("Registration Successful");
                } else {
                    $.each(res.errorMessages, function (key, value) {
                        $('input[name=' + key + ']').after('<span class="error">' + value + '</span>');
                    });
                }
            }
        })
    });

});