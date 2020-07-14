"use strict";

function addAnimePublicationButtonBind(){
    let id = 0;
    $("#addPublicationBtn").bind("click",function () {
        let name = $('#inputName').val(),
            fullName = $('#inputFullName').val(),
            director = $('#inputDirector').val(),
            language = $('#inputLanguage').val(),
            descrition = $('#inputDescription').val();

        let genre = new Array(), i = 0;
        $('#spanGenre').find('span').each(function () {
            genre[i];
            i++;

        });
        let form = new Object();
        form.name = name;
        form.fullName = fullName;
        form.director = director;
        form.language = language;
        form.description = descrition;
        form.genre = genre;

        // let jsonForm = JSON.parse(form);

        $.ajax({
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
            },
            type: "POST",
            dataType: "json",
            data: form,
            url: "/api/v1/admin/publication/anime/add",
            success: function (res) {
                id = res.id;
                addAvatarToPublication(id);
            },
            error: function () {

            }

        })
    });
}
function addAvatarToPublication(id){

    let form = $('#uploadAvatarPublication')[0];
    let data = new FormData(form);

    $('#avatar_Publication').trigger('ready');


    $.ajax({
        beforeSend: function(request) {
            request.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
        },
        async:'true',
        type: 'POST',
        url: '/api/v1/publication/uploadAvatar/' + id,
        enctype:'multipart/form-data',
        dataType: 'json',
        data: data,
        cache: false,
        processData: false,
        contentType: false,
        success: function (res) {
            alert('avatar download');
        },
        error: function () {
            alert('fail download');
        }

    })
}
