"use strict";
// var files;
// $('#inputNewAvatar').on('change', function () {
//     files = this.files;
// });
$('#settingUser').click(function(e) {
    if(!$('#mini_user_info_menu').attr('hidden')){
        $('#mini_user_info_menu').attr('hidden',true);
        $('#mini_user_setting_menu').attr('hidden',false);
    }
});
$('#saveSettingButton').click(function(e) {
    if(!$('#mini_user_setting_menu').attr('hidden')){
        $('#mini_user_setting_menu').attr('hidden',true);
        $('#mini_user_info_menu').attr('hidden',false);
    }
});
$('#uploadAvatarButton').click(function (e) {

    event.stopPropagation();
    event.preventDefault();

   // if(typeof files == 'undefined')return;
    var form =  $('#uploadAvatar')[0];
    var data = new FormData(form);

    // $.each( files, function ( key, value ) {
    //     data.append( key, value );
    // });
    //
    // data.append('file',1);

    data.append("CustomField", "This is some extra data, testing");

    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        beforeSend: function(request) {
            request.setRequestHeader('Authorization',('Bearer_' + localStorage.getItem('token')));
        },
        asyc: true,
        type: "POST",
        enctype: 'multipart/form-data',
        url: '/api/v1/image/uploadAvatar',
        data: data,
        dataType: "json",
        cache:false,
        processData: false,
        contentType: false,
        // timeout: 1000000,
        success: function () {
            $('#registerEmployeeForm').html('<h3>Регістрація успішна</h3>');
        },
        error: function () {
            $('#registration_error_div').html('<h4>Ведені неправильні дані або користувач з таким email уже існує</h4>');
        }
    })
});