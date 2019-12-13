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

<title>My JSP 'Success.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
			if (request.getSession().getAttribute("Tlogin") == null) {
				response.sendRedirect("../Teacher/login");
			}
			;
	%>
	<jsp:include page="side-navbar.jsp"></jsp:include>

	<div class="content-inner form-cont">
		<div class="row">
			<div class="col-md-12">

				<!--***** TCourse *****-->
				<div class="card form" id="form1">
					<div class="card-header">
						<h3>成绩录入</h3>
					</div>
					<br>
					<div class="form-group row">
						<label for="example-text-input"
							style="width: 85px;margin-left: 5%" class=" col-form-label">请选择您所开的课程:</label>
						<div class="col-9" style="flex-basis:20%">
							<select class="form-control" name="Course" id="Course"
								style="width: 100%;height: 40px;margin-top: 10px">

							</select>
						</div>
						<input type="button" value="查询"
							style="height: 40px;margin-top: 10px" onclick="table()">
					</div>
					<div class="page-content d-flex align-items-stretch">
						<div class="content-inner chart-cont" style="margin-left: 5%">

							<!--***** CONTENT *****-->
							<div class="row">
								<table class="table table-hover" id="Success">
									<thead>
										<tr class="bg-info text-white">
											<th>序号</th>
											<th>课程名称</th>
											<th>学生名称</th>
											<th>学号</th>
											<th>星期</th>
											<th>节次</th>
											<th>教室</th>
											<th>考勤分</th>
											<th>课堂分</th>
											<th>期末分</th>
											<th>总分</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="SuccessTable">

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<hr>
					<form action="CourseSchedule/update" method="post">
						<div class="form-group row">
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">学生姓名</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="学生姓名"
									id="StudentName" style="width: 100%" name="cSchedule.student.Name">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">学号</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="学号"
									id="Stu_ID" style="width: 100%" name="cSchedule.student.Stu_ID">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">考勤分</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="考勤分"
									id="ScoreOne" style="width: 100%" name="cSchedule.ScoreOne">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">课堂分</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="课堂分"
									id="ScoreTwo" style="width: 100%;margin-top: 15px"
									name="cSchedule.ScoreTwo">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">期末分</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="期末分"
									id="ScoreThree" style="width: 100%;margin-top: 15px"
									name="cSchedule.ScoreThree">
							</div>
						</div>
						<div style="margin-left: 40%">
							<input class="form-control" type="hidden" style="width: 100%;"
								name="cSchedule.ID" id="CourseScheduleID">
							<button type="submit" class="btn btn-general btn-blue mr-2"
								id="tijiao" onclick="return conf()">提交</button>
							<button type="reset" class="btn btn-general btn-white"
								onclick="inputreset()">重置</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<%
		} catch (NullPointerException e) {
			response.sendRedirect("../Teacher/login");
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

<script src="Teacher/js/Success.js"></script>
</html>
