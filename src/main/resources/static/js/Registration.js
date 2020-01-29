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
            success : [ function(data,textStatus) {

                // if(res.validated){
                //Set response
                // $('#resultContainer pre code').text(JSON.stringify(res.employee));
                // $('#resultContainer').show();
                alert("Registration Successful");
                // }else{
                //     //Set error messages
                //     $.each(res.errorMessages,function(key,value){
                //         $('input[name='+key+']').after('<span class="error">'+value+'</span>');
                //     });


            }]
        })

    });

});