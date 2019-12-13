<%@page import="com.qyc.OneProject.util.util"%>
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
					<h3 class="text-center">登录</h3>
					<br>
					<form action="LoginMgrServlet" method="post">
						<div class="form-group">
							<label for="username">账号</label> <input type="text"
								class="form-control" id="username" placeholder="账号"
								name="ID">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">密码</label> <input
								class="form-control" type="password" placeholder="密码"
								id="example-password-input" name="Password">
						</div>
						<div class="form-group">登录方式:
							<label><input name="user" type="radio" value="S" >学生
							</label> <label><input name="user" type="radio" value="T" checked>教师</label>
							<label><input name="user" type="radio" value="A">管理员
							</label>
						</div>
						<input type="hidden" name="judge" value="login">
						<button class="btn btn-general btn-blue" role="button">
							<i fa fa-right-arrow></i>登录
						</button>
						<%
							String s = String.valueOf(request.getAttribute("error"));
						%>
						<%=util.sendJspNull(s)%>
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
