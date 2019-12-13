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
			<div class="pet_news_list_tag_name">个人信息修改</div>
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

				<form action="user/photo" enctype="multipart/form-data"
					method="post">
					<div class="pet_grzx_nr">
						<div class="pet_grzx_map">修改头像</div>
						<div class="pet_grzx_ico">
							<img id="pic" alt=""
								src="user/userPhoto/${login.photo }${login.photoType}">
						</div>
						<div class="pet_grzx_num_font">
							<input placeholder="" type="text" id="filename"
								style="display: none;"
								class="form-control image-preview-filename" readonly="readonly">
							<span class="input-group-btn"> <span
								class="glyphicon glyphicon-folder-open"></span> <input
								type="file" accept=" image/*" name="image"
								onchange="ImgShowPreview(this)"
								style="margin-left: 43.6%;margin-top: 10px;">

							</span> &nbsp<input style="margin-top: 10px" type="submit" value="上传照片" />
						</div>
					</div>
				</form>
				<form action="user/update" method="post">
					<div class="pet_grzx_name">账号</div>
					<div class="pet_grzx_name">
						<input type="text" name="user.uID" disabled="disabled"
							value="${login.uID }">
					</div>
					<div class="pet_grzx_name">名称</div>
					<div class="pet_grzx_name">
						<input type="text" name="user.name" value="${login.name }">
					</div>
					<div class="pet_grzx_name">电话号码</div>
					<div class="pet_grzx_name">
						<input type="text" name="user.phone"
							oninput="value=value.replace(/[^\d]/g,'')"
							value="${login.phone }">
					</div>
					<div class="pet_grzx_name">简介</div>
					<div class="pet_grzx_name">
						<textarea rows="5" cols="50" name="user.remark"
							placeholder="请输入简介(可为空)">${login.remark }</textarea>
						<div class="pet_grzx_name">
							<input type="submit" id="sub" value="修改" onclick="return conf()">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<script src="js/appjs/resize.js"></script>
	<script>
	$(document).ready(function(){
		if (${er=="1"}) {
				alert("图片修改成功");
				${er=null};
			} else if (${er=="0"}) {
				alert("图片修改失败");
				${er=null}
			}
			;
			if(${ur=="1"}){
			alert("个人信息修改成功")
			${ur=null}
			}
	})
		function conf() {
			if (!confirm("确认修改?")) {
				return false;
			}
		}

		function ImgShowPreview(source) {
			var file = source.files[0];
			if (window.FileReader) {
				var fr = new FileReader();
				console.log(fr);
				var pic = document.getElementById('pic');
				var filename = document.getElementById('filename');
				fr.onloadend = function(e) {
					pic.src = e.target.result;
				};
				fr.readAsDataURL(file);
				pic.style.display = 'block';
				filename.value = file.name;
			}
		}
	</script>
</body>
</html>
