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


<body>
	<%
		try {
			if (request.getSession().getAttribute("login") == null) {
				response.sendRedirect("login.jsp");
			}
	%>
	<jsp:include page="../side-navbar.jsp"></jsp:include>
	<div class="content-inner chart-cont" style="height: 100%">
		<div class="card form" id="form2" style="padding:10px 20px 20px 40px;">
			<div class="card-header">
				<h4>公告发布</h4>
			</div>
			<br>
			<div class="row" style="padding:10px 20px 20px 40px;">
				<form class="col-md-6" action="NoticeMgrServlet" method="post">
					<div class="col-md-9">
						<div class="form-group row">
							<label for="example-text-input" style="width: 85px;"
								class=" col-form-label">公告标题：</label>
							<div class="col-9">
								<input class="form-control" type="text" id="NoticeTitle"
									name="NoticeTitle">
							</div>
						</div>
					</div>
					<textarea name="NoticeContent" id="NoticeContent"></textarea>
					<input type="hidden" value="in" name="judge">
					<div class="col-md-6">
						<button type="submit" class="btn btn-general btn-white"
							onclick="return OnNotice()" name="release" >发布</button>
						<button type="reset" class="btn btn-general btn-white" onclick="inputreset()">重置</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<%
		} catch (NullPointerException e) {
			response.sendRedirect("login.jsp");
		}
	%>

</body>
<!--Global Javascript -->
<script src="js/jquery.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/front.js"></script>

<script src="ckeditor/ckeditor.js"></script>
<script src="admin/js/AdminRelease.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		InsertJudge();
		CKeditor();

	})

	function InsertJudge() {
<%String pd = String.valueOf((request.getSession().getAttribute("AdInsert")));%>
	var pd =<%=pd%>;
		if (pd == true) {
			alert("公告发布成功")
		} else if (pd == false) {
			alert("公告发布失败")
		}
<%request.getSession().setAttribute("AdInsert", null);%>
	}
</script>

</html>