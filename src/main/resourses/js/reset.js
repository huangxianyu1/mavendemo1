function Lpassword() {
		var lp = document.getElementById("lpassword").value;
		var reg1 = /^[a-zA-Z0-9]{6,16}$/;
		if (!reg1.test(lp)) {
			span_lpassword.innerHTML = "*密码不能含有非法字符，长度在6-16之间*";
		} else {
			span_lpassword.innerHTML = "";
		}
	}
function answ(){
	var lanswer=document.getElementById("lanswer").value;
	var reg = /(^[\u4E00-\u9FA5a-zA-Z0-9_]{2,12}$)/;
	 if(!reg.test(lanswer)){
		 span_lanswer.innerHTML = '*输入不符合标准*';
	 }else{
		 span_lanswer.innerHTML = '';
	 
	 }
	 
	}
function btok(){
	var lname=$("#lname").val();
	var lpassword=$("#lpassword").val();
	var lquestion=$("#lquestion").val();
	var lanswer=$("#lanswer").val();
	var lo={'lname':lname,
			'lpassword':lpassword,
			'lquestion':lquestion,
			'lanswer':lanswer,
	}
		$.get('reset.do',lo,function(code){
			if(code=='1'){
				$.messager.alert('提示','重置成功，请返回登陆');
        		setTimeout(function(){
                    location.href = "loginn.jsp";
                },1000);
			}else{
				$.messager.alert('提示','密码更改失败，请返回重试');
				setTimeout(function(){
                    location.href = "loginn.jsp";
                },1000);
			}
		});
}