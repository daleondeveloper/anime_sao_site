"use strict";
// function rigthMenuAutoFill() {
var leftMenuHtml =
    "<div class=\"card border border-primary\" id=\"registration_div\" style=\"margin: 0.4rem;\">\n" +
    "                    <div class=\"card-header\">\n" +
    //
    //Вибір дії ( створення/ редагування публікації , огляд юзера)
    //
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
    //
    //Вибір типу публікацію для створення нової публікації
    //
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
    //
    //Вибір номера публікації для редагування її
    //
    "<div id=\"choosePublicationIdDiv\" hidden=\"true\">\n" +
    "                        <form class=\"form-inline\" >\n" +
    "                            <div class=\"form-group\">\n" +
    "                                <input type=\"number\" class=\"form-control\" id=\"publicationIdInput\" placeholder=\"Id публікації\">\n" +
    "                            </div>\n" +
    "                            <br>\n" +
    "                            <button id=\"publicationShowByIdButton\" type=\"button\" class=\"btn btn-primary mb-2\">Вибрати публікацію</button>\n" +
    "                        </form>\n" +
    "                        <span class=\"badge badge-primary\" id=\"publicationIdSpan\">3</span>\n" +
    "                            <span class=\"badge badge-primary\" id=\"publicationTypeSpan\">4</span>\n"+
    "                        </div>\n"+
   //
    //Вибір номера юзера для отримання інформації про нього
    //
    "<div id=\"chooseUserIdDiv\" hidden=\"true\">\n" +
    "                        <form class=\"form-inline\" >\n" +
    "                            <div class=\"form-group\">\n" +
    "                                <input type=\"number\" class=\"form-control\" id=\"userIdPublication\" placeholder=\"Id користувача\">\n" +
    "                            </div>\n" +
    "                            <br>\n" +
    "                            <button id=\"userShowByIdButton\" type=\"button\" class=\"btn btn-primary mb-2\">Показати користувача</button>\n" +
    "                        </form>\n" +
    "                        </div>"+
    //
    //
    //
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
    //
    //Вибір Жанру
    //
    "                                <div class=\"dropdown\">\n" +
    "                                <label id=\"txtGenre\" for=\"inputGenre\">Жанр</label>\n" +
    "                                <input type=\"text\" class=\"form-control\" id=\"inputGenre\" placeholder=\"жанр\">\n" +
    "                                <div id=\"dropDownInputGenre\" class=\"dropdown-menu\" >\n"+
    "                                </div>\n" +
    "                                <div id = \"spanGenre\">\n" +
    "                                </div>\n" +
    "                                </div>\n" +
    //
    //Вибір Категоріїї
    //
    "                                <div class=\"dropdown\">\n" +
    "                                <label id=\"txtCategories\" for=\"inputCategories\">Категорії</label>\n" +
    "                                <input type=\"text\" class=\"form-control\" id=\"inputCategories\" placeholder=\"категорії\">\n" +
    "                                <div id=\"dropDownInputCategories\" class=\"dropdown-menu\" aria-labelledby=\"inputCategories\">\n" +
    "                                </div>\n" +
    "                                <div id = \"spanCategories\">\n" +
    "                                </div>\n" +
    "                                </div>\n" +
    "                                    <br>\n" +
    //
    //Додавання аватарки( одна картинка)
    //
    "  <div class=\"custom-file\">\n" +
    "                                            <form method=\"POST\" enctype=\"multipart/form-data\" id=\"uploadAvatarPublication\">\n" +
    "                                                <input type=\"file\" name=\"file\" value=\"ooo\" class=\"custom-file-input\" id=\"avatar_Publication\" aria-describedby=\"uploadAvatarButton\" >\n" +
    "                                                <label class=\"custom-file-label\" for=\"avatar_file_download\" id=\"avatar_Publication_Label\"></label>\n" +
    "\n" +
    "                                            </form>\n" +
    "\n" +
    "                                        </div>\n" +
    //
    //Додавання інформаційних картинок (багато файлів)
    //
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
    //
    //Кнопка віправки даних для створення публікації
    //
    "                                <button type=\"button\" id='addPublicationBtn' class=\"btn btn-outline-primary\">Додати публікацію</button>" +
    "                                <button type=\"button\" id='editPublicationBtn' class=\"btn btn-outline-primary\">Редагувати публікацію</button>" +
    "                                </div>\n" ;

//}

document.getElementById("centerEditShowDiv").insertAdjacentHTML("afterbegin",addPubStr);
function showAddPublication(){
    $('#addAnimePublication').attr("hidden",false);
    $('#addPublicationBtn').attr('hidden',false);
    $('#editPublicationBtn').attr('hidden',true);

}
function showEditPublication(){
    $('#addAnimePublication').attr("hidden",false);
    $('#addPublicationBtn').attr('hidden',true);
    $('#editPublicationBtn').attr('hidden',false);

}


