<%@page import="com.qyc.OneProject.Model.Student"%>
<%@page import="com.qyc.OneProject.util.util"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<header class="header">
	<nav class="navbar navbar-expand-lg ">
		<div class="search-box">
			<button class="dismiss">
				<i class="icon-close"></i>
			</button>
			<form id="searchForm" action="#" role="search">
				<input type="search" placeholder="Search Now" class="form-control">
			</form>
		</div>
		<div class="container-fluid ">
			<div
				class="navbar-holder d-flex align-items-center justify-content-between">
				<div class="navbar-header">
					<a href="index.html" class="navbar-brand">
						<div class="brand-text brand-big hidden-lg-down">
							<h4>学生选课系统</h4>
						</div>
						<div class="brand-text brand-small">
							<img src="img/logo-icon.png" alt="Logo" class="img-fluid">
						</div>
					</a> <a id="toggle-btn" href="#" class="menu-btn active"> <span></span>
						<span></span> <span></span>
					</a> <a href="#" class="navbar-brand">
						<h6>---学生端---</h6>
					</a>
				</div>
			</div>
			<ul
				class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
				<!-- Expand-->
				<li class="nav-item d-flex align-items-center full_scr_exp"><a
					class="nav-link" href="#"><%=util.getNowTime()%></a></li>
				<!-- Search-->
				<li class="nav-item d-flex align-items-center"><a
					class="nav-link" href="StudentMgrServlet?judge=exit">注销</a></li>
			</ul>
		</div>
	</nav>
</header>

<!--====================================================
                                    PAGE CONTENT
                ======================================================-->
<div class="page-content d-flex align-items-stretch">
	<%
		Student stu = ((Student) request.getSession()
				.getAttribute("Slogin"));
	%>
	<!--***** SIDE NAVBAR *****-->
	<nav class="side-navbar">
		<div class="sidebar-header d-flex align-items-center">
			<div class="avatar">
				<img
					src="Student/StudentPhoto/<%if (stu != null)
				out.print(stu.getPhoto());%>.jpg"
					alt="..." class="img-fluid rounded-circle">
			</div>
			<div class="title">
				<h1 class="h4">
					<%
						if (stu != null)
							out.print(stu.getName());
					%>
				</h1>
			</div>
		</div>
		<hr>
		<!-- Sidebar Navidation Menus-->
		<ul class="list-unstyled">
		<li><a href="#Release" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-building-o"></i>公告
			</a>
				<ul id="Release" class="collapse list-unstyled">
					<li><a href="Student/StudentReleaseInfo.jsp">系统公告</a></li>
				</ul></li>
			<li><a href="#forms" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-building-o"></i>课程管理
			</a>
				<ul id="forms" class="collapse list-unstyled">
					<li><a href="Student/TimeTables.jsp">课程表</a></li>
					<li><a href="Student/CourseSchedule.jsp">课程选择</a></li>
					<li><a href="Student/OptCourseSchedule.jsp">已选课程</a></li>
					<li><a href="Student/StudentSuccess.jsp">成绩查询</a></li>
				</ul></li>
			<li><a href="#Chart" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-bar-chart"></i>账号信息修改
			</a>
				<ul id="Chart" class="collapse list-unstyled">
					<li><a href="Student/StudentRevise.jsp">账号信息修改</a></li>
					<li><a href="Student/StudentRevisePwd.jsp">账号密码修改</a></li>
				</ul></li>
		</ul>
	</nav>