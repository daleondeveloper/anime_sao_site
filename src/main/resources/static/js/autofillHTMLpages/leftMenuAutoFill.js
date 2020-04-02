"use strict";
// function rigthMenuAutoFill() {
var leftMenuHtml = "            <div class=\"col-12 col-md-4 col-lg-3 order-md-1\" >\n" +
    "                <div id=\"autorization_div\">\n" +
    "                    <card class=\"card border border-primary\" style=\" padding: 10%; margin: 0.4rem;\">\n" +
    "                        <form id=\"autorization_form\" action=\"\" method=\"post\"  >\n" +
    "                            <div class=\"form-group row\">\n" +
    "                                <label for=\"inputEmail3\" class=\"col-sm-12 col-form-label\"><h4>Авторизація</h4></label>\n" +
    "                                <div class=\"col-sm-12\">\n" +
    "                                    <input type=\"email\" class=\"form-control\" name=\"email\" value=\"\" id=\"inputEmail3\" placeholder=\"Email\">\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                            <div class=\"form-group row\">\n" +
    "                                <div class=\"col-sm-12\">\n" +
    "                                    <input type=\"password\" class=\"form-control\" name=\"password\" id=\"inputPassword3\" placeholder=\"Password\">\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                            <div class=\"form-group row\">\n" +
    "                                <div class=\"col-sm-6\">\n" +
    "                                    <button id=\"autorization_button\" class=\"btn btn-outline-primary btn-block\">Вхід</button>\n" +
    "                                </div>\n" +
    "                                <div class=\"col-sm-6\">\n" +
    "                                    <a href=\"/Registration\" class=\"btn btn-outline-primary btn-block\">Регістрація</a>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </form>\n" +
    "                        <div class=\"row\" id=\"mini_user_info_menu\" hidden=\"true\" >\n" +
    "                            <div class='preview col-7'>\n" +
    "                                <img src=\"\" id=\"avatarImg\" class=\"img-fluid rounded float-left border border-dark\" alt=\"avatar\">\n" +
    "                                <p class=\" text-primary text-left text-wrap text-break font-italic\" id = \"user_nick_name_txt_left_menu\">daleonandra</p>\n" +
    "                            </div>\n" +
    "\n" +
    "                            <div class=\"col-5\">\n" +
    "                                <button id=\"settingUser\" type=\"button\" class=\"btn btn-outline-primary btn-sm float-right\">Настройки</button>\n" +
    "                               <br><br>\n" +
    "                                <button id=\"logout\" type=\"button\" class=\"btn btn-outline-primary btn-sm float-right\">Вихід</button>\n" +
    "\n" +
    "                            </div>\n" +
    "                            <div class=\"row\">\n" +
    "                                <div class=\"col-12\">\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                        <div class=\"row\" id=\"mini_user_setting_menu\" hidden=\"true\" >\n" +
    "                            <div class=\"input-group\">\n" +
    "                                <div class=\"custom-file\">\n" +
    "                                    <form method=\"POST\" enctype=\"multipart/form-data\" id=\"uploadAvatar\">\n" +
    "                                        <label>Зміна аватара</label><br><br>\n" +
    "                                        <input type=\"file\" name=\"file\" value=\"ooo\" class=\"custom-file-input\" id=\"avatar_file_download\" aria-describedby=\"uploadAvatarButton\">\n" +
    "                                        <label class=\"custom-file-label\" for=\"avatar_file_download\"></label>\n" +
    "                                    </form>\n" +
    "\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div class=\"input-group-append\">\n" +
    "                                    <button class=\"btn btn-outline-primary btn-sm\" type=\"button\" id=\"uploadAvatarButton\">Зміна</button>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                            <!--<form method=\"POST\" enctype=\"multipart/form-data\" id=\"uplo312\">-->\n" +
    "                                <!--<input type=\"file\" name=\"file8\" class=\"\" id=\"123\">-->\n" +
    "                                <!--<label class=\"\" for=\"123\">kl</label>-->\n" +
    "                                <!--<input type=\"submit\" value=\"Submit\" id=\"uploadAvatarButton1\" class=\"btn btn-outline-primary btn-sm\"/>-->\n" +
    "                                <!--<div class=\"row\" id = \"download_avatar_error_div\">-->\n" +
    "                                    <!--<h5>Картинка загружена</h5>-->\n" +
    "                                 <!--</div>-->\n" +
    "                            <!--</form>-->\n" +
    "\n" +
    "                            <div class=\"row\">\n" +
    "                                <div class=\"col-12\">\n" +
    "                                    <br>\n" +
    "                                    <button id=\"saveSettingButton\" type=\"button\" class=\"btn btn-outline-primary btn-sm\">Назад</button>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "\n" +
    "                    </card>\n" +
    "                </div>\n" +
    "                <div id=\"last_update_post\">\n" +
    "                    <card class=\"card border border-primary\" style=\" padding: 1rem; margin: 0.4rem;\">\n" +
    "                        <div class=\"card-header\">\n" +
    "                            <h4>Остані оновлення:</h4>\n" +
    "                        </div><!--                    card-header-->\n" +
    "                        <div class=\"card-body\">\n" +
    "                            <div class=\"row\">\n" +
    "                                <div class=\"col-12\">\n" +
    "                                    <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <img class=\"tooltip-img\" src=\"../image/season_1/SAO_Alicization_MP1.jpg\" alt=\"Card image cap\">\n" +
    "                            <p>Год выхода: 2018<br>\n" +
    "                            Жанр: приключения, фэнтези<br>\n" +
    "                            Тип: ТВ<br>\n" +
    "                            Количество серий: 48 (25 мин.)<br>\n" +
    "                            Режиссёр: Ито Томохико</p>\n" +
    "                            </div>\n" +
    "                            </div>\n" +
    " '>\n" +
    "                                        <h6>Мастера меча онлайн (третий сезон) / Sword Art Online 3rd Season [1-24 из 48] [25 серия - как отдохну]</h6>\n" +
    "                                    </a>\n" +
    "                                </div>\n" +
    "                                <div class=\"col-12\">\n" +
    "                                    <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <img class=\"tooltip-img\" src=\"../image/season_1/SAO_GGO_MP1.jpg\" alt=\"Card image cap\">\n" +
    "                            <p class=\"collapse-group\"><strong>Год выхода:</strong> 2012<br>\n" +
    "\n" +
    "                                <strong>Жанр:</strong> приключения, фэнтези, романтика, драма<br>\n" +
    "\n" +
    "                                <strong>Тип:</strong> ТВ<br>\n" +
    "\n" +
    "                                <strong>Количество серий:</strong> 12 (25 мин.)<br>\n" +
    "\n" +
    "                                <strong>Режиссёр:</strong> Ито Томохико<br>\n" +
    "                            </div>\n" +
    "                            </div>\n" +
    " '>\n" +
    "                                        <h6>Мастера Меча Онлайн: Альтернативная \"Призрачная пуля\" / Sword Art Online Alternative: Gun Gale Online</h6>\n" +
    "                                    </a>\n" +
    "                                </div>\n" +
    "                                <div class=\"col-12\">\n" +
    "                                    <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <img class=\"tooltip-img\" src=\"../image/season_1/SAO_OrdinalScale_MP1.jpg\" alt=\"Card image cap\">\n" +
    "                            <p class=\"collapse-group\"><strong>Год выхода:</strong> 2017<br>\n" +
    "\n" +
    "                                <strong>Жанр:</strong> приключения, фэнтези, романтика, драма<br>\n" +
    "\n" +
    "                                <strong>Тип:</strong> ТВ<br>\n" +
    "\n" +
    "                                <strong>Количество серий:</strong>  1 (120 мин.))<br>\n" +
    "\n" +
    "                                <strong>Режиссёр:</strong> Ито Томохико<br>>\n" +
    "                            </div>\n" +
    "                            </div>\n" +
    " '>\n" +
    "                                        <h6>Мастера меча онлайн (фильм) / Gekijouban Sword Art Online: Ordinal Scale</h6>\n" +
    "                                    </a>\n" +
    "                                </div>\n" +
    "                                <div class=\"col-12\">\n" +
    "                                    <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <img class=\"tooltip-img\" src=\"../image/season_1/SAO_S1_Special_MP1.jpg\" alt=\"Card image cap\">\n" +
    "                            <p class=\"collapse-group\"><strong>Год выхода:</strong> 2013<br>\n" +
    "\n" +
    "                                <strong>Жанр:</strong> приключения, фэнтези<br>\n" +
    "\n" +
    "                                <strong>Тип:</strong> ТВ<br>\n" +
    "\n" +
    "                                <strong>Количество серий:</strong> 1 (100 мин.)<br>\n" +
    "\n" +
    "                                <strong>Режиссёр:</strong> Ито Томохико<br>\n" +
    "                            </div>\n" +
    "                            </div>\n" +
    " '>\n" +
    "                                        <h6>Мастера меча онлайн (спецвыпуск 1) / Sword Art Online: Extra Edition</h6>\n" +
    "                                    </a>\n" +
    "                                </div>\n" +
    "\n" +
    "                            </div><!--                        row-->\n" +
    "                        </div><!--                    card-body-->\n" +
    "                    </card>\n" +
    "                </div>\n" +
    "            </div>\n";
var centerMenu = document.getElementById("centerMenu");

centerMenu.insertAdjacentHTML("beforebegin", leftMenuHtml);
//}


