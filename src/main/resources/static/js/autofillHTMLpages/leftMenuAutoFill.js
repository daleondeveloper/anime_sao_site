"use strict";
// function rigthMenuAutoFill() {
var leftMenuHtml = "            <div class=\"col-12 col-md-4 col-lg-3 order-md-1\" >\n" +
    "                <div id=\"autorization_div\">\n" +
    "                <card class=\"card border border-primary\" style=\" padding: 1rem; margin: 0.4rem;\">\n" +
    "                <form id=\"autorization_form\" action=\"\" method=\"post\" >\n" +
    "                      <div class=\"form-group row\">\n" +
    "                          <label for=\"inputEmail3\" class=\"col-sm-12 col-form-label\"><h4>Авторизація</h4></label>\n" +
    "                        <div class=\"col-sm-12\">\n" +
    "                          <input type=\"email\" class=\"form-control\" name=\"email\" value=\"\" id=\"inputEmail3\" placeholder=\"Email\">\n" +
    "                        </div>\n" +
    "                      </div>\n" +
    "                      <div class=\"form-group row\">\n" +
    "                        <div class=\"col-sm-12\">\n" +
    "                          <input type=\"password\" class=\"form-control\" name=\"password\" id=\"inputPassword3\" placeholder=\"Password\">\n" +
    "                        </div>\n" +
    "                      </div>\n" +
    "                      <div class=\"form-group row\">\n" +
    "                        <div class=\"col-sm-6\">\n" +
    "                          <button id=\"autorization_button\" class=\"btn btn-outline-primary btn-block\">Вхід</button>\n" +
    "                        </div>\n" +
    "                        <div class=\"col-sm-6\">\n" +
    "                            <a href=\"/Registration\" class=\"btn btn-outline-primary btn-block\">Регістрація</a>\n" +
    "                        </div>\n" +
    "                      </div>\n" +
    "                </form>\n" +
    "                    <div class=\"row\" id=\"mini_user_info_menu\" hidden=\"true\">\n" +
    "                        <div class='preview col-4'>\n" +
    "                            <img src=\"\" id=\"avatarImg\" width=\"100\" height=\"100\" alt=\"avatar\">\n" +
    "                        </div>\n" +
    "                        <div class=\"col-4\" id=\"autorization_div_nick_name\">\n" +
    "\n" +
    "                        </div>\n" +
    "                        <div class=\"col-4\">\n" +
    "                            <button id=\"settingUser\" type=\"button\" class=\"btn btn-outline-primary btn-sm\">Настройки</button>\n" +
    "                        </div>\n" +
    "                        <div class=\"row\">\n" +
    "                            <div class=\"col-12\">\n" +
    "                                <button id=\"logout\" type=\"button\" class=\"btn btn-outline-primary btn-sm\">Вихід</button>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"row\" id=\"mini_user_setting_menu\" hidden=\"true\" >\n" +
    "                        <form method=\"POST\" enctype=\"multipart/form-data\" id=\"uploadAvatar\">\n" +
    "                            <input type=\"text\" name=\"extraField\"/><br/>\n" +
    "                            <input type=\"file\" name=\"file\"/><br/>\n" +
    "                            <input type=\"submit\" class=\"btn btn-outline-primary btn-sm\" value=\"Submit\" id=\"uploadAvatarButton\"/><br/>\n" +
    "                            <input type=\"text\" id = \"errorAvatarDownloadtxt\"/><br/>\n" +
    "                        </form>\n" +
    "                            </div>\n" +
    "                        <div class=\"row\">\n" +
    "                            <div class=\"col-auto\">\n" +
    "                            <button id=\"saveSettingButton\" type=\"button\" class=\"btn btn-outline-primary btn-sm\">Зберегти</button>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                </card>\n" +
    "                </div>\n" +
    "                <div id=\"last_update_post\">\n" +
    "                <card class=\"card border border-primary\" style=\" padding: 1rem; margin: 0.4rem;\">\n" +
    "                    <div class=\"card-header\">\n" +
    "                        <h4>Остані оновлення:</h4>\n" +
    "                    </div><!--                    card-header-->\n" +
    "                    <div class=\"card-body\">\n" +
    "                        <div class=\"row\">\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
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
    "                                <h6>Мастера меча онлайн (третий сезон) / Sword Art Online 3rd Season [1-24 из 48] [25 серия - как отдохну]</h6>\n" +
    "                            </a>\n" +
    "                            </div>\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
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
    "                                <h6>Мастера Меча Онлайн: Альтернативная \"Призрачная пуля\" / Sword Art Online Alternative: Gun Gale Online</h6>\n" +
    "                            </a>\n" +
    "                            </div>\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
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
    "                                <h6>Мастера меча онлайн (фильм) / Gekijouban Sword Art Online: Ordinal Scale</h6>\n" +
    "                            </a>\n" +
    "                            </div>\n" +
    "                            <div class=\"col-12\">\n" +
    "                            <a  class=\"\" href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" data-html=\"true\" data-title='<div class=\"row\">\n" +
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
    "                                <h6>Мастера меча онлайн (спецвыпуск 1) / Sword Art Online: Extra Edition</h6>\n" +
    "                            </a>\n" +
    "                            </div>\n" +
    "\n" +
    "                        </div><!--                        row-->\n" +
    "                    </div><!--                    card-body-->\n" +
    "                </card>\n" +
    "                </div>\n" +
    "            </div><!--            col-3-->\n";
var centerMenu = document.getElementById("centerMenu");

centerMenu.insertAdjacentHTML("beforebegin", leftMenuHtml);
//}


