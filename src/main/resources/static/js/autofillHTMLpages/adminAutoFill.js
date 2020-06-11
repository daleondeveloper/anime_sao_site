"use strict";
// function rigthMenuAutoFill() {
var leftMenuHtml = " <div class=\"col-12\">\n" +
    "                <button id=\"addPublicationBtn\" type=\"button\" class=\"btn btn-outline-primary\">Додати Публікацію</button>\n" +
    "                <button id=\"editPublicationBtn\" type=\"button\" class=\"btn btn-outline-primary\">Редагування Публікації</button>\n" +
    "                <button id=\"getUserBtn\" type=\"button\" class=\"btn btn-outline-primary\">Отримання користувачів</button>\n" +
    "                </div>\n" +
    "                <div id=\"divAdmin\" class=\"col-12\" >\n" +
    "                    \n" +
    "                    \n" +
    "                </div>";
var centerMenu = document.getElementById("centerMenu");

centerMenu.insertAdjacentHTML("afterbegin", leftMenuHtml);
//}


