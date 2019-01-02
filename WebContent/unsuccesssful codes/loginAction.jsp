<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录密码核对页面</title>
</head>
<body>
<%@ page import="weiyi.MD5.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	try{	
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jsp","sa","123456");
			String sql="select userName,password from softuser where userName= ? and password=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			session.setAttribute("username", request.getParameter("username"));
			
			//调用MD5包进行加密
			EncryptImp ei=new EncryptImp();
			System.out.println("这里是登录页面,即将把密码："+ei.md5(request.getParameter("password"))+"存到session中！");
			session.setAttribute("password", ei.md5(request.getParameter("password")));
			
			ps.setString(1,(String)session.getAttribute("username"));
			ps.setString(2,(String)session.getAttribute("password"));
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				%>
				<jsp:forward page="user_page.jsp"/>
				<%
			}else{
				out.println("登录失败！");
				out.println(request.getParameter("username").toString()+"账户的账号或者密码错误！");
			}
	}catch(Exception e){
		out.println("出现异常："+e);
	}
%>
</body>
</html>
