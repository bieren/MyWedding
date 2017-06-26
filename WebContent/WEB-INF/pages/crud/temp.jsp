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
	
						document.getElementById("msg").innerHTML = "坐稳!跳转中...";
						var handler = function(){ 
							if ("${sessionScope.result.loginName }" != "") {
								window.location.href = "getOrder?placeId=${sessionScope.result.placeId}";
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
	<p>&nbsp;</p>
	<div align="center">
		<font id="msg" style="color: red; font-size: 80px;"></font><br>
	</div>
</body>
</html>