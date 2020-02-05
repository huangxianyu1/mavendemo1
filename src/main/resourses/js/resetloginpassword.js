function lp1() {
    var lpassword = document.getElementById("lpassword").value;
    var reg1 = /^[a-zA-Z0-9]{6,16}$/;
    if (!reg1.test(lpassword)) {
        span_lp1.innerHTML = "*请输入正确6-16位密码*";
    }
    else {
    	span_lp1.innerHTML = "*格式正确*";
    }
}
function lp2() {
    var lpassword = document.getElementById("lpassword").value;
    var lpassword2= document.getElementById("lpassword2").value;
    if (lpassword!=lpassword2) {
        span_lp2.innerHTML = "*两次输入密码不同，请重新输入*";
    }
    else {
    	span_lp2.innerHTML = "*匹配正确*";
    }
}
function btok(){
	var lpassword1=$("#lpassword1").val();
	var lpassword2=$("#lpassword2").val();
	var lpassword=$("#lpassword").val();
	var lo={'lpassword1':lpassword1,
			'lpassword2':lpassword2,
			'lpassword':lpassword,
	}
		$.get('updateLpassword.do',lo,function(code){
			if(code=='1'){
				$.messager.alert('提示','更改成功，请返回登陆');
        		setTimeout(function(){
                    location.href = "loginn.jsp";
                },3000);
			}else{
				$.messager.alert('提示','密码更改失败，请返回重试');
				setTimeout(function(){
                    location.href = "loginn.jsp";
                },3000);
			}
		});
}