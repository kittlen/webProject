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

		<h1 class="am-header-title pet_article_user"
			style="padding-top: 10px;">
			<span class="link_share_button"
				style="width: 80%;font-size: 15px;background-color: white;"><input
				type="text" style="width: 70%;height:100%;border: 0px;outline:none;"
				placeholder="搜索" id="seatext"><input type="button" value="搜索"
				style="height: 100%;width: 20%;border-radius: 50px;border: 0;float: right;"
				onclick="sea()"></span>

		</h1>

		<div class="am-header-right am-header-nav" style="margin-top: 10px;">
			<a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
		</div>
		</header>
	</div>
	<div class="pet_mian" id="top">
		<jsp:include page="Top.jsp"></jsp:include>
		<div class="pet_circle_nav">
			<ul class="pet_circle_nav_list">
				<li><a href="not/skipType?typeIndex=1" class="iconfont pet_nav_xinxianshi ">&#xe61e;</a><span>新鲜事</span></li>
				<li><a href="not/skipType?typeIndex=2" class="iconfont pet_nav_zhangzhishi ">&#xe607;</a><span>趣闻</span></li>
				<li><a href="not/skipType?typeIndex=3" class="iconfont pet_nav_kantuya ">&#xe62c;</a><span>阅读</span></li>
				<!-- <li><a href="" class="iconfont pet_nav_mengzhuanti ">&#xe622;</a><span>专题</span></li>
				<li><a href="" class="iconfont pet_nav_meirong ">&#xe629;</a><span>订阅</span></li>
				<li><a href="" class="iconfont pet_nav_yiyuan ">&#xe602;</a><span>专栏</span></li>
				<li><a href="" class="iconfont pet_nav_dianpu ">&#xe604;</a><span>讨论</span></li> -->
				<li><a href="javascript:;" class="iconfont pet_nav_gengduo ">&#xe600;</a><span>更多</span></li>
			</ul>
			<div class="pet_more_list">
				<div class="pet_more_list_block">
					<jsp:include page="More.jsp"></jsp:include>
				</div>
			</div>
		</div>
		<jsp:include page="cont-main.jsp"></jsp:include>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="js/appjs/index.js"></script>
	<script src="js/appjs/util.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							topImg();
							show(1);
							if (${la=="1"}) {
								/* alert("登陆成功"); */
								${er=null};
							} else if (${la=="0"}) {
								alert("登陆失败,请重新登陆");
								${la==null}
							}
							;
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
													show(num);
													num++;
												}
											});
						})
		$(function() {

			// 动态计算新闻列表文字样式
			auto_resize();
			$(window).resize(function() {
				auto_resize();
			});
			$('.am-list-thumb img').load(function() {
				auto_resize();
			});

			$('.am-list > li:last-child').css('border', 'none');
			function auto_resize() {
				$('.pet_list_one_nr').height($('.pet_list_one_img').height());

			}
			$('.pet_nav_gengduo').on('click', function() {
				$('.pet_more_list').addClass('pet_more_list_show');
			});
			$('.pet_more_close').on('click', function() {
				$('.pet_more_list').removeClass('pet_more_list_show');
			});
		});
		function sea(){
		var seatext=$("#seatext").val();
		location="user/search?seatext="+seatext;
		}
	</script>
</body>

</html>