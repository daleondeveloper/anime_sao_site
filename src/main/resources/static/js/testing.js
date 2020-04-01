"use strict";
var headerText = '<div> <h3> Голова </h3> </div>';

function setHeader(){
    var header = document.createElement("div");
    header.innerHTML = headerText;
    document.body.insertAdjacentElement('afterbegin', header);
}
