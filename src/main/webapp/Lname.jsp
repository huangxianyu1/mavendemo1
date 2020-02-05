<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户名查看</title>
<style>
body{background: #00ff00 url("img/banner.jpg")repeat;}
table {
	background-color: #111111;
	color: white;
	border-radius: 10px;
}
form{position: relative;top:120px;
}
td{
border-radius: 5px
}
tr{
height: 35px
}
input[type="button"] {
border-radius: 15px;
background-color: #333333;
color:white;
}
</style>
</head>
<body>
	<form action="" method="get">
		<table border="2" align="center">
			<tr>
				<td colspan="3" align="center">员工用户名表</td>
			</tr>
			<tr>
				<td>员工编号</td>
				<td>员工姓名</td>
				<td>员工账号</td>
			</tr>
			<c:forEach items="${listlo }" var="lo">
			<tr>
				<td>${lo.getLid() }</td>
				<td>
				
				${listem.get(listlo.indexOf(lo)).getEname()}
				</td>
				<td>${lo.getLname() }</td>
			</c:forEach>
			<tr>
				<td colspan="3" align="center"><a href="findPageAll.do"><input
						type="button" value="返回查看"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>