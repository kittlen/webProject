<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<div style="margin-left: 45%;margin-top: 100px">
<h4>欢迎您${req}</h4>
<h4>欢迎您${ses}</h4>
	<table id="MyTable">
		<thead>
			<tr>
				<th>姓名</th>
				<th>密码</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	<table id="MyTable2">
		<thead>
			<tr>
				<th>姓名</th>
				<th>密码</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	</div>

</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/MyJsp.js"></script>
</html>
