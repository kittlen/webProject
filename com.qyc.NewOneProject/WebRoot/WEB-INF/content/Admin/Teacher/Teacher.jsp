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

<script src="admin/js/Teacher.js"></script>
<body>
	<%
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("../Admin/login");
		}
	%>
	<jsp:include page="..//side-navbar.jsp"></jsp:include>

	<div class="content-inner form-cont">
		<div class="row">
			<div class="col-md-12">

				<!--***** teacher *****-->
				<div class="card form" id="form1">
					<div class="card-header">
						<h3>教师</h3>
					</div>
					<br>
					<form action="Teacher/insert" method="post" name="forms">
						<div class="form-group row">
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">所属分院</label>
							<div class="col-9" style="flex-basis:24%">
								<select class="form-control" id="CollegeID" name="college.CollegeID"
									onchange="table()">

								</select>
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">教师编号</label>
							<div class="col-9" style="flex-basis:24%">
								<input class="form-control" type="text" placeholder="系部编号"
									id="example-text-input" style="width: 100%;" name="TeacherID">
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 10px" class=" col-form-label">教师名称</label>
							<div class="col-9" style="flex-basis:24%">
								<input class="form-control" type="text" placeholder="教师名称"
									id="example-text-input" style="width: 100%;" name="Name">
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">教师性别</label>
							<div class="col-9" style="flex-basis:24%">
								<select class="form-control" id="Sex" name="Sex"
									style="width: 100%;margin-top: 15px">
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">出生日期</label>
							<div class="col-9" style="flex-basis:24%">
								<input class="form-control" type="date" value="2011-08-19"
									id="Birth" name="Birthday" style="width: 100%;margin-top: 15px">

							</div>

							<label for="example-text-input"
								style="width: 85px;margin-left: 10px;margin-top: 15px"
								class=" col-form-label">教师职位</label>
							<div class="col-9" style="flex-basis:24%">
								<input class="form-control" type="text" placeholder="教师职位(可空)"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="Kulture">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">电话号码</label>
							<div class="col-9" style="flex-basis:24%">
								<input class="form-control" type="text" placeholder="电话号码(可空)"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="Phone">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">家庭住址</label>
							<div class="col-9" style="flex-basis:24%">
								<input class="form-control" type="text" placeholder="家庭住址(可空)"
									id="example-text-input" style="width: 100%;margin-top: 15px"
									name="Home">
							</div>
						</div>
						<div class="form-group row">
							<label for="example-search-input"
								style="width: 85px;margin-left: 5%;" class=" col-form-label">教师备注</label>
							<div class="col-9" style="flex-basis:30%">
								<input class="form-control" type="search" placeholder="教师备注"
									id="example-search-input" style="width: 100%;" name="Remark">
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
									<table class="table table-hover" id="Teacher">
										<thead>
											<tr class="bg-info text-white">
												<th>序号</th>
												<th>教师编号</th>
												<th>教师姓名</th>
												<th>所属分院</th>
												<th>教师性别</th>
												<th>出生日期</th>
												<th>教师职位</th>
												<th>家庭地址</th>
												<th>电话号码</th>
												<th>Remark</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="TeacherTable">

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