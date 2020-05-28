"use strict"

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
    alert("sss");
    createNumericalPageNavigation(100);


});

function createNumericalPageNavigation(start){

    let pageCount = 1;
    let publicationInPage = 3;

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
                    getAnimePublicationAjax(page);
                }
            });
        },
        error: function(){
            pageCount = 1;
        }
    });




    // $.ajax({
    //     beforeSend: function (request) {
    //         request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
    //     },
    //     url : "/api/v1/publication/getNumberOfPublication",
    //     type : "GET",
    //     success : function (res) {
    //
    //     }
    // })


}

function getAnimePublicationAjax(page){
    $.ajax({
        url:("/api/v1/publication/anime/getAime" + page),
        type:"GET",
        success: function(res){

        },
        error: function(){

        }

    });
}

function publicationShow() {
    for(var i = 1 , j = 10; i < 11; i++, j++){

    }

}

