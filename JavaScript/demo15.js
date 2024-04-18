alert("访问百度?")

var x=3;

setInterval(function wait(){

    document.body.innerHTML = "";
    document.write(x+"秒钟后跳转到百度页面...");
    if(x==0){

        location.href = "http://www.baidu.com"
    }
    x--;
},1000)

