"use strict";

//Загрузка даних публікації
//Загрузка аватарки

//header
// <h4>
// <a  href="#">&#10031; Мастера меча онлайн / Sword Art Online [1-25 из 25]</a>
// </h4>
//body
// <div class="row">
    // <div class="col-md-12">
// <img style="float:left;width:10rem;height:auto; margin-right:10px;" src="../image/season_1/main_picture_1.jpg" alt="Card image cap">
//     <p class="collapse-group"><strong>Год выхода:</strong> 2012<br>
//
// <strong>Жанр:</strong> приключения, фэнтези, романтика, драма<br>
//
// <strong>Тип:</strong> ТВ<br>
//
// <strong>Количество серий:</strong> 25 (25 мин.)<br>
//
// <strong>Режиссёр:</strong> Ито Томохико<br>
// <strong>Описание:</strong> Разработчики онлайн игр каждый год радуют своих пользователей новыми инновациями и современными технологиями, которые позволяют игроку более реалистично погружаться в любимый игровой мир. В 2022 год эта деятельность достигла своего пика. Программисты придумали специальный нейро шлем, которые соединяется
// <span class="collapse" id="viewdetails">с нервной системой и позволяет игроку полностью погрузится в виртуальную реальность. Такой прорыв стал настоящим подарком для любого геймера и люди начали жить в двух мирах.<br><br>
//
// Эта история об одной из таких игр, которая стала настоящей трагедией для всего человечества. "Мастер меча онлайн" - разлетелся с полок магазина в миг и множество игроков по всему миру погрузились в этот прекрасный виртуальный мир, но их ждала трагедия. В какой-то момент из игры невозможно было выйти и разработчик обратился ко всем пользователям. Он сообщил им, что единственный выход из игры это пройти ее до конца. Если кто-то попытается выйти другим способом, его ждет смерть. Разработчик попросту сошел с ума и люди в действительности стали погибать в реальном мире. За месяц игры умерло около 2000 человек и не какие меры не были предприняты. Люди осознали, что им ничего не остается делать, кроме как проходить игру. Сможет ли кто-то это сделать и выбраться из ловушки безумного гения? Узнаем. </span>
//     <a href="#" data-toggle="collapse" data-target="#viewdetails">Більше... &raquo;</a>
// </p>
// </div>
// </div>
//footer
// <div class="row">
//     <div class="col-9">
//     <p><strong>Категории:</strong> ТВ, 2012, Драма, Приключения, Романтика, Фэнтези</p>
// </div>
// <div class="col-3">
//     <button type="button" class="btn btn-primary" style="display: block; margin-left: auto;">Смотреть</button>
//     </div>
//     </div>

$('#autorization_div').ready(function(){
    createNumericalPageNavigation();


});

function createNumericalPageNavigation(){

    let pageCount = 1;
    let publicationInPage = 10;

    $.ajax({
        url:"/api/v1/publication/anime/getCount",
        type:"GET",
        success: function(res){
            pageCount = res / publicationInPage;
            if((res%publicationInPage) !== 0 ){
                pageCount ++;
            }
            $('#paginatio').twbsPagination({
                totalPages: pageCount,
                visiblePages: 7,

                onPageClick: function (event, page) {
                    getAnimePublicationAjax(page-1);
                }
            });
        },
        error: function(){
            pageCount = 1;
        }
    });
}

function getAnimePublicationAjax(page){
    $.ajax({
        url:("/api/v1/publication/anime/getAnime/" + page),
        type:"GET",
        success: function(res){
            let i;
            $('#publicationDiv').empty();

            for(i = 0; i < res.content.length; i++){
                let publication = res.content[i],genres = "",categories = "";

                for(let i = 0 ; i < publication.genres.length; i++){
                    genres += publication.genres[i].genre + ", ";
                }
                for(let i = 0 ; i < publication.categories.length; i++){
                    categories += publication.categories[i].categories + ", ";
                }

                let stringPublicationDiv = createPublicationdiv(publication.id,
                     publication.fullName, genres, publication.director, publication.language,
                     publication.createDate,
                     publication.description,categories,publication.countSeries) ;
                let publicationDiv = document.getElementById("publicationDiv");
                publicationDiv.insertAdjacentHTML("beforeend", stringPublicationDiv);
                ajaxDownloadAvatar(publication.id);
            }
        },
        error: function(){

        }

    });
}

function ajaxDownloadAvatar(id) {
    $.ajax({
        async:"true",
        datatype: "json",
        url: ("/api/v1/publication/getAvatar/" + id),
        type: "GET",
        processData: "false",
        contentType: "false",
        success: function (res) {
            $('#publicationImage' + id).attr('src', 'data:image/jpeg;base64,'+ res);
        },
        error: function () {

        }

    })
}

