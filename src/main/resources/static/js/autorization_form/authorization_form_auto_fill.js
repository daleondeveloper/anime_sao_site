"use strict"
$('#autorization_div').ready(function (e) {
    $('#autorization_div').html(' <card class="card border border-primary" style=" padding: 1rem; margin: 0.4rem;">\n' +
        '                <form id="autorization_form" action="" method="post">\n' +
        '                      <div class="form-group row">\n' +
        '                          <label for="inputEmail3" class="col-sm-12 col-form-label"><h4>Авторизація</h4></label>\n' +
        '                        <div class="col-sm-12">\n' +
        '                          <input type="email" class="form-control" name="email" id="inputEmail3" placeholder="Email">\n' +
        '                        </div>\n' +
        '                      </div>\n' +
        '                      <div class="form-group row">\n' +
        '                        <div class="col-sm-12">\n' +
        '                          <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password">\n' +
        '                        </div>\n' +
        '                      </div>\n' +
        '                      <div class="form-group row">\n' +
        '                        <div class="col-sm-6">\n' +
        '                          <button id="autorization_button" class="btn btn-outline-primary btn-block">Вхід</button>\n' +
        '                        </div>\n' +
        '                        <div class="col-sm-6">\n' +
        '                            <a href="/jsp/Reg" class="btn btn-outline-primary btn-block">Регістрація</a>\n' +
        '                        </div>\n' +
        '                      </div>\n' +
        '                </form>\n' +
        '                    <div class="row" id="mini_user_info_menu" hidden="true">\n' +
        '                        <div class="col-4">\n' +
        '                            <img src="/image/icon.jpg" Width="50" Height="50">\n' +
        '                        </div>\n' +
        '                        <div class="col-4" id="autorization_div_nick_name">\n' +
        '\n' +
        '                        </div>\n' +
        '                        <div class="col-4">\n' +
        '                            <button id="logout" type="button" class="btn btn-outline-primary btn-sm">Вихід</button>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                    <div class="row">\n' +
        '                        <div class="col-12">\n' +
        '\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                </card>');
    $("#autorization_div").load("exemple.html #page");
});