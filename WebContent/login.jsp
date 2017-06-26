<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

	<!-- <p>
		<a href="emps"> emps</a>
	</p> -->
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<div id="login_div" align="center">
		<form action="/MyOrder/login" method="post">

			<p>&nbsp;</p>
			<label> 
				帐号 <input type="text" name="userName">
			</label>
			<p>
				<label> 
					密码 <input type="password" name="password">
				</label>
			</p>

			<input type="submit" value="登录">
			<p>
				<font style="color: red;">${requestScope.msg}</font>
			</p>
		</form>
	</div>
	<%-- <div align="center">
		<label> name:${sessionScope.username} </label> 
		<br> 
		<label>name:${requestScope.result}</label>
		<br> 
		<label>name:${requestScope.status}</label> 
		<br> 
		<label>name:${requestScope.msg}</label>
	</div> --%>
</body>
</html>