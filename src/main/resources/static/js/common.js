function chkInputValue(id, msg) {
    console.log($.trim($(id).val()));
    if ( $.trim($(id).val()) == "") {
        alert(msg+"을(를) 입력해주세요.");
        $(id).focus();
        return false;
    }
    return true;
}