var inputUserName= document.getElementById("username");

//光标不在这个框里了
inputUserName.onblur  = checkUsername;

    function checkUsername(){

    var key=true;
    if(inputUserName.value.trim().length>12||inputUserName.value.trim().length==0){

        document.getElementById("用户名过长").style.display="";
        key=false;
    }else{

        document.getElementById("用户名过长").style.display="none";
    }

    if(inputUserName.value.trim() === "Elysia"){

        document.getElementById("用户名重复").style.display="";
        key=false;
    }else{

        document.getElementById("用户名重复").style.display="none";
    }

    return key;
}



var inputPassword=document.getElementById("password");

inputPassword.onblur=checkPassword;

    function checkPassword() {

    var x=true;
    if(inputPassword.value.trim().length == 0){

        document.getElementById("密码过短").style.display="none";
        document.getElementById("密码安全性低").style.display="none";
        return false;
    }

    if(inputPassword.value.trim().length<6){

        document.getElementById("密码过短").style.display="";
        x=false;
    }else{

        document.getElementById("密码过短").style.display="none";
    }

    var arr = inputPassword.value.trim().split("");

    let 小写字母=false;
    let 大写字母=false;
    let 数字=false;
    let 特殊字符=false;
    for(let i=0;i<arr.length;i++){

        if('a'<=arr[i]&&arr[i]<='z'){

            小写字母=true;
        }else if('A'<=arr[i]&&arr[i]<='Z'){

            大写字母=true;
        }else if('0'<=arr[i]&&arr[i]<='9'){

            数字=true;
        }else{

            特殊字符=true;
        }
    }

    var key=小写字母&&大写字母&&数字&&特殊字符;
    if(!x||key){

        document.getElementById("密码安全性低").style.display="none";
        if(x==false){

            return x;
        }
    }else{

        document.getElementById("密码安全性低").style.display="";
        return false;
    }

    return true;

}


var inputTelephoneNumber=document.getElementById("telephoneNumber");

inputTelephoneNumber.onblur=checkTelephonNumber;

    function checkTelephonNumber(){

    if(!/^\d{11}$/.test(inputTelephoneNumber.value.trim())){

        document.getElementById("电话不符合要求").style.display="";
        return false;
    }else{

        document.getElementById("电话不符合要求").style.display="none";
        return true;
    }
}


var submitButton=document.getElementById("注册按钮");

submitButton.onsubmit=function (){

    var key=checkPassword()&&checkUsername()&&checkTelephonNumber();
    return key;
}