function createPublicationdiv(id,fullName,genre, director, language,createDate, description, categories, series) {
    let stringDiv = "                <div class=\"card border border-primary\" style=\"margin: 0.4rem;\">\n" +
        "                    <div class=\"card-header\">\n" +
        "                        <h4>\n" +
        "                          <a  href=\"anime\\" + id + "\">&#10031; " + fullName + "</a>\n" +
        "                        </h4>\n" +
        "                    </div><!--                    card-header-->\n" +
        "                  <div class=\"card-body\">\n" +
        "                      <div class=\"row\">\n" +
        "                        <div class=\"col-md-12\">\n" +
        "                              <img id=\"publicationImage"+ id +"\" style=\"float:left;width:10rem;height:auto; margin-right:10px;\" src=\"\" alt=\"Card image cap\">\n" +
        "                            <p class=\"collapse-group\"><strong>Дата випуску:</strong>" + createDate + "<br>\n" +
        "\n" +
        "                                <strong>Жанр:</strong>" + genre + "<br>\n" +
        "\n" +
        "                                <strong>Тип:</strong> ТВ<br>\n" +
        "\n" +
        "                                <strong>Количество серий:</strong> " + series + "<br>\n" +
        "\n" +
        "                                <strong>Режиссёр:</strong>" + director + "<br>\n" +
        "                                <strong>Описание:</strong>" + description.slice(0,250) + "\n" +
        "                            <span class=\"collapse\" id=\"viewdetails" + id + "\">" + description.slice(251,description.length) + "</span>\n" +
        "                            <a href=\"#\" data-toggle=\"collapse\" data-target=\"#viewdetails" + id + "\">Більше... &raquo;</a>\n" +
        "                            </p>\n" +
        "                                \n" +
        "                                <div id=\"accordion\">\n" +
        "                                  <div class=\"card\">\n" +
        "                                    <div class=\"card-header\" id=\"headingOne\" style=\"padding: 0; background: d8d2d9;\">\n" +
        "                                      <h5 class=\"mb-0\">\n" +
        "                                        <button class=\"btn btn-link\" style=\"padding: 0\" data-toggle=\"collapse\" data-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\n" +
        "                                          Это аниме состоит из:\n" +
        "                                        </button>\n" +
        "                                      </h5>\n" +
        "                                    </div>\n" +
        "\n" +
        "                                    <div id=\"collapseOne\" class=\"collapse\" aria-labelledby=\"headingOne\" data-parent=\"#accordion\">\n" +
        "                                      <div class=\"card-body\">\n" +
        "                                       <ol>\n" +
        "                                           <li><a href=\"#\">Мастера меча онлайн</a> - ТВ (25 эп.), адаптация ранобэ, 2012</li>\n" +
        "                                           <li><a href=\"#\">Мастера меча онлайн (спецвыпуск 1)</a> - ТВ-спэшл, продолжение, 2013</li>\n" +
        "                                           <li><a href=\"#\">Мастера меча онлайн (второй сезон)</a> - ТВ (24 эп.), продолжение, 2014</li>\n" +
        "                                           <li><a href=\"#\">Мастера меча онлайн (фильм)</a> - п/ф, адаптация ранобэ, 2017</li>\n" +
        "                                           <li><a href=\"#\">Мастера меча онлайн (третий сезон)</a> - ТВ (12+ эп.), продолжение, 2018</li>\n" +
        "                                           <li><a href=\"#\">Мастера Меча Онлайн: Альтернативная \"Призрачная пуля\"</a> - ТВ (12+ эп.), адаптация ранобэ, 2018</li>\n" +
        "                                        </ol>\n" +
        "                                      </div><!--                                        card-body-->\n" +
        "                                    </div><!--                                      collapse show one-->\n" +
        "                                  </div><!--                                    card-collapse-->\n" +
        "                                </div><!--                            id-accordition-->\n" +
        "                        </div><!--                          col-12 -card-body -->\n" +
        "                    </div><!--                      row - card-body -->\n" +
        "                      \n" +
        "                  </div><!--                    card-body-->\n" +
        "                    <div class=\"card-footer text-muted\">\n" +
        "                        <div class=\"row\">\n" +
        "                            <div class=\"col-9\">\n" +
        "                                <p><strong>Категории:</strong>" + categories + "</p>\n" +
        "                            </div>\n" +
        "                            <div class=\"col-3\">\n" +
        "                                <a id=\"goToPublication" + id + "\"  class=\"btn btn-primary\" href=\"anime\\" + id + "\" style=\"display: block; margin-left: auto;\">Дивитися</a>\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                      </div><!--                    card-footer-->\n" +
        "                </div><!--                card-->\n"
        return stringDiv;
}

