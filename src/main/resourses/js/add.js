function Ename() {
	var names = document.getElementById("span_ename");
    var name = document.getElementById("ename").value; 
    console.log(name)
    var nameReg = /^[\u4e00-\u9fa5]{2,6}$/; 
    if (!nameReg.test(name)) {  
        names.innerHTML = "*请输入2~6个汉字*"; //输入不合法，显示提示信息
        // console.log(names.innerHTML = "请输入2~6个汉字!")
        return false;
    }
    else {
        names.innerHTML = "*格式正确*"; //验证通过后提示
        return true;
    }
}
function Etel() {
    //手机号验证
    var tel = document.getElementById("etel").value;
    var reg1 = /^1[3456789]\d{9}$/;
    if (!reg1.test(tel)) {
        span_etel.innerHTML = "*请输入正确的手机号*";
    }
    else {
        span_etel.innerHTML = "*格式正确*";
    }
}
function English() {
    //手机号验证
    var English = document.getElementById("english").value;
    var reg1 = /^[a-zA-Z\/ ]{2,20}$/;
    if (!reg1.test(English)) {
        span_english.innerHTML = "*请输入正确的英文名*";
    }
    else {
    	span_english.innerHTML = "*格式正确*";
    }
}
function Esalary() {
    //手机号验证
    var Esalary = document.getElementById("esalary").value;
    var reg1 = /^\d{0,7}(\.\d{0,2})?$/g;
    if (!reg1.test(Esalary)) {
        span_esalary.innerHTML = "*请输入正确的薪资*";
    }
    else {
    	span_esalary.innerHTML = "*格式正确*";
    }
}