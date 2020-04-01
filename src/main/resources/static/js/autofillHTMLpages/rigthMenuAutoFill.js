"use strict";
// function rigthMenuAutoFill() {
    var rigthMenuHtml = "            <div class=\"col-12 col-md-4 col-lg-3 order-md-3 \">\n" +
        "                <card class=\"card border border-primary\" style=\" padding: 1rem; margin: 0.4rem;\">\n" +
        "                    <div id=\"carouselExampleSlidesOnly\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
        "                      <div class=\"carousel-inner\">\n" +
        "                        <div class=\"carousel-item\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/kirito.jpeg\" alt=\"Kirito\">\n" +
        "                        </div>\n" +
        "                        <div class=\"carousel-item active\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/asuna.jpg\" alt=\"Asuna\">\n" +
        "                        </div>\n" +
        "                        <div class=\"carousel-item\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/kayaba.png\" alt=\"Kayaba\">\n" +
        "                        </div>\n" +
        "                        <div class=\"carousel-item\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/klein.jpg\" alt=\"Klein\">\n" +
        "                        </div>\n" +
        "                        <div class=\"carousel-item\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/silica.jpg\" alt=\"Silica\">\n" +
        "                        </div>\n" +
        "                        <div class=\"carousel-item\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/casemiro.jpg\" alt=\"Casemiro\">\n" +
        "                        </div>\n" +
        "                        <div class=\"carousel-item\">\n" +
        "                          <img class=\"d-block w-100 img-fluid\" src=\"../image/herous_caroules/eugeo.jpg\" alt=\"Eugeo\">\n" +
        "                        </div>\n" +
        "                      </div>\n" +
        "                    </div>\n" +
        "                </card>\n" +
        "            </div><!--            col-3-->\n";
    var centerMenu = document.getElementById("centerMenu");

    centerMenu.insertAdjacentHTML("afterend", rigthMenuHtml);
//}


