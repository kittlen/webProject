<%@page import="com.qyc.OneProject.Model.Student"%>
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


<body>
	<%
		try {
			if (request.getSession().getAttribute("Slogin") == null) {
					response.sendRedirect("../Student/login");
			}
			Student stu = (Student) (request.getSession()
					.getAttribute("Slogin"));
	%>
	<jsp:include page="side-navbar.jsp"></jsp:include>

	<div class="content-inner chart-cont" style="height: 100%">
		<div class="card form" id="form2" style="padding:10px 20px 20px 40px;">
			<div class="card-header">
				<h4>学生信息修改</h4>
			</div>
			<br>
			<div class="row" style="padding:10px 20px 20px 40px;">
				<form action="Student/updateIn" method="post" style="width: 50%">
					<label for="example-text-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">学生编号</label>
					<div class="col-9" style="flex-basis:20%">
						<input class="form-control" type="text" id="example-text-input"
							style="width: 100%;" value="<%=stu.getStu_ID()%>"
							readonly="readonly" name="Stu_ID">
					</div>

					<label for="example-text-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">学生姓名</label>
					<div class="col-9" style="flex-basis:20%">
						<input class="form-control" type="text" placeholder="学生姓名"
							id="example-text-input" style="width: 100%;"
							value="<%=stu.getName()%>" name="Name" readonly="readonly">
					</div>
					<label for="example-text-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">所属班级</label>
					<div class="col-9" style="flex-basis:20%">
						<input class="form-control" type="text" id="example-text-input"
							style="width: 100%; readonly="
							readonly"
							value="<%=stu.getTClass().getYearName()%>级<%=stu.getTClass().getGradeName()%>"
							readonly="readonly" name="TClass.Class_ID">
					</div>
					<label for="example-text-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">学生性别</label>
					<div class="col-9" style="flex-basis:20%">
						<select class="form-control" id="Sex" name="Sex"
							style="width: 100%;">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>

					<label for="example-search-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">出生日期</label>
					<div class="col-9" style="flex-basis:20%">
						<input class="form-control" type="date"
							value="<%=stu.getBirth()%>" id="Birth" name="Birth"
							style="width: 100%;">
					</div>

					<label for="example-search-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">学生电话</label>
					<div class="col-9" style="flex-basis:20%">
						<input class="form-control" type="text" placeholder="学生电话"
							id="example-search-input" value="<%=stu.getPhone()%>"
							style="width: 100%;" name="Phone">
					</div>

					<label for="example-search-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">家庭地址</label>
					<div class="col-9" style="flex-basis:20%">
						<input class="form-control" type="text" placeholder="家庭地址"
							id="example-search-input" value="<%=stu.getFamily()%>"
							style="width: 100%;" name="Family">
					</div>

					<label for="example-search-input"
						style="width: 85px;margin-left: 5%;margin-top: 15px"
						class=" col-form-label">学生备注</label>
					<div class="col-9" style="flex-basis:30%">
						<input class="form-control" type="text" placeholder="学生备注"
							id="example-search-input" value="<%=stu.getRemark()%>"
							style="width: 100%;" name="Remark">
					</div>

					<button type="submit" class="btn btn-general btn-white"
						style="margin-left: 30%">保存</button>

				</form>

				<form class="col-md-6" action="Student/execute"
					enctype="multipart/form-data" method="post">
					<div class="form-group row">
						<label for="example-datetime-local-input" style="width:85px;"
							class=" col-form-label"></label>
						<div class="card hovercard">
							<div class="avatar">
								<img id="pic" alt=""
									src="Student\studentphoto\<%=stu.getPhoto()%>.jpg"
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
				response.sendRedirect("../Student/login");
		}
	%>

</body>
<script type="text/javascript">
		$(document).ready(sex());
		function sex(){
		<%Student stu = (Student) (request.getSession()
					.getAttribute("Slogin"));%>
		$("[name=Sex]").val("<%=stu.getSex()%>");
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
</html>