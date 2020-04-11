"use strict";
function checkFile(blob,arrType){
    var fileMimeType = getBLOBFileHeader(blob);
    return arrType.find(function (element) {
        if(element === fileMimeType.split("/")[1])return true;
    })
}


function getBLOBFileHeader() {
    var mimeType ="";
    var fileReader = new FileReader();
    fileReader.onloadend = function(e) {
        var arr = (new Uint8Array(e.target.result)).subarray(0, 4);
        var header = "";
        for (var i = 0; i < arr.length; i++) {
            header += arr[i].toString(16);
        }
        mimeType = MIMEType(header);
    };
    // fileReader.readAsArrayBuffer(blob);
    return mimeType;
}
function MIMEType(headerString){

    switch (headerString) {
        case "89504e47":
            headerString = "image/png";
            break;
        case "47494638":
            headerString = "image/gif";
            break;
        case "ffd8ffe0":
        case "ffd8ffe1":
        case "ffd8ffe2":
            headerString = "image/jpeg";
            break;
        default:
            headerString = "unknown";
            break;
    }
    return headerString;
}