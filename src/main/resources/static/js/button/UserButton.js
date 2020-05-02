"use strict";
// var files;
// $('#inputNewAvatar').on('change', function () {
//     files = this.files;
// });
$('#settingUser').click(function() {
    var infoMenu = $('#mini_user_info_menu');
    if(!infoMenu.attr('hidden')){
        infoMenu.attr('hidden',true);
        $('#mini_user_setting_menu').attr('hidden',false);
    }
});
$('#saveSettingButton').click(function() {
    var settingMenu = $('#mini_user_setting_menu');
    if(!settingMenu.attr('hidden')){
       settingMenu.attr('hidden',true);
        $('#mini_user_info_menu').attr('hidden',false);
    }
});
$('#uploadAvatarButton').click(function () {

    var avatarTxt = $('#upload_avatar_txt');

    event.stopPropagation();
    event.preventDefault();

   // if(typeof files == 'undefined')return;
    var form =  $('#uploadAvatar')[0];
    var data = new FormData(form);

  //  alert("123" + data.files[0].size);

    $('#avatar_file_download').on("ready",function () {
        alert(this.files[0].size);

        if(this.files[0].size > 1000000){
            avatarTxt.attr('class', 'text-primary text-left text-wrap text-break font-italic');
            avatarTxt.html('Розмір файлу не має перевищувати 10 Мb');
            return null;
        }
    });
    $('#avatar_file_download').trigger("ready");

    var uploadImageType = $('#avatar_file_download').val().toString().split(".").pop().toLowerCase();
    var imageCheckArr = ["jpg", "png", "jpeg"];

    if(imageCheckArr.find(function (element) {
        if(element === uploadImageType)return true;
    })) {
        data.append("CustomField", "This is some extra data, testing");

        $("#btnSubmit").prop("disabled", true);

        $.ajax({
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
            },
            asyc: true,
            type: "POST",
            enctype: 'multipart/form-data',
            url: '/api/v1/image/uploadAvatar',
            data: data,
            dataType: "json",
            cache: false,
            processData: false,
            contentType: false,
            // timeout: 1000000,
            success: function () {

               avatarTxt.attr('class', 'text-primary text-left text-wrap text-break font-italic');
                avatarTxt.html('Аватар змінено');
            },
            error: function () {
                avatarTxt.attr('class', 'text-primary text-left text-wrap text-break font-italic');
                avatarTxt.html('Помилка завантаження, попробуйте пізніше');
            }
        })
    }else{
        avatarTxt.html('Змініть тип файлу ' + uploadImageType + '' +
            ' на: ' + imageCheckArr.toString() + '.');
    }
});
