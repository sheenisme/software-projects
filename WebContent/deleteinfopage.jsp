<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除信息页面</title>
<link rel="stylesheet" href="./css/rform.css" />
<script type="text/javascript" src="js/register.js">
</script>
</head>
<body>
	<div class="container">
		<p class="title">基于浏览器的身份验证登录系统</p>
		<div class="box">
			<div id="register_box">
				<h2>删除页面</h2>
				<form action="DeleteUser" method="post" name="deleteform" onsubmit="return confirm('确定要删除吗？')">
					<div class="delete">		
					账号：<input id="username" type="text" name="username">
					<input class="ui button" type="submit" value="删除">
					</div>
				</form>
			</div>
			<br>
				<div><pre>基于浏览器的身份验证登录系统 - 删除账户页面！</pre></div> 
		</div>
	</div>
	<p class="foot">
		© WeiyiNetClient v1.0.0
		<br>
	</p>
</body>
</html>