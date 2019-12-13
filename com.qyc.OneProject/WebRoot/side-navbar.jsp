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
					class="nav-link" href="AdminMgrServlet?judge=exit">注销</a></li>
			</ul>
		</div>
	</nav>
</header>

<!--====================================================
                                    PAGE CONTENT
                ======================================================-->
<div class="page-content d-flex align-items-stretch">
<%Admin adm=((Admin)request.getSession().getAttribute("login")); %>
	<!--***** SIDE NAVBAR *****-->
	<nav class="side-navbar">
		<div class="sidebar-header d-flex align-items-center">
			<div class="avatar">
				<img src="admin\adminphoto\<%if(adm!=null)out.print(adm.getPhoto());%>.jpg" alt="..."
					class="img-fluid rounded-circle">
			</div>
			<div class="title">
				<h1 class="h4"><%if(adm!=null)out.print(adm.getAdminName());%></h1>
			</div>
		</div>
		<hr>
		<!-- Sidebar Navidation Menus-->
		<ul class="list-unstyled">
			<li><a href="#home" aria-expanded="false" data-toggle="collapse">
					<i class="icon-home"></i>数据修改
			</a>
				<ul id="home" class="collapse list-unstyled">
					<li><a href="admin/College/College.jsp">学院</a></li>
					<li><a href="admin/Department/Department.jsp">系</a></li>
					<li><a href="admin/Profession/Profession.jsp">专业</a></li>
					<li><a href=admin/Class/Class.jsp>班级</a></li>
					<li><a href=admin/Student/Student.jsp>学生</a></li>
					<li><a href=admin/Teacher/Teacher.jsp>教师</a></li>
					<li><a href=admin/Course/Course.jsp>课程</a></li>
					<li><a href=admin/ClassRoom/ClassRoom.jsp>教室</a></li>
				</ul></li>
			<%
				if (adm != null) {
					if (adm.getPower().equals("高级管理员")) {
			%>
			<li><a href="#apps" aria-expanded="false" data-toggle="collapse">
					<i class="icon-interface-windows"></i>管理员账户管理
			</a>
				<ul id="apps" class="collapse list-unstyled">
					<li><a href="admin/Admin/Admin.jsp">管理员账户管理</a></li>
				</ul></li>
			<%
					}
				}
			%>
			<li><a href="#Chart" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-bar-chart"></i>账号信息修改
			</a>
				<ul id="Chart" class="collapse list-unstyled">
					<li><a href="admin/Admin/AdminRevise.jsp">账号信息修改</a></li>
					<li><a href="admin/Admin/AdminRevisePwd.jsp">账号密码修改</a></li>
				</ul></li>
			<li><a href="#forms" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-building-o"></i>Forms
			</a>
				<ul id="forms" class="collapse list-unstyled">
					<li><a href="basic-form.html">Basic Form</a></li>
					<li><a href="form-layouts.html">Form Layouts</a></li>
				</ul></li>
			<li><a href="#Maps" aria-expanded="false" data-toggle="collapse">
					<i class="fa fa-map-o"></i>Maps
			</a>
				<ul id="Maps" class="collapse list-unstyled">
					<li><a href="basic-form.html">Basic Form</a></li>
					<li><a href="form-layouts.html">Form Layouts</a></li>
				</ul></li>
			<li><a href="#pages" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-file-o"></i>Pages
			</a>
				<ul id="pages" class="collapse list-unstyled">
					<li><a href="faq.html">FAQ</a></li>
					<li><a href="empty.html">Empty</a></li>
					<li><a href="gallery.html">Gallery</a></li>
					<li><a href="login.html">Log In</a></li>
					<li><a href="register.html">Register</a></li>
					<li><a href="search-result.html">Search Result</a></li>
					<li><a href="404.html">404</a></li>
				</ul></li>
			<li><a href="#Tables" aria-expanded="false"
				data-toggle="collapse"> <i class="icon-grid"></i>Tables
			</a>
				<ul id="Tables" class="collapse list-unstyled">
					<li><a href="faq.html">FAQ</a></li>
					<li><a href="empty.html">Empty</a></li>
					<li><a href="gallery.html">Gallery</a></li>
					<li><a href="login.html">Log In</a></li>
					<li><a href="register.html">Register</a></li>
					<li><a href="search-result.html">Search Result</a></li>
					<li><a href="404.html">404</a></li>
				</ul></li>
			<li><a href="#elements" aria-expanded="false"
				data-toggle="collapse"> <i class="fa fa-globe"></i>UI Elements
			</a>
				<ul id="elements" class="collapse list-unstyled">
					<li><a href="ui-buttons.html">Buttons</a></li>
					<li><a href="ui-cards.html">Cards</a></li>
					<li><a href="ui-progressbars.html">Progress Bar</a></li>
					<li><a href="ui-timeline.html">Timeline</a></li>
				</ul></li>
		</ul>
		<span class="heading">Extras</span>
		<ul class="list-unstyled">
			<li><a href="#"> <i class="icon-picture"></i>Demo
			</a></li>
		</ul>
	</nav>