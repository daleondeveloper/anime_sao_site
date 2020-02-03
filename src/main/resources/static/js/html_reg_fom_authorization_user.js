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
            url : '/api/v1/admin/users/6',
            timeout : 1000000,
            success :  function(res) {
                $('#autorization_form').attr('hidden',true);
            },
            error: function (res) {
                $('#autorization_form').attr('hidden',false);
            }
        })


});