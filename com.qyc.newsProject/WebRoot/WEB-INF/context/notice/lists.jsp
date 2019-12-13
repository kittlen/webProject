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
<link rel="stylesheet" href="css/wap.css?2">
<title>首页</title>

</head>

<body>
	<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
		<a href="#top" title=""> <img class="am-gotop-icon-custom"
			src="img/goTop.png" />
		</a>
	</div>
	<div class="pet_head">
		<header data-am-widget="header"
			class="am-header am-header-default pet_head_block">
		<div class="am-header-left am-header-nav " style="margin-top: 10px;">
			<a href="javascript:void(0);" onclick="back()" class="iconfont pet_head_jt_ico">&#xe601;</a>
		</div>

		<h1 class="am-header-title pet_article_user">
			<div class="pet_article_user_info_tab">
				<div class="pet_article_user_info_tab_font">
					<div class="pet_article_user_info_tab_font_triangle"></div>
					<div class="pet_article_user_info_tab_font_center"></div>
				</div>
			</div>
		</h1>

		<div class="am-header-right am-header-nav" style="margin-top: 10px;">
			<a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
		</div>
		</header>
	</div>
	<div class="pet_mian" id="top">
		<div class="pet_circle_nav">
			<div class="pet_more_list">
				<div class="pet_more_list_block">
					<jsp:include page="../More.jsp"></jsp:include>
				</div>
			</div>
		</div>
		<jsp:include page="../cont-main.jsp"></jsp:include>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="js/appjs/lists.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script src="js/appjs/util.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			if(${deNo=="1"}){
			alert("新闻删除成功");
			${deNo=null}
			}
			show();
		})
	</script>
</body>

</html>