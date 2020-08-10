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
                $('#txtFullName').text(res.fullName);
                $('#txtDirector').text(res.director);
                $('#txtLanguage').text(res.language);
                $('#txtDescription').text(res.description);
                $('#txtCountSeries').text(res.countSeries);
                let strCategories ="";
                res.categories.forEach(function (masObj){
                    strCategories += masObj.categories + ", ";
                })
                $('#txtCategories').text(strCategories);
                let strGenre ="";
                res.genres.forEach(function (masObj){
                    strGenre += masObj.genre + ", ";
                })
                $('#txtGenre').text(strGenre);
        },
        error : function (){}
    })
}
function showPublicationAvatar(){}
function showInfoImages(){}
function showAnimeVideo(){}
function getIdFromHref(){
    let path = $(location).attr('pathname');
    let masOfPath = path.split('/');
    return masOfPath[masOfPath.length - 1];
}
