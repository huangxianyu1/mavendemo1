<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>人员展示</title>
<link href="${pageContext.request.contextPath }/css/zjustView2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="" method="post">
		<table align="center" border="1">
			<tr>
				<td colspan="6" align="center" style="font-weight: 800">公司人员信息</td>
			</tr>
			<tr>
				<td class="li1">编号</td>
				<td class="li2">${em.getEid()}</td>
				<td rowspan="4"><a href="uppic/${em.fname}"> <img
								src="uppic/${em.fname}" width="120" height="110" /></a></td>
			</tr>
			<tr>
				<td class="li1">姓名</td>
				<td class="li2">${em.getEname()}</td>
			</tr>
			<tr>
				<td class="li1">英文名</td>
				<td class="li2">${em.getEnglish()}</td>
			</tr>
			<tr>
				<td class="li1">性别</td>
				<td class="li2">${em.getEsex()}</td>
			</tr>
			<tr>
				<td class="li1">联系方式</td>
				<td class="li2" colspan="5">${em.getEtel()}</td>
			</tr>
			<tr>
				<td class="li1">所在部门</td>
				<td class="li2" colspan="5">${em.pname}</td>
			</tr>
			<tr>
				<td class="li1">职位</td>
				<td class="li2" colspan="5">${em.jname}</td>
			</tr>

			<tr>
				<td class="li1">薪资</td>
				<td class="li2" colspan="5">${em.getEsalary()}</td>
			</tr>
			<tr>
				<td class="li1">入职时间</td>
				<td class="li2" colspan="5">${em.getEgoindate()}</td>
			</tr>
			<tr>
				<td class="li1">登录账户名</td>
				<td class="li2" colspan="5">${lo.getLname() }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="findByLname.do?lname=${lo.getLname() }"
					style="font-size: 14px">更改密码</a> 
					<%session.setAttribute("oldpassword",""); %>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<c:if test="${lo.getLrootlevel()=='1' }">
					<a href="show3.jsp"><input type="button" value="返回查看"></a>
					</c:if>
					 <a href="loginn.jsp"><input type="button" value="退出登陆"></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>