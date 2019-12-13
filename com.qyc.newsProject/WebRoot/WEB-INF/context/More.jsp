<%@page import="com.qyc.newsProject.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<div class="iconfont pet_more_close">×</div>
<div class="pet_more_list_block">
	<div class="pet_more_list_block_name">
		<div class="pet_more_list_block_name_title">阅读 Read</div>
		<a class="pet_more_list_block_line" href="not/skipType?typeIndex=1">
			<i class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
			<div class="pet_more_list_block_line_font">新鲜事</div>
		</a> <a class="pet_more_list_block_line" href="not/skipType?typeIndex=2">
			<i class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
			<div class="pet_more_list_block_line_font">趣闻</div>
		</a> <a class="pet_more_list_block_line" href="not/skipType?typeIndex=3">
			<i class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
			<div class="pet_more_list_block_line_font">阅读</div>
		</a> <a class="pet_more_list_block_line" href="user/search"> <i
			class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
			<div class="pet_more_list_block_line_font">搜索</div>
		</a> <a class="pet_more_list_block_line" href=""> <i
			class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
			<div class="pet_more_list_block_line_font">首页</div>
		</a>
		<div
			class="pet_more_list_block_name_title pet_more_list_block_line_height">服务
			Service</div>
		<%
			User user = (User) request.getSession().getAttribute("login");
			if (user == null) {
		%>
		<a class="pet_more_list_block_line" href="user/login" target="_blank">
			<i class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
			<div class="pet_more_list_block_line_font">登陆</div>
		</a> <a class="pet_more_list_block_line" href="user/logon" target="_blank">
			<i class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
			<div class="pet_more_list_block_line_font">注册</div>
		</a>
		<%
			}
		%>
		<a class="pet_more_list_block_line" href="user/personal"
			target="_blank"> <i
			class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
			<div class="pet_more_list_block_line_font">个人</div>
		</a> <a class="pet_more_list_block_line" href="user/modify"
			target="_blank"> <i
			class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
			<div class="pet_more_list_block_line_font">修改</div>
		</a> <a class="pet_more_list_block_line" href="user/modifyPwd"
			target="_blank"> <i
			class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
			<div class="pet_more_list_block_line_font">密码</div>
		</a><a class="pet_more_list_block_line" href="user/exit"> <i
			class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
			<div class="pet_more_list_block_line_font">退出</div>
		</a>
		<%
			if (user != null) {
				if (!user.getPower().getpID().equals("0")) {
		%>
		<div
			class="pet_more_list_block_name_title pet_more_list_block_line_height">专属</div>
		<a class="pet_more_list_block_line" href="user/notice" target="_blank">
			<i class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
			<div class="pet_more_list_block_line_font">发布</div>
		</a> </a> <a class="pet_more_list_block_line" href="not/noticelist"> <i
			class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
			<div class="pet_more_list_block_line_font">列表</div>
		</a>
		<%
			if (!user.getPower().getpID().equals("1")) {
		%>
		<a class="pet_more_list_block_line" href="adm/topImg" target="_blank">
			<i class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
			<div class="pet_more_list_block_line_font">轮播</div>
		</a>
		<a class="pet_more_list_block_line" href="adm/audit" target="_blank"> <i
			class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
			<div class="pet_more_list_block_line_font">审核</div>
		</a>
		<%
			}
				}
			}
		%>
	</div>
</div>


