<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function isNull(str) {
	if (str == null || str == undefined || str == '') {
		return true;
	} else {
		return false;
	}

	}
	$(document).ready(function() {
		var loginName = '${sessionScope.result.loginName}';
		if(isNull(loginName)){
			document.getElementById("msg").innerHTML = "请先登录！";
			alert("请先登录！");

			window.location.href = "logout";
			window.location.href = "logout";
		}
		

			
		
	})
</script>
</head>
<body>

	<!-- <p>
		<a href="emps"> emps</a>
	</p> -->
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<div id="login_div" align="center">
		<form action="/MyOrder/rechargeLogin" method="post">

			<p>&nbsp;</p>
			<label> 
				帐号 <input type="text" name="userName" >
			</label>
			<p>
				<label> 
					密码 <input type="password" name="password">
				</label>
			</p>

			<input type="submit" value="登录">
			<p>
				<font id="msg" style="color: red;">${requestScope.msg}</font>
			</p>
		</form>
	</div>
</body>
</html>