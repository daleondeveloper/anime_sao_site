"use strict";

$('#dropDownChoose').on('click','a',function(){
    $('#dropDownChooseAnimeType').attr("hidden",true);
    $('#choosePublicationIdDiv').attr("hidden",true);
    $('#chooseUserIdDiv').attr("hidden",true);
    $('#dropdownMenuButton').empty();
    document.getElementById("dropdownMenuButton").insertAdjacentHTML("afterbegin",this.text);
    switch (this.text) {
        case "Створити публікацію":
            $('#dropDownChooseAnimeType').attr("hidden",false);
            break;
         case "Редагувати публікацію":
             $('#choosePublicationIdDiv').attr("hidden",false);
             publicationShowByIdBtnBind();
             showEditPublication();
             editPublicationButtonBind();
            break;
        case "Отримати юзерів":
            $('#chooseUserIdDiv').attr("hidden",false);
            userShowByIdBtnBind()
            break;


    }
});


$('#dropDownChooseAnimeType').on('click','a',function(){
    //$('#dropDownChooseAnimeType').empty();
    document.getElementById("typePublicationDropDown").insertAdjacentHTML("afterbegin",this.text);
    switch (this.text) {
        case "Аніме":
            showAddPublication();
            addBindToGenre();
            addBindToCategories();
            addAnimePublicationButtonBind();
            imageLabelsShowTxtButtonBind();
            break;
        case "Манга":
            break;
        case "Гра":
            break;

    }
});