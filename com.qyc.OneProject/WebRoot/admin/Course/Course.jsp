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
<!--Global Javascript -->
<script src="js/jquery.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/front.js"></script>

<script src="admin/js/Course.js"></script>
<body>
<%
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("../Admin/login.jsp");
		}
	%>
	<jsp:include page="../side-navbar.jsp"></jsp:include>

	<div class="content-inner form-cont">
		<div class="row">
			<div class="col-md-12">

				<!--***** Course *****-->
				<div class="card form" id="form1">
					<div class="card-header">
						<h3>课程</h3>
					</div>
					<br>
					<form action="CourseMgrServlet" method="post">
						<div class="form-group row">
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">所属分院</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control" id="colselect" name="CollegeID"
									onchange="SecondLoadcols()">

								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">所属系部</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control" id="depselect" name="DepartmentID"
									onchange="ThirdLoadcols()">

								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">所属专业</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control" id="proselect" name="ProfessionID"
									onchange="table()">

								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">课程编号</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="课程编号"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="CourseID">
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">课程名称</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="课程名称"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="Course">
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">学时</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="学时"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="StudyTime">
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">学分</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="学分"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="Crediy">
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">课长</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="课长"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="CurriculumTime">
							</div>

							<label for="example-search-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">课程备注</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="search" placeholder="课程备注"
									id="example-search-input" style="width: 100%;margin-top: 15px"
									name="Remark">
							</div>
						</div>
						<div class="form-group row">


							<div class="col-9" style="flex-basis:30%">
								<input class="form-control" type="hidden" style="width: 100%;"
									name="judge" value="in">
							</div>

						</div>
						<div class="form-inline">
							<button type="submit" class="btn btn-general btn-blue mr-2"
								id="tijiao">提交</button>
							<button type="reset" class="btn btn-general btn-white"
								onclick="inputreset()">重置</button>
						</div>

						<hr>
						<div class="page-content d-flex align-items-stretch">
							<div class="content-inner chart-cont">

								<!--***** CONTENT *****-->
								<div class="row">
									<table class="table table-hover" id="Course">
										<thead>
											<tr class="bg-info text-white">
												<th>序号</th>
												<th>课程编号</th>
												<th>课程名称</th>
												<th>学时</th>
												<th>学分</th>
												<th>课长</th>
												<th>所属分院</th>
												<th>所属系部</th>
												<th>所属专业</th>
												<th>Remark</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="CourseTable">

										</tbody>
									</table>
								</div>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>

</html>