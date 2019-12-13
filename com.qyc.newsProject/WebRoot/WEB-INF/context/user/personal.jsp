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
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/amazeui.min.css">
<link rel="stylesheet" href="css/wap.css">
</head>

<body style="background:#ececec">
	<div class="pet_mian">
		<div class="pet_head">
			<header data-am-widget="header"
				class="am-header am-header-default pet_head_block">
			<div class="am-header-left am-header-nav " style="margin-top: 10px;">
				<a href="#left-link" class="iconfont pet_head_jt_ico">&#xe601;</a>
			</div>
			<div class="pet_news_list_tag_name">个人信息</div>
			<div class="am-header-right am-header-nav" style="margin-top: 10px;">
				<a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
			</div>
			</header>
		</div>

		<div class="pet_more_list">
			<div class="pet_more_list_block">
				<jsp:include page="../More.jsp"></jsp:include>
			</div>
		</div>

		<div class="pet_content pet_content_list">
			<div class="pet_grzx">
				<div class="pet_grzx_nr">
					<div class="pet_grzx_ico">
						<img id="pic" alt=""
							src="user/userPhoto/${login.photo }${login.photoType}">
					</div>
				</div>
				<div class="pet_grzx_name">账号</div>
				<div class="pet_grzx_name">
					<input type="text" name="user.uID" disabled="disabled"
						value="${login.uID }">
				</div>
				<div class="pet_grzx_name">名称</div>
				<div class="pet_grzx_name">
					<input type="text" name="user.name" value="${login.name } "
						disabled="disabled">
				</div>
				<div class="pet_grzx_name">电话号码</div>
				<div class="pet_grzx_name">
					<input type="text" name="user.phone"
						oninput="value=value.replace(/[^\d]/g,'')" value="${login.phone }"
						disabled="disabled">
				</div>
				<div class="pet_grzx_name">简介</div>
				<div class="pet_grzx_name">
					<textarea rows="5" cols="50" name="user.remark"
						placeholder="请输入简介(可为空)" disabled="disabled">${login.remark }</textarea>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="js/appjs/resize.js"></script>

</body>
</html>
