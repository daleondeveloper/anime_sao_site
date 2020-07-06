"use strict";
let typePublication;
$('#showPublicationBtn').click(function(){
    typePublication = $('#inlineTypeSelect option:selected').text();
    showAddPublication();
    addBindToGenre();
    addBindToCategories();
    $("#addPublicationBtn").bind("click",function () {
        alert("hj");
        let name = $('#inputName').val(),
            fullName = $('#inputFullName').val(),
            director = $('#inputDirector').val(),
            language = $('#inputLanguage').val(),
            descrition = $('#inputDescription').val();

        let genre = new Array(), i = 0;
        $('#spanGenre').find('span').each(function () {
                genre[i];
                i++;

        });
        let form = new Object();
        form.name = name;
        form.fullName = fullName;
        form.director = director;
        form.language = language;
        form.description = descrition;
        form.genre = genre;

        // let jsonForm = JSON.parse(form);

        $.ajax({
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
            },
            type: "POST",
            dataType: "json",
            data: form,
            url: "/api/v1/admin/publication/anime/add",
            success: function () {

            },
            error: function () {

            }

        })
    });
});

$('#addPublicationBtn').click(function () {


});
function addBindToGenre() {
    $('#inputGenre').bind('input', function () {
        $.ajax({
                beforeSend: function (request) {
                    request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
                },
                async: true,
                type: "GET",
                url: "/api/v1/admin/publication/genre/" + $('#inputGenre').val(),
                success: function (res) {
                    let i, j = 5, dropdownStr = "";
                    let dropdownDiv = document.getElementById("dropDownInputGenre");
                    if (res.length < j) {
                        j = res.length
                    }
                    for (i = 0; i < j; i++) {
                        let genre = res[i];
                        dropdownStr += "<a class=\"dropdown-item\" value=\"" + i + "\">" + genre.genre + "</a>\n"
                    }
                    $('#dropDownInputGenre').empty();
                    dropdownDiv.insertAdjacentHTML("beforeend", dropdownStr);
                    $('#dropDownInputGenre').show();

                    if (res.length === 0) {
                        $('#dropDownInputGenre').hide();
                    }
                },
                error: function () {
                    $('#dropDownInputGenre').hide();
                }
            }
        )
    });

    $('#dropDownInputGenre').on('click', 'a', function () {
        let textSpan, genreTxt = this.text;
        textSpan = "<span class=\"badge badge-primary\">" + genreTxt + "</span>\n";
        $('#spanGenre').find('span').each(function () {
            if ($(this).text() === genreTxt) {
                textSpan = "";
            }
        });
        document.getElementById("spanGenre").insertAdjacentHTML("afterbegin", textSpan);
        $('#dropDownInputGenre').hide();


    });
    $('#inputGenre').focusout(function () {
        $('#dropDownInputGenre').hide();
    });
}

function addBindToCategories() {
    $('#inputCategories').bind('input', function () {
        $.ajax({
                beforeSend: function (request) {
                    request.setRequestHeader('Authorization', ('Bearer_' + localStorage.getItem('token')));
                },
                async: true,
                type: "GET",
                url: "/api/v1/admin/publication/categories/" + $('#inputCategories').val(),
                success: function (res) {
                    let i, j = 5, dropdownStr = "";
                    let dropdownDiv2 = document.getElementById("dropDownInputCategories");
                    if (res.length < j) {
                        j = res.length
                    }
                    for (i = 0; i < j; i++) {
                        let genre = res[i];
                        dropdownStr += "<a class=\"dropdown-item\" value=\"" + i + "\">" + genre.categories + "</a>\n"
                    }
                    $('#dropDownInputCategories').empty();
                    dropdownDiv2.insertAdjacentHTML("afterbegin", dropdownStr);
                    $('#dropDownInputCategories').show();

                    if (res.length === 0) {
                        $('#dropDownInputCategories').hide();
                    }
                },
                error: function () {
                    $('#dropDownInputCategories').hide();
                }
            }
        )
    });
    $('#inputCategories').focusout(function () {
        $('#dropDownInputCategories').hide();
    });
}
    $('#dropDownInputCategories').on('click', 'a', function () {
        alert("jjj");
        let textSpan, categoriesTxt = this.text;
        textSpan = "<span class=\"badge badge-primary\">" + categoriesTxt + "</span>\n";
        $('#spanCategories').find('span').each(function () {
            if ($(this).text() === categoriesTxt) {
                textSpan = "";
            }
        });
        document.getElementById("spanCategories").insertAdjacentHTML("afterbegin", textSpan);
        $('#dropDownInputCategories').hide();


    });



