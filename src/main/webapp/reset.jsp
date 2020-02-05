<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆修改</title>
<script src="js/jquery-1.9.1.js"></script>
<!-- 引入easyui -->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="${pageContext.request.contextPath }/js/reset.js"></script>
<link href="${pageContext.request.contextPath }/css/zreset.css" rel="stylesheet" type="text/css" />
<style>

</style>
</head>
<body>
	<form action="reset.do" method="post">
		<table align="center" border="1">
			<tr>
				<td align="center" colspan="2">登录账户重置</td>
			</tr>
			<tr>
				<td>登录名</td>
				<td>
				<input type="text" name="lname" id="lname" value="${lo.getLname()}" class="input"></td>
			</tr>
			<tr>
				<td>登陆密码</td>
				<td><input type="text" name="lpassword" id="lpassword"
					placeholder="请输入6-16位新密码" class="input" onblur="Lpassword()"><br>
					<span id="span_lpassword"></span></td>
			</tr>
			<tr>
				<td>密保问题</td>
				<td><select name="lquestion" id="lquestion">
						<option value="您的生日是什么时候？" selected="selected">您的生日是什么时候？</option>
						<option value="您的女朋友叫什么？">您的女朋友叫什么？</option>
						<option value="您的大学叫什么？">您的大学叫什么？</option>
				</select></td>
			</tr>
			<tr>
				<td>密保答案</td>
				<td><input type="text" name="lanswer" id="lanswer" placeholder="2-10个汉字英文或数字" onblur="answ()"
					class="input">
					<br><span id="span_lanswer"></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="确认提交" class="bt" onblur="btok()"> 
				<input type="reset" value="重置"	class="bt"> 
				<a href="loginn.jsp">
				<input type="button" value="返回登陆" class="bt"></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>