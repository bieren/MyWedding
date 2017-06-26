<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
String serverPath="http://www.csbfxc.com";
pageContext.setAttribute("path",path);
pageContext.setAttribute("serverPath",serverPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中央厨房官网 - 500</title>
 <link href="${path }/static/css/error.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h1>500</h1>
    <h3 class="font-bold">服务器内部错误！</h3>
    <div class="error-desc">
        		抱歉，工程师正在紧急抢修中~
    </div>
</div>
</body>
</html>