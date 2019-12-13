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
				<a href="javascript:void(0);" onclick="back()" class="iconfont pet_head_jt_ico">&#xe601;</a>
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
				<form class="col-md-6" action="not/save" method="post">
					<div class="pet_grzx_name">
						<div class="pet_grzx_name">
							新闻类型： <select name="notice.nType.nTID" id="id" onchange="show()">

							</select>
						</div>
					</div>
					<div class="pet_grzx_name">新闻标题：</div>
					<div class="pet_grzx_name" style="margin-bottom: 10px">
						<textarea rows="3" cols="50" name="notice.noticeTitle"
							id="noticeTitle" placeholder="新闻标题"></textarea>
					</div>
					<div class="pet_grzx_name">新闻简介：</div>
					<div class="pet_grzx_name" style="margin-bottom: 10px">
						<textarea rows="3" cols="50" name="notice.noticeBrief"
							id="noticeBrief" placeholder="简介"></textarea>
					</div>
					<textarea name="notice.noticeContent" id="NoticeContent"></textarea>
					<div>
						<button type="submit" class="pet_grzx_name"
							onclick="return OnNotice()" name="release">发布</button>
						<button type="reset" class="pet_grzx_name" onclick="inputreset()">重置</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="ckeditor/ckeditor.js"></script>
	<script src="ckeditor/config.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script src="js/appjs/notice.js"></script>
	<script src="js/appjs/util.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			if (${nsa=="1"}) {
				alert("新闻发布成功,请等待审核")
			} else if (${nsa=="0"}) {
				alert("新闻发布失败")
			}
			${nsa=null}
			CKeditor();
			show();
		})
	</script>
</body>
</html>
