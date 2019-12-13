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
			<a href="javascript:void(0);" onclick="back()"
				class="iconfont pet_head_jt_ico">&#xe601;</a>
		</div>

		<h1 class="am-header-title pet_article_user"
			style="padding-top: 10px;">
			<span class="link_share_button"
				style="width: 80%;font-size: 15px;background-color: white;"><input
				type="text" style="width: 70%;height:100%;border: 0px;outline:none;"
				placeholder="搜索" id="seatext"><input type="button"
				value="搜索"
				style="height: 100%;width: 20%;border-radius: 50px;border: 0;float: right;"
				onclick="show()"></span>
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
	<script src="js/appjs/resize.js"></script>
	<script src="js/appjs/util.js"></script>

	<script type="text/javascript">
		$(document).ready(
				function() {
					var searchUrl = window.location.href;
					var searchData = searchUrl.split("="); //截取 url中的“=”,获得“=”后面的参数
					var searchText = decodeURI(searchData[1]); //decodeURI解码
					var seatext = $("#seatext");
					seatext.val(searchText);
					if (seatext.val() == "" || seatext.val() == null
							|| seatext.val() == "undefined") {
						seatext.val("");
					} else {
						show();
					}
				})
		function show() {
			var seatext = $("#seatext");
			var am = $("#am");
			$
					.ajax({
						url : "user/searchInfo?seatext="+ seatext.val(),
						type : "post",
						dataType : "json",
						success : function(data) {
							am.html("");
							var Thtml = "";

							for (var i = 0; i < data.length; i++) {
								Thtml += "<li class='am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-right pet_list_one_block' >";
								Thtml += "<div class='pet_list_one_info'>";
								Thtml += "<div class='pet_list_one_info_l'>";
								Thtml += "<div class='pet_list_one_info_ico'>";
								Thtml += "<img src='user/userPhoto/"
								+ data[i].user.photo + data[i].user.photoType
								+ "' alt=''>";
								Thtml += "</div>";
								Thtml += "	<div class='pet_list_one_info_name'>"
										+ data[i].user.name + "</div>";
								Thtml += "</div>";
								Thtml += "<div class='pet_list_one_info_r'>";
								Thtml += "<div class='pet_list_tag pet_list_tag_xxs'>"
										+ data[i].nType.name + "</div>";
								Thtml += "</div></div>";
								Thtml += "<div class=' am-u-sm-8 am-list-main pet_list_one_nr' style='height: 140px;'>";
								Thtml += "<h3 class='am-list-item-hd pet_list_one_bt'>";
								Thtml += "<a href='not/noticecont?notice.nID="
										+ data[i].nID + "' class=''>"
										+ data[i].noticeTitle + "</a>";
								Thtml += "</h3><div class='am-list-item-text pet_list_one_text'>";
								Thtml += data[i].noticeBrief + "</div></div>";
								Thtml += "<div class='am-u-sm-4 am-list-thumb'>";
								Thtml += "<a href='not/noticecont?notice.nID="
										+ data[i].nID
										+ "' class=''> <img src='"
								+ data[i].noticephoto1 + "'";
						Thtml += "class='pet_list_one_img' alt='' />";
								Thtml += "</a></div></li>";
							}
							am.append(Thtml);
						},
						error : function() {

						}
					})
		}
	</script>
</body>

</html>