<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.net.URLDecoder" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>基于浏览器的身份验证登录系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/form.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js">
	</script>
</head>
<body>
<%
Cookie cookies[]=request.getCookies();
String username="";
String password="";
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("userCookie")){
// 			username = URLDecoder.decode(cookies[i].getValue().split("#")[0]);
// 			password= URLDecoder.decode(cookies[i].getValue().split("#")[1]);
			username=cookies[i].getValue().split("#")[0];
			password=cookies[i].getValue().split("#")[1];
		}
	}
}
%>
	<div class="container">
		<p class="title">基于浏览器的身份验证登录系统</p>
		<div class="box">
				<div id="login_box">
						<h2>登录页面</h2>
						<form action="Login" method="post" name="userform" onsubmit="return checklogin()">
						<div class="ui field">		
						账号：<input id="username" type="text" name="username" value="<%=username %>"><br>
						</div>
						<div class="ui field">	
						密码：<input id="password" type="password" name="password" value="<%=password %>"><br>
						</div>
						<div class="ui field information">	
						<input id="checkbox" type="checkbox" name="autoLogin" checked="checked" value="save">记住密码<br>
						</div>
						<div class="m">
							<input class="ui button" type="submit" value="登录">
							<a href="register.jsp"><input class="ui button" type="button"  value="注册"></a>
						</div>
						</form>	
				</div>
				<br>
				<div><pre>基于浏览器的身份验证登录系统-登录页面!!     <a href="foundmm.jsp">找回密码</a></pre></div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© WeiyiNetClient v1.0.0
		<br>
	</p>
</body>
</html>