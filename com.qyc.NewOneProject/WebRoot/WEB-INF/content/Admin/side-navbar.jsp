<%@page import="com.qyc.OneProject.Model.Admin"%>
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
						<h6>---管理端---</h6>
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
					class="nav-link" href="Exit/AdminExit">注销</a></li>
			</ul>
		</div>
	</nav>
</header>

<!--====================================================
                                    PAGE CONTENT
                ======================================================-->
<div class="page-content d-flex align-items-stretch">
	<%
		Admin adm = ((Admin) request.getSession().getAttribute("login"));
	%>
	<!--***** SIDE NAVBAR *****-->
	<nav class="side-navbar">
		<div class="sidebar-header d-flex align-items-center">
			<div class="avatar">
				<img
					src="admin\adminphoto\<%if (adm != null)
				out.print(adm.getPhoto());%>.jpg"
					alt="..." class="img-fluid rounded-circle">
			</div>
			<div class="title">
				<h1 class="h4">
					<%
						if (adm != null)
							out.print(adm.getAdminName());
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
					<li><a href="Admin/AdminRelease">公告发布</a></li>
					<li><a href="Admin/AdminReleaseInfo">系统公告</a></li>
				</ul></li>
			<li><a href="#home" aria-expanded="false" data-toggle="collapse">
					<i class="icon-home"></i>数据修改
			</a>
				<ul id="home" class="collapse list-unstyled">
					<li><a href="College/College">学院</a></li>
					<li><a href="Department/Department">系</a></li>
					<li><a href="Profession/Profession">专业</a></li>
					<li><a href="Class/Class">班级</a></li>
					<li><a href="Student/Student">学生</a></li>
					<li><a href="Teacher/Teacher">教师</a></li>
					<li><a href="Course/Course">课程</a></li>
					<li><a href="ClassRoom/ClassRoom">教室</a></li>
				</ul></li>
			<li><a href="#forms" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-building-o"></i>课程管理
			</a>
				<ul id="forms" class="collapse list-unstyled">
					<li><a href="Audit/Audit">课程审核</a></li>
				</ul></li>
			<%
				if (adm != null) {
					if (adm.getPower().equals("高级管理员")) {
			%>
			<li><a href="#apps" aria-expanded="false" data-toggle="collapse">
					<i class="icon-interface-windows"></i>管理员账户管理
			</a>
				<ul id="apps" class="collapse list-unstyled">
					<li><a href="Admin/Admin">管理员账户管理</a></li>
				</ul></li>
			<%
				}
				}
			%>
			<li><a href="#Chart" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-bar-chart"></i>账号信息修改
			</a>
				<ul id="Chart" class="collapse list-unstyled">
					<li><a href="Admin/AdminRevise">账号信息修改</a></li>
					<li><a href="Admin/AdminRevisePwd">账号密码修改</a></li>
				</ul></li>

		</ul>
	</nav>