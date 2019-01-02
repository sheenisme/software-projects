<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style>
#main{
			margin: 0 auto;
			width:1002px;
			height:600px;
     }
#left{
			width:202px;
			height:600px;
			float:left;
	  }
 #right{
			width:800px;
			height:600px;
			float:left;
       }
</style>
</head>
<body>
<%  
	String username=request.getParameter("username");
	out.println("<h2>"+"<center>"+"欢迎"+username+"登录基于浏览器的身份验证登录系统            "+"</center>"+"</h2>"+"<br><br>");
%>
<div id="main">
	<div id="left">
		<ul>
			<li><a href="showinfopage.jsp"  target="rightFrame">查看信息</a>
			<li><a href="updateinfopage.jsp"  target="rightFrame">修改信息</a>
			<li><a href="deleteinfopage.jsp"  target="rightFrame">删除信息</a>
			<li><a href="exit.jsp"  target="rightFrame">退出登录</a>
		</ul>
	</div>
	<div id="right">
		<iframe width="700px"  height="500px"  name="rightFrame" ></iframe>
	</div>
</div>
</body>
</html>