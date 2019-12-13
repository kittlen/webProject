<%@page import="com.qyc.OneProject.Model.Admin"%>
<%@page import="com.qyc.OneProject.Model.College"%>
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

<script src="admin/js/College.js"></script>
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

				<!--***** College *****-->
				<div class="card form" id="form1">
					<div class="card-header">
						<h3>分院</h3>
					</div>
					<br>
					<form action="CollegeMgrServlet" method="post">
						<div class="form-group row">
							<label for="example-text-input" style="width: 85px;"
								class=" col-form-label">分院编号</label>
							<div class="col-9" style="flex-basis:30%">
								<input class="form-control" type="text" placeholder="分院编号"
									id="example-text-input" style="width: 100%;" name="CollegeID">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 10px" class=" col-form-label">分院名称</label>
							<div class="col-9" style="flex-basis:30%">
								<input class="form-control" type="text" placeholder="分院名称"
									id="example-text-input" style="width: 100%;" name="CollegeName">
							</div>
						</div>
						<div class="form-group row">
							<label for="example-search-input" style="width: 85px;"
								class=" col-form-label">分院备注</label>
							<div class="col-9" style="flex-basis:30%">
								<input class="form-control" type="search" placeholder="分院备注"
									id="example-search-input" style="width: 100%;" name="Remark">
							</div>

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
									<table class="table table-hover" id="College">
										<thead>
											<tr class="bg-info text-white">
												<th>序号</th>
												<th>分院编号</th>
												<th>分院名称</th>
												<th>Remark</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="CollegeTable">

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