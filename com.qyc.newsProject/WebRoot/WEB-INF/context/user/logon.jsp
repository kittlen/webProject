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
			<div class="pet_news_list_tag_name">个人注册</div>
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
				<form action="user/enroll" method="post">
					<div class="pet_grzx_name">账号</div>
					<div class="pet_grzx_name">
						<input type="text" name="user.uID" placeholder="请输入您要注册的账号"
							id="id">
					</div>
					<div class="pet_grzx_name">密码</div>
					<div class="pet_grzx_name">
						<input type="password" onblur="pwd()" placeholder="请输入密码"
							id="pwd1"> <input type="password" name="user.password"
							oninput="pwd()" placeholder="请再次输入密码" id="pwd2">
						<div style="display:none;" id="aty">两次密码不相同</div>
					</div>
					<div class="pet_grzx_name">简介</div>
					<div class="pet_grzx_name">
						<textarea rows="5" cols="50" name="user.remark"
							placeholder="请输入简介(可为空)"></textarea>
						<div class="pet_grzx_name">
							<input type="submit" id="sub" value="注册" onclick="return conf()" disabled="disabled">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			if (${er=="1"}) {
				alert("图片上传成功");
				${er=null};
			} else if (${er=="0"}) {
				alert("图片上传失败,图片格式不正确");
				${er=null};
			}
			if (${lo=="0"}) {
				alert("注册失败,此名字已被使用");
			} else if (${lo=="1"}) {
				${lo=null}
				if (confirm("注册成功,是否完善信息")) {
					location = 'user/modify';
				} else {
					location = '';
				}
			}
		})

		function conf() {
			if (!confirm("确认注册?")) {
				return false;
			}
		}

		function pwd() {
			var p1 = $("#pwd1").val();
			var p2 = $("#pwd2").val();
			var sub = $("#sub");
			var aty = $("#aty")
			if (p1 != p2) {
				sub.attr('disabled', true);
				aty.show();
			} else {
				sub.attr('disabled', false);
				aty.hide();
			}
		}
	</script>
</body>
</html>
