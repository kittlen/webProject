<%@page import="com.qyc.OneProject.Model.Notice"%>
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
			if (request.getSession().getAttribute("Slogin") == null) {
					response.sendRedirect("../Student/login");
			}
			if(request.getSession().getAttribute("notice")==null){
				response.sendRedirect("../Student/StudentReleaseInfo");
			}
			Notice notice=(Notice)request.getSession().getAttribute("notice");
			
	%>
	<jsp:include page="side-navbar.jsp"></jsp:include>
	<div class="content-inner chart-cont" style="height: 100%">
		<div class="card form" id="form2" style="padding:10px 20px 20px 40px;">
			<div class="card-header">
				<h4>公告详情</h4>
			</div>
			<br>
			<div class="row" style="padding:10px 20px 20px 40px;">
				<div class="card form" id="form2"
					style="padding:20px 30px 20px 30px;margin-left: 5%;width: 70%">
					 <div class="row" style="padding:10px 20px 20px 40px;margin: auto;">					
						<h5><%=notice.getNoticeTitle() %></h5>	
					</div>
					<div class="row" style="padding:10px 20px 20px 40px;margin: auto;">					
						<h6>发布：<%=notice.getAdmin().getAdminID() %> &nbsp;&nbsp;日期：<%=notice.getReleaseTime() %> </h6>	
					</div>
					<div class="row" style="padding:10px 20px 20px 40px;">			
							<%=notice.getNoticeContent() %>
					</div>					
				
			</div>
				</div>
			</div>
		</div>
	</div>
	<%		} catch (NullPointerException e) {
				response.sendRedirect("../Student/login");
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


</html>