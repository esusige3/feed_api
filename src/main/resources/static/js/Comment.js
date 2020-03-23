function SimpleLogin(userId) {
    setCookie("userId",userId.toString(),1);
    console.log("간이 로그인!!! 쿠키 생성됨!");

}
var setCookie = function(name, value, exp) {
    var date = new Date();
    date.setTime(date.getTime() + exp*24*60*60*1000);
    document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
};



var setCookie = function(name, value, exp) {
    var date = new Date();
    date.setTime(date.getTime() + exp*24*60*60*1000);
    document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
};
var deleteCookie = function(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
}


출처: https://thereclub.tistory.com/59 [강남부자]
function writeComment() {
    let object = new Object();
    object
}