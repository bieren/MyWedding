<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<title>请求充值</title>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
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
		var loginName = '${sessionScope.rechargeResult.customer.loginName}';
		if (isNull(loginName)) {
			document.getElementById("msg").innerHTML = "请先登录！";
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
			<label><a href=tempRegister>注册、绑卡</a> </label> &nbsp;
			<label><a href="logout"> 注销</a> </label> &nbsp;
		</c:if>
	</div>

	<form class="form-horizontal" action="/MyOrder/recharge" method="post">
		<div style="padding: 300px 300px 0px; width: 2000px;">
			<div class="input-group">
				<!-- <label for="inputEmail3" class="col-sm-2 control-label">充值账户</label> -->
				<span class="input-group-addon">充值卡号</span> <input type="text"
					class="form-control" id="cardNumb" name="cardNumb"
					placeholder="cardNumb" >
			</div>
			<div class="input-group">
				<!-- <label for="inputPassword3" class="col-sm-2 control-label">帐号类型</label> -->
				<span class="input-group-addon">帐号类型</span> <input type="text"
					class="form-control" id="rechargeType" name="rechargeType"
					placeholder="rechargeType" value="主账户"> </label>
			</div>

			<div class="input-group">
				<!-- <label for="inputPassword3" class="col-sm-2 control-label">充值金额</label> -->
				<span class="input-group-addon">充值金额</span> <input type="text"
					class="form-control" id="amount" name="amount" placeholder="amount"
					>
			</div>

			<div class="input-group">
				<!-- <label for="inputPassword3" class="col-sm-2 control-label">备注信息</label> -->
				<span class="input-group-addon">备注信息</span>
				<!-- 			<div class="col-sm-10"> -->
				<input type="text" class="form-control" id="comment" name="comment"
					placeholder="comment" value="补贴金额">
				<!-- 			</div> -->
			</div>


			<div class="input-group">
				<!-- <label for="inputPassword3" class="col-sm-2 control-label">支付方式</label> -->
				<span class="input-group-addon">支付方式</span> <input type="text"
					class="form-control" id="paymentMethod" name="paymentMethod"
					placeholder="paymentMethod" value="现金支付">
			</div>
			<div class="input-group">
				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<!-- 			<div class="col-sm-offset-2 col-sm-10"> -->

				<button type="submit" class="btn btn-default">确认充值</button>
				&nbsp;&nbsp;&nbsp;&nbsp;<font id="msg" style="color: red;">${requestScope.msg}</font>
				&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: red;">${requestScope.bal}</font>
			
			</div>
			<!-- 		</div> -->
		</div>
	</form>


</body>
</html>