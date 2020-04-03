<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="add" method="post">
    	<input type="text" name="name">
    	<input type="submit" value="提交">
    </form>
    驱动模型
    <s:form action="us/add" method="post">
    <s:textfield key="name" name="Name"></s:textfield>
    <s:password key="pwd" name="password"></s:password>
    <s:submit value="提交"></s:submit>
    </s:form>
    域模型
    <s:form action="us/add2" method="post">
    <s:textfield key="name" name="user.Name"></s:textfield>
    <s:password key="pwd" name="user.password"></s:password>
    <s:submit value="提交"></s:submit>
    </s:form>
    动态Action
    <s:form action="us/add3!useradd" method="post">
    <s:textfield key="name" name="user.Name"></s:textfield>
    <s:password key="pwd" name="user.password"></s:password>
    <s:submit value="提交"></s:submit>
    </s:form>
    
  </body>
</html>
