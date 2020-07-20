"use strict";
// function rigthMenuAutoFill() {
var leftMenuHtml =
    "<div class=\"card border border-primary\" id=\"registration_div\" style=\"margin: 0.4rem;\">\n" +
    "                    <div class=\"card-header\">\n" +
    "                        <div class=\"dropdown\" id=\"dropDownChoose\">\n" +
    "                                <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
    "                                Вибір дії\n" +
    "                            </button>\n" +
    "                            <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\n" +
    "                                <a class=\"dropdown-item\" href=\"#\">Створити публікацію</a>\n" +
    "                                <a class=\"dropdown-item\" href=\"#\">Редагувати публікацію</a>\n" +
    "                                <a class=\"dropdown-item\" href=\"#\">Отримати юзерів</a>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                        <div class=\"dropdown\" id=\"dropDownChooseAnimeType\" hidden=\"true\">\n" +
    "                            <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"typePublicationDropDown\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
    "                                Вибір типу публікації\n" +
    "                            </button>\n" +
    "                            <div class=\"dropdown-menu\" aria-labelledby=\"typePublicationDropDown\">\n" +
    "                                <a class=\"dropdown-item\" href=\"#\">Аніме</a>\n" +
    "                                <a class=\"dropdown-item\" href=\"#\">Манга</a>\n" +
    "                                <a class=\"dropdown-item\" href=\"#\">Гра</a>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </div><!--                    card-header-->" +
    "<div class=\"card-body\">\n" +
    "                        <div class=\"row\">\n" +
    "                            <div id=\"centerEditShowDiv\" class=\"col-12\" >" +
    "</div><!--                      row - card-body -->\n" +
    "\n" +
    "                    </div><!--                    card-body-->\n" +
    "                </div><!--                card-->";
var centerMenu = document.getElementById("centerMenu");

centerMenu.insertAdjacentHTML("afterbegin", leftMenuHtml);

let addPubStr = "<div id=\"addAnimePublication\" hidden=\"true\">" +
    "                                   <div class=\"form-group\" >\n" +
    "                                        <label for=\"inputName\">Назва публікації</label>\n" +
    "                                        <input type=\"text\" class=\"form-control\" id=\"inputName\" placeholder=\"name\">\n" +
    "                                    </div>\n" +
    "                                    <div class=\"form-group\">\n" +
    "                                        <label for=\"inputFullName\">Повна назва публікації</label>\n" +
    "                                        <input type=\"text\" class=\"form-control\" id=\"inputFullName\" placeholder=\"fullName\">\n" +
    "                                    </div>\n" +
    "                                    <div class=\"form-group\">\n" +
    "                                        <label for=\"inputDirector\">Автор</label>\n" +
    "                                        <input type=\"text\" class=\"form-control\" id=\"inputDirector\" placeholder=\"director\">\n" +
    "                                    </div>\n" +
    "                                    <div class=\"form-group\">\n" +
    "                                        <label for=\"inputLanguage\">Мова публікації</label>\n" +
    "                                        <input type=\"text\" class=\"form-control\" id=\"inputLanguage\" placeholder=\"language\">\n" +
    "                                    </div>\n" +
    "                                    <div class=\"form-group\">\n" +
    "                                        <label for=\"inputDescription\">Опис</label>\n" +
    "                                        <input type=\"text\" class=\"form-control\" id=\"inputDescription\" placeholder=\"description\">\n" +
    "                                    </div>\n" +
    "                                <div class=\"form-group\">\n" +
    "                                    <label for=\"inputCountSeries\">Кількість серій</label>\n" +
    "                                    <input type=\"number\" class=\"form-control\" value=\"0\" id=\"inputCountSeries\" placeholder=\"countSeries\">\n" +
    "                                </div>\n" +
    "                                <div class=\"dropdown\">\n" +
    "                                <label id=\"txtGenre\" for=\"inputGenre\">Назва публікації</label>\n" +
    "                                <input type=\"text\" class=\"form-control\" id=\"inputGenre\" placeholder=\"жанр\">\n" +
    "                                <div id=\"dropDownInputGenre\" class=\"dropdown-menu\" >\n" +
    "                                <a class=\"dropdown-item\" >fafa</a>\n" +
    "                                <a class=\"dropdown-item\" >fafa</a>\n" +
    "                                <a class=\"dropdown-item\" >fafa</a>\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div id = \"spanGenre\">\n" +
    "\n" +
    "                                </div>\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div class=\"dropdown\">\n" +
    "                                <label id=\"txtCategories\" for=\"inputCategories\">Назва публікації</label>\n" +
    "                                <input type=\"text\" class=\"form-control\" id=\"inputCategories\" placeholder=\"категорії\">\n" +
    "                                <div id=\"dropDownInputCategories\" class=\"dropdown-menu\" aria-labelledby=\"inputCategories\">\n" +
    "\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div id = \"spanCategories\">\n" +
    "                                <span class=\"badge badge-primary\">Primary</span>\n" +
    "                                <span class=\"badge badge-primary\">Primary</span>\n" +
    "                                <span class=\"badge badge-primary\">Primary</span>\n" +
    "                                <span class=\"badge badge-primary\">Primary</span>\n" +
    "                                </div>\n" +
    "                                </div>\n" +
    "\n" +
    "                                    <br>\n" +
    "                                    <br>\n" +
    "                                <div class=\"form-group\">\n" +
    "  <div class=\"custom-file\">\n" +
    "                                            <form method=\"POST\" enctype=\"multipart/form-data\" id=\"uploadAvatarPublication\">\n" +
    "                                                <input type=\"file\" name=\"file\" value=\"ooo\" class=\"custom-file-input\" id=\"avatar_Publication\" aria-describedby=\"uploadAvatarButton\" >\n" +
    "                                                <label class=\"custom-file-label\" for=\"avatar_file_download\" id=\"avatar_Publication_Label\"></label>\n" +
    "\n" +
    "                                            </form>\n" +
    "\n" +
    "                                        </div>\n" +
    "                                    <div class=\"custom-file\">\n" +
    "                                        <form method=\"POST\" enctype=\"multipart/form-data\" id=\"uploadImagesInfoPublication\">\n" +
    "<!--                                            <label>Зміна аватара</label><br><br>-->\n" +
    "                                            <input type=\"file\" name=\"files\" value=\"ooo\" class=\"custom-file-input\" id=\"images_Publication\" aria-describedby=\"uploadAvatarButton\" multiple>\n" +
    "                                            <label class=\"custom-file-label\" for=\"avatar_file_download\" id=\"images_Publication_Label\"></label>\n" +
    "\n" +
    "                                        </form>\n" +
    "\n" +
    "                                    </div>" +
    "                                    <br>\n" +
    "\n" +
    "                                <button type=\"button\" id='addPublicationBtn' class=\"btn btn-outline-primary\">Додати публікацію</button>" +
    "                                </div>\n" ;

//}

document.getElementById("centerEditShowDiv").insertAdjacentHTML("afterbegin",addPubStr);
function showAddPublication(){
    $('#addAnimePublication').attr("hidden",false);

}


