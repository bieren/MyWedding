<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>input!!</h1>
 
	<c:if test="${requestScope.employee.id!=null }">
		<c:set value="/${employee.id} " var="id"></c:set>
	</c:if> 
	<form:form action="${pageContext.request.contextPath }/emp${id }" method="post" modelAttribute="employee">
		<form:hidden path="id" />
		<c:set var="disabled" value="false" ></c:set>
		<c:if test="${employee.id!=null }">
		<input type="hidden" name="_method" value="PUT" />
		<c:set var="disabled" value="true" ></c:set>
		</c:if>
		<label>LastName</label>
		<form:input path="lastName" disabled="${disabled }"  />
		<label>Email</label>
		<form:input path="email" />
		<%
			Map genders = new HashMap();
				genders.put(1, "男");
				genders.put(0, "女");
				request.setAttribute("genders", genders);
		%>
		<label>Gender</label>
		<form:radiobuttons path="gender" items="${genders }" />
		<label>Department</label>
		<form:select path="department.id" items="${departments }"
			itemLabel="departmentName" itemValue="id"></form:select>
		<input type="submit" value="submit" />
	</form:form>

</body>
</html>