<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>基于浏览器的身份验证登录系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/rform.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/register.js">
	</script>
</head>
<body>
	<div class="container">
		<p class="title">基于浏览器的身份验证登录系统</p>
		<div class="box">
				<div id="register_box">
						<h2>注册页面</h2>
						<form action="Register" method="post" name="registerform" onsubmit="return checkregister()">
						<div class="ui register">		
						账   号：<input id="username" type="text" name="username"><br>
						</div>
						<div class="ui register">	
						密   码：   <input id="password" type="password" name="password"><br>
						</div>
						<div class="ui register">	
						 确  认：   <input id="repck" type="password" name="repck"><br>
						</div>
						<div class="ui register">	
						  邮   箱：    <input id="email" type="text" name="email"><br>
						</div>
						<div class="ui register">	
						  备  注：    <input id="others" type="text" name="others"><br>
						</div>
						<div class="m">
							<input class="ui register button" type="submit" value="注册">
						</div>
						</form>	
				</div>
				<br>
				<div><pre>基于浏览器的身份验证登录系统 - 注册账户页面！</pre></div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© WeiyiNetClient v1.0.0
		<br>
	</p>
</body>
</html>