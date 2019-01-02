<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册后跳转页面</title>
	<link rel="stylesheet" href="./css/form.css" />
</head>
<body>
	<div class="container">
		<p class="title">基于浏览器的身份验证登录系统</p>
		<div class="box">
				<div id="transform_box">
						<h2>恭喜您注册成功！！！</h2>
						<br>
						<pre>即将为您跳转页面，若30秒后无响应请点击<a href="login.jsp">这里</a>进行手动跳转</pre>
				</div> 
		</div>
	</div>
	<br>
	<jsp:forward page="login.jsp"/>
	<p class="foot">
		© WeiyiNetClient v1.0.0
		<br>
	</p>
</body>
</html>