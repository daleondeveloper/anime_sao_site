    "use strict"
$(document).ready(function (){
    showPublicationDate();
})
function showPublicationDate(){
    $.ajax({
        beforeSend : function (req){
            req.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
        },
        type : 'GET',
        url : '/api/v1/publication/' + getIdFromHref(),
        success : function (res){
            document.getElementById('txtFullName').insertAdjacentHTML('afterbegin','&#10031; ' + res.fullName);
            document.getElementById('txtDirector').insertAdjacentHTML('afterbegin','<strong>Режисер: </strong>' + res.director);
            document.getElementById('txtLanguage').insertAdjacentHTML('afterbegin','<strong>Мова: </strong>' + res.language);
            document.getElementById('txtDescription').insertAdjacentHTML('afterbegin','<strong>Опис: </strong>' + res.description);
            document.getElementById('txtCountSeries').insertAdjacentHTML('afterbegin','<strong>Кількість серій: </strong>' + res.countSeries);

                let strCategories ="";
                res.categories.forEach(function (masObj){
                    strCategories += masObj.categories + ", ";
                })
            document.getElementById('txtCategories').insertAdjacentHTML('afterbegin','<strong>Категорії: </strong>' + strCategories);

            let strGenre ="";
                res.genres.forEach(function (masObj){
                    strGenre += masObj.genre + ", ";
                })
                document.getElementById('txtGenre').insertAdjacentHTML('afterbegin','<strong>Жанр: </strong>' + strGenre);
                showPublicationAvatar(res);
                showInfoImages(res);
                showAnimeVideo();
        },
        error : function (){}
    })
}
function showPublicationAvatar(resObj){
    $.ajax({
        beforeSend : function (req){
            req.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
        },
        type : 'GET',
        url : '/api/v1/publication/getAvatar/' + resObj.id,
        async : true,
        success : function (res){
            $('#avatarPublicationImg').attr('src', 'data:image/jpeg;base64,'+ res);

        },
        error : function (){

        }
    })
}
function showInfoImages(resObj){
    $.ajax({
        beforeSend : function (req){
            req.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
        },
        type : 'GET',
        url : '/api/v1/publication/anime/getInfoImages/' + resObj.id,
        async : true,
        success : function (res){
            let imageDiv = document.getElementById('infoImages');

            res.forEach(function (masObj){
                imageDiv.insertAdjacentHTML('afterbegin',
                    "<img class=\"img-fluid img-thumbnail\" style=\"width:23%;height:10rem; \" src=\"data:image/jpeg;base64," + res + "\" alt=\"Card image cap\">\n")
            })
            $('#avatarPublicationImg').attr('src', 'data:image/jpeg;base64,'+ res);

        },
        error : function (){

        }
    })
}
function showAnimeVideo(){}
function getIdFromHref(){
    let path = $(location).attr('pathname');
    let masOfPath = path.split('/');
    return masOfPath[masOfPath.length - 1];
}
