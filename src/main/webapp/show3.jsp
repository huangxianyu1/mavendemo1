<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${pb.pagelist==null||pb.pagelist.size()==1}">
	<c:redirect url="add.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/css/zshow.css" rel="stylesheet" type="text/css" />
<!-- 引入easyui -->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="${pageContext.request.contextPath }/js/show.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员展示</title>
<style>
body {
	background: #00ff00 url("img/banner.jpg") repeat;
}

table {
	background-color: #111111;
	color: white;
	width: 900px;
	border-radius: 5px
}

input[type="button"] {
	border-radius: 15px;
	background-color: #333333;
	color: white;
}

td {
	text-align: center
}

input {
	border-radius: 5px
}
</style>
<script type="text/javascript">
function del(eid){
	 $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		        $.get('delById.do?eid='+eid,function(code){
		        	if(code=='1'){
		        		timeout:5000;
		        		$.messager.alert('提示','删除成功');
		        		setTimeout(function(){
		                    location.href = "findPageAll.do";
		                },1000);
		        		/* window.location = "findPageAll.do"; */   // 重新载入当前页面数据  
		        	}else{
		        		$.messager.alert('提示','删除失败');
		        	}
		        });    
		    }    
		});  
}
	function jump() {//跳转页数的函数
		var page = document.form1.page.value;
		if (isNaN(page)) {
			alter('输入正确数字！');
			document.form1.page.value = ${pb.page};
			return;
		}
		window.location = "findPageAll.do?page=" + page;
	}
	//更改每页记录数的函数
	function every() {
		var rows = document.form1.rows.value;
		if (isNaN(rows)) {
			alter('输入正确数字！');
			document.form1.rows.value = ${pb.rows};
			return;
		}
		window.location = "findPageAll.do?rows=" + rows;
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table align="center" border="1" id="formm">
			<tr height="40">
				<td colspan="12" align="center"
					style="font-size: 20px; font-weight: 600; color: red; text-shadow: silver;">公司人员信息</td>
			</tr>
			<tr>
				<td>人员编号</td>
				<td>姓名</td>
				<td>英文名</td>
				<td>性别</td>
				<td>联系方式</td>
				<td>所在部门</td>
				<td>职位</td>
				<td>薪资</td>
				<td>入职时间</td>
				<td>权限等级</td>
				<td width="110">照片</td>
				<td width="50">操作</td>
			</tr>
			<c:forEach items="${pb.pagelist }" var="em">
				<c:if test="${em.getEname()!='superadmin' }">
					<tr>
						<td>${em.getEid()-1}</td>
						<td>${em.getEname()}</td>
						<td>${em.getEnglish()}</td>
						<td>${em.getEsex()}</td>
						<td>${em.getEtel()}</td>
						<td>${em.pname}</td>
						<td>${em.jname}</td>
						<td>${em.getEsalary()}</td>
						<td>${em.getEgoindate()}</td>
						<td>${em.getLrootlevel()}</td>
						<c:if test="${em.getEid()!='1'}">
							<td><a href="uppic/${em.fname}"> <img
									src="uppic/${em.fname}" width="120" height="110" />
							</a></td>
						</c:if>
						<td><input type="button" value="开除 "
							onclick="del(${em.getEid() })"> <a
							href="findById.do?eid=${em.getEid() }"> <input type="button"
								value="调整 "></a></td>
					</tr>
				</c:if>
			</c:forEach>

			<tr>
				<td colspan="12" align="center"><a href="pesonalInfoCheck.do"><input
						type="button" value="个人信息查看 "></a> <a href="add.jsp"><input
						type="button" value="新员工录入 "></a> <a href="LnameCheck.do"><input
						type="button" value="员工账号查看 "></a>
						 <a href="loginn.jsp"> <input
						type="button" value="退出登录 " onclick="if(confirm('确认退出？！'))quit()"></a>
				</td>
			</tr>
		</table>
	</form>
	<form action="post" id="form1" name="form1">
		<table align="center" border="1">
			<tr>
				<td align="center"><c:if test="${pb.page>1 }">
						<a href="findPageAll.do?page=1">
					</c:if><input type="button" value="首页"></a></td>
				<td align="center"><c:if test="${pb.page>1 }">
						<a href="findPageAll.do?page=${pb.page-1 }">
					</c:if><input type="button" value="上一页"></a></td>
				<td align="center"><c:if test="${pb.maxPage>pb.page }">
						<a href="findPageAll.do?page=${pb.page+1 }">
					</c:if><input type="button" value="下一页"></a></td>
				<td align="center"><c:if test="${pb.maxPage>pb.page }">
						<a href="findPageAll.do?page=${pb.maxPage }">
					</c:if><input type="button" value="尾页"></a></td>
				<td align="center"><input type="button" value="跳转到"
					onclick="jump()"> <input type="text" size="1" name="page"
					value="${pb.page }"></td>
				<td align="center"><input type="button" value="每页"
					onclick="every()"> <input type="text" size="1" name="rows"
					value="${pb.rows }"></td>
				<td align="center">${pb.page}/${pb.maxPage }</td>
			</tr>
		</table>
	</form>
</body>
</html>