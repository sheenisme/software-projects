function exit(username){
	if(confirm("确定退出吗？") == true)
	{
		window.top.location.replace("login.jsp");
		window.parent.location.href="login.jsp";
		top.location = "http://www.baidu.com";
	}
}