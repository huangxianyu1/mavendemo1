<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>忘记密码</title>
<link href="${pageContext.request.contextPath }/css/forget.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="forgetCheck.do" method="post">
<table align="center" border="1">
<tr>
<td colspan="2" align="center">身份验证</td>
</tr>
<tr>
<td>请输入您的账号名</td>
<td><input type="text" name="lname" placeholder="请输入您的登录名" class="input"></td>
</tr>
<tr>
<td>请选择您的密报问题</td>
<td>
<select name="lquestion">
<option value="您的生日是什么时候？" selected="selected">您的生日是什么时候？</option>
<option value="您的女朋友叫什么？">您的女朋友叫什么？</option>
<option value="您的大学叫什么？">您的大学叫什么？</option>
</select>
</td>
</tr>
<tr>
<td>请输入您的密保答案</td>
<td>
<input type="text" name="lanswer" placeholder="请输入您预设的密保答案"  class="input">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="确认提交" class="bt">
<input type="reset" value="重置"  class="bt">
<a href="loginn.jsp"><input type="button" value="返回登陆"  class="bt"></a>
</td>
</tr>
</table>
</form>
</body>
</html>