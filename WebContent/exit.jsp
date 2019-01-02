<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>退出页面</title>
	<link rel="stylesheet" href="./css/form.css" />
	<script type="text/javascript" src="js/exit.js"></script>
</head>
<body>
<% session.invalidate(); %>
	<div class="container">
		<p class="title">基于浏览器的身份验证登录系统</p>
		<div class="box">
				<div id="register_box">
						<h2>退出页面</h2>
						<br><br>
						<a class="ui button" href="login.jsp" target="_top">退出</a>
<!-- 						<form action="#" method="post" name="exitform"  onsubmit="exit()">  -->
<!--  							<input class="ui button" type="submit" value="退出">  -->
<!--  						</form>  -->
				</div>
				<br>
				<div><pre>基于浏览器的身份验证登录系统 - 退出页面！</pre></div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© WeiyiNetClient v1.0.0
		<br>
	</p>
</body>
</html>