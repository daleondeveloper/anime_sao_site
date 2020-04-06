"use strict";
// function rigthMenuAutoFill() {
var headerMenuHtml = "<header class=\"header\">\n" +
    "</header>\n" +
    "<nav class=\"navbar  navbar-expand-lg navbar-dark bg-dark sticky-top\">\n" +
    "\n" +
    "    <a href=\"#\" class=\"navbar-brand\">\n" +
    "        <img src=\"../image/icon.jpg\"\n" +
    "             Width=\"50\" Height=\"50\"\n" +
    "             alt=\"logo\">\n" +
    "        Sword Art Online\n" +
    "    </a>\n" +
    "    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\n" +
    "            data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n" +
    "            aria-label=\"Toogle-navigation\">\n" +
    "        <span class=\"navbar-toggler-icon\"></span>\n" +
    "    </button>\n" +
    "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
    "        <ul class=\"navbar-nav mr-auto\">\n" +
    "            <li class=\"nav-item active\">\n" +
    "                <a href=\"/\" class=\"nav-link\">Головна</a>\n" +
    "            </li>\n" +
    "            <li class=\"nav-item \">\n" +
    "                <a href=\"/game\" class=\"nav-link\">Ігри</a>\n" +
    "            </li>\n" +
    "            <li class=\"nav-item\">\n" +
    "                <a href=\"/anime\" class=\"nav-link\">Аніме</a>\n" +
    "            </li>\n" +
    "            <li class=\"nav-item\">\n" +
    "                <a href=\"/manga\" class=\"nav-link\">Манга</a>\n" +
    "            </li>\n" +
    "            <li class=\"nav-item\">\n" +
    "                <a href=\"/contacts\" class=\"nav-link\">Контакти</a>\n" +
    "            </li>\n" +
    "        </ul>\n" +
    "        <form class=\"form-inline\">\n" +
    "            <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Пошук по сайту\" aria-label=\"Search\">\n" +
    "            <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Пошук</button>\n" +
    "        </form>\n" +
    "    </div>\n" +
    "\n" +
    "\n" +
    "</nav><!--    navbar-->";

document.body.insertAdjacentHTML("afterbegin", headerMenuHtml);
//}


