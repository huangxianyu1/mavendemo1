<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${listjob==null||listdep==null}">
	<c:redirect url="dofind.do"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新员工录入</title>
<link href="${pageContext.request.contextPath }/css/zadd.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath }/js/add.js"></script>
<style>
span{
color:red;
font-size:14px;
}
</style>
</head>
<body>
	<form action="add.do" enctype="multipart/form-data" method="post">
		<table align="center" border="1">
			<tr>
				<td colspan="2" align="center" class="ftitle">新员工录入信息表</td>
			</tr>
			<tr>
				<td>照片</td>
				<td><span id="uploadImg"> <input type="file" id="file"
						name="pic" size="1"> <a href="#">上传图片</a>
				</span></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>
				<input type="hidden" name="eid" id="eid">
				<input type="text" name="ename" class="input" id="ename" placeholder="请输入员工姓名" onblur="Ename()">
				<span id="span_ename"></span>
				</td>
			</tr>
			<tr>
				<td>英文名</td>
				<td><input type="text" name="english" id="english" class="input" placeholder="请输入员工英文名" onblur="English()">
				<span id="span_english"></span>
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="esex" value="男" checked="checked"
					class="input"><span class="sextext">男</span> <input
					type="radio" name="esex" value="女" class="input"><span
					class="sextext">女</span></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input type="text" name="etel" id="etel" class="input" placeholder="请输入员工手机号" onblur="Etel()">
				<span id="span_etel"></span></td>
				
			</tr>
			<tr>
				<td>部门</td>
				<td>
				<select name="epartmentid">
						<c:forEach items="${listdep }" var="dep">
							<option value="${dep.pid }">${dep.pname}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>级职</td>
				<td>
				<select name="ejobid">
						<c:forEach items="${listjob }" var="job">
							<option value="${job.jid }">${job.jname}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr style="display: none;">
				<td >登陆帐号</td>
				<td><input type="hidden" name="eloginname" value="英文名+编号+部门代码"
					class="input"></td>
			</tr>
			<tr>
				<td>薪资</td>
				<td><input type="text" name="esalary" id="esalary" class="input" placeholder="请输入员工薪资" onblur="Esalary()">
				<span id="span_esalary"></span></td>
			</tr>
			<tr>
				<td>入职时间</td>
				<td><input type="date" name="egoindate" value="2000-01-01"
					class="input"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交">
					<input type="reset" value="取消"> <a href="show3.jsp"><input
						type="button" value="查看"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>