<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var action = $(this).attr("href");
			$("#hiddenForm").attr("action", action);
			$("#hiddenMethod").val("DELETE");
			$("#hiddenForm").submit();
			return false;
		});
	})
</script>
</head>
<body>
	<h1>list!!</h1>
	<a href="input"> input</a>
	<form action="" method="post" id="hiddenForm">
		<input type="hidden" name="_method" id="hiddenMethod" />
	</form>
	<c:if test="${requestScope.employees.size()==0 }">没有任何数据</c:if>
	<c:if test="${requestScope.employees.size()!=0 }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>Id</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Gender</td>
				<td>Department</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach items="${requestScope.employees }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender==1?'男':'女'}</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="input/${emp.id }">Edit</a></td>
					<td><a href="emp/${emp.id }" class="delete">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>


</body>
</html>