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

<title>My JSP 'Arrange.jsp' starting page</title>

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
						<h3>课表配置</h3>
					</div>
					<br>
					
						<div class="page-content d-flex align-items-stretch">
							<div class="content-inner chart-cont" style="margin-left: 5%">

								<!--***** CONTENT *****-->
								<div class="row">
									<table class="table table-hover" id="Arrange">
										<thead>
											<tr class="bg-info text-white">
												<th>序号</th>
												<th>课程编号</th>
												<th>课程名称</th>
												<th>学时</th>
												<th>学分</th>
												<th>课长</th>
												<th>所属专业</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="ArrangeTable">

										</tbody>
									</table>
								</div>
							</div>
						</div>
						<hr>
						<form action="Schedule/insert" method="post">
						<div class="form-group row">
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">课程编号</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="课程编号"
									id="TeachTaskID" style="width: 100%" id="TeachTaskID" name="teachTask.ID">
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">教室类型</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control" name="ClassRoomCategory" id="ClassRoomCategory"
									onchange="FirstLoadcols()">
									<option value="多媒体教室">多媒体教室</option>
									<option value="实训室">实训室</option>
									<option value="阶梯教室">阶梯教室</option>
									<option value="报告厅">报告厅</option>
								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%" class=" col-form-label">教室名称</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control" name="ClassRoomID" id="ClassRoomName">

								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">时间(星期)</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control"
									style="width: 100%;margin-top: 15px" name="Classfestival" id="Classfestival">
									<option value="星期一">星期一</option>
									<option value="星期二">星期二</option>
									<option value="星期三">星期三</option>
									<option value="星期四">星期四</option>
									<option value="星期五">星期五</option>
								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label">时间(节数)</label>
							<div class="col-9" style="flex-basis:20%">
								<select class="form-control"
									style="width: 100%;margin-top: 15px" name="ClassTime" id="ClassTime">
									<option value="一、二节">一、二节</option>
									<option value="三、四节">三、四节</option>
									<option value="五、六节">五、六节</option>
									<option value="七、八节">七、八节</option>
									<option value="九、十节">九、十节</option>
									<option value="十一、十二节">十一、十二节</option>
								</select>
							</div>
							<label for="example-text-input"
								style="width: 85px;margin-left: 5%;margin-top: 15px"
								class=" col-form-label" onclick="conf()">课表备注</label>
							<div class="col-9" style="flex-basis:20%">
								<input class="form-control" type="text" placeholder="课表备注"
									id="Remark" style="width: 100%;margin-top: 15px"
									name="Remark">
							</div>
						</div>
						<div style="margin-left: 40%">
							<button type="submit" class="btn btn-general btn-blue mr-2"
								id="tijiao" onclick="return conf()">提交</button>
							<button type="reset" class="btn btn-general btn-white"
								onclick="inputreset()">重置</button>
						</div>
					</form>
					<div class="form-group row">
						<label for="example-text-input"
							style="width: 85px;margin-left: 5%;margin-top: 10px" class=" col-form-label">请选择课程:</label>
						<div class="col-9" style="flex-basis:20%">
							<select class="form-control" name="Course" id="Course"
							style="width: 100%;height: 40px;margin-top: 10px" >

						</select>
						</div>
						<input type="button" value="查询"
							style="height: 40px;margin-top: 10px" onclick="sctable()">
					</div>
					<div class="page-content d-flex align-items-stretch">
						<div class="content-inner chart-cont" style="margin-left: 5%">

							<!--***** CONTENT *****-->
							<div class="row">
								<table class="table table-hover" id="Schedule">
									<thead>
										<tr class="bg-info text-white">
											<th>序号</th>
											<th>课程名称</th>
											<th>星期</th>
											<th>节次</th>
											<th>教室</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="ScheduleTable">

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

<script src="Teacher/js/Arrange.js"></script>
</html>
