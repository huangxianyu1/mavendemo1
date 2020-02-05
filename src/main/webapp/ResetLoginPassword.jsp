<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link href="${pageContext.request.contextPath }/css/resetloginpassword.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.js"></script>
<!-- 引入easyui -->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="${pageContext.request.contextPath }/js/resetloginpassword.js"></script>
<style type="text/css">
span {
	color: red;
	font-size: 14px;
}</style>
</head>
<body>
	<form action="updateLpassword.do" method="post">
		<table align="center" border="1">
			<tr>
				<td align="center" colspan="2">修改密码</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="lname" value="${lo.getLname() }" class="input">
				</td>
			</tr>
			<tr>
				<td>请输入原始密码</td>
				<td><input type="text" name="lpassword1" id="lpassword1" class="input" placeholder="请输入原始密码">
				</td>
			</tr>
			<tr>
				<td>请输入第一次密码</td>
				<td><input type="text" name="lpassword" id="lpassword" onblur="lp1()" class="input" placeholder="请输入一次密码">
				<br><span id="span_lp1"></span>
				</td>
			</tr>
			<tr>
				<td>请输入第二次密码</td>
				<td><input type="text" name="lpassword2" id="lpassword2" onblur="lp2()" class="input" placeholder="请再次输入密码">
				<br><span id="span_lp2"></span>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" value="确认修改" class="bt" onclick="btok()"> <input type="reset"
					value="重置" class="bt">
				<a href="loginn.jsp"><input type="button" value="取消修改" class="bt"></a>
					</td>
			</tr>
		</table>
	</form>
</body>
</html>