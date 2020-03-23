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


async  function FeedList(){
    try{
        let response = await $.get('/');
        // $('#comments-list').html(JSON.stringify(response));
        for(let i=0;i<response.length;i++){
           //printedComments(response[i]);
            console.log(JSON.stringify(response[i]));

        }
    }catch (e) {
        $('#comments-list').html(JSON.stringify(e));
    }
}

FeedList();
async function FeedDtail() {




}
