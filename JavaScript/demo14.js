function on(){

    document.getElementById('myImage').src="resource/2-1.jpg"
}

function off(){

    document.getElementById('myImage').src="resource/2.jpg"
}

var x=0;
setInterval(function (){


    if(x%2==0){
        on();
    }else{
        off();
    }
    x++;
},500)