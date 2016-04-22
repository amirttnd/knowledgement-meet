$(document).ready(function () {

});

function showModal(modalHtmlId) {
    $('#' + modalHtmlId.toString()).modal({
        show: 'true',
        backdrop: 'static',
        keyboard: false
    });
}
function hideModal(modalHtmlId) {
    $('#' + modalHtmlId).modal('hide');
}


Array.prototype.isValueExist = function (value) {
    var $array = this;
    return $array.indexOf(value) >= 0 ? true : false
};