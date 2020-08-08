"use strict"
function showPublicationDate(){
    $.ajax({
        beforeSend : function (req){
            req.setRequestHeader('Autorization',('Bearer_' + localStorage.getItem('token')));
        },
        type : 'GET',
        url : '/api/v1/publication' + getIdFromHref(),
        success : function (){

        },
        error : function (){}
    })
}
function showPublicationAvatar(){}
function showInfoImages(){}
function showAnimeVideo(){}
function getIdFromHref(){
    let path = $(location).attr('path');
    let masOfPath = path.split('/');
    return masOfPath[masOfPath.length - 1];
}
