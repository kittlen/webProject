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
			<a href="" class="iconfont pet_head_jt_ico">&#xe601;</a>
		</div>

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
	<script src="js/appjs/type.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							show(${type},1);
							var range = 0; //距下边界长度/单位px
							var elemt = 500; //插入元素高度/单位px
							var maxnum = 4; //设置加载最多次数
							var num = 2;
							var totalheight = 0;
							$(window)
									.scroll(
											function() {
												var srollPos = $(window)
														.scrollTop(); //滚动条距顶部距离(页面超出窗口的高度)

												//console.log("滚动条到顶部的垂直高度: "+$(document).scrollTop());
												//console.log("页面的文档高度 ："+$(document).height());
												//console.log('浏览器的高度：'+$(window).height());

												totalheight = parseFloat($(
														window).height())
														+ parseFloat(srollPos);
												if (($(document).height() - range) <= totalheight
														&& num != maxnum) {
													show(type,num);
													num++;
												}
											});
						})
	</script>

</body>

</html>