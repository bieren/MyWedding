<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sp.utils.URL"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<title>注册</title>
<script type="text/javascript">
function isNull(str) {
	if (str == null || str == undefined || str == '') {
		return true;
	} else {
		return false;
	}

	}


	$(document).ready(function() {
		var loginName = '${sessionScope.rechargeResult.customer.loginName}';
		if(isNull(loginName)){
			document.getElementById("msgTip").innerHTML = "请先登录！";
			alert("请先登录！");

			window.location.href = "login1";
			window.location.href = "login1";
		}
		
	})
</script>

</head>
<body>


	<div>
		<c:if
			test="${sessionScope.rechargeResult.customer.loginName != null }">
			<label><a href="rechargeForword">充值</a> </label> &nbsp;
			<label><a href="logout"> 注销</a> </label> &nbsp;
		</c:if>
	</div>


	<div style="padding: 300px 300px 10px;">
		<div class="input-group">
			<span class="input-group-addon">用户名</span> <input id="userName"
				type="text" class="form-control" placeholder="请输入您的用户名">
			<!-- <span class="input-group-addon"><a>注册<a></span> -->
			<!--  <button type="button" class="btn btn-default" class="input-group-addon">默认按钮</button> -->
		</div>
		<br>

		<div class="input-group">
			<span class="input-group-addon">卡&nbsp;&nbsp;&nbsp;号</span> <input
				id="cardNum" type="text" class="form-control"
				placeholder="请将卡片放置于感应区">

		</div>
		<br>
		<div>
			<button id="register" type="button" class="btn btn-default"
				class="input-group-addon"
				style="display: block; width: 20%; float: left; text-align: center;">注册</button>
			&nbsp;&nbsp;&nbsp;
			<button id="tieCard" type="button" class="btn btn-default"
				class="input-group-addon"
				style="display: block; width: 20%; float: left; text-align: center;">绑卡</button>


		</div>
		<br>
		<p id="msgTip" style="text-align: left; color: red"></p>
	</div>


</body>
<script>
var serverUrl = "http://<%=URL.serverIp%>/<%=URL.OpenAPI%>/system/";
	//var serverUrl = "http://192.168.1.194:8081/OpenAPI/system/";

	$(function() {

		$("#register").click(function() {
			var userName = $("#userName").val();
			if (isNull(userName)) {
				$("#msgTip").html("用户名不可为空！");
			} else {
				register(userName);
			}

		})

		$("#tieCard").click(function() {

			// layer.msg('Hello World');
			var userName = $("#userName").val();
			var cardNum = $("#cardNum").val();

			if (!isNull(userName) & !isNull(cardNum)) {
				tieCard(userName, cardNum);
			} else {
				$("#msgTip").html("用户名合卡号不可为空！");
			}

		})

	})
	function isNull(str) {
		if (str == null || str == undefined || str == '') {
			return true;
		} else {
			return false;
		}

	}

	function register(userName) {
		$.ajax({
			type : "post",
			dataType : "json",
			/*   jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
			   jsonpCallback:"flightHandler",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据 */
			// crossDomain:true,
			data : {
				loginName : userName
			},
			url : serverUrl + "tempCustRegister",
			//crossDomain: true,

			success : function(result) {
				if (result.code == "200") {
					$("#msgTip").html("注册成功！");

				} else {
					$("#msgTip").html(result.msg);
				}
			}

		})

	}

	function tieCard(userName, cardNum) {
		$.ajax({
			type : "post",
			dataType : "json",
			data : {
				loginName : userName,
				numb : cardNum
			},
			url : serverUrl + "tempApplyCard",
			success : function(result) {
				if (result.code == "200") {
					window.location.href = "/MyOrder/rechargeForword";

				} else {
					$("#msgTip").html(result.msg);
				}

			}

		})

	}
</script>
</html>