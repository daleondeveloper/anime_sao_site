"use strict";
// function rigthMenuAutoFill() {
var leftMenuHtml =
    "                        <label class=\"my-1 mr-2\" for=\"inlineTypeSelect\">Тип публікації</label>\n" +
    "                        <select class=\"custom-select my-1 mr-sm-2\" id=\"inlineTypeSelect\">\n" +
    "                            <option selected>Вибрати...</option>\n" +
    "                            <option value=\"1\">Аніме</option>\n" +
    "                            <option value=\"2\">Манга</option>\n" +
    "                            <option value=\"3\">Гра</option>\n" +
    "                        </select>\n" +
    "\n" +
    "                        <button id=\"showPublicationBtn\" class=\"btn btn-outline-primary my-1\">Додати публікацію</button>\n" +
    "                    <button id=\"editPublicationBtn\" type=\"button\" class=\"btn btn-outline-primary\">Редагування Публікації</button>\n" +
    "                    <button id=\"getUserBtn\" type=\"button\" class=\"btn btn-outline-primary\">Отримання користувачів</button>\n";
var centerMenu = document.getElementById("centerMenu");

centerMenu.insertAdjacentHTML("afterbegin", leftMenuHtml);
//}
function showAddPublication(){
    let addPubStr = " <div class=\"form-group\">\n" +
        "                            <label for=\"inputName\">Назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputName\" placeholder=\"name\">\n" +
        "                        </div>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"inputFullName\">Повна назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputFullName\" placeholder=\"fullName\">\n" +
        "                        </div>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"inputDirector\">Назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputDirector\" placeholder=\"director\">\n" +
        "                        </div>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"inputLanguage\">Назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputLanguage\" placeholder=\"language\">\n" +
        "                        </div>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"inputDescription\">Назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputDescription\" placeholder=\"description\">\n" +
        "                        </div>\n" +
        "\n" +
        "                        <div class=\"dropdown\">\n" +
        "                            <label id=\"txtGenre\" for=\"inputGenre\">Назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputGenre\" placeholder=\"жанр\">\n" +
        "                            <div id=\"dropDownInputGenre\" class=\"dropdown-menu\" >\n" +
        "                                <a class=\"dropdown-item\" >fafa</a>\n" +
        "                                <a class=\"dropdown-item\" >fafa</a>\n" +
        "                                <a class=\"dropdown-item\" >fafa</a>\n" +
        "                            </div>\n" +
        "\n" +
        "                        <div id = \"spanGenre\">\n" +
        "                            <span class=\"badge badge-primary\">Primary</span>\n" +
        "                            <span class=\"badge badge-primary\">Primary</span>\n" +
        "                            <span class=\"badge badge-primary\">Primary</span>\n" +
        "                            <span class=\"badge badge-primary\">Primary</span>\n" +
        "\n" +
        "                        </div>\n" +
        "                        </div>\n" +
        "\n" +
        "                        <div class=\"dropdown\">\n" +
        "                            <label id=\"txtCategories\" for=\"inputCategories\">Назва публікації</label>\n" +
        "                            <input type=\"text\" class=\"form-control\" id=\"inputCategories\" placeholder=\"категорії\">\n" +
        "                            <div id=\"dropDownInputCategories\" class=\"dropdown-menu\" aria-labelledby=\"inputCategories\">\n" +
        "\n" +
        "                            </div>\n" +
        "\n" +
        "                            <div id = \"spanCategories\">\n" +
        "                                <span class=\"badge badge-primary\">Primary</span>\n" +
        "                                <span class=\"badge badge-primary\">Primary</span>\n" +
        "                                <span class=\"badge badge-primary\">Primary</span>\n" +
        "                                <span class=\"badge badge-primary\">Primary</span>\n" +
        "\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                        <button id=\"addPublicationBtn\" class=\"btn btn-outline-primary my-1\">Додати публікацію</button>\n";
    $('#centerMenu').empty();
    centerMenu.insertAdjacentHTML("afterbegin",addPubStr);

}


