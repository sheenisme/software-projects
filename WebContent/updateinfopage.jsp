<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息页面</title>
<link rel="stylesheet" href="./css/updateform.css" />
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div>
	<p class="title">基于浏览器的身份验证登录系统</p>
	<form action="UpdateUser" method="post" name="updateform" onsubmit="return confirm('确定要修改吗？')">
	<%@ include file="showinfopage.jsp" %>
		<table align="center" border="5px">
		<tr>
			<td>用户名 </td>
			<td>密    码</td>
			<td>邮    箱</td>
			<td>其    他</td>
		</tr>
		<tr>
			<td><input id="username" type="text" name="username" value=""></td>
			<td><input id="password" type="text" name="password" value=""></td>
			<td><input id="email" type="text" name="email" value=""></td>
			<td><input id="others" type="text" name="others" value=""></td>
		</tr>
		</table>
		<center><input class="ui button" type="submit" value="修改"></center>
	</form>
</div>
</body>
</html>