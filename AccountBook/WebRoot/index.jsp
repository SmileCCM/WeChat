<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    This is my JSP page. <br>
    <a href="infoupdate?openid=ojpUv5WynA9EKtU3c-ZYaJ4ibIJU">login</a>  
    <a href="togetAccounts?openid=ojpUv5WynA9EKtU3c-ZYaJ4ibIJU">getAccount</a>
    <a href="addAccount">addAccount</a>
    <a href="updateAccount">updateAccount</a>
    <a href="deleteAccount">deleteAccount</a>
    <a href="findbud">findbud</a>
    <a href="updatedbud">updatedbud</a>
    <a href="addbill">addbill</a>
    <a href="findbills">findbills</a>
    <a href="updatebill">updatebill</a>
    <a href="findbyconditons">findbyconditons</a>
    <a href="delete">delete</a>
    <a href="getclasses">getclasses</a>
    <a href="add">add类</a>
    <a href="update">update类</a>
    <a href="remove">remove类</a>
  </body>
</html>
