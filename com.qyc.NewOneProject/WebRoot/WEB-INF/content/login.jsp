<%@page import="com.qyc.OneProject.util.util"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
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

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">

<title>Bootstrap Admin Template</title>
<link rel="shortcut icon" href="img/favicon.ico">

<!-- global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-icon-style.css">
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet" href="css/pages/login.css">
</head>


<body>

	<!--====================================================
                        PAGE CONTENT
======================================================-->
	<section class="hero-area">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 ">
				<div class="contact-h-cont">
					<h3 class="text-center">登录入口选择</h3>
					<br>
					<form action="" method="post">
						<div class="form-group">
							<a href="AllLogin/Slogin" style="padding-left: 40%">学生登录</a>
						</div>
						<div class="form-group">
							<a href="AllLogin/Tlogin" style="padding-left: 40%">教师登录</a>
						</div>
						<div class="form-group">
							<a href="AllLogin/Alogin" style="padding-left: 39%">管理员登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!--Global Javascript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>
