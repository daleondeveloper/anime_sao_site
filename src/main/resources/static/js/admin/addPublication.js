"use strict";
$('#addPublicationBtn').click(function(){
   var form

});

$('#inputGenre').bind('input', function () {
    $.ajax({
        beforeSend: function(request) {
            request.setRequestHeader('Authorization',('Bearer_' + localStorage.getItem('token')));
        },
        async:true,
        type:"GET",
        url:"",
        data:$('#inputGenre').serialize(),
        dataType:"json",
        success:function(res){
            let i,j = 20,dropdownStr = "";
            let dropdownDiv = document.getElementById("dropDownInputGenre");
            if(res.content.length < 20 ){j = res.content.length}
            for(i = 0; i < j; i++){
                let genre = res.content[i];
                dropdownStr += "<a class=\"dropdown-item\" href=\"#\">" + genre.name + "</a>\n"
            }
            dropdownDiv.empty();
            dropdownDiv.insertAdjacentHTML("afterbegin",dropdownStr);
        },
        error:function () {
        }
        }
    )
});