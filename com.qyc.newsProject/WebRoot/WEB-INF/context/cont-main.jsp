<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="pet_content_main">
	<div data-am-widget="list_news"
		class="am-list-news am-list-news-default">
		<div class="am-list-news-bd">
			<ul class="am-list" id="am">
				<!--缩略图在标题右边-->

			</ul>
		</div>
	</div>
</div>
