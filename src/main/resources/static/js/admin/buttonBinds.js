"use strict";
function imageLabelsShowTxtButtonBind(){
    $('#avatar_Publication').on('change',function(e){
        //get the file name
        var fileName = e.target.files[0].name;
        //replace the "Choose a file" label
        $(this).next('#avatar_Publication_Label').html(fileName);
    })
    $('#images_Publication').on('change',function(e){
        let  fileNames = "";
        let countFiles = e.target.files.length;
        for(let i = 0; i < countFiles; i++){
            fileNames += e.target.files[i].name ;
            if((countFiles-1) === i){
                fileNames += '.';
            }else{
                fileNames+= ', ';
            }
        }
        //get the file name
        //replace the "Choose a file" label
        $(this).next('#images_Publication_Label').html(fileNames);
    })
}
function publicationShowByIdBtnBind(){
    $('#publicationShowByIdButton').bind('click',function () {
        let id = $('#publicationIdInput').val();
        $.ajax({
            beforeSend : function (req){
                req.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
            },
            type : "GET",
            url : "/api/v1/publication/" + id,
            success : function (data){
                $('#publicationIdSpan').text(data.id);
                $('#publicationTypeSpan').text(data.types[0].types);
                $('#inputName').attr("placeholder","name");
                $('#inputFullName').attr("placeholder","fullName");
                $('#inputDescription').attr("placeholder","description");
                $('#inputDirector').attr("placeholder","director");
                $('#inputLanguage').attr("placeholder","language");
                $('#inputName').attr("placeholder",data.name);
                $('#inputFullName').attr("placeholder",data.fullName);
                $('#inputDescription').attr("placeholder",data.description);
                $('#inputDirector').attr("placeholder",data.director);
                $('#inputLanguage').attr("placeholder",data.language);
                showGenreDate(data);
                showCategoriesDate(data);
                switch (data.types[0].types.toString().toLowerCase()){
                    case "anime" :
                        showAnimePublicationDate(data);
                        break;
                    case "manga" :
                        showMangaPublicationDate(data);
                        break;
                    case "game" :
                        showGamePublicationDate(data);
                        break;
                }
            },
            error : function (){}
        });
    });
}
function editPublicationButtonBind(){
    $("#editPublicationBtn").bind("click",function () {
        let id = $('#publicationIdSpan').text();
        $.ajax({
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
            },
            type: "POST",
            dataType: "json",
            data: createPublicationObjFromHtmlDateWithType("anime"),
            url: "/api/v1/publication/edit/" + id,
            success: function (res) {

                //addAvatarToPublication(id);
                //addInfoImageToPublication(id);
            },
            error: function () {

            }

        })
    });
}
function addAnimePublicationButtonBind(){
    let id = 0;
    $("#addPublicationBtn").bind("click",function () {
        $.ajax({
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
            },
            type: "POST",
            dataType: "json",
            data: createPublicationObjFromHtmlDateWithType("anime"),
            url: "/api/v1/publication/anime/admin/add",
            success: function (res) {
                id = res.id;
                addAvatarToPublication(id);
                addInfoImageToPublication(id);
            },
            error: function () {

            }

        })
    });
}
function createPublicationObjFromHtmlDateWithType(type){
    let obj = createPublicationObjFromHtmlDate();
    if(type == null){
        return obj;
    }
    switch (type.toLowerCase()){
        case "anime" :
            let countSeries = $('#inputCountSeries').val();
            obj.countSeries = countSeries;
            break;
        case "manga":
            break;
        case "game" :
            break;
    }
    return obj;
}
function createPublicationObjFromHtmlDate() {
    let name = $('#inputName').val(),
        fullName = $('#inputFullName').val(),
        director = $('#inputDirector').val(),
        language = $('#inputLanguage').val(),
        description = $('#inputDescription').val();

    let genre = [], i = 0;
    $('#spanGenre').find('span').each(function () {
        genre[i]=$(this).text();
        i++;
    });
    let categories = [], j = 0;
    $('#spanCategories').find('span').each(function () {
        categories[j]=$(this).text();
        j++;
    });

    let form = {
        "name":name,
        'fullName' : fullName,
        'director' : director,
        'language': language,
        'description' : description,
    };
    form.genre = JSON.stringify(genre);
    form.categories = JSON.stringify(categories);

    return form;
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
let files; // переменная. будет содержать данные файлов

// заполняем переменную данными, при изменении значения поля file
$('#images_Publication').on('change', function(){
    files = this.files;
});
function addInfoImageToPublication(id){

    let data = new FormData();

    $.each( files, function( key, value ){
        data.append( 'files', value );
    });


    $.ajax({
        beforeSend: function(request) {
            request.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
        },
        async:'true',
        type: 'POST',
        url: '/api/v1/publication/anime/uploadInfoImages/' + id,
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
// $("#uploadImagesInfoPublication").on("change", function () {
//     var fileInput = document.getElementById('fileInput');
//     //Iterating through each files selected in fileInput
//     for (i = 0; i < fileInput.files.length; i++) {
//
//         var sfilename = fileInput.files[i].name;
//         let srandomid = Math.random().toString(36).substring(7);
//
//         formdata.append(sfilename, fileInput.files[i]);
//
//         var markup = "<tr id='" + srandomid + "'><td>" + sfilename + "</td><td><a href='#' onclick='DeleteFile(\"" + srandomid + "\",\"" + sfilename +
//             "\")'><span class='glyphicon glyphicon-remove red'></span></a></td></tr>"; // Binding the file name
//         $("#FilesList tbody").append(markup);
//
//     }
//     chkatchtbl();
//     $('#fileInput').val('');
// });
