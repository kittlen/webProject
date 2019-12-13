
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
<link rel="shortcut icon" href="img/favicon.ico">

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
			if (request.getSession().getAttribute("Slogin") == null) {
				response.sendRedirect("login.jsp");
			}
	%>
	<jsp:include page="side-navbar.jsp"></jsp:include>

	<div class="content-inner form-cont">
		<div class="row">
			<div class="col-md-12">

				<!--***** TCourse *****-->
				<div class="card form" id="form1">
					<div class="card-header">
						<h3>已选课程</h3>
					</div>
					<hr>
					<div class="page-content d-flex align-items-stretch"
						style="padding-top: 2%">
						<div class="content-inner chart-cont" style="margin-left: 5%">

							<!--***** CONTENT *****-->
							<div class="row">
								<table class="table table-hover" id="OptCourseSchedule">
									<thead>
										<tr class="bg-info text-white">
											<th>序号</th>
											<th>课程名称</th>
											<th>授课教师</th>
											<th>星期</th>
											<th>节次</th>
											<th>教室</th>
											<th>学时</th>
											<th>学分</th>
											<th>课长</th>
											<th>课程所属学院</th>
											<th>Remark</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="OptCourseScheduleTable">

									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
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
<script src="js/jquery.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/front.js"></script>

<script src="Student/js/OptCourseSchedule.js"></script>
</html>
