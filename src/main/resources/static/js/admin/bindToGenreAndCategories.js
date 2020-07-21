"use strict";

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
        badgeRemoveBind();

    });
    // $('#inputGenre').focusout(function () {
    //  //   $('#dropDownInputGenre').hide();
    // });
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
    // $('#inputCategories').focusout(function () {
    //     $('#dropDownInputCategories').hide();
    // });
}
$('#dropDownInputCategories').on('click', 'a', function () {
    let textSpan, categoriesTxt = this.text;
    textSpan = "<span class=\"badge badge-primary\">" + categoriesTxt + "</span>\n";
    $('#spanCategories').find('span').each(function () {
        if ($(this).text() === categoriesTxt) {
            textSpan = "";
        }
    });
    document.getElementById("spanCategories").insertAdjacentHTML("afterbegin", textSpan);
    $('#dropDownInputCategories').hide();
    badgeRemoveBind();


});
function badgeRemoveBind() {
    $(".badge-primary").on('click',function () {
        $(this).remove();
    })
}