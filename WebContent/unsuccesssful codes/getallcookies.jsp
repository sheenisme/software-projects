<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.net.URLDecoder" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取所有cookie</title>
</head>
<body>
<%
Cookie cookies[]=request.getCookies();
String user="";
String password="";
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("userCookie")){
		}
	}
}
if("".equals(user) && "".equals(password)){
	
}
%>
</body>
</html>