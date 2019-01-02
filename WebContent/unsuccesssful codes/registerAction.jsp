<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="weiyi.MD5.*"%>
<%
response.setContentType("text/html;charset=UTF-8");
request.setCharacterEncoding("UTF-8");
//1，加载驱动
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//2，获取连接
Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jsp","sa","123456");
//3，操作数据
String sql="insert into softuser values(?,?,?,?) ";
PreparedStatement ps=conn.prepareStatement(sql);

ps.setString(1,request.getParameter("username"));

//调用MD5包进行加密
EncryptImp ei=new EncryptImp();
System.out.println("这里是注册页面,即将把密码："+ei.md5(request.getParameter("password"))+"存到数据库中！");
ps.setString(2,ei.md5(request.getParameter("password")));
ps.setString(3,request.getParameter("email"));
ps.setString(4,request.getParameter("others"));
if(ps.executeUpdate()>0){
	session.setAttribute("username", request.getParameter("username"));
%>
	<jsp:forward page="successful_register.jsp"/>
<%
}else{
	out.println("注册失败");
}
//4，释放资源
out.println("注册成功!");
ps.close(); 
conn.close();
%>
</body>
</html>