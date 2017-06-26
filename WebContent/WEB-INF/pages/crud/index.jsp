<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.Timestamp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我收到的订单</title>

<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if ("${sessionScope.result.loginName }" == "") {
			
			document.getElementById("msg").innerHTML = "请先登录！";
			alert("请先登录！");
			
	    	window.location.href="logout";
	    	window.location.href="logout"; 
		}
	})
</script>
</head>
<body>
	<!-- <a href="emps"> emps</a> -->
	<%-- 
<a href="getOrder?placeId=${sessionScope.result.placeId}"> refresh</a> 
<a href="logout"> 注销</a>  
--%>

	<p>&nbsp;</p>
	<label> <a
		href="getOrder?placeId=${sessionScope.result.placeId}"> 刷新</a>
	</label> &nbsp;

	<c:if test="${sessionScope.result.loginName!=null }">
		<label><a href="logout"> 注销</a> </label> &nbsp;
		<label><a href="login1"> 登录</a> </label> &nbsp;
	</c:if>
	<%-- <c:if test="${requestScope.orderResult.orderInfoList.size()==0 }">11111</c:if> --%>

	<div align="center">
		<font id="msg" style="color: red; font-size: 120px;"></font><br>
		<%
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		%>

		<label> ${sessionScope.result.loginName}，您好！！ </label> &nbsp; <label>
			${sessionScope.username} </label> &nbsp;
		<%-- <br> 
		<label>result:${requestScope.result}</label> --%>

		<label>上次登录时间&nbsp;:&nbsp;${sessionScope.result.lastLoginTime}</label>
		&nbsp; <label>当前时间&nbsp;:&nbsp;<%=sdf.format(timestamp)%></label>
		&nbsp;

		<%-- <label>${sessionScope.result.corp}</label>&nbsp; --%>
		<%-- <br> 
		<label>orderResult:${requestScope.orderResult}</label> --%>

		<!-- <input value="当前时间段订单" type="button" onclick="all()">  -->

	</div>
	<p></p>
	<p align="center">今天的订单</p>

	<c:if test="${sessionScope.result.loginName!=null }">




		<div align="center">

			<c:if test="${requestScope.orderResult.orderInfoList.size()==0 }">没有任何数据</c:if>
			<c:if test="${requestScope.orderResult.orderInfoList.size()!=0 }">
				<table width="976" border="1" cellpadding="10" cellspacing="0">
					<tr>
						<td width="128">菜品名</td>
						<td width="158">价格（分）</td>
						<td width="121">数量（份）</td>
					</tr>
					<c:forEach items="${requestScope.orderResult.orderInfoList }"
						var="orderInfo">
						<tr>
							<td>${orderInfo.name }</td>
							<td>${orderInfo.price.amount }</td>
							<td>${orderInfo.count }</td>
						</tr>
					</c:forEach>
					<c:forEach items="${requestScope.orderResult.timePeriod }"
						var="timePeriodAndId">
						<tr>
							<td colspan="3">${timePeriodAndId }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

		</div>

		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<hr>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<div align="center">

			<c:if test="${requestScope.orderResult.customerOrderList.size()==0 }">没有任何数据</c:if>
			<c:if test="${requestScope.orderResult.customerOrderList.size()!=0 }">
				<table width="100%" border="1" cellpadding="10" cellspacing="0">
					<tr>
						<td>序号</td>
						<td>菜品</td>
						<td>订单号</td>
						<td>订单生成时间</td>
						<td>订单有效期</td>
						<td>用户帐号</td>
						<td>用户名</td>
						<td>订单状态</td>
					</tr>
					<c:forEach items="${requestScope.orderResult.customerOrderList }"
						var="customerOrder">
						<tr>
							<td>${customerOrder.id }</td>
							<td>${customerOrder.transientData.prodNameList }</td>
							<td>${customerOrder.purchaseOrderNumber }</td>
							<td>${customerOrder.orderDate }</td>
							<td>${customerOrder.validFor.startDateTime }--
								${customerOrder.validFor.endDateTime }</td>
							<td>${customerOrder.customer.loginName }</td>
							<td>${customerOrder.customer.name }</td>
							<td>${customerOrder.status.name }</td>
						</tr>
					</c:forEach>

				</table>
			</c:if>

		</div>
	</c:if>




</body>
</html>