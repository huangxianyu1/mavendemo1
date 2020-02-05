<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/css/update.css" rel="stylesheet" type="text/css" />
<style>
table {
	background-color: #111111;
	color: white
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>调整</title>
</head>
<body>
	<form action="update.do" method="post" enctype="multipart/form-data">
		<table align="center" border="1" cellpadding="1" cellspacing="0">
			<tr>
				<td colspan="3" align="center">职员信息更改页面</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="ename" value="${em.getEname() }" class="input">
					<input type="hidden" name="eid" value="${em.getEid()}"></td>
				<td rowspan="3" height="35px"><img src="uppic/${em.getFname()}" width="90"
					height="74" /></td>
			</tr>
			<tr>
				<td>英文名</td>
				<td><input type="text" name="english"
					value="${em.getEnglish()}" class="input"></td>
			</tr>
			<tr>
				<td>选择照片</td>
				<td><span id="uploadImg"> <input type="file" id="file"
						name="pic" size="1"> <a href="#">上传图片</a>
				</span>
					</td>
			</tr>
			<tr>
				<td>性别</td>
				<td colspan="2">
				<input type="radio" name="esex" value="男"  <c:if test="${em.getEsex()=='男' }">checked="checked"</c:if>>男
				<input type="radio" name="esex" value="女"  <c:if test="${em.getEsex()=='女' }">checked="checked"</c:if>>女
				</td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td colspan="2"><input type="text" name="etel"
					value="${em.getEtel()}" class="input"></td>
			</tr>
			<tr>
				<td>所在部门</td>
				<td colspan="2">
				<select name="epartmentid">
						<c:forEach items="${listdep }" var="dep">
							<option value="${dep.pid }" 
							<c:if test="${em.pname==dep.pname }">
							selected="selected"
							</c:if>
							>${dep.pname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>职位</td>
				<td colspan="2"><select name="ejobid">
						<c:forEach items="${listjob }" var="job">
							<option value="${job.jid }"
							<c:if test="${em.jname==job.jname }">
							selected="selected"
							</c:if>>${job.jname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr style="display: none">
				<td>登陆帐号</td>
				<td><input type="text" name="eloginname" value="${em.getEloginname()}"></td>
			</tr>
			<tr>
				<td>薪资</td>
				<td colspan="2"><input type="text" name="esalary"
					value="${em.getEsalary()}" class="input"></td>
			</tr>
			<tr style="display: none">
				<td>入职时间</td>
				<td><input type="date" name="egoindate" value="${em.getEgoindate()}"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="确认更改" class="bt"> <input type="reset" value="重置" class="bt"> <a
					href="loginn.jsp"><input type="button" value="取消更改 " class="bt"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>