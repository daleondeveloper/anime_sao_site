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
        success : function (){
                alert("success publication get");
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
