<%@page import="com.qyc.newsProject.model.Notice"%>
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

<title>My JSP 'cont.jsp' starting page</title>

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
			<div class="am-header-left am-header-nav " style="margin-top: 10">
				<a href="javascript:void(0);" onclick="back()" class="iconfont pet_head_jt_ico">&#xe601;</a>
			</div>

			<h1 class="am-header-title pet_article_user">
				<!-- <div class="pet_article_user_info_tab">
					<div class="pet_article_user_info_tab_font">
						<div class="pet_article_user_info_tab_font_triangle"></div>
						<div class="pet_article_user_info_tab_font_center"></div>
					</div>
				</div> -->
				<span class="pet_article_user_ico"><img
					src="user/userPhoto/${noticeCont.user.photo}${noticeCont.user.photoType}"
					alt="" class=""></span> <span class="pet_article_user_name">${noticeCont.user.name}</span>
			</h1>

			<div class="am-header-right am-header-nav" style="margin-top: 10">
				<a href="javascript:;" class="iconfont pet_head_gd_ico">&#xe600;</a>
			</div>
			</header>
		</div>

		<div class="pet_more_list">
			<div class="pet_more_list_block">
				<jsp:include page="../More.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<div class="pet_content">
		<div class="pet_content_block" style="width: 640px">
			<article data-am-widget="paragraph"
				class="am-paragraph am-paragraph-default pet_content_article"
				data-am-paragraph="{ tableScrollable: true, pureview: true }">
			<h1 class="pet_article_title">${noticeCont.noticeTitle }</h1>
			<div class="pet_article_user_time">发表于：${noticeCont.releaseTime }</div>
			<div>${noticeCont.noticeContent}</div>
			</article>
			<ul class="like_share_block">
				<li><a class="link_share_button" href="###"><i
						class="iconfont share_ico_link">&#xe62f;</i>
					<!-- 1460 --></a></li>
				<li><span class="link_share_button" style="width: 200%;"><input
						type="text"
						style="width: 80%;height:100%;border: 0px;outline:none;"
						id="comment" placeholder="评论" value="登录后才能发表评论"
						readonly="readonly"><input type="button" value="发表"
						disabled="disabled" id="commentSu" onclick="commSu()"></span></li>
			</ul>

			<div class="pet_comment_list">
				<div class="pet_comment_list_wap">
					<div class="pet_comment_list_title">评论</div>

					<div data-am-widget="tabs"
						class="am-tabs am-tabs-default pet_comment_list_tab">
						<div class="am-tabs-bd pet_pl_list" id="comments"></div>
						<span class="link_share_button "><a href="not/allCom"
							style="width: 200%;">所有评论</a></span>
					</div>
				</div>

				<div class="pet_article_like">
					<div class="pet_article_like_title">其他新闻</div>
					<jsp:include page="../cont-main.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script src="js/appjs/index.js"></script>
	<script src="js/appjs/util.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							comment();
							commentList();
							show(1);
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
		function comment() {
			var comment = $("#comment");
			var commentSu = $("#commentSu");
			if (${login!=null}) {
				comment.val("");
				comment.attr("readOnly", false)
				commentSu.attr("disabled", false)
			}
		}
		function commSu() {
			var commentVal = $("#comment").val();
			if (confirm("确定发布此条评论?")) {
				$.ajax({
					url : "not/addComment",
					type : "post",
					data : {
						"comment.notice.nID" : ${noticeCont.nID},
						"comment.context" : commentVal
					},
					success : function() {
						alert("评论发表成功");
						$("#comment").val("");
						commentList();
					},
					error : function() {

					}
				})
			}
		}

		function commentList() {
			var comments = $("#comments");
			$
					.ajax({
						url : "not/CommentInfo",
						type : "post",
						dataType : "json",
						data : {
							"notice.nID" : ${noticeCont.nID}
						},
						success : function(data) {
							comments.html("");
							var Thtml = "";
							for (var i = 0; i < data.length; i++) {
								Thtml += "<div class='pet_comment_list_block'>"
								Thtml += "<div class='pet_comment_list_block_l'>"
								Thtml += "<img src='user/userPhoto/"+data[i].user.photo + data[i].user.photoType+"' alt=''></div>"
								Thtml += "<div class='pet_comment_list_block_r'>"
								Thtml += "<div class='pet_comment_list_block_r_info'>"
										+ data[i].user.name + "</div>"
								Thtml += "<div class='pet_comment_list_block_r_text'>"
										+ data[i].context + "</div>"
								Thtml += "<div class='pet_comment_list_block_r_bottom'>"
								Thtml += "<div class='pet_comment_list_bottom_info_l'>"
										+ GetDateTimeDiff(data[i].time,
												getNowFormatDate()) + "</div>"
								Thtml += "<div class='pet_comment_list_bottom_info_r'>"
								Thtml += "<span> "
								Thtml += "</div></div></div></div>"
							}
							comments.append(Thtml);
						},
						error : function() {

						}
					})
		}
	</script>
</body>
</html>
