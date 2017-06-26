<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转...</title>

<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
	
						document.getElementById("msg").innerHTML = "充值成功！！跳转中";
						var handler = function(){ 
							if ("${sessionScope.rechargeResult.customer.loginName }" != "") {
								/* window.location.href = "javascript:history.go(-1)"; */
								window.location.href="history.back();";
							}
						}
						
						
						var timer = setInterval( handler , 1000); //每1秒调用一次方法
						var clear = function(){ 
						    clearInterval(timer); //清理时间
						}
						
						
					})
					
					
</script>
</head>
<body>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<a href="javascript:history.back()">返回上一页</a>
	<p>&nbsp;</p>
	<div align="center">
		<font id="msg" style="color: red; font-size: 80px;"></font><br>
	</div>
</body>
</html>