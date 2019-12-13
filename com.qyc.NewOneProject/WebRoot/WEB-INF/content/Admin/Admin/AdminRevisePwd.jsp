<%@page import="com.qyc.OneProject.Model.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
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

<title>My JSP 'AdminResetPwd.jsp' starting page</title>

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
				<h4>账号密码修改</h4>
			</div>
			<br>

			<form action="Admin/updatePwd" method="post">
				<div class="row" style="padding:10px 20px 20px 40px;">
					<div class="col-md-6" style="padding-left: 15%;">
						<div class="form-group row">
							<label for="example-text-input" style="width: 85px;"
								class=" col-form-label">管理员账号</label>
							<div class="col-9">
								<input class="form-control" type="text"
									value="<%=adm.getAdminID()%>" readonly="readonly"
									name="AdminID">
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" style="width: 85px;"
								class=" col-form-label">旧密码</label>
							<div class="col-9">
								<input class="form-control" type="password" value=""
									name="PastPassword" placeholder="请输入旧密码">
							</div>
						</div>
						<div class="form-group row">
							<label for="example-search-input" style="width: 85px;"
								class=" col-form-label">新密码</label>
							<div class="col-9">
								<input class="form-control" type="password" value=""
									placeholder="请输入新密码" name="NewPassword">
							</div>
						</div>
						<div class="form-group row">
							<label for="example-search-input" style="width: 85px;"
								class=" col-form-label">新密码</label>
							<div class="col-9">
								<input class="form-control" type="password" value=""
									placeholder="请再次输入新密码" name="NewPassword2" oninput="RevisePwd()">
							</div>
							<div style="display: none" name="aty">新密码不一致</div>
						</div>
						<div class="form-group row">
							<input type="hidden" value="upPwd" name="judge">
							<button type="submit" class="btn btn-general btn-white"
								name="Preservation">保存</button>
						</div>
					</div>
				</div>
			</form>
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
	$(document).ready(function(){
	
	var pd=${pd};
	if(pd==true){
	alert("密码修改成功")
	}else if(pd==false){
	alert("密码修改失败")
	}
	<%request.getSession().setAttribute("pd", null);%>
	});
	
	function RevisePwd() {
		var NewPassword = $("[name=NewPassword]").val();
		var NewPassword2 = $("[name=NewPassword2]").val();
		if (NewPassword2 != NewPassword) {
			$("[name=Preservation]").attr('disabled', true);
			$("[name=aty]").show();
		} else {
			$("[name=Preservation]").attr('disabled', false);
			$("[name=aty]").hide();
		}
	}
</script>
</html>