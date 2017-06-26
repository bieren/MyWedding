<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
</head>
<body>

			<p>&nbsp;</p>

			<p>&nbsp;</p>

			<p>&nbsp;</p>

			<p>&nbsp;</p>
	<div id="login_div" align="center">
		<form action="/MyOrder/upload/filesUpload" method="POST"
			enctype="multipart/form-data">
			yourfile: <input type="file" name="myfiles" /><br /> yourfile: <input
				type="file" name="myfiles" /><br /> <input type="submit"
				value="上传图片" />
		</form>
	</div>
	<div id="login_div" align="center">
		<form action="/MyOrder/login" method="post">

			<p>&nbsp;</p>
			<label> 帐号 <input type="text" name="userName">
			</label>
			<p>
				<label> 密码 <input type="password" name="password">
				</label>
			</p>

			<input type="submit" value="登录">
			<p>
				<font style="color: red;">${requestScope.msg}</font>
			</p>
		</form>
	</div>

</body>
</html>
