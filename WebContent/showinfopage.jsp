<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看信息页面</title>
</head>
<body>
<%@ page import="java.sql.*,java.util.*,weiyi.dao.*,weiyi.dao.vo.*,weiyi.dao.proxy.UserDAOProxy" %>
	<table align="center" border="5px">
	<tr>
		<td>序    号</td>
		<td>用户ID</td>
		<td>用户名 </td>
		<td>密    码</td>
		<td>邮    箱</td>
		<td>其    他</td>
	</tr>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	UserDAOProxy userdao = new	UserDAOProxy();
	List<User> list = userdao.findAll();
	for(int i=0;i<list.size();i++){
		request.setAttribute("number",i);
		User user=list.get(i);
%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=user.getUserID().toString() %></td>
		<td><%=user.getUserName().toString() %></td>
		<td><%=user.getPassword().toString() %></td>
		<td><%=user.getEmail().toString() %></td>
		<td><%=user.getOthers().toString() %></td>
	</tr>
<% 
}
%>
	</table>
</body>
</html>