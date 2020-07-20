"use strict";

$('#dropDownChoose').on('click','a',function(){
    $('#dropDownChooseAnimeType').attr("hidden",true);
    $('#dropdownMenuButton').empty();
    document.getElementById("dropdownMenuButton").insertAdjacentHTML("afterbegin",this.text);
    switch (this.text) {
        case "Створити публікацію":
            $('#dropDownChooseAnimeType').attr("hidden",false);
            break;
         case "Редагувати публікацію":
            break;
        case "Отримати юзерів":
            break;


    }
})


$('#dropDownChooseAnimeType').on('click','a',function(){
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
})