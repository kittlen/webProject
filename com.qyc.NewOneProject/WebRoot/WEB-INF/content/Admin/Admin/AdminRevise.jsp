<%@page import="com.qyc.OneProject.Model.Admin"%>
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

<title>My JSP 'AdminReset.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
<link rel="stylesheet" href="css/form.css">

</head>
<!--Global Javascript -->
<script src="js/jquery.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/front.js"></script>

<script src="admin/js/Admin.js"></script>

<body>
	<%
		try {
			if (request.getSession().getAttribute("login") == null) {
				response.sendRedirect("../Admin/login");
			}
			Admin adm = (Admin) (request.getSession().getAttribute("login"));
	%>
	<jsp:include page="../side-navbar.jsp"></jsp:include>
	<div class="content-inner chart-cont" style="height: 100%">
		<div class="card form" id="form2" style="padding:10px 20px 20px 40px;">
			<div class="card-header">
				<h4>账号信息修改</h4>
			</div>
			<br>
			<div class="row" style="padding:10px 20px 20px 40px;">
				<form action="Admin/updateIn" method="post" style="width: 50%">
					<div class="form-group row">
						<label for="example-text-input" style="width: 85px;"
							class=" col-form-label">管理员账号</label>
						<div class="col-9">
							<input class="form-control" type="text"
								value="<%=adm.getAdminID()%>" readonly="readonly" name="AdminID">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-text-input" style="width: 85px;"
							class=" col-form-label">管理员名称</label>
						<div class="col-9">
							<input class="form-control" type="text"
								value="<%=adm.getAdminName()%>" name="AdminName">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-search-input" style="width: 85px;"
							class=" col-form-label">管理员类型</label>
						<div class="col-9">
							<input class="form-control" type="text"
								value="<%=adm.getPower()%>" readonly="readonly" name="power">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-search-input" style="width: 85px;"
							class=" col-form-label">备注:</label>
						<div class="col-9">
							<input class="form-control" type="text"
								value="<%=adm.getRemark()%>" name="Remark">
						</div>
					</div>
					<div class="form-group row">
						<button type="submit" class="btn btn-general btn-white">保存</button>
					</div>
				</form>

				<form class="col-md-6" action="Admin/Photo"
					enctype="multipart/form-data" method="post">
					<div class="form-group row">
						<label for="example-datetime-local-input" style="width:85px;"
							class=" col-form-label"></label>
						<div class="card hovercard">
							<div class="avatar">
								<img id="pic" alt=""
									src="admin\adminphoto\<%=adm.getPhoto()%>.jpg"
									style="width:40mm;height: 52mm;">
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-9">
							<div class="input-group image-preview">
								<input placeholder="" type="text" id="filename"
									class="form-control image-preview-filename" readonly="readonly">
								<span class="input-group-btn">
									<div class="btn btn-default image-preview-input">
										<span class="glyphicon glyphicon-folder-open"></span> <span
											class="image-preview-input-title">打开</span> <input
											type="file" accept=" image/jpg" name="image"
											onchange="ImgShowPreview(this)" />
									</div>
								</span> &nbsp<input type="submit" value="上传照片" />
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
	</div>
	<%
		} catch (NullPointerException e) {
			response.sendRedirect("../Admin/login");
		}
	%>

</body>
<script type="text/javascript">
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
</html>